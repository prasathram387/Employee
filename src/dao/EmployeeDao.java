package com.ideas2it.management.dao;  

import com.ideas2it.management.model.Employee;
import com.ideas2it.management.model.Role;
import com.ideas2it.management.exception.CustomException;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.Instant;
import java.util.List;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.cfg.Configuration;  
import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;    
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  

public class EmployeeDao extends BaseDao {  

    static SessionFactory factory = new Configuration().configure().buildSessionFactory();  

    public int insertEmployee(Employee employee) throws CustomException {
        try {
            Session session = factory.openSession();  
            Transaction transaction = session.beginTransaction();   
            session.save(employee);  
            int employeeId = employee.getId();
            transaction.commit();      
            session.close();  
            return employeeId; 
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        }
    }

    public Employee retrieveEmployee(int employeeId) throws CustomException {
       try {
            Session session = factory.openSession(); 
            session.beginTransaction();       
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.eq("id", employeeId));
            Employee employee = (Employee) criteria.uniqueResult();
            return employee;
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        }
    }

    public boolean searchEmployeeId(int employeeId) throws CustomException {
        int id = 0;
        try {
	    String query = "SELECT id FROM employee_detail where id = '" + employeeId + "' and status = 'active' ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);          
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while(resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (Exception error) {
            error.printStackTrace();
	    throw new CustomException(error.getMessage());
        } 
        if (id == employeeId) {
            return true;
        }
        return false;
    }

    public boolean updateEmployee(Employee employee, int employeeId) throws CustomException { 
	try {
            String query = "update employee_detail set first_name = ?, last_name = ?, address = ?, mobile_no = ?, date_of_birth = ?, gender = ?, email_id = ?,"
		+ "batch = ?, date_of_joining = ?, designation = ? , modified_date = current_timestamp where employeeId = " +employeeId;
            return preparedStatement(query, employee);                   	                          
        } catch (Exception error) {
            error.printStackTrace();
	    throw new CustomException(error.getMessage());
        }
    }

    public boolean modifyEmployee(String fieldName, String fieldValue, int employeeId) throws CustomException {
        try {
            String query = "update employee_detail set " + fieldName + " = ? where id = ?";  
            PreparedStatement preparedStatement = connection.prepareStatement(query);                             
            preparedStatement.setString(1, fieldValue);
            preparedStatement.setInt(2, employeeId);             
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

    public boolean deleteEmployee(int employeeId) throws CustomException {
        try {
	    String query = "update employee_detail set status = 'inactive' WHERE id = '" + employeeId + "' ";
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

    public boolean preparedStatement(String query, Employee employee) throws CustomException {
        Date birthDate = Date.valueOf(employee.getDateOfBirth());
        Date joinDate = Date.valueOf(employee.getDateOfJoining());
        try {
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
            return preparedStatement.execute(); 
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        }
    }

    public int lastInsertedEmployeeId() throws CustomException {
        try {
            String query = "SELECT id FROM employee_detail order by id DESC LIMIT 1";            
            PreparedStatement preparedStatement = connection.prepareStatement(query); 
            ResultSet rs = preparedStatement.executeQuery(query);
            int employeeId = 0;
            while(rs.next()){
               employeeId = rs.getInt(1);
            } 
            return employeeId;
        } catch (Exception error) {
            error.printStackTrace();
            throw new CustomException(error.getMessage());
        }
    }
 
    public Employee preparedStatementRetrieveEmployee(String query) throws CustomException {
        Employee employee = new Employee();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);  
            ResultSet resultSet = preparedStatement.executeQuery();  
            while(resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setAddress(resultSet.getString("address"));
		employee.setMobileNo(resultSet. getLong("mobile_no"));
                employee.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());                 
                employee.setGender(resultSet.getString("gender"));
		employee.setEmailId(resultSet.getString("email_id"));
		employee.setBatch(resultSet.getInt("batch"));
                employee.setDateOfJoining(resultSet.getDate("date_of_joining").toLocalDate());
		employee.setDesignation(resultSet.getString("designation"));	
                employee.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime().toLocalDate());
                employee.setModifiedDate(resultSet.getTimestamp("modified_date").toLocalDateTime().toLocalDate());	
            }        
            return employee;         	                                                                       
        } catch (Exception error) {
            error.printStackTrace();
	    throw new CustomException(error.getMessage());
        }
    }

}