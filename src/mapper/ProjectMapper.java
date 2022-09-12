package com.ideas2it.mapper;

import java.time.LocalDate;
import java.util.Date;

import com.ideas2it.dto.ProjectDto;
import com.ideas2it.model.Project;
import com.ideas2it.utils.DateUtil;

public class ProjectMapper {

    public Project fromDto(ProjectDto projectDto) {
        LocalDate startDate = DateUtil.convertToLocalDate(projectDto.getStartDate());
        LocalDate deadline = DateUtil.convertToLocalDate(projectDto.getDeadline());
        Project project = new Project(projectDto.getId(), projectDto.getName(), projectDto.getClientName(), projectDto.getCompanyName(),
            startDate, deadline, projectDto.getStatus(), projectDto.getEmployeeProjects());
        return project;
    }

    public ProjectDto toDto(Project project) {
        Date startDate = DateUtil.convertToDate(project.getStartDate());
        Date deadline = DateUtil.convertToDate(project.getDeadline());
        ProjectDto projectDto = new ProjectDto(project.getId(), project.getName(), project.getClientName(), project.getCompanyName(),
            startDate, deadline, project.getStatus(), project.getEmployeeProjects());
        return projectDto;
    }
}