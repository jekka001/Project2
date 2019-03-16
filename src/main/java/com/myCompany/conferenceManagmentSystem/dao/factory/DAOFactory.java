package com.myCompany.conferenceManagmentSystem.dao.factory;

import com.myCompany.conferenceManagmentSystem.dao.factory.impl.MySqlDAOFactory;
import com.myCompany.conferenceManagmentSystem.dao.impl.ReviewDAO;
import com.myCompany.conferenceManagmentSystem.dao.impl.SpeakerDAO;
import com.myCompany.conferenceManagmentSystem.dao.impl.SpeakingDAO;
import com.myCompany.conferenceManagmentSystem.dao.impl.UserDAO;

import java.sql.Connection;

public abstract class DAOFactory {
    private static volatile DAOFactory daoFactory;

    public abstract ReviewDAO createReview(Connection connection);
    public abstract SpeakerDAO createSpeaker(Connection connection);
    public abstract UserDAO createUser(Connection connection);
    public abstract SpeakingDAO createSpeaking(Connection connection);

    public static DAOFactory getInstance(){
        if(isNullDaoFactory(daoFactory)){
            synchronized (DAOFactory.class){
                if(isNullDaoFactory(daoFactory)){
                    daoFactory = new MySqlDAOFactory();
                }
            }
        }
        return daoFactory;
    }
    private static boolean isNullDaoFactory(DAOFactory daoFactory){
        return daoFactory == null;
    }
}
