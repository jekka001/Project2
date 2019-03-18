package com.myCompany.conferenceManagmentSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Speaker extends User {
    private long rating;
    private long bonus;
    private List<Review> reviewList;

    public long getRating() {
        return rating;
    }
    public void setRating(long rating) {
        this.rating = rating;
    }
    public long getBonus() {
        return bonus;
    }
    public void setBonus(long bonus) {
        this.bonus = bonus;
    }
    public List<Review> getReviewList() {
        return reviewList;
    }
    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public Speaker() {
        this(0, 0, new ArrayList<Review>());
    }

    public Speaker(long rating, long bonus, List<Review> reviewList) {
        this.rating = rating;
        this.bonus = bonus;
        this.reviewList = reviewList;
    }

    public Speaker(long id, String email, String password, String name, String surname, Role role,
                   long rating, long bonus, List<Review> reviewList) {
        super(id, email, password, name, surname, role);
        this.rating = rating;
        this.bonus = bonus;
        this.reviewList = reviewList;
    }

    @Override
    public String toString() {
        return super.toString() + getClass().getSimpleName() +
                " rating = " + rating +
                " bonus = " + bonus +
                " reviewList: " + Review.convertListReviewToString(reviewList);
    }
}
