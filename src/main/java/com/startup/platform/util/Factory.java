package com.startup.platform.util;

import com.startup.platform.dao.UserDao;

public class Factory {

    private static Factory instance = new Factory();
    private UserDao userDao;

    private Factory() {
    }

    public static Factory getInstance() {
        return Factory.instance;
    }

    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

}
