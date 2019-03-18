package com.myCompany.conferenceManagmentSystem.servlets.servlet.user.menu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
    //final static Logger logger = Logger.getLogger(Logout.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        removeAttributeSession(req);
        resp.sendRedirect("/");
    }

    private void removeAttributeSession(HttpServletRequest req){
        HttpSession session = req.getSession();
        //logger.info("User " + ((User)session.getAttribute("User")).getEmail() + " go out");
        session.removeAttribute("User");
        session.removeAttribute("PageBonus");
        session.removeAttribute("PageChooseCruise");
        session.removeAttribute("PageUserCruise");
        session.removeAttribute("lang");
        session.removeAttribute("title");
        session.removeAttribute("sign_in");
        session.removeAttribute("registration");
        session.removeAttribute("change");
        session.removeAttribute("user_cruise");
        session.removeAttribute("choose_cruise");
        session.removeAttribute("bonuses");
        session.removeAttribute("admin");
        session.removeAttribute("searching");
        session.removeAttribute("email");
        session.removeAttribute("password");
        session.removeAttribute("button_sign_in");
        session.removeAttribute("button_register");
        session.removeAttribute("name");
        session.removeAttribute("surname");
        session.removeAttribute("repeat_password");
        session.removeAttribute("my_profile");
        session.removeAttribute("my_cruise");
        session.removeAttribute("button_choose_cruise");
        session.removeAttribute("my_bonus");
        session.removeAttribute("log_out");
        session.removeAttribute("button_change");
        session.removeAttribute("name_cruise");
        session.removeAttribute("city_departure");
        session.removeAttribute("start_cruise");
        session.removeAttribute("duration_cruise");
        session.removeAttribute("name_ship");
        session.removeAttribute("ticket_id");
        session.removeAttribute("number_of_tickets");
        session.removeAttribute("ticket_class");
        session.removeAttribute("action");
        session.removeAttribute("previous");
        session.removeAttribute("find");
        session.removeAttribute("next");
        session.removeAttribute("refuse");
        session.removeAttribute("ticket_price");
        session.removeAttribute("buy");
        session.removeAttribute("bonus");
        session.removeAttribute("change_bonus");
        session.removeAttribute("save");
    }
}
