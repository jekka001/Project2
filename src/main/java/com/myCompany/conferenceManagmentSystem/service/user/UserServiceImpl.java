package com.myCompany.conferenceManagmentSystem.service.user;


import com.myCompany.conferenceManagmentSystem.dao.connection.ConnectionPoolHolder;
import com.myCompany.conferenceManagmentSystem.dao.factory.impl.MySqlDAOFactory;
import com.myCompany.conferenceManagmentSystem.dao.impl.AbstractDAO;
import com.myCompany.conferenceManagmentSystem.dao.impl.UserDAO;
import com.myCompany.conferenceManagmentSystem.entity.Role;
import com.myCompany.conferenceManagmentSystem.entity.User;
import com.myCompany.conferenceManagmentSystem.service.signIn.Encryption;
import com.myCompany.conferenceManagmentSystem.service.signIn.EncryptionImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private AbstractDAO<User> userDAO;
    private Connection connection;
    private User user;
    private int salt;
    private String passwordWithSalt;
    private Encryption encryption;

    public UserServiceImpl() {
        connection = ConnectionPoolHolder.getInstance().getConnection();
        userDAO = MySqlDAOFactory.getInstance().createUser(connection);
        encryption = EncryptionImpl.instance;
    }

    @Override
    public User getUser(String login, String password) {
        if(isExistEmail(login)) {
            user = findUserInBD(login);
            salt = findSaltInBD();
            passwordWithSalt = addSaltToPassword(salt, password);

            if (checkPassword()) {
                return user;
            }
        }
        throw new NullPointerException();
    }
    private boolean checkPassword(){
        return encryption.checkPassword(passwordWithSalt, user.getPassword());
    }
    private int findSaltInBD(){
        return ((UserDAO)userDAO).findSalt(user.getId());
    }
    private User findUserInBD(String login){
        return userDAO.findByString("email", login).get(0);
    }

    @Override
    public boolean isExistEmail(String login){
        return !userDAO.findByString("email", login).isEmpty();
    }

    @Override
    public void makingUser(String name, String surname, String email, String password) {
        salt = encryption.generationSalt();
        int idUser = findNumberOfUsers();
        String encryptedPassword = protectPassword(password);
        user = new User(idUser, email, encryptedPassword, name, surname, Role.User);
        insertDataInBD();
    }
    private int findNumberOfUsers(){
        return userDAO.findAll().size() + 1;
    }
    private String addSaltToPassword(int salt, String password){
        return salt + password;
    }
    private String protectPassword(String password){
        passwordWithSalt = addSaltToPassword(salt, password);
        return encryption.encryption(passwordWithSalt);
    }
    private void insertDataInBD(){
        userDAO.create(user);
        ((UserDAO)userDAO).updateSalt(salt, user.getId());
    }

    @Override
    public void updateUser(User user) {
        userDAO.update(user);
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
