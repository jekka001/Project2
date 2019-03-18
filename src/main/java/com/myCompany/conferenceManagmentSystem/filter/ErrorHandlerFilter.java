package com.myCompany.conferenceManagmentSystem.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ErrorHandlerFilter", urlPatterns = "/*")
public class ErrorHandlerFilter extends AbstractFilter{

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        try{
            filterChain.doFilter(req, resp);
        }catch (Throwable th){
            String requestUrl = req.getRequestURI();
            LOGGER.error("Error during processing the request: " + requestUrl, th);
            if(requestUrl.startsWith("/ajax/")){
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }else if(!requestUrl.startsWith("/error")){
                resp.sendRedirect("/error");
            } else{
                throw new ServletException(th);
            }
        }
    }
}
