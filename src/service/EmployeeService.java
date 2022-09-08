package com.ideas2it.management.service;

import com.ideas2it.management.dto.EmployeeDto;
import com.ideas2it.management.dao.EmployeeDao;
import com.ideas2it.management.dao.RoleDao;
import com.ideas2it.management.model.Employee;
import com.ideas2it.management.model.Role;
import com.ideas2it.management.mapper.EmployeeMapper;
import com.ideas2it.management.exception.CustomException;

import java.util.ArrayList;
import java.util.Date;
import java.text.Format;
import java.util.List;
import java.text.SimpleDateFormat;

public class EmployeeService {	

    private EmployeeMapper mapper = new EmployeeMapper();
    private EmployeeDao employeeDao = new EmployeeDao();
    private RoleDao roleDao = new RoleDao();

    public void addEmployee(EmployeeDto employeeDto, String userType) throws CustomException {   
	Employee employee = mapper.fromDto(employeeDto);
        Role roles = roleDao.retrieveRoleByName(userType);
        List<Role> role = new ArrayList<Role>();
        role.add(roles);
        employee.setRole(role);
	int employeeId = employeeDao.insertEmployee(employee);	
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
	EmployeeDto employeeDto = mapper.toDto(employee);
        return employeeDto;
    }

    public boolean updateEmployee(EmployeeDto employeeDto) throws CustomException {
	Employee employee = mapper.fromDto(employeeDto);
        employeeDao.updateEmployee(employee);
        return true;
    }

    public void deleteEmployee(int employeeId) throws CustomException {
        Employee employee = employeeDao.retrieveEmployeeById(employeeId);
        employee.setStatus("inactive");
        employeeDao.deleteEmployee(employee);
    } 

}
