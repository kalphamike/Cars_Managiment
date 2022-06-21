/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Mugara Steven
 */
public class GeneralDao<A> {
    private Class<A> type;

    public GeneralDao(Class<A> type) {
        this.type = type;
    }
    Session ss=null;
    public A insert(A obj)
    {
        ss=HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(obj);
        ss.getTransaction().commit();
        ss.close();
        return obj;
    }
       public A update(A obj)
    {
        ss=HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.update(obj);
        ss.getTransaction().commit();
        ss.close();
        return obj;
        
    }
       public A delete(A obj)
    {
        ss=HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(obj);
        ss.getTransaction().commit();
        ss.close();
        return obj;
    }
      public A findById(Serializable id){
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        A obj =  (A) ss.get(type,id);
        ss.getTransaction().commit();
        ss.close();
        return obj;
    }
    public A findByName(String name){
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        A obj = (A) ss.get(type,name);
        ss.getTransaction().commit();
        ss.close();
        return obj;
    }
   
       public List<A> findAll()
    {
        ss=HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        Criteria cri=ss.createCriteria(type);
        //Query qr=ss.createQuery(type.getTypeName());
        List<A> list=cri.list();
        
        return list;
    }
}
