package org.ideas2it.management.service;

import org.ideas2it.management.dto.EmployeeDto;
import org.ideas2it.management.dao.EmployeeDao;
import org.ideas2it.management.model.Employee;
import org.ideas2it.management.mapper.Mapper;
import org.ideas2it.management.exception.CustomException;

import java.util.ArrayList;
import java.util.Date;
import java.text.Format;
import java.util.List;
import java.text.SimpleDateFormat;

/**
 * It can be implemented for transfer data  between Employee controller
 * to trainerDao and trainerDao to Employeecontroller
 **/
public class EmployeeService {	

    private Mapper mapper = new Mapper();
    private EmployeeDao employeeDao = new EmployeeDao();

    public boolean addEmployee(EmployeeDto employeeDto) throws CustomException {   
	Employee employee = mapper.employeeDtoToEmployee(employeeDto);
        boolean isAdded = false;
        try {
	    isAdded = employeeDao.insertEmployee(employee);
        } catch (CustomException e) {
            throw new CustomException(e.getMessage());
        }	
	return isAdded;
    }

/*   public EmployeeDto retrieveEmployee() {   
	Employee employee = employeeDao.retrieveEmployee();
	Employee employeeDto = mapper.employeeToEmployeeDto(employee);	
	return employeeDto;
    }  */
}

