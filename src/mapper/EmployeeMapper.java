package com.ideas2it.management.mapper;

import java.util.Date;
import java.time.LocalDate;

import com.ideas2it.management.dto.EmployeeDto;
import com.ideas2it.management.model.Employee;
import com.ideas2it.management.utils.DateUtil;

public class EmployeeMapper {

    public Employee fromDto(EmployeeDto employeeDto) {
        LocalDate dateOfBirth = DateUtil.convertToLocalDate(employeeDto.getDateOfBirth());
        LocalDate dateOfJoining = DateUtil.convertToLocalDate(employeeDto.getDateOfJoining());
        LocalDate createdDate = DateUtil.convertToLocalDate(employeeDto.getCreatedDate());
        LocalDate modifiedDate = DateUtil.convertToLocalDate(employeeDto.getModifiedDate());
        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getAddress(), employeeDto.getMobileNo(),
	    dateOfBirth, employeeDto.getGender(), employeeDto.getEmailId(), employeeDto.getBatch(),
	    dateOfJoining, employeeDto.getDesignation(), createdDate, modifiedDate);
	    return employee; 

    }

    public EmployeeDto toDto(Employee employee) {   
        Date dateOfBirth = DateUtil.convertToDate(employee.getDateOfBirth());
        Date dateOfJoining = DateUtil.convertToDate(employee.getDateOfJoining());
        Date createdDate = DateUtil.convertToDate(employee.getCreatedDate());
        Date modifiedDate = DateUtil.convertToDate(employee.getModifiedDate());
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getAddress(), employee.getMobileNo(),
	    dateOfBirth, employee.getGender(), employee.getEmailId(), employee.getBatch(),
	    dateOfJoining, employee.getDesignation(), createdDate, modifiedDate);
	return employeeDto;
    }
}