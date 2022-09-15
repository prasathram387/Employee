/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.dao;

import com.ideas2it.exception.CustomException;

import org.hibernate.cfg.Configuration;      
import org.hibernate.SessionFactory;

/**
 * <p>
 * BaseDao can be used for create session factory.
 * </p> 
 * @author Ramprasath
 * @version 1.0
 **/
public class BaseDao {

    private static SessionFactory factory = null; 

    private BaseDao() {
  
    }

    /** 
     * <p>
     * getInstance can be used for create session factory object.
     * </p>
     *
    public static SessionFactory getInstance() {
        if (factory == null) {
            return new Configuration().configure().buildSessionFactory();
        }
        return factory;
    }
}
        
