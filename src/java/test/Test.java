/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.hibernate.Hibernate;

import util.NewHibernateUtil;

/**
 *
 * @author a
 */
public class Test {
    public static void main(String[] args) {
             NewHibernateUtil.getSessionFactory().openSession();
    }
}
