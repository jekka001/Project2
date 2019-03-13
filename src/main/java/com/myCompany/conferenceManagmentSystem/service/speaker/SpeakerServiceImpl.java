package com.myCompany.conferenceManagmentSystem.service.speaker;

import com.myCompany.conferenceManagmentSystem.model.entity.Review;

public class SpeakerServiceImpl implements SpeakerService {
    private Review review;

    public SpeakerServiceImpl(Review review) {
        this.review = review;
    }

    @Override
    public void suggestReviewTopic(String topic) {
        //
    }
}
