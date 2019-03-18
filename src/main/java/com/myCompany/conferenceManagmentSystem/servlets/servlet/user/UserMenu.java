package com.myCompany.conferenceManagmentSystem.servlets.servlet.user;

import com.myCompany.conferenceManagmentSystem.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserMenu")
public class UserMenu extends HttpServlet {
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private String menuItem;
    private long userId;
    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.req = req;
        this.resp = resp;
        getRequestData();
        moveToMenu();
    }

    private void moveToMenu() throws ServletException, IOException {
        if (menuItem.equals(session.getAttribute("my_cruise"))) {
            //setDataForUserCruiseTable();
            req.getRequestDispatcher("/WEB-INF/view/userCruise.jsp").forward(req, resp);
        } else if (menuItem.equals(session.getAttribute("button_choose_cruise"))) {
            //setDataForCruiseTable();
            req.getRequestDispatcher("/WEB-INF/view/chooseCruise.jsp").forward(req, resp);
        } else if (menuItem.equals(session.getAttribute("my_bonus"))) {
            //setDataForBonusTable();
            req.getRequestDispatcher("/WEB-INF/view/bonus.jsp").forward(req, resp);
        } else if(menuItem.equals(session.getAttribute("log_out"))) {
            req.getRequestDispatcher("Logout").forward(req, resp);
        }else {
            req.getRequestDispatcher("/WEB-INF/view/userProfile.jsp").forward(req, resp);
        }
    }
    private void getRequestData() {
        session = req.getSession();
        menuItem = req.getParameter("UserMenu");
        userId = ((User) req.getSession().getAttribute("User")).getId();
    }
    /*private void setDataForUserCruiseTable(){
        UserCruiseTable userCruiseTable = new UserCruiseTable();
        List<UserCruiseTable> userCruises = userCruiseTable.getUserCruise(userId);
        req.setAttribute("tickets", userCruises);
        userCruiseTable.closeConnection();
    }
    private void setDataForCruiseTable(){
        SelectionTable cruiseTable = new SelectionTable();
        List<SelectionTable> cruiseTables = cruiseTable.getCruise();
        req.setAttribute("tickets", cruiseTables);
        cruiseTable.closeConnection();
    }
    private void setDataForBonusTable(){
        UserBonusTable userBonusTable = new UserBonusTable();
        List<CruiseTicket> bonusTable = userBonusTable.getUserCruiseTicket(userId);
        req.setAttribute("tickets", bonusTable);
        userBonusTable.closeConnection();
    }*/
}
