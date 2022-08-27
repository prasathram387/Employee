package com.ideas2it.management.service;

import com.ideas2it.management.dto.EmployeeDto;
import com.ideas2it.management.dao.EmployeeDao;
import com.ideas2it.management.dao.RoleDao;
import com.ideas2it.management.model.Employee;
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

    public void addEmployee(EmployeeDto employeeDto, String roleName) throws CustomException {   
	Employee employee = mapper.fromDto(employeeDto);
        System.out.println(employee);
	int employeeId = employeeDao.insertEmployee(employee);
        int roleId = roleDao.reteriveRoleByName(roleName);
        System.out.println("employee id--" + employeeId + "roleId" + roleId);
        roleDao.insertEmployeeRole(employeeId, roleId);	
    }

    public boolean findEmployeeId(int employeeId) throws CustomException {
        return employeeDao.searchEmployee(employeeId);
    }

    public List<EmployeeDto> getAllEmployee() throws CustomException {   
        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
        for (Employee employee : employeeDao.retrieveAllEmployee()) {
	    EmployeeDto employeeDto = mapper.toDto(employee);
            employeeDtos.add(employeeDto);
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
