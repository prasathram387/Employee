package com.ideas2it.dao;

import com.ideas2it.exception.CustomException;

import org.hibernate.cfg.Configuration;      
import org.hibernate.SessionFactory;

public class BaseDao {

    protected static SessionFactory factory; 

    private BaseDao() {
  
    }

    public static SessionFactory getInstance() {

        if (factory == null) {
            factory = new Configuration().configure().buildSessionFactory();
        }
        return factory;
    }
}
        
