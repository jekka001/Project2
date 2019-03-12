package com.myCompany.conferenceManagmentSystem.service.user;


import com.myCompany.conferenceManagmentSystem.dao.impl.AbstractDAO;
import com.myCompany.conferenceManagmentSystem.model.entity.User;

import java.sql.Connection;

public class UserServiceImpl implements UserService {
    private AbstractDAO<User> userDao;
    private Connection connection;
    private User user;
    private int salt;
    private String passwordWithSalt;


    @Override
    public User getUser(String login, String password) {
        return null;
    }

    @Override
    public void makingUser(String name, String surname, String email, String password) {

    }

    @Override
    public void updateUser(User user) {

    }
}
