package com.ideas2it.management.service;

import com.ideas2it.management.dao.ProjectDao;
import com.ideas2it.management.dto.ProjectDto;
import com.ideas2it.management.model.Project;
import com.ideas2it.management.mapper.ProjectMapper;
import com.ideas2it.management.exception.CustomException;

public class ProjectService {	

    private ProjectMapper mapper = new ProjectMapper();
    private ProjectDao projectDao = new ProjectDao();

    public void addProject(ProjectDto projectDto) throws CustomException {   
	Project project = mapper.fromDto(projectDto);
	int projectId = projectDao.insertProject(project);	
    }
}