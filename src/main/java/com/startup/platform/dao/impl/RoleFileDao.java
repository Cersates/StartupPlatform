package com.startup.platform.dao.impl;

import com.startup.platform.dao.RoleDao;
import com.startup.platform.models.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "roleFileDao")
public class RoleFileDao extends FileAbstractDao<Role> implements RoleDao {

    public RoleFileDao() {

    }

    public List<Role> getAll() {
        return null;
    }

    public Role getById() {
        return null;
    }

    public String getDatasourceName() {
        return null;
    }
}