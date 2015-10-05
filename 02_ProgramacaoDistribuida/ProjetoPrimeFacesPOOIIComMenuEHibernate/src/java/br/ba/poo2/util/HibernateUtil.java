/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try {
            AnnotationConfiguration conf = new AnnotationConfiguration();
            SessionFactory obj = conf.configure("hibernate.cfg.xml").buildSessionFactory();
            return obj;
            } catch (Throwable ex) {
            System.err.println("Falha ao Iniciar Sessão." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
