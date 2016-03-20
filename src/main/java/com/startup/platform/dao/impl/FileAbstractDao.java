package com.startup.platform.dao.impl;

import com.startup.platform.dao.accessors.FileDatasourceAccessor;
import com.startup.platform.models.Model;

public abstract class FileAbstractDao<T extends Model> extends FileDatasourceAccessor {

    public void remove(T model) {
    }

    public void add(T model) {

    }

    public void update(T model) {

    }

}
