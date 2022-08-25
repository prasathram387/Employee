package org.ideas2it.management.dao;  

import org.ideas2it.management.model.Employee;
import org.ideas2it.management.exception.CustomException;

import java.util.ArrayList;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.util.List;
import java.sql.*;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class EmployeeDao extends BaseDao {  
    List<Employee> employees = new ArrayList<Employee>();
    Connection connection = BaseDao.databaseConnection();
    public int insertEmployee(Employee employee) throws CustomException {
	int employeeId = 0;
	try {
            String query = "INSERT INTO employee_detail(first_name, last_name, address, mobile_no, date_of_birth, gender, email_id "
		+ "batch, date_of_joining, designation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);                        
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setLong(4, employee.getMobileNo());
            preparedStatement.setDate(5, employee.getDateOfBirth());
            preparedStatement.setString(6, employee.getEmailId());
            preparedStatement.setString(7, employee.getGender());
            preparedStatement.setInt(9, employee.getBatch());
            preparedStatement.setDate(10, employee.getDateOfJoining());
            preparedStatement.setString(11, employee.getDesignation());   
            String idQuery = "select id from employee_detail";
            ResultSet rs = preparedStatement.executeQuery(idQuery);
            if(rs != null && rs.next()){
                employeeId = rs.getInt(1);
                System.out.println(employeeId);
            }                   	                          
        } catch (Exception error) {
            System.out.println(error.getMessage());
            error.printStackTrace();
	    throw new CustomException(error.getMessage());
        }
	return employeeId;
    }

    public List<Employee> retrieveEmployee() throws CustomException {
	try {
            String query = "select employee_detail.*,employee_roles.role_id from employee_roles inner join " +
                "employee_detail on employee_detail.id = employee_roles.employee_id where employee_roles.role_id = '1'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);  
            ResultSet resultSet = preparedStatement.executeQuery();  
            while(resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
		long mobileNo = resultSet.getLong("mobile_no");
                Date dateOfBirth = SELECT FORMAT (resultSet.getDate("date_of_birth"), "'dd-MM-yy'") as date;
                String gender = resultSet.getString("gender");
		String emailId = resultSet.getString("email_id");
		int batch = resultSet.getInt("batch");
                Date dateOfJoining = resultSet.getDate("date_of_joining");
		String designation = resultSet.getString("designation");		
                Employee employee = new Employee(firstName, lastName, address, mobileNo, dateOfBirth, gender, emailId,
                    batch, dateOfJoining, designation);
                employees.add(employee);
            }                 	                                                                       
        } catch (Exception error) {
            System.out.println(error.getMessage());
            error.printStackTrace();
	    throw new CustomException(error.getMessage());
        }
        return employees;
    } 
}