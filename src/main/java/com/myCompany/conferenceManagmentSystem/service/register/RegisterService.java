package com.myCompany.conferenceManagmentSystem.service.register;

import com.myCompany.conferenceManagmentSystem.service.language.ResourceManager;
import com.myCompany.conferenceManagmentSystem.service.user.UserService;
import com.myCompany.conferenceManagmentSystem.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterService {
    private HttpServletRequest req;
    private HttpServletResponse res;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String repeatPassword;
    private ResourceManager manager = ResourceManager.INSTANCE;
    private UserService userService = new UserServiceImpl();

    public RegisterService(HttpServletRequest req, HttpServletResponse res) {
        this.req = req;
        this.res = res;
    }

    public void getRequestData(HttpServletRequest req){
        name = req.getParameter("NameRegister");
        surname = req.getParameter("SurnameRegister");
        email = req.getParameter("EmailRegister");
        password = req.getParameter("PasswordRegister");
        repeatPassword = req.getParameter("RepeatPasswordRegister");
    }
    public void register() throws ServletException, IOException {
        if(!equalsPasswordAndRepeatPassword()){
            setDataForRegistrationFields(req);
            req.setAttribute("Error", manager.getMessage("PASSWORD_COINCIDE"));
            req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, res);
        }else if (!userService.isExistEmail(email)) {
            userService.makingUser(name, surname, email, password);
            ((UserServiceImpl)userService).closeConnection();
            res.sendRedirect("/");
        } else{
            setDataForRegistrationFields(req);
            req.setAttribute("Error", manager.getMessage("EMAIL_BUSY"));
            req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, res);
        }
    }
    private boolean equalsPasswordAndRepeatPassword(){
        return password.equals(repeatPassword);
    }
    private void setDataForRegistrationFields(HttpServletRequest req){
        req.setAttribute("NameRegister", name);
        req.setAttribute("SurnameRegister", surname);
        req.setAttribute("EmailRegister", email);
    }
}
