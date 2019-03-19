package com.myCompany.conferenceManagmentSystem.entity;


import java.util.List;

public class Speaker extends User {
    private long rating;
    private long bonus;

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

}
