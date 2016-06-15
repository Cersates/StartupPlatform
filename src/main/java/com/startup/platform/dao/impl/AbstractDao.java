package com.startup.platform.dao.impl;

import com.startup.platform.model.Model;
import com.startup.platform.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.ParameterizedType;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractDao<T extends Model> {

    //    @Autowired
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private Class<T> clazz;

    public AbstractDao() {
        final ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        clazz = (Class<T>) superClass.getActualTypeArguments()[0];
    }

    public List<T> getAll() {
        Criteria criteria = getSession().createCriteria(clazz);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        getSession().close();
        Comparator с = new Comparator<T>() {
            public int compare(T o1, T o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                }
                return -1;
            }
        };
        List<T> list = criteria.list();
        list.sort(с);
        return list;
    }

    public T getById(int id) {
        Criteria criteria = getSession().createCriteria(clazz);
        criteria.add(Restrictions.eq("id", id));
        getSession().close();
        return (T) criteria.uniqueResult();
    }

    public void add(T model) {
        Session s = getSession();
        s.beginTransaction();
        s.save(model);
        s.getTransaction().commit();
        s.close();
    }

    public void update(T model) {
        Session s = getSession();
        s.beginTransaction();
        s.merge(model);
        s.getTransaction().commit();
        s.close();
    }

    public void remove(T model) {
        Session s = getSession();
        s.beginTransaction();
        s.delete(model);
        s.getTransaction().commit();
        s.close();
    }

    public Session getSession() {
        if (sessionFactory.isClosed()) {
            sessionFactory.openSession();
        }
        return sessionFactory.openSession();
    }
}
