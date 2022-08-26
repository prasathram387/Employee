
package org.ideas2it.management.dao;

import org.ideas2it.management.constant.Constants;
import org.ideas2it.management.exception.CustomException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class BaseDao {

    static Connection connection = null;
    public static Connection databaseConnection(){
	try { 
	    Class.forName("com.mysql.jdbc.Driver");  
            connection = DriverManager.getConnection(Constants.URL, Constants.SQL_USER_NAME, Constants.SQL_PASSWORD); 
            System.out.println("database connection created");
	} catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }    
}