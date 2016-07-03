package com.startup.platform.dao.impl;

import com.startup.platform.dao.UserDao;
import com.startup.platform.model.User;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public UserDaoImpl() {
    }

}