package com.myCompany.conferenceManagmentSystem.service.moderator;

import com.myCompany.conferenceManagmentSystem.model.Review;

public interface EditingReview {
    void fixReviewTopic(Review review);
    void suggestReviewTopic(Review review);
    void changeReviewTopic(Review review);
}
