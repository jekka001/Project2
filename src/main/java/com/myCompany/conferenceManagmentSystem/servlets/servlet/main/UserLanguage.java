package com.myCompany.conferenceManagmentSystem.servlets.servlet.main;

import com.myCompany.conferenceManagmentSystem.service.language.UserLanguageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserLanguage")
public class UserLanguage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserLanguageService userLanguageService = new UserLanguageService(req, resp);
        userLanguageService.getRequestData();
        userLanguageService.moveToMenu();
    }

}
