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

    public boolean findProjectId(int projectId) throws CustomException {
        return projectDao.searchProjectId(projectId);
    }

    public ProjectDto getProject(int projectId) throws CustomException {
        Project project = projectDao.retrieveProject(projectId);
	ProjectDto projectDto = mapper.toDto(project);
        return projectDto;
    }

    public boolean updateProject(ProjectDto projectDto, int projectId) throws CustomException {   
	Project project = mapper.fromDto(projectDto);
	return projectDao.updateProject(project, projectId);	
    }

    public boolean modifyProject(String fieldName, String updatedData, int projectId) throws CustomException{
        return projectDao.modifyProject(fieldName, updatedData, projectId);
    }

    public boolean deleteProjectById(int projectId) throws CustomException{
        boolean isDeleted = projectDao.deleteProject(projectId);
        return isDeleted;
    }

}