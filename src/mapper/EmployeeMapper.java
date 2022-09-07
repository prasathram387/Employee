package com.ideas2it.management.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;

import com.ideas2it.management.dto.EmployeeDto;
import com.ideas2it.management.model.Employee;
import com.ideas2it.management.dto.RoleDto;
import com.ideas2it.management.model.Role;
import com.ideas2it.management.utils.DateUtil;

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

        List<Role> roles = new ArrayList<Role>();
        for (RoleDto role : employeeDto.getRoles()) {
            roles.add(fromRoleDto(role));
        }
        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getAddress(), 
            employeeDto.getMobileNo(), dateOfBirth, employeeDto.getGender(), employeeDto.getEmailId(), employeeDto.getBatch(),
	    dateOfJoining, employeeDto.getDesignation(), createdDate, modifiedDate, employeeDto.getStatus(), roles);
	    return employee; 
    }

    public EmployeeDto toDto(Employee employee) {   
        Date dateOfBirth = DateUtil.convertToDate(employee.getDateOfBirth());
        Date dateOfJoining = DateUtil.convertToDate(employee.getDateOfJoining());
        Date createdDate = DateUtil.convertToDate(employee.getCreatedDate());
        Date modifiedDate = DateUtil.convertToDate(employee.getModifiedDate());
        List<RoleDto> roles = new ArrayList<RoleDto>();
        for (Role role : employee.getRole()) {
            roles.add(toRoleDto(role));
        }
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getAddress(), 
            employee.getMobileNo(), dateOfBirth, employee.getGender(), employee.getEmailId(), employee.getBatch(),
	    dateOfJoining, employee.getDesignation(), createdDate, modifiedDate, employee.getStatus(), roles);
	return employeeDto;
    }
}