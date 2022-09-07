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

    public boolean findEmployeeId(int employeeId) throws CustomException {
        return employeeDao.searchEmployeeId(employeeId);
    }

    public List<EmployeeDto> getAllEmployee() throws CustomException {   
        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
        for (Employee employee : roleDao.retrieveAllEmployee()) {
            employeeDtos.add(mapper.toDto(employee));
        }
        return employeeDtos;	              
    }  

    public List<EmployeeDto> getEmployeeByRole(String roleName) throws CustomException { 
        Role role = roleDao.retrieveRoleByName(roleName);
        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
        for (Employee employee : roleDao.retrieveEmployeeByRole(role.getId())) {
            employeeDtos.add(mapper.toDto(employee));
        }
        return employeeDtos;	              
    }  

    public EmployeeDto getEmployee(int employeeId) throws CustomException {
        Employee employee = employeeDao.retrieveEmployee(employeeId);
	EmployeeDto employeeDto = mapper.toDto(employee);
        return employeeDto;
    }

    public boolean updateEmployee(EmployeeDto employeeDto, int employeeId) throws CustomException {   
	Employee employee = mapper.fromDto(employeeDto);
	return employeeDao.updateEmployee(employee, employeeId);	
    }

    public boolean modifyEmployee(String fieldName, String updatedData, int employeeId) throws CustomException{
        return employeeDao.modifyEmployee(fieldName, updatedData, employeeId);
    }

    public boolean deleteEmployeeById(int employeeId) throws CustomException{
        boolean isDeleted = employeeDao.deleteEmployee(employeeId);
        return isDeleted;
    }

}
