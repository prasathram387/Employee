/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.dao;  

import com.ideas2it.model.Employee;
import com.ideas2it.model.Project;
import com.ideas2it.model.EmployeeProject;
import com.ideas2it.exception.CustomException;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.cfg.Configuration;  
import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;

/**
 * <p>
 * projectDao can be used for insert, retrieve, update operations of project on the database.
 * </p> 
 * @author Ramprasath
 * @version 1.0
 **/
public class ProjectDao {  

    /** 
     * <p>
     * To perform insert project data to the database.
     * </p>
     * 
     * @param project it contains project information.
     */  
    public int insertProject(Project project) throws CustomException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseDao.getInstance().openSession();  
            transaction = session.beginTransaction();   
            int projectId = (Integer) session.save(project);  
            transaction.commit();        
            return projectId; 
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

    /** 
     * <p>
     * To perform retrieve project from the database using project.
     * </p>
     * 
     * @param projectId id of the project.
     */  
    public Project retrieveProjectById(int projectId) throws CustomException {
        Session session = null;  
        Transaction transaction = null;
        try {
            session = BaseDao.getInstance().openSession();  
            session.beginTransaction();       
            return (Project) session.get(Project.class, projectId);
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException("Project Id not Found",error);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /** 
     * <p>
     * To perform retrieves all the projects from the database using project.
     * </p>
     * 
     */ 
    public Set<Project> retrieveAllProjects() throws CustomException {
        Session session = null;
       try {
            SessionFactory factory = BaseDao.getInstance();
            session = factory.openSession();  
            List<Project> project = session.createQuery("from Project").list();
            return new HashSet<Project>(project); 
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    } 

    /** 
     * <p>
     * To update project on the database.
     * </p>
     * 
     * @param project it contains project information.
     */ 
    public void updateProject(Project project) throws CustomException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseDao.getInstance().openSession();  
            transaction = session.beginTransaction();   
            session.saveOrUpdate(project);  
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

    /** 
     * <p>
     * To insert employee project to the database.
     * </p>
     * 
     * @param employeeProject it contains employeeProject information.
     */ 
    public void assignEmployeesForProject(EmployeeProject employeeProject) throws CustomException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseDao.getInstance().openSession();  
            transaction = session.beginTransaction();   
            session.save(employeeProject);  
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