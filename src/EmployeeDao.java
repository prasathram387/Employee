package org.ideas2it.management.dao;  

import org.ideas2it.management.model.Employee;
import org.ideas2it.management.exception.CustomException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Date;

public class EmployeeDao {  
    public boolean insertEmployee(Employee employee) throws CustomException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/employee?verifyServerCertificate=false&useSSL=true","root","Ram@i2it"); 
            Statement statement = connection.createStatement();
            String query = "INSERT INTO employee_detail(first_name, last_name, address, mobile_no, date_of_birth, gender, email_id, employee_id, "
		+ "batch, experience, role, designation)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);  
                      
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setLong(4, employee.getMobileNo());
            preparedStatement.setString(5, employee.getDateOfBirth());
            preparedStatement.setString(6, employee.getEmailId());
            preparedStatement.setString(7, employee.getGender());
            preparedStatement.setString(8, employee.getEmployeeId());
            preparedStatement.setInt(9, employee.getBatch());
            preparedStatement.setByte(10,employee.getExperience());
            preparedStatement.setString(11, employee.getRole()); 
            preparedStatement.setString(12, employee.getDesignation()); 
            preparedStatement.executeUpdate();  
                   	                        
	    ResultSet rs = statement.executeQuery("select * from employee_detail");  
	    while(rs.next()) {  
	        System.out.println(rs.getString("first_name")+"   " + rs.getLong("mobile_no")); 
	    }     
            preparedStatement.close();                                             
            connection.close();
        } catch (SQLException sqlException) {
	    throw new CustomException("Enter the valid input ",sqlException)
        }
        return true;
    }
} 