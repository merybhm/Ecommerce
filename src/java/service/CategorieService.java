/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Categorie;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

/**
 *
 * @author categorie
 */
public class CategorieService implements IDao<Categorie> {

     public boolean create(Categorie o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Categorie o)  {
               Session session = null;
        Transaction tx = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Categorie o) {
                Session session = null;
        Transaction tx = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    @Override
    public Categorie findById(int id) {
        Categorie categorie = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categorie  = (Categorie) session.get(Categorie.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return categorie;
    }
     

    @Override
    public List<Categorie> findAll() {
        List<Categorie> categories = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categories  =  session.createQuery("from Categorie").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return categories;
    }
    
}
