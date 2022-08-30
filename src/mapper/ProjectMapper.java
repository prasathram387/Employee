package com.ideas2it.management.mapper;

import java.util.Date;
import java.time.LocalDate;

import com.ideas2it.management.dto.ProjectDto;
import com.ideas2it.management.model.Project;
import com.ideas2it.management.utils.DateUtil;

public class ProjectMapper {

    public Project fromDto(ProjectDto projectDto) {
        LocalDate startedDate = DateUtil.convertToLocalDate(projectDto.getStartedDate());
        LocalDate deadline = DateUtil.convertToLocalDate(projectDto.getDeadline());
        Project project = new Project(projectDto.getId(), projectDto.getName(), projectDto.getClientName(), projectDto.getCompanyName(),
            startedDate, deadline, projectDto.getStatus());
        System.out.println("after insert "+ project.getDeadline());
        return project;
    }

    public ProjectDto toDto(Project project) {
        Date startedDate = DateUtil.convertToDate(project.getStartedDate());
        Date deadline = DateUtil.convertToDate(project.getDeadline());
        ProjectDto projectDto = new ProjectDto(project.getId(), project.getName(), project.getClientName(), project.getCompanyName(),
            startedDate, deadline, project.getStatus());
        return projectDto;
    }
}