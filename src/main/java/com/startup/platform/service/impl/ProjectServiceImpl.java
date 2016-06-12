package com.startup.platform.service.impl;

import com.startup.platform.dao.ProjectDao;
import com.startup.platform.model.Project;
import com.startup.platform.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "projectService")
public class ProjectServiceImpl implements ProjectService {

    @Resource(name = "projectDao")
    private ProjectDao dao;


    public List<Project> getAll() {
        return dao.getAll();
    }

    public Project getById(int id) {
        return dao.getById(id);
    }

    public void add(Project model) {
        dao.add(model);
    }

    public void update(Project model) {
        dao.update(model);
    }

    public void remove(Project model) {
        dao.remove(model);
    }
}
