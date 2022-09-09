package com.ideas2it.dao;  

import com.ideas2it.model.Project;
import com.ideas2it.model.EmployeeProject;
import com.ideas2it.exception.CustomException;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.cfg.Configuration;  
import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;

public class ProjectDao {  

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

    public List<Project> retrieveAllProjects() throws CustomException {
        Session session = null;
       try {
            SessionFactory factory = BaseDao.getInstance();
            session = factory.openSession();  
            return session.createQuery("from Project").list(); 
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    } 

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

    public void deleteProject(Project project) throws CustomException {
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

}