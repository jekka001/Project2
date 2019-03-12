package com.myCompany.conferenceManagmentSystem.service.user;

import com.myCompany.conferenceManagmentSystem.model.entity.User;

public interface UserService {
    User getUser(String login, String password);
    void makingUser(String name, String surname, String email, String password);
    void updateUser(User user);
}
