package com.myCompany.conferenceManagmentSystem.controller;

import com.myCompany.conferenceManagmentSystem.service.BusinessService;
import com.myCompany.conferenceManagmentSystem.service.impl.ServiceManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController extends HttpServlet {
    protected final Logger LOGGER = Logger.getLogger(AbstractController.class);
    private BusinessService businessService;

    public final BusinessService getBusinessService() {
        return businessService;
    }

    @Override
    public void init() throws ServletException {
        businessService = ServiceManager.getInstance(getServletContext()).getBusinessService();
    }

    public final void forwardToPage(String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentPage", "page/" + jspPage);
        req.getRequestDispatcher("/WEB-INF/JSP/pageTemplate.jsp").forward(req, resp);
    }

    public final void forwardToFragment(String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/JSP/fragment/" + jspPage).forward(req, resp);
    }

}
