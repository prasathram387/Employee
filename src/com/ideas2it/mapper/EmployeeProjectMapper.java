/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.mapper;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ideas2it.dto.EmployeeProjectDto;
import com.ideas2it.dto.EmployeeDto;
import com.ideas2it.dto.ProjectDto;
import com.ideas2it.model.EmployeeProject;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Project;
import com.ideas2it.utils.DateUtil;

/**
 * <p>
 * EmployeeProjectMapper class can be used for convert dto object to model object.
 * </p> 
 * @author Ramprasath 
 * @version 1.0
 **/
public class EmployeeProjectMapper {
   
    private EmployeeMapper employeeMapper = new EmployeeMapper();
    private ProjectMapper projectMapper = new ProjectMapper();

    /** 
     * <p>
     * it converts employee project dto object to employee project object.
     * </p>
     * 
     * @employeeProjectDto it contains employeeProjectDto object data. 
     */
    public EmployeeProject fromDto(EmployeeProjectDto employeeProjectDto) {
         Employee employee = employeeMapper.fromDto(employeeProjectDto.getEmployeeDto());
         Project project = projectMapper.fromDto(employeeProjectDto.getProjectDto());
         LocalDate startDate = DateUtil.convertToLocalDate(employeeProjectDto.getStartDate());
         LocalDate relievedDate = DateUtil.convertToLocalDate(employeeProjectDto.getRelievedDate());
        EmployeeProject employeeProject = new EmployeeProject(employeeProjectDto.getId(),  startDate, relievedDate, 
            employeeProjectDto.getStatus(), employee, project);
        return employeeProject;
    }

    /** 
     * <p>
     * it converts employee project object to employee project dto object.
     * </p>
     * 
     * @employeeProject it contains employeeProject data. 
     */
    public EmployeeProjectDto toDto(EmployeeProject employeeProject) {
        EmployeeDto employee = employeeMapper.toDto(employeeProject.getEmployee());
        ProjectDto project = projectMapper.toDto(employeeProject.getProject());
        Date startDate = DateUtil.convertToDate(employeeProject.getStartDate());
        Date relievedDate = DateUtil.convertToDate(employeeProject.getRelievedDate());
        EmployeeProjectDto employeeProjectDto = new EmployeeProjectDto(employeeProject.getId(), startDate, relievedDate, 
            employeeProject.getStatus(), employee, project);
        return employeeProjectDto;
    }
}