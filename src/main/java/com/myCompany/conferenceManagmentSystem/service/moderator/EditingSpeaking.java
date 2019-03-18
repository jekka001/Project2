package com.myCompany.conferenceManagmentSystem.service.moderator;

import com.myCompany.conferenceManagmentSystem.model.Speaking;

public interface EditingSpeaking {
    void changeTimeConduction(Speaking speaking);
    void changeVenue(Speaking speaking);
}
