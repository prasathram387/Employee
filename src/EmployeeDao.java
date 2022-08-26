package org.ideas2it.management.dao;  

import org.ideas2it.management.model.Employee;
import org.ideas2it.management.exception.CustomException;
import org.ideas2it.management.utils.ValidationUtil;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.Instant;
import java.util.List;
import java.time.LocalDate;
import java.sql.*;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class EmployeeDao extends BaseDao {  

    Connection connection = databaseConnection();

    public int insertEmployee(Employee employee) throws CustomException {
       System.out.println(employee.getDateOfBirth());
	int employeeId = 0;
	try {
            String query = "INSERT INTO employee_detail(first_name, last_name, address, mobile_no, date_of_birth, gender, email_id, "
		+ "batch, date_of_joining, designation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Instant instant1 = employee.getDateOfBirth().toInstant();
            ZonedDateTime zone1 = instant1.atZone(ZoneId.systemDefault());
            LocalDate dateOfBirth = zone1.toLocalDate();
            Date birthDate = Date.valueOf(dateOfBirth);
            System.out.println(birthDate);
            Instant instant = employee.getDateOfJoining().toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate dateOfJoining = zone.toLocalDate();
            Date joinDate = Date.valueOf(dateOfJoining);
            PreparedStatement preparedStatement = connection.prepareStatement(query);                        
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setLong(4, employee.getMobileNo());
            preparedStatement.setDate( 5, birthDate);
            preparedStatement.setString(6, employee.getGender());
            preparedStatement.setString(7, employee.getEmailId());
            preparedStatement.setInt(8, employee.getBatch());
            preparedStatement.setDate(9, joinDate);
            preparedStatement.setString(10, employee.getDesignation());  
            preparedStatement.execute(); 
            String idQuery = "SELECT id FROM employee_detail order by id DESC LIMIT 1";            
            ResultSet rs = preparedStatement.executeQuery(idQuery);
            while(rs.next()){
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
        List<Employee> employees = new ArrayList<Employee>();
	try {
            String query = "select employee_detail.first_name, employee_detail.last_name, employee_detail.address, employee_detail.mobile_no," +
                "employee_detail.date_of_birth, employee_detail.gender, employee_detail.email_id, employee_detail.batch," + 
                "employee_detail.date_of_joining, employee_detail.designation, employee_roles.role_id from employee_roles inner join " +
                "employee_detail on employee_detail.id = employee_roles.employee_id where employee_roles.role_id = '1'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);  
            ResultSet resultSet = preparedStatement.executeQuery();  
            while(resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
		long mobileNo = resultSet.getLong("mobile_no");
                java.util.Date dateOfBirth =  resultSet.getDate("date_of_birth");                
                System.out.println(dateOfBirth);
                String gender = resultSet.getString("gender");
		String emailId = resultSet.getString("email_id");
		int batch = resultSet.getInt("batch");
                java.util.Date dateOfJoining = resultSet.getDate("date_of_joining");
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
    } // select date_format(date_of_birth,"%d %M %Y") from employee_detail;

    public int searchEmployee(String emailId) throws CustomException {
        int employeeId = 0;
        try {
	    String query = "SELECT id FROM employee_detail where email_Id = '" + emailId + "' ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);          
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while(resultSet.next()) {
                employeeId = resultSet.getInt(1);
                System.out.println(employeeId);
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
            error.printStackTrace();
	    throw new CustomException(error.getMessage());
        } 
        return employeeId;
    }

    public int updateEmployee(Employee employee, int employeeId) throws CustomException {
 
	try {
            String query = "update employee_detail set first_name = ?, last_name = ?, address = ?, mobile_no = ?, date_of_birth = ?, gender = ?, email_id = ?,"
		+ "batch = ?, date_of_joining = ?, designation = ? where employeeId = ?";
            Instant dateOfBirthInstant = employee.getDateOfBirth().toInstant();
            ZonedDateTime dateOfBirthZone = dateOfBirthInstant.atZone(ZoneId.systemDefault());
            LocalDate dateOfBirth = dateOfBirthZone.toLocalDate();
            Date date = Date.valueOf(dateOfBirth);
	    System.out.println(date);
            Instant instant = employee.getDateOfJoining().toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate dateOfJoining = zone.toLocalDate();
            Date joinDate = Date.valueOf(dateOfJoining);
            PreparedStatement preparedStatement = connection.prepareStatement(query);                        
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setLong(4, employee.getMobileNo());
            preparedStatement.setDate(5, date);
            preparedStatement.setString(6, employee.getGender());
            preparedStatement.setString(7, employee.getEmailId());
            preparedStatement.setInt(8, employee.getBatch());
            preparedStatement.setDate(9, joinDate);
            preparedStatement.setString(10, employee.getDesignation());  
            preparedStatement.execute(); 
            String idQuery = "SELECT id FROM employee_detail order by id DESC LIMIT 1";            
            ResultSet rs = preparedStatement.executeQuery(idQuery);
            while(rs.next()){
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

    public boolean deleteEmployee(int employeeId) throws CustomException {
        try {
	    String query = "delete from employee_detail WHERE id = '" + employeeId + "' ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);          
            ResultSet resultSet = preparedStatement.executeQuery(query);                   
            int rowsDeleted = preparedStatement.executeUpdate();    
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (Exception error) {
            throw new CustomException(error.getMessage());
        } 
        return false;     
    }  
}