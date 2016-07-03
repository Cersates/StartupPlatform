package com.startup.platform.dao;

import com.startup.platform.model.Model;

import java.util.List;

public interface ItemDao<T extends Model> {

    public List<T> getAll();

    public T getById(int id);

    public void add(T model);

    public void update(T model);

    public void remove(T model);

}
