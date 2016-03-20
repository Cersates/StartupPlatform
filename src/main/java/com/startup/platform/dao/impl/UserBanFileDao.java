package com.startup.platform.dao.impl;

import com.startup.platform.dao.UserBanDao;
import com.startup.platform.models.UserBan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userBanFileDao")
public class UserBanFileDao extends FileAbstractDao<UserBan> implements UserBanDao {

    public UserBanFileDao() {

    }

    public List<UserBan> getAll() {
        return null;
    }

    public UserBan getById() {
        return null;
    }

    public String getDatasourceName() {
        return null;
    }
}