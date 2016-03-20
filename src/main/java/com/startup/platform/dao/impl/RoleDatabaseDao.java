package com.startup.platform.dao.impl;

import com.startup.platform.dao.RoleDao;
import com.startup.platform.models.Role;
import org.springframework.stereotype.Repository;

@Repository(value = "roleDatabaseDao")
public class RoleDatabaseDao extends HibernateAbstractDao<Role> implements RoleDao {

    public RoleDatabaseDao() {
    }


}