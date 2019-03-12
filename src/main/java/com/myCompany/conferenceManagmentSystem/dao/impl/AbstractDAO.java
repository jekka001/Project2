package com.myCompany.conferenceManagmentSystem.dao.impl;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractDAO<T> {
    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract List<T> findAll();
    public abstract T findById(long id);
    public abstract List<T> findByString(String type, String value);
    public abstract List<T> findByLong(String type, long value);
    public abstract boolean create(T object);
    public abstract T update(T object);
    public abstract boolean delete(T object);
    public abstract boolean delete(long id);
}
