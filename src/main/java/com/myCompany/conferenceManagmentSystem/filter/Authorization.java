package com.myCompany.conferenceManagmentSystem.filter;

import com.myCompany.conferenceManagmentSystem.service.signIn.AuthorizationService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/Authorization")
public class Authorization implements Filter {
    private AuthorizationService authorizationService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        authorizationService = new AuthorizationService((HttpServletRequest) servletRequest,
                                                                            (HttpServletResponse) servletResponse);
        authorizationService.getRequestData();
        authorizationService.getUserData();
        authorizationService.userVerification();
    }

    @Override
    public void destroy() {
    }


}
