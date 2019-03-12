package com.myCompany.conferenceManagmentSystem.dao.factory.impl;

import com.myCompany.conferenceManagmentSystem.dao.factory.DAOFactory;
import com.myCompany.conferenceManagmentSystem.dao.impl.ReviewDAO;
import com.myCompany.conferenceManagmentSystem.dao.impl.SpeakerDAO;
import com.myCompany.conferenceManagmentSystem.dao.impl.SpeakingDAO;
import com.myCompany.conferenceManagmentSystem.dao.impl.UserDAO;

import java.sql.Connection;

public class MySqlDAOFactory extends DAOFactory {
    @Override
    public ReviewDAO createReview(Connection connection) {
        return new ReviewDAO(connection);
    }

    @Override
    public SpeakerDAO createSpeaker(Connection connection) {
        return new SpeakerDAO(connection);
    }

    @Override
    public UserDAO createUser(Connection connection) {
        return new UserDAO(connection);
    }

    @Override
    public SpeakingDAO createSpeakingDAO(Connection connection) {
        return new SpeakingDAO(connection);
    }

}
