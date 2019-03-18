package com.myCompany.conferenceManagmentSystem.service.menu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainMenuService {
    private HttpSession session;
    private HttpServletRequest req;
    private HttpServletResponse res;

    public MainMenuService(HttpServletRequest req, HttpServletResponse res) {
        this.req = req;
        this.res = res;
        session = req.getSession();
    }

    public void moveToMenu(HttpServletRequest req, HttpServletResponse resp, String menuItem) throws ServletException, IOException {
        if(menuItem != null && menuItem.equals(session.getAttribute("register"))){
            req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);
        }
    }
}
