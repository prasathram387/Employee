package com.ideas2it.management.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

import com.ideas2it.management.dto.EmployeeProjectDto;
import com.ideas2it.management.model.EmployeeProject;
import com.ideas2it.management.utils.DateUtil;

public class EmployeeProjectMapper {

    public EmployeeProject fromDto(EmployeeProjectDto employeeProjectDto) {
         LocalDate startedDate = DateUtil.convertToLocalDate(employeeProjectDto.getStartedDate());
         LocalDate relievedDate = DateUtil.convertToLocalDate(employeeProjectDto.getRelievedDate());
        EmployeeProject employeeProject = new EmployeeProject(employeeProjectDto.getId(), employeeProjectDto.getProjectId(), 
            employeeProjectDto.getEmployeeId(), startedDate, relievedDate,employeeProjectDto.getStatus());
        return employeeProject;
    }

    public EmployeeProjectDto toDto(EmployeeProject employeeProject) {
        Date startedDate = DateUtil.convertToDate(employeeProject.getStartedDate());
        Date relievedDate = DateUtil.convertToDate(employeeProject.getRelievedDate());
        EmployeeProjectDto employeeProjectDto = new EmployeeProjectDto(employeeProject.getId(), employeeProject.getProjectId(), employeeProject.getEmployeeId(),
            startedDate, relievedDate, employeeProject.getStatus());
        return employeeProjectDto;
    }
}