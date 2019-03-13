package com.myCompany.conferenceManagmentSystem.service.signIn;

import org.jasypt.util.password.BasicPasswordEncryptor;

import java.security.SecureRandom;

public class EncryptionImpl implements Encryption {
    public static EncryptionImpl instance = new EncryptionImpl();
    private SecureRandom secureRandom = new SecureRandom();
    private BasicPasswordEncryptor basicPasswordEncryptor = new BasicPasswordEncryptor();

    private EncryptionImpl() {
    }

    @Override
    public int generationSalt() {
        return secureRandom.nextInt();
    }

    @Override
    public String encryption(String password) {
        return basicPasswordEncryptor.encryptPassword(password);
    }

    @Override
    public boolean checkPassword(String userPassword, String bdPassword) {
        return basicPasswordEncryptor.checkPassword(userPassword, bdPassword);
    }
}
