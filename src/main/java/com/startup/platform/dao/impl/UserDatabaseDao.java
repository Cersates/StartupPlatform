package com.startup.platform.dao.impl;

import com.startup.platform.dao.UserDao;
import com.startup.platform.models.User;
import org.springframework.stereotype.Repository;

@Repository(value = "userDatabaseDao")
public class UserDatabaseDao extends HibernateAbstractDao<User> implements UserDao {

    public UserDatabaseDao() {
    }

}