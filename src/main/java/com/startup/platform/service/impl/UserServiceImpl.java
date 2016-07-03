package com.startup.platform.service.impl;

import com.startup.platform.dao.UserDao;
import com.startup.platform.model.User;
import com.startup.platform.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao dao;


    public List<User> getAll() {
        return dao.getAll();
    }

    public User getById(int id) {
        return dao.getById(id);
    }

    public void add(User model) {
        dao.add(model);
    }

    public void update(User model) {
        dao.update(model);
    }

    public void remove(User model) {
        dao.remove(model);
    }
}
