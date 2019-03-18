package com.myCompany.conferenceManagmentSystem.servlets.servlet.main;

import com.myCompany.conferenceManagmentSystem.service.register.RegisterService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterService registerService = new RegisterService(req, resp);
        registerService.getRequestData(req);

        registerService.register();
    }


}
