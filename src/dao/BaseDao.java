package com.ideas2it.management.dao;

import com.ideas2it.management.constant.Constants;
import com.ideas2it.management.exception.CustomException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {

    protected static Connection connection = null;

    public Connection databaseConnection(){
	try {   
            connection = DriverManager.getConnection(Constants.URL, Constants.SQL_USER_NAME, Constants.SQL_PASSWORD); 
	} catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }    
}