/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.dao;  

import com.ideas2it.model.Employee;
import com.ideas2it.model.Role;
import com.ideas2it.exception.CustomException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.cfg.Configuration;  
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;      

/**
 * <p>
 * EmployeeDao can be used for insert, retrieve, update operations on the database.
 * </p> 
 * @author Ramprasath
 * @version 1.0
 **/
public class EmployeeDao {

    /** 
     * <p>
     * To perform insert employee data to the database.
     * </p>
     * 
     * @param employee it contains employee information.
     */     
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
            transaction.rollback();
            throw new CustomException("Employee insertion failed", error);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /** 
     * <p>
     * To perform retrieve employee data from the database.
     * </p>
     * 
     * @param employeeId id of an employee.
     */  
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
            throw new CustomException("Retrieve failed", error);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /** 
     * <p>
     * To retrieve all employees data from the database.
     * </p>
     * 
     */  
    public Set<Employee> retrieveAllEmployees() throws CustomException {
        
        Session session = null;
       try {
            SessionFactory factory = BaseDao.getInstance();
            session = factory.openSession();  
            List<Employee> employee = session.createQuery("from Employee where status = :status").
                setParameter("status", "active").list(); 
            return new HashSet<Employee>(employee);
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException("Retrieve failed", error);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }    

    /** 
     * <p>
     * To perform update employee data to the database.
     * </p>
     * 
     * @param employee it contains employee information.
     */  
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
            transaction.rollback();
            throw new CustomException("Employee updation failed", error);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }          
}