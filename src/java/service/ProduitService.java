/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Categorie;
import entities.Marque;
import entities.Produit;
import entities.Produit;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

/**
 *
 * @author produit
 */
public class ProduitService  implements IDao <Produit> {
    
       public boolean create(Produit o) {
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
    public boolean delete(Produit o)  {
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
    public boolean update(Produit o) {
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
    public Produit findById(int id) {
        Produit produit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit  = (Produit) session.get(Produit.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return produit;
    }
     
    

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits  =  session.createQuery("from Produit").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return produits;
    }

  public List<Produit> findByCategorie(Categorie ct){
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits  =  session.createQuery("from Produit p where p.categorie = "+ct.getId()).list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return produits;
        
    }
    public List<Produit>  findByMarque(Marque mar) {
       List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
           produits  =  session.createQuery("from Produit p where p.marque = "+mar.getId()).list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return produits;
    
}
}
