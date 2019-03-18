package com.myCompany.conferenceManagmentSystem.controller.page;

import com.myCompany.conferenceManagmentSystem.controller.AbstractController;
import com.myCompany.conferenceManagmentSystem.exception.ApplicationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error")
public class ErrorController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        forwardToPage("error.jsp", httpServletRequest, httpServletResponse);
    }
}
