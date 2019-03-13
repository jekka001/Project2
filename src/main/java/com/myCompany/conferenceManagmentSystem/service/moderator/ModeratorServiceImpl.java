package com.myCompany.conferenceManagmentSystem.service.moderator;

import com.myCompany.conferenceManagmentSystem.model.entity.Review;
import com.myCompany.conferenceManagmentSystem.model.entity.Speaking;

import java.time.Instant;

public class ModeratorServiceImpl implements ModeratorService {
    private Review review;
    private Speaking speaking;

    public ModeratorServiceImpl(Review review) {
        this.review = review;
    }
    public ModeratorServiceImpl(Speaking speaking) {
        this.speaking = speaking;
    }
    public ModeratorServiceImpl(Review review, Speaking speaking){
        this.review = review;
        this.speaking = speaking;
    }

    @Override
    public void setReviewTopic(String topic) {
        //review.setTopic(topic);
    }

    @Override
    public void suggestReviewTopic(String topic) {

    }

    @Override
    public void changeReviewTopic(String topic) {
        review.setTopic(topic);
    }

    @Override
    public void changeTimeConduction(Instant instant) {
        speaking.setTimeConduction(instant);
    }

    @Override
    public void changeVenue(String venue) {
        speaking.setVenue(venue);
    }
}
