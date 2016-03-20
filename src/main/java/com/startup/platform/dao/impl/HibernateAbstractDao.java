package com.startup.platform.dao.impl;

import com.startup.platform.models.Model;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class HibernateAbstractDao<T extends Model> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> clazz;

    public HibernateAbstractDao() {
        final ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        clazz = (Class<T>) superClass.getActualTypeArguments()[0];
    }

    public List<T> getAll() {
        Criteria criteria = getSession().createCriteria(clazz);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    public T getById(int id) {
        Criteria criteria = getSession().createCriteria(clazz);
        criteria.add(Restrictions.eq("id", id));
        return (T) criteria.uniqueResult();
    }

    public void add(T model) {
        getSession().save(model);
    }

    public void update(T model) {
        getSession().merge(model);
    }

    public void remove(T model) {
        getSession().delete(model);
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
