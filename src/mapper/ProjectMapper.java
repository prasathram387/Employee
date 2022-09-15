/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.mapper;

import java.time.LocalDate;
import java.util.Date;

import com.ideas2it.dto.ProjectDto;
import com.ideas2it.model.Project;
import com.ideas2it.utils.DateUtil;

/**
 * <p>
 * ProjectMapper class can be used for convert dto object to model object.
 * </p> 
 * @author Ramprasath 
 * @version 1.0
 **/
public class ProjectMapper {

    /** 
     * <p>
     * it converts project dto object to project object.
     * </p>
     * 
     * @projectDto it contains projectDto data. 
     */
    public Project fromDto(ProjectDto projectDto) {
        LocalDate startDate = DateUtil.convertToLocalDate(projectDto.getStartDate());
        LocalDate deadline = DateUtil.convertToLocalDate(projectDto.getDeadline());
        Project project = new Project(projectDto.getId(), projectDto.getName(), projectDto.getClientName(), projectDto.getCompanyName(),
            startDate, deadline, projectDto.getStatus(), projectDto.getEmployeeProjects());
        return project;
    }

    /** 
     * <p>
     * it converts project object to project dto object.
     * </p>
     * 
     * @project it contains project data. 
     */
    public ProjectDto toDto(Project project) {
        Date startDate = DateUtil.convertToDate(project.getStartDate());
        Date deadline = DateUtil.convertToDate(project.getDeadline());
        ProjectDto projectDto = new ProjectDto(project.getId(), project.getName(), project.getClientName(), project.getCompanyName(),
            startDate, deadline, project.getStatus(), project.getEmployeeProjects());
        return projectDto;
    }
}