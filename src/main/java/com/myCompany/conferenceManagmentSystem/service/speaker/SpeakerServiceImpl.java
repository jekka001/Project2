package com.myCompany.conferenceManagmentSystem.service.speaker;

import com.myCompany.conferenceManagmentSystem.model.Review;
import com.myCompany.conferenceManagmentSystem.service.moderator.ModeratorServiceImpl;

public class SpeakerServiceImpl implements SpeakerService {

    @Override
    public void suggestReviewTopic(Review review) {
        ModeratorServiceImpl.reviewConsidered.add(review);
    }
}
