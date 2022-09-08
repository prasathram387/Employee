package com.ideas2it.management.dao;  

import com.ideas2it.management.model.Employee;
import com.ideas2it.management.model.Role;
import com.ideas2it.management.exception.CustomException;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.cfg.Configuration;  
import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;      

public class EmployeeDao {
     
    public int insertEmployee(Employee employee) throws CustomException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseDao.getInstance().openSession();  
            transaction = session.beginTransaction();   
            int employeeId = (Integer) session.save(employee);  
            transaction.commit();        
            return employeeId; 
        } catch (Exception error) {
            error.printStackTrace();
            System.out.println(error.getMessage());
            throw new CustomException(error.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Employee retrieveEmployeeById(int employeeId) throws CustomException {
        Session session = null;  
        Transaction transaction = null;
       try {
            session = BaseDao.getInstance().openSession();  
            session.beginTransaction();       
            Employee employee = (Employee) session.get(Employee.class, employeeId);
            return employee;
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Employee> retrieveAllEmployees() throws CustomException {
        Session session = null;
       try {
            SessionFactory factory = BaseDao.getInstance();
            session = factory.openSession();  
            return session.createQuery("from Employee where status = :status").
                setParameter("status", "active").list(); 
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }    

    public void updateEmployee(Employee employee) throws CustomException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseDao.getInstance().openSession();  
            transaction = session.beginTransaction();   
            session.saveOrUpdate(employee);  
            transaction.commit();         
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }  

    public void deleteEmployee(Employee employee) throws CustomException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseDao.getInstance().openSession();  
            transaction = session.beginTransaction();   
            session.saveOrUpdate(employee);  
            transaction.commit();         
        } catch (Exception error) {
            error.printStackTrace();
            System.out.println(error.getMessage());
            throw new CustomException(error.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }        
}