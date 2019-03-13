package com.myCompany.conferenceManagmentSystem.service.moderator;


import java.time.Instant;

public interface ModeratorService {
    void setReviewTopic(String topic);
    void suggestReviewTopic(String topic);
    void changeReviewTopic(String topic);


    void changeTimeConduction(Instant instant);
    void changeVenue(String venue);
}
