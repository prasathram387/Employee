/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Date;
import java.util.Set;

import com.ideas2it.dto.EmployeeDto;
import com.ideas2it.dto.RoleDto;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Role;
import com.ideas2it.utils.DateUtil;

/**
 * <p>
 * EmployeeMapper class can be used for convert dto object to model object.
 * </p> 
 * @author Ramprasath 
 * @version 1.0
 **/
public class EmployeeMapper {

    /** 
     * <p>
     * it converts role dto object to role object.
     * </p>
     *
     * @roleDto it contains role dto data.  
     */
    public Role fromRoleDto(RoleDto roleDto) {
        Role role = new Role(roleDto.getId(), roleDto.getName());
        return role;
    }


    /** 
     * <p>
     * it converts role object to role dto object.
     * </p>
     * 
     * @role it contains role data. 
     */
    public RoleDto toRoleDto(Role role) {
        RoleDto roleDto = new RoleDto(role.getId(), role.getName());
	return roleDto;
    }


    /** 
     * <p>
     * it converts employee dto object to employee object.
     * </p>
     * 
     * @employeeDto it contains employee dto data. 
     */
    public Employee fromDto(EmployeeDto employeeDto) {
        LocalDate dateOfBirth = DateUtil.convertToLocalDate(employeeDto.getDateOfBirth());
        LocalDate dateOfJoining = DateUtil.convertToLocalDate(employeeDto.getDateOfJoining());
        LocalDateTime createdDate = DateUtil.convertToLocalDateTime(employeeDto.getCreatedDate());
        LocalDateTime modifiedDate = DateUtil.convertToLocalDateTime(employeeDto.getModifiedDate());

        Set<Role> roles = new HashSet<Role>();
        for (RoleDto role : employeeDto.getRoles()) {
            roles.add(fromRoleDto(role));
        }
        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getAddress(), 
            employeeDto.getMobileNo(), dateOfBirth, employeeDto.getGender(), employeeDto.getEmailId(), employeeDto.getBatch(),
	    dateOfJoining, employeeDto.getDesignation(), createdDate, modifiedDate, employeeDto.getStatus(), roles, employeeDto.getEmployeeProjects());
	    return employee; 
    }



    /** 
     * <p>
     * it converts employee object to employee dto object.
     * </p>
     * 
     * @employee it contains employee data. 
     */ 
    public EmployeeDto toDto(Employee employee) {   
        Date dateOfBirth = DateUtil.convertToDate(employee.getDateOfBirth());
        Date dateOfJoining = DateUtil.convertToDate(employee.getDateOfJoining());
        Date createdDate = DateUtil.convertToDateViaInstant(employee.getCreatedDate());
        Date modifiedDate = DateUtil.convertToDateViaInstant(employee.getModifiedDate());
        Set<RoleDto> roles = new HashSet<RoleDto>();
        for (Role role : employee.getRole()) {
            roles.add(toRoleDto(role));
        }
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getAddress(), 
            employee.getMobileNo(), dateOfBirth, employee.getGender(), employee.getEmailId(), employee.getBatch(),
	    dateOfJoining, employee.getDesignation(), createdDate, modifiedDate, employee.getStatus(), roles, employee.getEmployeeProjects());
	return employeeDto;
    }
}