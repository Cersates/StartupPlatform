package com.startup.platform.service.impl;

import com.startup.platform.dao.RoleDao;
import com.startup.platform.model.Role;
import com.startup.platform.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Resource(name = "roleDao")
    private RoleDao dao;


    public List<Role> getAll() {
        return dao.getAll();
    }

    public Role getById(int id) {
        return dao.getById(id);
    }

    public void add(Role model) {
        dao.add(model);
    }

    public void update(Role model) {
        dao.update(model);
    }

    public void remove(Role model) {
        dao.remove(model);
    }
}
