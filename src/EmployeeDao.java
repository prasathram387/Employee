package org.ideas2it.management.dao;  

import org.ideas2it.management.model.Employee;
import org.ideas2it.management.exception.CustomException;

import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Date;

public class EmployeeDao extends BaseDao {  
    public boolean insertEmployee(Employee employee) throws CustomException {
	try {
            Connection connection = BaseDao.databaseConnection();
            String query = "INSERT INTO employee_detail(first_name, last_name, address, mobile_no, date_of_birth, gender, email_id, employee_id, "
		+ "batch, date_of_joining, designation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            preparedStatement.setString(10, employee.getDateOfJoining());
            preparedStatement.setString(11, employee.getDesignation()); 
            preparedStatement.executeUpdate();                     	                          
            preparedStatement.close();                                             
            connection.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
	    throw new CustomException(error.getMessage());
        }
	return true;
    }
} 