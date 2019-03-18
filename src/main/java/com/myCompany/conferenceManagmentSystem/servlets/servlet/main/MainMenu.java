package com.myCompany.conferenceManagmentSystem.servlets.servlet.main;

import com.myCompany.conferenceManagmentSystem.service.menu.MainMenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MainMenu")
public class MainMenu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MainMenuService mainMenuService = new MainMenuService(req, resp);
        String menuItem = req.getParameter("Menu");
        mainMenuService.moveToMenu(req, resp, menuItem);
    }
}
