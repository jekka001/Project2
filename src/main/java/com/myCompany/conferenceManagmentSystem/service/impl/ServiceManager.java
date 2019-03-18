package com.myCompany.conferenceManagmentSystem.service.impl;

import com.myCompany.conferenceManagmentSystem.dao.connection.ConnectionPoolHolder;
import com.myCompany.conferenceManagmentSystem.service.BusinessService;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.SQLException;

public class ServiceManager {
    private static final String SERVICE_MANAGER = "SERVICE_MANAGER";
    private static final Logger LOGGER = Logger.getLogger(ServiceManager.class);
    private final BusinessService businessService;
    private final Connection connection;

    public BusinessService getBusinessService() {
        return businessService;
    }

    private ServiceManager(ServletContext context){
        connection = ConnectionPoolHolder.getInstance().getConnection();
        businessService = new BusinessServiceImpl();
        LOGGER.info("ServiceManager instance created");
    }

    public static ServiceManager getInstance(ServletContext context){
        ServiceManager instance = (ServiceManager) context.getAttribute(SERVICE_MANAGER);
        if(instance == null){
            instance = new ServiceManager(context);
            context.setAttribute(SERVICE_MANAGER, instance);
        }
        return instance;
    }

    public void destroy(){
        try {
            connection.close();
        } catch (SQLException e) {
            LOGGER.error("Close dataSource failed: " + e.getMessage(), e);
        }
        LOGGER.info("ServiceManager instance destroyed");
    }


}
