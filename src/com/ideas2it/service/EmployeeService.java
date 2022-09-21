/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.service;

import com.ideas2it.constant.Constants;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dto.EmployeeDto;
import com.ideas2it.dto.EmployeeProjectDto;
import com.ideas2it.exception.CustomException;
import com.ideas2it.mapper.EmployeeMapper;
import com.ideas2it.mapper.EmployeeProjectMapper;
import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeProject;
import com.ideas2it.model.Role;
import com.ideas2it.service.RoleService;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * EmployeeService class can be used for transfers data from employee controller to employee dao and employee dao to employee controller.
 * </p> 
 * @author Ramprasath
 * @version 1.0
 **/
public class EmployeeService {	

    private EmployeeMapper mapper = new EmployeeMapper();
    private EmployeeDao employeeDao = new EmployeeDao();
    private RoleService roleService = new RoleService();

    /** 
     * <p>
     * To perform add employee details.
     * </p>
     * 
     * @param employeeDto it contains employee dto object.
     * @param userType it contains the user role.
     *
     * @return it returns the string value.
     */
    public String addEmployee(EmployeeDto employeeDto, String userType) throws CustomException {   
	Employee employee = mapper.fromDto(employeeDto);
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleService.getRoleByName(userType));
        employee.setRole(roles);
	int employeeId = employeeDao.insertEmployee(employee);	
        return "ADDED SUCCESSFULLY";
    }

    /** 
     * <p>
     * To get all the employees.
     * </p>
     * 
     */
    public Set<EmployeeDto> getAllEmployee() throws CustomException {   
        Set<EmployeeDto> employeeDtos = new HashSet<EmployeeDto>();
        for (Employee employee : employeeDao.retrieveAllEmployees()) {
            employeeDtos.add(mapper.toDto(employee));
        }
        return employeeDtos;	              
    }  

    /** 
     * <p>
     * it get employee using user role.
     * </p>
     * 
     * @param roleName Role of an user.
     *
     * @return employeeDtos it returns the set of employeeDtos object.
     */
    public Set<EmployeeDto> getEmployeeByRole(String roleName) throws CustomException { 
        Role role = roleService.getRoleByName(roleName);
        Set<EmployeeDto> employeeDtos = new HashSet<EmployeeDto>();
        for (Employee employee : role.getEmployee()) {
            employeeDtos.add(mapper.toDto(employee));
        }
        return employeeDtos;	              
    }  

    /** 
     * <p>
     * it get employee using employee id.
     * </p>
     * 
     * @param employeeId id of an user.
     *
     * @return employeeDto it returns the employeeDto object or null.
     */
    public EmployeeDto getEmployeeById(int employeeId) throws CustomException {
        Employee employee = employeeDao.retrieveEmployeeById(employeeId);
        if (employee != null) {
	    return mapper.toDto(employee);
        }
        return null;
    }

    /** 
     * <p>
     * To perform update employee details.
     * </p>
     * 
     * @param employeeDto it contains employee dto object.
     *
     * @return it returns the string value.
     */
    public String updateEmployee(EmployeeDto employeeDto) throws CustomException {
	Employee employee = mapper.fromDto(employeeDto);
        employeeDao.updateEmployee(employee);
        return "UPDATED SUCCESSFULLY";
    }

    /** 
     * <p>
     * To perform delete process of employee details.
     * </p>
     * 
     * @param employeeid id of an user.
     *
     * @return it returns the string value.
     */
    public String deleteEmployee(int employeeId) throws CustomException {
        Employee employee = employeeDao.retrieveEmployeeById(employeeId);
        employee.setRole(new HashSet<>());
        employee.setStatus(Constants.INACTIVE);
        employeeDao.updateEmployee(employee);
        return "DELETED SUCCESSFULLY";
    } 
}
