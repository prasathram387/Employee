package com.ideas2it.management.dao;  


import com.ideas2it.management.model.Employee;
import com.ideas2it.management.model.Role;
import com.ideas2it.management.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.cfg.Configuration;  
import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;    

public class RoleDao {    

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
            throw new CustomException(error.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}            

