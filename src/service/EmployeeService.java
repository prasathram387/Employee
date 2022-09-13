package com.ideas2it.service;

import com.ideas2it.constant.Constants;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dao.RoleDao;
import com.ideas2it.dto.EmployeeDto;
import com.ideas2it.dto.EmployeeProjectDto;
import com.ideas2it.exception.CustomException;
import com.ideas2it.mapper.EmployeeMapper;
import com.ideas2it.mapper.EmployeeProjectMapper;
import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeProject;
import com.ideas2it.model.Role;

import java.util.HashSet;
import java.util.Set;

public class EmployeeService {	

    private EmployeeMapper mapper = new EmployeeMapper();
    private EmployeeDao employeeDao = new EmployeeDao();
    private RoleDao roleDao = new RoleDao();

    public String addEmployee(EmployeeDto employeeDto, String userType) throws CustomException {   
	Employee employee = mapper.fromDto(employeeDto);
        Role roles = roleDao.retrieveRoleByName(userType);
        Set<Role> role = new HashSet<Role>();
        role.add(roles);
        employee.setRole(role);
	int employeeId = employeeDao.insertEmployee(employee);	
        return "ADDED SUCCESSFULLY";
    }

    public Set<EmployeeDto> getAllEmployee() throws CustomException {   
        Set<EmployeeDto> employeeDtos = new HashSet<EmployeeDto>();
        for (Employee employee : employeeDao.retrieveAllEmployees()) {
            employeeDtos.add(mapper.toDto(employee));
        }
        return employeeDtos;	              
    }  

    public Set<EmployeeDto> getEmployeeByRole(String roleName) throws CustomException { 
        Role role = roleDao.retrieveRoleByName(roleName);
        Set<EmployeeDto> employeeDtos = new HashSet<EmployeeDto>();
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
        Set<Role> roles = new HashSet<>(); 
        Employee employee = employeeDao.retrieveEmployeeById(employeeId);
        employee.setRole(roles);
        employee.setStatus(Constants.INACTIVE);
        employeeDao.updateEmployee(employee);
        return "DELETED SUCCESSFULLY";
    } 
}
