package com.myCompany.conferenceManagmentSystem.service.language;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;

    ResourceManager() {
        resourceBundle = ResourceBundle.getBundle("language", new Locale("en", "UK"));
    }

    public void changeLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("language", locale);
    }

    public String getMessage(String key) {
        return resourceBundle.getString(key);
    }
}
