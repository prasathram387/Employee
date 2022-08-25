package org.ideas2it.management.service;

import org.ideas2it.management.dto.EmployeeDto;
import org.ideas2it.management.dao.EmployeeDao;
import org.ideas2it.management.dao.RoleDao;
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
    private RoleDao roleDao = new RoleDao();

    public void addEmployee(EmployeeDto employeeDto, String roleName) throws CustomException {   
	Employee employee = mapper.employeeDtoToEmployee(employeeDto);
        int employeeId = 0;
        int roleId = 0;
	employeeId = employeeDao.insertEmployee(employee);
        roleId = roleDao.reteriveRoleByName(roleName);
        System.out.println("employee id--" + employeeId + "roleId" + roleId);
        roleDao.insertEmployeeRole(employeeId, roleId);	
    }

   public List<EmployeeDto> getEmployee() throws CustomException {   
        List<EmployeeDto> employeesDto = new ArrayList<EmployeeDto>();
        for (Employee employee : employeeDao.retrieveEmployee()) {
	    EmployeeDto employeeDto = mapper.employeeToEmployeeDto(employee);
            employeesDto.add(employeeDto);
        }
        return employeesDto;	              
    }  
}
