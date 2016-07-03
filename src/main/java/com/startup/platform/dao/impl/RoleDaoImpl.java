package com.startup.platform.dao.impl;

import com.startup.platform.dao.RoleDao;
import com.startup.platform.model.Role;
import org.springframework.stereotype.Repository;

@Repository(value = "roleDao")
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {

    public RoleDaoImpl() {
    }


}