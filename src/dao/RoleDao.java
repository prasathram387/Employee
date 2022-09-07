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
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  

public class RoleDao {  

    static SessionFactory factory = new Configuration().configure().buildSessionFactory(); 

    public Role retrieveRoleByName(String roleName) throws CustomException {
	try {
            Session session = factory.openSession(); 
            session.beginTransaction();       
            Criteria criteria = session.createCriteria(Role.class);
            criteria.add(Restrictions.eq("name", roleName));
            Role role = (Role) criteria.uniqueResult();
            return role;
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        }
    }

    public List<Employee> retrieveAllEmployee() {
        Session session = factory.openSession();
        return session.createQuery("select employees from Role").list();
    }    

    public Role retrieveRoleIdByName(String roleName) throws CustomException {
	try {
            Session session = factory.openSession(); 
            session.beginTransaction();       
            Criteria criteria = session.createCriteria(Role.class);
            criteria.add(Restrictions.eq("name", roleName));
            Role role = (Role) criteria.uniqueResult();
            return role;
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        }
    }

    public List<Employee> retrieveEmployeeByRole(int roleId) {
        Session session = factory.openSession();
        return session.createQuery("select employees from Role where id = "+roleId).list();
    } 

}            

