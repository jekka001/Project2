package com.myCompany.conferenceManagmentSystem.dao.connection;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPoolHolder {
    private static ConnectionPoolHolder instance;
    private static volatile DataSource dataSource;

    private ConnectionPoolHolder() {

    }

    public static ConnectionPoolHolder getInstance() {
        if (isNullConnectionPool()) {
            synchronized (ConnectionPoolHolder.class) {
                if (isNullConnectionPool()) {
                    instance = new ConnectionPoolHolder();
                }
            }
        }
        return instance;
    }

    private static boolean isNullConnectionPool() {
        return instance == null;
    }

    private DataSource getDataSource() {
        if (isNullDataSource()) {
            synchronized (ConnectionPoolHolder.class) {
                if (isNullDataSource()) {
                    initialization();
                }
            }
        }
        return dataSource;
    }

    private boolean isNullDataSource() {
        return dataSource == null;
    }

    private void initialization() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("dataBase");
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(resourceBundle.getString("url"));
        basicDataSource.setUsername(resourceBundle.getString("user"));
        basicDataSource.setPassword(resourceBundle.getString("pass"));
        basicDataSource.setMinIdle(Integer.valueOf(resourceBundle.getString("min.idle")));
        basicDataSource.setMaxIdle(Integer.valueOf(resourceBundle.getString("max.idle")));
        basicDataSource.setMaxOpenPreparedStatements(Integer.valueOf(resourceBundle.getString("max.open.prepare.statements")));
        dataSource = basicDataSource;
    }

    public Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
