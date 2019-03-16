package com.myCompany.conferenceManagmentSystem.service.moderator;


import com.myCompany.conferenceManagmentSystem.model.entity.Review;
import com.myCompany.conferenceManagmentSystem.model.entity.Speaking;


public interface ModeratorService {
    void fixReviewTopic(Review review);
    void suggestReviewTopic(Review review);
    void changeReviewTopic(Review review);


    void changeTimeConduction(Speaking speaking);
    void changeVenue(Speaking speaking);
}
