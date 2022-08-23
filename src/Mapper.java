package org.ideas2it.management.mapper;

import org.ideas2it.management.dto.EmployeeDto;
import org.ideas2it.management.model.Employee;

public class Mapper {

    public Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getAddress(), employeeDto.getMobileNo(),
	    employeeDto.getDateOfBirth(), employeeDto.getGender(), employeeDto.getEmailId(), employeeDto.getEmployeeId(), employeeDto.getBatch(),
	    employeeDto.getExperience(), employeeDto.getDesignation());
	    return employee; 

    }

    public EmployeeDto employeeToEmployeeDto(Employee employee) {   
	EmployeeDto employeeDto = new EmployeeDto(employee.getFirstName(), employee.getLastName(), employee.getAddress(), employee.getMobileNo(),
	    employee.getDateOfBirth(), employee.getGender(), employee.getEmailId(), employee.getEmployeeId(), employee.getBatch(),
	    employee.getExperience(), employee.getDesignation());
	return employeeDto;
    }
}