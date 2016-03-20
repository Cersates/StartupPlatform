package com.startup.platform.dao.impl;

import com.startup.platform.dao.UserBanTypeDao;
import com.startup.platform.models.UserBanType;
import org.springframework.stereotype.Repository;

@Repository(value = "userBanTypeDatabaseDao")
public class UserBanTypeDatabaseDao extends HibernateAbstractDao<UserBanType> implements UserBanTypeDao {

    public UserBanTypeDatabaseDao() {
    }
}