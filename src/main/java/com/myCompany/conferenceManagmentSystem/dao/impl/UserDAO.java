package com.myCompany.conferenceManagmentSystem.dao.impl;

import com.myCompany.conferenceManagmentSystem.model.entity.Role;
import com.myCompany.conferenceManagmentSystem.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {
    private static final String SQL_INSERT = "INSERT INTO user(id, email, password, name, surname, role) " +
            "VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_FIND_ALL = "SELECT * FROM user";
    private static final String SQL_UPDATE = "UPDATE user SET email = ?, password = ?, name = ?, " +
            "surname = ?, role = ? WHERE id = ?";
    private static final String SQL_UPDATE_SALT = "UPDATE user SET salt = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM user WHERE id = ?";

    public UserDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<User> findAll() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL);

            return parseSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(long id) {
        if(isExistUser(id)) {
            return findByLong("id", id).get(0);
        }
        return null;
    }
    private boolean isExistUser(long id){
        return !findByLong("id", id).isEmpty();
    }

    @Override
    public List<User> findByString(String type, String value) {
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
    public List<User> findByLong(String type, long value) {
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
    public boolean create(User object) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
            preparedStatement.setLong(1, object.getId());
            preparedStatement.setString(2, object.getEmail());
            preparedStatement.setString(3, object.getPassword());
            preparedStatement.setString(4, object.getName());
            preparedStatement.setString(5, object.getSurname());
            preparedStatement.setString(6, object.getRole().name());

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User update(User object) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)){
            preparedStatement.setString(1, object.getEmail());
            preparedStatement.setString(2, object.getPassword());
            preparedStatement.setString(3, object.getName());
            preparedStatement.setString(4, object.getSurname());
            preparedStatement.setString(5, object.getRole().name());
            preparedStatement.setLong(6, object.getId());

            preparedStatement.execute();

            return object;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(User object) {
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

    public boolean updateSalt(int salt, long clientId){
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_SALT)) {
            preparedStatement.setInt(1, salt);
            preparedStatement.setLong(2, clientId);

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public int findSalt(long clientId){
        String currentSql = getSelectQuery("id");

        try(PreparedStatement preparedStatement = connection.prepareStatement(currentSql)) {
            preparedStatement.setLong(1, clientId);

            ResultSet resultSet = preparedStatement.executeQuery();

            return parseSetWithSalt(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private int parseSetWithSalt(ResultSet resultSet) throws SQLException{
        resultSet.next();

        return resultSet.getInt("salt");
    }

    private List<User> parseSet(ResultSet resultSet) throws SQLException {
        List<User> userList = new ArrayList<>();

        while(resultSet.next()){
            userList.add(fillUser(resultSet));
        }

        return userList;
    }
    private User fillUser(ResultSet resultSet) throws SQLException{
        User tempUser = new User();

        tempUser.setId(resultSet.getLong("id"));
        tempUser.setEmail(resultSet.getString("email"));
        tempUser.setPassword(resultSet.getString("password"));
        tempUser.setName(resultSet.getString("name"));
        tempUser.setSurname(resultSet.getString("surname"));
        tempUser.setRole(Role.valueOf(resultSet.getString("role")));

        return tempUser;
    }
    private String getSelectQuery(String type){return SQL_FIND_ALL + " WHERE " + type + " = ?";}
}
