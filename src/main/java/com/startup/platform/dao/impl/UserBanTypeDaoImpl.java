package com.startup.platform.dao.impl;

import com.startup.platform.dao.UserBanTypeDao;
import com.startup.platform.model.UserBanType;
import org.springframework.stereotype.Repository;

@Repository(value = "userBanTypeDao")
public class UserBanTypeDaoImpl extends AbstractDao<UserBanType> implements UserBanTypeDao {

    public UserBanTypeDaoImpl() {
    }
}