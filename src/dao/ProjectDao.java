package com.ideas2it.management.dao;  

import com.ideas2it.management.model.Project;
import com.ideas2it.management.exception.CustomException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ProjectDao extends BaseDao {  

    Connection connection = databaseConnection();

    public int insertProject(Project project) throws CustomException {
	int projectId = 0;
	try {
            String query = "INSERT INTO project_detail(name, client_name, company_name, started_date, deadline, status) VALUES (?, ?,"
                + " ?, ?, ?, ?)";
            boolean isInserted = preparedStatement(query, project);
            String idQuery = "SELECT id FROM project_detail order by id DESC LIMIT 1";            
            projectId = lastInsertedProjectId(idQuery);                 	                          
        } catch (Exception error) {
            System.out.println(error.getMessage());
            error.printStackTrace();
	    throw new CustomException(error.getMessage());
        }
	return projectId;
    }

    public Project retrieveProject(int projectId) throws CustomException {
	try {
            String query = "select * from project_detail where id = " + projectId ; 
            return preparedStatementRetrieveProject(query);
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        }
    }


    public boolean preparedStatement(String query, Project project) throws CustomException {
        Date startedDate = Date.valueOf(project.getStartedDate());
        Date deadline = Date.valueOf(project.getDeadline());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);                        
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getClientName());
            preparedStatement.setString(3, project.getCompanyName());
            preparedStatement.setDate(4, startedDate); 
            preparedStatement.setDate(5, deadline);
            preparedStatement.setString(6, project.getStatus()); 
            return preparedStatement.execute(); 
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        }
    }

    public Project preparedStatementRetrieveProject(String query) throws CustomException {
        Project project = new Project();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);  
            ResultSet resultSet = preparedStatement.executeQuery();  
            while(resultSet.next()) {
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setClientName(resultSet.getString("client_name"));
                project.setCompanyName(resultSet.getString("company_name"));
                project.setStartedDate(resultSet.getDate("started_date").toLocalDate());     
                project.setDeadline(resultSet.getDate("deadline").toLocalDate());
                project.setStatus(resultSet.getString("status"));
            } 
            return project;
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        }
    }

    public boolean searchProjectId(int projectId) throws CustomException {
        int id = 0;
        try {
	    String query = "SELECT id FROM project_detail where id = '" + projectId + "' ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);          
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while(resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (Exception error) {
            error.printStackTrace();
	    throw new CustomException(error.getMessage());
        } 
        if (id == projectId) {
            return true;
        }
        return false;
    }

    public boolean updateProject(Project project, int projectId) throws CustomException { 
	try {
            String query = "update project_detail set name = ?, client_name = ?, company_name = ?, started_date = ?, deadline = ?,"
		+ " status = ? where id = " + projectId;
            return preparedStatement(query, project);                   	                          
        } catch (Exception error) {
            System.out.println(error.getMessage());
            error.printStackTrace();
	    throw new CustomException(error.getMessage());
        }
    }

    public boolean modifyProject(String fieldName, String fieldValue, int projectId) throws CustomException {
        try {
            String query = "update project_detail set " + fieldName + " = ? where id = ?";  
            PreparedStatement preparedStatement = connection.prepareStatement(query);                             
            preparedStatement.setString(1, fieldValue);
            preparedStatement.setInt(2, projectId);             
            int rowsUpdated = preparedStatement.executeUpdate();    
            if (rowsUpdated > 0) {
                return true;
            }
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        } 
        return false;
    }

    public boolean deleteProject(int projectId) throws CustomException {
        try {
	    String query = "update employee_detail set status = 'inactive' WHERE id = '" + projectId + "' ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);                             
            int rowsDeleted = preparedStatement.executeUpdate();    
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        } 
        return false;     
    }  

    public int lastInsertedProjectId(String query) throws CustomException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query); 
            ResultSet rs = preparedStatement.executeQuery(query);
            int projectId = 0;
            while(rs.next()){
               projectId = rs.getInt(1);
            } 
            return projectId;
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        }
    }
}