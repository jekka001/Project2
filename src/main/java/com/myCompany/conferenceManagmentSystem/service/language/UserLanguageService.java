package com.myCompany.conferenceManagmentSystem.service.language;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

public class UserLanguageService {
    private ResourceManager manager = ResourceManager.INSTANCE;
    private HttpSession session;
    private HttpServletRequest req;
    private HttpServletResponse res;
    private String stringLocale;
    private Locale locale;

    public UserLanguageService(HttpServletRequest req, HttpServletResponse res) {
        this.req = req;
        this.res = res;
    }

    public void getRequestData(){
        stringLocale = req.getParameter("Language");
        if(isEmptyStringLocale()){
            stringLocale = "English";
        }
        session = req.getSession();
    }
    private boolean isEmptyStringLocale(){
        return stringLocale == null;
    }

    public void moveToMenu() throws ServletException, IOException {
        switch (stringLocale){
            case "Русский":
                locale = Language.RUS.getLocale();
                break;
            case "Українська":
                locale = Language.UA.getLocale();
                break;
            default:
                locale = Language.ENG.getLocale();
        }
        manager.changeLocale(locale);
        setLanguage();

        moveToRequest();

    }
    private void setLanguage(){
        session.setAttribute("lang", manager.getMessage("LANG"));
        session.setAttribute("title", manager.getMessage("TITLE"));
        session.setAttribute("sign_in", manager.getMessage("SIGN_IN"));
        session.setAttribute("registration", manager.getMessage("REGISTRATION"));
        session.setAttribute("password_coincide", manager.getMessage("PASSWORD_COINCIDE"));
        session.setAttribute("email", manager.getMessage("EMAIL"));
        session.setAttribute("password", manager.getMessage("PASSWORD"));
        session.setAttribute("register", manager.getMessage("REGISTER"));
        session.setAttribute("name", manager.getMessage("NAME"));
        session.setAttribute("surname", manager.getMessage("SURNAME"));
        session.setAttribute("email_busy", manager.getMessage("EMAIL_BUSY"));
        session.setAttribute("user_wrong", manager.getMessage("USER_WRONG"));
        session.setAttribute("searching", manager.getMessage("SEARCHING"));
        session.setAttribute("repeat_password", manager.getMessage("REPEAT_PASSWORD"));
        session.setAttribute("log_out", manager.getMessage("LOG_OUT"));
        session.setAttribute("action", manager.getMessage("ACTION"));
        session.setAttribute("previous", manager.getMessage("PREVIOUS"));
        session.setAttribute("find", manager.getMessage("FIND"));
        session.setAttribute("next", manager.getMessage("NEXT"));
        session.setAttribute("refuse", manager.getMessage("REFUSE"));
        session.setAttribute("buy", manager.getMessage("BUY"));
        session.setAttribute("save", manager.getMessage("SAVE"));

    }
    private void moveToRequest() throws ServletException, IOException {
        if(userNotAuthorization()) {
            req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, res);
        }/*else {
            switch (userRole()) {
                case "User":
                    updateTableforUser();
                    break;
                case "Admin":
                    updateTableforAdmin();
                    break;
                case "Speaker":
                    updateTableforSpeaker();
                    break;
                case "Moderator":
                    updateTableforModerator();
            }
            req.getRequestDispatcher("/WEB-INF/view/tableConference.jsp").forward(req, res);
        }*/

    }
    private boolean userNotAuthorization(){
        return session.getAttribute("User") == null;
    }
    /*private String userRole(){
        return ((User)session.getAttribute("User")).getRole().name();
    }
    private void updateTableforUser(){
        AdminBonusTable adminBonusTable = new AdminBonusTable();
        List<CruiseTicket> userCruises = adminBonusTable.getCruiseTicket();
        req.setAttribute("tickets", userCruises);
        adminBonusTable.closeConnection();
    }
    private void updateTableforAdmin(){

    }
    private void updateTableforSpeaker(){

    }
    private void updateTableforModerator(){

    }*/
}
