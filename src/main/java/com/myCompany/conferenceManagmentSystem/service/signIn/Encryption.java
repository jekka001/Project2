package com.myCompany.conferenceManagmentSystem.service.signIn;

public interface Encryption {
    int generationSalt();
    String encryption(String password);
    boolean checkPassword(String userPassword, String bdPassword);
}
