package com.startup.platform.dao.impl;

import com.startup.platform.dao.UserBanDao;
import com.startup.platform.models.UserBan;
import org.springframework.stereotype.Repository;

@Repository(value = "userBanDatabaseDao")
public class UserBanDatabaseDao extends HibernateAbstractDao<UserBan> implements UserBanDao {

    public UserBanDatabaseDao() {
    }
}