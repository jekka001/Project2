package com.myCompany.conferenceManagmentSystem.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Speaking {
    private long id;
    private Instant timeConduction;
    private String venue;
    private List<Review>  reviewList;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Instant getTimeConduction() {
        return timeConduction;
    }
    public void setTimeConduction(Instant timeConduction) {
        this.timeConduction = timeConduction;
    }
    public String getVenue() {
        return venue;
    }
    public void setVenue(String venue) {
        this.venue = venue;
    }
    public List<Review> getReviewList() {
        return reviewList;
    }
    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public Speaking() {
        this(0, Instant.now(), "noVenue", new ArrayList<>());
    }

    public Speaking(long id, Instant timeConduction, String venue, List<Review> reviewList) {
        this.id = id;
        this.timeConduction = timeConduction;
        this.venue = venue;
        this.reviewList = reviewList;
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash = hash * 17 + (int)(id ^ (id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        Speaking speaking = (Speaking) obj;
        return speaking.id == this.id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " id = " + id +
                " timeConduction = " + timeConduction +
                " venue = " + venue +
                " reviewList: " + Review.convertListReviewToString(reviewList);
    }

}
