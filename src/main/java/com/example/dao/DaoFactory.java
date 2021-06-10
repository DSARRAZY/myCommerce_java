package com.example.dao;

import com.example.dao.jpa.JpaMyProductDao;
import com.example.dao.jpa.PersistenceManager;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static MyProductDao getMyProductDao() {

        return new JpaMyProductDao(PersistenceManager.getConnection());

    }

}