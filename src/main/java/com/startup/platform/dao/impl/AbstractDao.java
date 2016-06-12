package com.startup.platform.dao.impl;

import com.startup.platform.model.Model;
import com.startup.platform.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T extends Model> {

    //    @Autowired
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private Class<T> clazz;

    public AbstractDao() {
        final ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        clazz = (Class<T>) superClass.getActualTypeArguments()[0];
        sessionFactory.openSession();
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
        Session s = getSession();
        s.beginTransaction();
        s.save(model);
        s.getTransaction().commit();
//        getSession().save(model);
    }

    public void update(T model) {
        Session s = getSession();
        s.beginTransaction();
        s.merge(model);
        s.getTransaction().commit();
//        getSession().merge(model);
    }

    public void remove(T model) {
        Session s = getSession();
        s.beginTransaction();
        s.delete(model);
        s.getTransaction().commit();
//        getSession().delete(model);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
