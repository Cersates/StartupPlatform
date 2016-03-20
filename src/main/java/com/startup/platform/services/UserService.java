package com.startup.platform.services;

import com.startup.platform.dao.UserDao;
import com.startup.platform.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserService {

    @Autowired()
    @Qualifier(value = "userFileDao")
    private UserDao userDao;

    public UserService() {
    }

    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }
}
