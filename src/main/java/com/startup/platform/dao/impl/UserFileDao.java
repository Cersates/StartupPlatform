package com.startup.platform.dao.impl;

import com.startup.platform.dao.UserDao;
import com.startup.platform.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userFileDao")
public class UserFileDao extends FileAbstractDao<User> implements UserDao {

    public UserFileDao() {

    }

    public List<User> getAll() {
        return null;
    }

    public User getById() {
        return null;
    }

    public String getDatasourceName() {
        return null;
    }
}