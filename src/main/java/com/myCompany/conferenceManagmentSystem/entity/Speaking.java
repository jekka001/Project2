package com.myCompany.conferenceManagmentSystem.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Speaking extends AbstractEntity<Long>{
    private Instant timeConduction;
    private String venue;

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

}
