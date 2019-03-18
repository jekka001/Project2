package com.myCompany.conferenceManagmentSystem.listener;

import com.myCompany.conferenceManagmentSystem.service.impl.ServiceManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AplicationListener implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(AplicationListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServiceManager.getInstance(sce.getServletContext());
        LOGGER.info("Application started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServiceManager.getInstance(sce.getServletContext()).destroy();
        LOGGER.info("Application destroyed");
    }
}
