package com.ideas2it.management.service;

import com.ideas2it.management.exception.CustomException;
import com.ideas2it.management.utils.DateUtil;
import com.ideas2it.management.service.EmployeeService;
import com.ideas2it.management.dao.ProjectDao;
import com.ideas2it.management.dto.EmployeeProjectDto;
import com.ideas2it.management.dto.ProjectDto;
import com.ideas2it.management.model.EmployeeProject;
import com.ideas2it.management.model.Project;
import com.ideas2it.management.mapper.EmployeeProjectMapper;
import com.ideas2it.management.mapper.ProjectMapper;

import java.util.Date;
import java.time.LocalDate;

public class ProjectService {	
     
    private ProjectMapper mapper = new ProjectMapper();
    private EmployeeProjectMapper projectMapper = new EmployeeProjectMapper();
    private ProjectDao projectDao = new ProjectDao();
    private EmployeeService employeeService = new EmployeeService();

    public void addProject(ProjectDto projectDto) throws CustomException {   
	Project project = mapper.fromDto(projectDto);
	projectDao.insertProject(project);	
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
  
    public boolean findEmployeeById(int employeeId) throws CustomException {
        return employeeService.findEmployeeId(employeeId);
    }
     
    public void assignEmployeesForProject(EmployeeProjectDto employeeProjectDto) throws CustomException{
	EmployeeProject employeeProject = projectMapper.fromDto(employeeProjectDto);
	projectDao.assignEmployeesForProject(employeeProject);
    }

    public EmployeeProjectDto getEmployeeProject(int employeeProjectId) throws CustomException {
        EmployeeProject employeeProject = projectDao.retrieveEmployeeProjects(employeeProjectId);
	EmployeeProjectDto employeeProjectDto = projectMapper.toDto(employeeProject);
        return employeeProjectDto;
    }

    public boolean removeEmployeeFromProject(int employeeId) throws CustomException{
        return projectDao.removeEmployeeFromProject(employeeId);
    }
}