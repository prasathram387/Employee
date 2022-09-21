/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.dao;  

import com.ideas2it.exception.CustomException;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Role;

import java.util.List; 

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.cfg.Configuration;  
import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;   

/**
 * <p>
 * RoleDao can be used for perform role operations on the database.
 * </p> 
 * @author Ramprasath
 * @version 1.0
 **/
public class RoleDao {    

    /** 
     * <p>
     * To retrieve the role from the database.
     * </p>
     * 
     * @param roleName it contains user role.
     */    
    public Role retrieveRoleByName(String roleName) throws CustomException {
        Session session = null;
	try {
            session = BaseDao.getInstance().openSession(); 
            session.beginTransaction();       
            Criteria criteria = session.createCriteria(Role.class);
            criteria.add(Restrictions.eq("name", roleName));
            List<Role> role = criteria.list();
            return role.get(0);
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException("Retrieve role failed", error);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}            

