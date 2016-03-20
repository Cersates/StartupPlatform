package com.startup.platform.dao.impl;

import com.startup.platform.dao.UserBanTypeDao;
import com.startup.platform.models.UserBanType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userBanTypeFileDao")
public class UserBanTypeFileDao extends FileAbstractDao<UserBanType> implements UserBanTypeDao {

    public UserBanTypeFileDao() {

    }

    public List<UserBanType> getAll() {
        return null;
    }

    public UserBanType getById() {
        return null;
    }

    public String getDatasourceName() {
        return null;
    }
}