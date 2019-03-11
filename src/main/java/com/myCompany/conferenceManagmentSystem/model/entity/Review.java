package com.myCompany.conferenceManagmentSystem.model.entity;

import java.util.List;

public class Review {
    private long id;
    private String topic;
    private int countRegistered;
    private int countVisitors;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public int getCountRegistered() {
        return countRegistered;
    }
    public void setCountRegistered(int countRegistered) {
        this.countRegistered = countRegistered;
    }
    public int getCountVisitors() {
        return countVisitors;
    }
    public void setCountVisitors(int countVisitors) {
        this.countVisitors = countVisitors;
    }

    public Review() {
        this(0, "NoTopic", 0, 0);
    }

    public Review(long id, String topic, int countRegistered, int countVisitors) {
        this.id = id;
        this.topic = topic;
        this.countRegistered = countRegistered;
        this.countVisitors = countVisitors;
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
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Review review = (Review) obj;
        return this.id == review.id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " id = " + id + " topic = " + topic +
                " countRegistered = " + countRegistered +
                " countVisitors = " + countVisitors;
    }

    public static String convertListReviewToString(List<Review> reviewList){
        StringBuilder result = new StringBuilder();
        for(Review review : reviewList){
            result.append(review.toString() + ",\n");
        }
        return result.toString();
    }
}
