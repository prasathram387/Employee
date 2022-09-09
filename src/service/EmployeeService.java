package com.ideas2it.service;

import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dao.RoleDao;
import com.ideas2it.dto.EmployeeDto;
import com.ideas2it.exception.CustomException;
import com.ideas2it.mapper.EmployeeMapper;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Role;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeService {	

    private EmployeeMapper mapper = new EmployeeMapper();
    private EmployeeDao employeeDao = new EmployeeDao();
    private RoleDao roleDao = new RoleDao();

    public String addEmployee(EmployeeDto employeeDto, String userType) throws CustomException {   
	Employee employee = mapper.fromDto(employeeDto);
        Role roles = roleDao.retrieveRoleByName(userType);
        List<Role> role = new ArrayList<Role>();
        role.add(roles);
        employee.setRole(role);
	int employeeId = employeeDao.insertEmployee(employee);	
        return "ADDED SUCCESSFULLY";
    }

    public List<EmployeeDto> getAllEmployee() throws CustomException {   
        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
        for (Employee employee : employeeDao.retrieveAllEmployees()) {
            employeeDtos.add(mapper.toDto(employee));
        }
        return employeeDtos;	              
    }  

    public List<EmployeeDto> getEmployeeByRole(String roleName) throws CustomException { 
        Role role = roleDao.retrieveRoleByName(roleName);
        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
        for (Employee employee : role.getEmployee()) {
            employeeDtos.add(mapper.toDto(employee));
        }
        return employeeDtos;	              
    }  

    public EmployeeDto getEmployeeById(int employeeId) throws CustomException {
        Employee employee = employeeDao.retrieveEmployeeById(employeeId);
        if (employee != null) {
	    return mapper.toDto(employee);
        }
        return null;
    }

    public String updateEmployee(EmployeeDto employeeDto) throws CustomException {
	Employee employee = mapper.fromDto(employeeDto);
        employeeDao.updateEmployee(employee);
        return "UPDATED SUCCESSFULLY";
    }

    public String deleteEmployee(int employeeId) throws CustomException {
        List<Role> roles = new ArrayList<>(); 
        Employee employee = employeeDao.retrieveEmployeeById(employeeId);
        employee.setRole(roles);
        employee.setStatus("inactive");
        employeeDao.deleteEmployee(employee);
        return "DELETED SUCCESSFULLY";
    } 
}
