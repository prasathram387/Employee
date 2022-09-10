package com.ideas2it.service;

import java.util.HashSet;
import java.util.Set;

import com.ideas2it.dao.ProjectDao;
import com.ideas2it.dto.EmployeeDto;
import com.ideas2it.dto.EmployeeProjectDto;
import com.ideas2it.dto.ProjectDto;
import com.ideas2it.exception.CustomException;
import com.ideas2it.mapper.EmployeeProjectMapper;
import com.ideas2it.mapper.ProjectMapper;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Project;
import com.ideas2it.model.EmployeeProject;

public class ProjectService {	

    private ProjectMapper mapper = new ProjectMapper();
    private EmployeeProjectMapper projectMapper = new EmployeeProjectMapper(); 
    private ProjectDao projectDao = new ProjectDao();
    private EmployeeService employeeService = new EmployeeService();

    public String addProject(ProjectDto projectDto) throws CustomException {   
	Project project = mapper.fromDto(projectDto);
	int projectId = projectDao.insertProject(project);
        return "ADDED SUCCESSFULLY";	
    }

    public String assignEmployeesForProject(EmployeeProjectDto employeeProjectDto) throws CustomException{
	EmployeeProject employeeProject = projectMapper.fromDto(employeeProjectDto);
	projectDao.assignEmployeesForProject(employeeProject);
        return "ASSIGNED SUCCESSFULLY";
    }

    public EmployeeDto getEmployeeById(int employeeId) throws CustomException {
        return employeeService.getEmployeeById(employeeId);
    }

    public ProjectDto getProjectById(int projectId) throws CustomException {
        Project project = projectDao.retrieveProjectById(projectId);
        if (project != null) { 
            return mapper.toDto(project);
        } 
        return null;
    }

    public Set<ProjectDto> getAllProject() throws CustomException {   
        Set<ProjectDto> projectDtos = new HashSet<ProjectDto>();
        for (Project project : projectDao.retrieveAllProjects()) {
            projectDtos.add(mapper.toDto(project));
        }
        return projectDtos;	              
    } 

    public String updateProject(ProjectDto projectDto) throws CustomException {
        projectDao.updateProject(mapper.fromDto(projectDto));
        return "UPDATED SUCCESSFULLY";
    }

    public String deleteProject(int projectId) throws CustomException {
        Project project = projectDao.retrieveProjectById(projectId);
        project.setStatus("inactive");
        projectDao.deleteProject(project);
        return "DELETED SUCCESSFULLY";
    } 

    public Set<EmployeeProjectDto> getAssignedProjectsById(int employeeId) throws CustomException {
        EmployeeProjectMapper mapper = new EmployeeProjectMapper();
        Set<EmployeeProjectDto> employeeProjectDto = new HashSet<>();
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        if (employeeDto != null) {         
            for (EmployeeProject project :employeeDto.getEmployeeProject()) {
	        employeeProjectDto.add(mapper.toDto(project));
            }
            return employeeProjectDto;
        }
        return null;
    }

}