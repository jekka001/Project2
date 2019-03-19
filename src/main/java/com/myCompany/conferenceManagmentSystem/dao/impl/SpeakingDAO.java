package com.myCompany.conferenceManagmentSystem.dao.impl;

import com.myCompany.conferenceManagmentSystem.dao.factory.DAOFactory;
import com.myCompany.conferenceManagmentSystem.dao.factory.impl.MySqlDAOFactory;
import com.myCompany.conferenceManagmentSystem.entity.Review;
import com.myCompany.conferenceManagmentSystem.entity.Speaking;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SpeakingDAO extends AbstractDAO<Speaking> {
    private static final String SQL_INSERT = "INSERT INTO speaking(id, time_conduction, venue) " +
            "VALUES(?, ?, ?)";
    private static final String SQL_FIND_ALL = "SELECT * FROM speaking";
    private static final String SQL_UPDATE = "UPDATE speaking SET time_conduction = ?, venue = ? " +
            "WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM speaking WHERE id = ?";

    private DAOFactory parentFactory = MySqlDAOFactory.getInstance();
    private AbstractDAO<Review> reviewDAO = parentFactory.createReview(connection);

    public SpeakingDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Speaking> findAll() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL);

            return parseSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Speaking findById(long id) {
        if(isExistSpeaker(id)) {
            return findByLong("id", id).get(0);
        }
        return null;
    }
    private boolean isExistSpeaker(long id){
        return !findByLong("id", id).isEmpty();
    }

    @Override
    public List<Speaking> findByString(String type, String value) {
        String currentSql = getSelectQuery(type);

        try(PreparedStatement preparedStatement = connection.prepareStatement(currentSql)) {
            preparedStatement.setString(1, value);

            ResultSet resultSet = preparedStatement.executeQuery();

            return parseSet(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Speaking> findByLong(String type, long value) {
        String currentSql = getSelectQuery(type);

        try(PreparedStatement preparedStatement = connection.prepareStatement(currentSql)) {
            preparedStatement.setLong(1, value);

            ResultSet resultSet = preparedStatement.executeQuery();

            return parseSet(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(Speaking object) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
            preparedStatement.setLong(1, object.getId());
            preparedStatement.setLong(2, object.getTimeConduction().getEpochSecond());
            preparedStatement.setString(3, object.getVenue());

            preparedStatement.execute();

            createReview(object.getReviewList(), object.getId());

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Speaking update(Speaking object) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)){
            preparedStatement.setLong(1, object.getTimeConduction().getEpochSecond());
            preparedStatement.setString(2, object.getVenue());
            preparedStatement.setLong(3, object.getId());

            preparedStatement.execute();

            updateReview(object.getReviewList(), object.getId());

            return object;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Speaking object) {
        return delete(object.getId());
    }

    @Override
    public boolean delete(long id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
            preparedStatement.setLong(1, id);

            preparedStatement.execute();

            deleteReview(id);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private List<Speaking> parseSet(ResultSet resultSet) throws SQLException {
        List<Speaking> speakingList = new ArrayList<>();

        while(resultSet.next()){
            speakingList.add(fillSpeaking(resultSet));
        }

        return speakingList;
    }
    private Speaking fillSpeaking(ResultSet resultSet) throws SQLException{
        Speaking tempSpeaking = new Speaking();

        tempSpeaking.setId(resultSet.getLong("id"));
        tempSpeaking.setTimeConduction(Instant.ofEpochSecond(resultSet.getLong("time_conduction")));
        tempSpeaking.setVenue(resultSet.getString("venue"));
        tempSpeaking.setReviewList(reviewDAO.findByLong("speaking_id", resultSet.getLong("id")));

        return tempSpeaking;
    }
    private String getSelectQuery(String type){return SQL_FIND_ALL + " WHERE " + type + " = ?";}

    private void createReview(List<Review> reviewList, long speakingId){
        for(Review review : reviewList) {
            reviewDAO.create(review);
            ((ReviewDAO)reviewDAO).updateSpeakingId(review, speakingId);
        }
    }
    private void updateReview(List<Review> reviewList, long speakerId){
        deleteReview(speakerId);
        createReview(reviewList, speakerId);
    }
    private void deleteReview(long speakingId){
        List<Review> reviewList = reviewDAO.findByLong("speaking_id", speakingId);

        for(Review review : reviewList){
            reviewDAO.delete(review);
        }
    }
}
