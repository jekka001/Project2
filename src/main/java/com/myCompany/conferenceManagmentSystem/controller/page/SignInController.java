package com.myCompany.conferenceManagmentSystem.controller.page;

import com.myCompany.conferenceManagmentSystem.controller.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/signIn")
public class SignInController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToPage("signIn.jsp", req, resp);
    }
}
