package com.ideas2it.dao;  

import com.ideas2it.exception.CustomException;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Role;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

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

