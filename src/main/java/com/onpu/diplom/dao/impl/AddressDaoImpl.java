package com.onpu.diplom.dao.impl;

import com.onpu.diplom.dao.AddressDao;
import com.onpu.diplom.entity.Address;
import com.onpu.diplom.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class AddressDaoImpl implements AddressDao {

    public void addAddres(Address address) throws SQLException {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }

    }

    public void deleteAddress(Address address) throws SQLException {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }

    }

    public Address getAddress(int id) throws SQLException {
        Address result = null;

        Session session = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            result = (Address) session.load(Address.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }

        return result;
    }

    public List<Address> getAddresses() throws SQLException {
        List<Address> addresses = null;

        Session session = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            addresses = session.createCriteria(Address.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }

        return addresses;
    }
}
