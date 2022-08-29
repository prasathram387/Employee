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
                + " ?, current_timestamp, ?, ?)";
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

    public boolean preparedStatement(String query, Project project) throws CustomException {
        Date startedDate = Date.valueOf(project.getStartedDate());
        Date deadline = Date.valueOf(project.getDeadline());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);                        
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getClientName());
            preparedStatement.setString(3, project.getCompanyName());
            preparedStatement.setDate(4, deadline);
            return preparedStatement.execute(); 
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
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
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }
}