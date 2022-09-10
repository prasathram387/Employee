package com.ideas2it.mapper;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Date;
import java.util.Set;

import com.ideas2it.dto.EmployeeDto;
import com.ideas2it.dto.RoleDto;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Role;
import com.ideas2it.utils.DateUtil;

public class EmployeeMapper {

    public Role fromRoleDto(RoleDto roleDto) {
        Role role = new Role(roleDto.getId(), roleDto.getName());
        return role;
    }

    public RoleDto toRoleDto(Role role) {
        RoleDto roleDto = new RoleDto(role.getId(), role.getName());
	return roleDto;
    }

    public Employee fromDto(EmployeeDto employeeDto) {
        LocalDate dateOfBirth = DateUtil.convertToLocalDate(employeeDto.getDateOfBirth());
        LocalDate dateOfJoining = DateUtil.convertToLocalDate(employeeDto.getDateOfJoining());
        LocalDate createdDate = DateUtil.convertToLocalDate(employeeDto.getCreatedDate());
        LocalDate modifiedDate = DateUtil.convertToLocalDate(employeeDto.getModifiedDate());

        Set<Role> roles = new HashSet<Role>();
        for (RoleDto role : employeeDto.getRoles()) {
            roles.add(fromRoleDto(role));
        }
        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getAddress(), 
            employeeDto.getMobileNo(), dateOfBirth, employeeDto.getGender(), employeeDto.getEmailId(), employeeDto.getBatch(),
	    dateOfJoining, employeeDto.getDesignation(), createdDate, modifiedDate, employeeDto.getStatus(), roles, employeeDto.getEmployeeProject());
	    return employee; 
    }

    public EmployeeDto toDto(Employee employee) {   
        Date dateOfBirth = DateUtil.convertToDate(employee.getDateOfBirth());
        Date dateOfJoining = DateUtil.convertToDate(employee.getDateOfJoining());
        Date createdDate = DateUtil.convertToDate(employee.getCreatedDate());
        Date modifiedDate = DateUtil.convertToDate(employee.getModifiedDate());
        Set<RoleDto> roles = new HashSet<RoleDto>();
        for (Role role : employee.getRole()) {
            roles.add(toRoleDto(role));
        }
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getAddress(), 
            employee.getMobileNo(), dateOfBirth, employee.getGender(), employee.getEmailId(), employee.getBatch(),
	    dateOfJoining, employee.getDesignation(), createdDate, modifiedDate, employee.getStatus(), roles, employee.getEmployeeProject());
	return employeeDto;
    }
}