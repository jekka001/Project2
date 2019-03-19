package com.myCompany.conferenceManagmentSystem.service.moderator;



import com.myCompany.conferenceManagmentSystem.dao.connection.ConnectionPoolHolder;
import com.myCompany.conferenceManagmentSystem.dao.factory.impl.MySqlDAOFactory;
import com.myCompany.conferenceManagmentSystem.dao.impl.AbstractDAO;
import com.myCompany.conferenceManagmentSystem.entity.Review;
import com.myCompany.conferenceManagmentSystem.entity.Speaking;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ModeratorServiceImpl implements ModeratorService {
    private Connection connection = ConnectionPoolHolder.getInstance().getConnection();
    private AbstractDAO<Review> reviewDAO = MySqlDAOFactory.getInstance().createReview(connection);
    private AbstractDAO<Speaking> speakingDAO = MySqlDAOFactory.getInstance().createSpeaking(connection);
    public static List<Review> reviewConsidered = new ArrayList<>();

    @Override
    public void fixReviewTopic(Review review) {
        if(reviewConsidered != null && reviewConsidered.contains(review)){
            changeReviewTopic(review);
        }
    }

    @Override
    public void suggestReviewTopic(Review review) {
        reviewConsidered.add(review);
    }

    @Override
    public void changeReviewTopic(Review review) {
        reviewDAO.update(review);
    }

    @Override
    public void changeTimeConduction(Speaking speaking) {
        speakingDAO.update(speaking);
    }

    @Override
    public void changeVenue(Speaking speaking) {
        speakingDAO.update(speaking);
    }
}
