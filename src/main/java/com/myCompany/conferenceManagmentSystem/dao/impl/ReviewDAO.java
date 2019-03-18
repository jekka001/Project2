package com.myCompany.conferenceManagmentSystem.dao.impl;

import com.myCompany.conferenceManagmentSystem.model.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO extends AbstractDAO<Review> {
    private static final String SQL_INSERT = "INSERT INTO review(id, topic, registered, visitors) " +
            "VALUES(?, ?, ?, ?)";
    private static final String SQL_FIND_ALL = "SELECT * FROM review";
    private static final String SQL_UPDATE = "UPDATE review SET topic = ?, registered = ?, visitors = ? " +
            "WHERE id = ?";
    private static final String SQL_UPDATE_SPEAKER_ID = "UPDATE review SET speaker_id = ? " +
            "WHERE id = ?";
    private static final String SQL_UPDATE_SPEAKING_ID = "UPDATE review SET speaking_id = ? " +
            "WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM review WHERE id = ?";

    public ReviewDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Review> findAll() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL);

            return parseSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Review findById(long id) {
        if(isExistReview(id)) {
            return findByLong("id", id).get(0);
        }
        return null;
    }
    private boolean isExistReview(long id){
        return !findByLong("id", id).isEmpty();
    }

    @Override
    public List<Review> findByString(String type, String value) {
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
    public List<Review> findByLong(String type, long value) {
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
    public boolean create(Review object) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
            preparedStatement.setLong(1, object.getId());
            preparedStatement.setString(2, object.getTopic());
            preparedStatement.setInt(3, object.getCountRegistered());
            preparedStatement.setInt(4, object.getCountVisitors());

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Review update(Review object) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)){
            preparedStatement.setString(1, object.getTopic());
            preparedStatement.setInt(2, object.getCountRegistered());
            preparedStatement.setInt(3, object.getCountVisitors());
            preparedStatement.setLong(4, object.getId());

            preparedStatement.execute();

            return object;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Review object) {
        return delete(object.getId());
    }

    @Override
    public boolean delete(long id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
            preparedStatement.setLong(1, id);

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private List<Review> parseSet(ResultSet resultSet) throws SQLException {
        List<Review> reviewList = new ArrayList<>();

        while(resultSet.next()){
            reviewList.add(fillReview(resultSet));
        }

        return reviewList;
    }
    private Review fillReview(ResultSet resultSet) throws SQLException{
        Review tempReview = new Review();

        tempReview.setId(resultSet.getLong("id"));
        tempReview.setTopic(resultSet.getString("topic"));
        tempReview.setCountRegistered(resultSet.getInt("registered"));
        tempReview.setCountVisitors(resultSet.getInt("visitors"));

        return tempReview;
    }
    private String getSelectQuery(String type){return SQL_FIND_ALL + " WHERE " + type + " = ?";}

    public boolean updateSpeakerId(Review review, long speakerId){
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_SPEAKER_ID)) {
            preparedStatement.setLong(1, speakerId);
            preparedStatement.setLong(2, review.getId());

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateSpeakingId(Review review, long speakingId){
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_SPEAKER_ID)) {
            preparedStatement.setLong(1, speakingId);
            preparedStatement.setLong(2, review.getId());

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
