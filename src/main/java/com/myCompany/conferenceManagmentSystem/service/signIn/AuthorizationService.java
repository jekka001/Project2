package com.myCompany.conferenceManagmentSystem.service.signIn;

import com.myCompany.conferenceManagmentSystem.model.User;
import com.myCompany.conferenceManagmentSystem.service.language.ResourceManager;
import com.myCompany.conferenceManagmentSystem.service.user.UserService;
import com.myCompany.conferenceManagmentSystem.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationService {
    private HttpServletRequest req;
    private HttpServletResponse res;
    private String login;
    private String password;
    private HttpSession session;
    private User user;
    private ResourceManager manager = ResourceManager.INSTANCE;

    public AuthorizationService(HttpServletRequest req, HttpServletResponse res) {
        this.req = req;
        this.res = res;
    }

    public void getRequestData(){
        login = req.getParameter("Email");
        password = req.getParameter("Password");
        session = req.getSession();
    }

    public void getUserData(){
        UserService userService = new UserServiceImpl();
        try {
            user = userService.getUser(login, password);
        }catch (NullPointerException ex){
            //logger
        }finally {
            ((UserServiceImpl) userService).closeConnection();
        }
    }

    public void userVerification() throws ServletException, IOException {
        if (checkUserSession()) {
            user = (User)session.getAttribute("User");
            moveToMenu();
        }else if(isExistUser()){
            req.getSession().setAttribute("User", user);
            moveToMenu();
        } else{
            //logger.info("User " + login + " mistaken when entering data");
            req.setAttribute("wrong", manager.getMessage("USER_WRONG"));
            req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, res);
        }
    }
    private boolean checkUserSession(){
        return session != null && session.getAttribute("User") != null;
    }
    private boolean isExistUser(){
        return user != null;
    }
    private void moveToMenu() throws ServletException, IOException {
        switch (user.getRole()){
            case Admin:
                //logger.info("Administrator "+ login +" logged in");
                //setDataForUserCruiseTable();
                req.getRequestDispatcher("/WEB-INF/view/tableConference.jsp").forward(req, res);
                break;
            case User:
                //logger.info("User " + login + " logged in");
                req.getRequestDispatcher("/WEB-INF/view/tableConference.jsp").forward(req, res);
                break;
            case Speaker:
                req.getRequestDispatcher("/WEB-INF/view/tableConference.jsp").forward(req, res);
                break;
            case Moderator:
                req.getRequestDispatcher("/WEB-INF/view/tableConference.jsp").forward(req, res);
        }
    }
    /*private void setDataForUserCruiseTable(){
        AdminBonusTable adminBonusTable = new AdminBonusTable();
        List<CruiseTicket> tickets = adminBonusTable.getCruiseTicket();
        req.setAttribute("tickets", tickets);
        adminBonusTable.closeConnection();
    }*/
}
