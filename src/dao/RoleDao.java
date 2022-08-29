package com.ideas2it.management.dao;  

import com.ideas2it.management.model.Employee;
import com.ideas2it.management.exception.CustomException;

import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

public class RoleDao extends BaseDao {  

    public int reteriveRoleByName(String role) throws CustomException {
	int roleId = 0;
	try {
            String query = "Select id from role where name ='" + role + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);  
            ResultSet rs = preparedStatement.executeQuery(); 
            while (rs.next()) {
                roleId = rs.getInt("id");
            } 
            return roleId;                  	                                                                       
        } catch (Exception error) {
            System.out.println(error.getMessage());
            error.printStackTrace();
	    throw new CustomException(error.getMessage());
        }          
    }

    public boolean insertEmployeeRole(int employeeId, int roleId) throws CustomException {
        boolean isAdded = false;
	try {
            String query = "INSERT INTO employee_roles(employee_id , role_id) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.setInt(2, roleId);
            isAdded = preparedStatement.execute();                                              
        } catch (Exception error) {
            System.out.println(error.getMessage());
            error.printStackTrace();
	    throw new CustomException(error.getMessage());
        }
        return isAdded; 
    }
}            

// select employee_detail.first_name, employee_detail.last_name, employee_detail.address, employee_detail.mobile_no, date_format(employee_detail.date_of_birth,"%d %M %y"), employee_detail.email_id, employee_detail.batch, date_format(employee_detail.date_of_joining,"%d %M %y"), employee_detail.designation, employee_roles.role_id from employee_roles inner join employee_detail on employee_detail.id = employee_roles.employee_id where employee_roles.role_id = '1';