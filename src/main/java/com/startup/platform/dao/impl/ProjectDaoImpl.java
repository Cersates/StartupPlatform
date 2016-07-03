package com.startup.platform.dao.impl;

import com.startup.platform.dao.ProjectDao;
import com.startup.platform.model.Project;
import org.springframework.stereotype.Repository;

@Repository(value = "projectDao")
public class ProjectDaoImpl extends AbstractDao<Project> implements ProjectDao {

    public ProjectDaoImpl() {
    }


}