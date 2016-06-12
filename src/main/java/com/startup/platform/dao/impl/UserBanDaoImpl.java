package com.startup.platform.dao.impl;

import com.startup.platform.dao.UserBanDao;
import com.startup.platform.model.UserBan;
import org.springframework.stereotype.Repository;

@Repository(value = "userBanDao")
public class UserBanDaoImpl extends AbstractDao<UserBan> implements UserBanDao {

    public UserBanDaoImpl() {
    }
}