/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.service;

import com.ideas2it.constant.Constants;
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

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * ProjectService class can be used for transfers data from controller to project dao and project dao to project controller.
 * </p> 
 * @author Ramprasath
 * @version 1.0
 **/
public class ProjectService {	

    private ProjectMapper mapper = new ProjectMapper();
    private EmployeeProjectMapper projectMapper = new EmployeeProjectMapper(); 
    private ProjectDao projectDao = new ProjectDao();
    private EmployeeService employeeService = new EmployeeService();

    /** 
     * <p>
     * To perform add project details.
     * </p>
     * 
     * @param projectDto it contains project dto object.
     *
     * @return it returns the string value.
     */
    public String addProject(ProjectDto projectDto) throws CustomException {   
	Project project = mapper.fromDto(projectDto);
	int projectId = projectDao.insertProject(project);
        return "ADDED SUCCESSFULLY";	
    }

    /** 
     * <p>
     * To perform assign employees to the project .
     * </p>
     * 
     * @param employeeProjectDto it contains employeeProjectDto dto object.
     *
     * @return it returns the string value.
     */
    public String assignEmployeesForProject(EmployeeProjectDto employeeProjectDto) throws CustomException{
	EmployeeProject employeeProject = projectMapper.fromDto(employeeProjectDto);
	projectDao.assignEmployeesForProject(employeeProject);
        return "ASSIGNED SUCCESSFULLY";
    }

    /** 
     * <p>
     * To get employee by using employee id.
     * </p>
     * 
     * @param employeeId id of an user.
     *
     * @return it returns employeeDto object;
     */
    public EmployeeDto getEmployeeById(int employeeId) throws CustomException {
        return employeeService.getEmployeeById(employeeId);
    }

    /** 
     * <p>
     * To get project by using project id.
     * </p>
     * 
     * @param projectId id of a project.
     *
     * @return it returns projectDto object;
     */
    public ProjectDto getProjectById(int projectId) throws CustomException {
        Project project = projectDao.retrieveProjectById(projectId);
        if (project != null) { 
            return mapper.toDto(project);
        } 
        return null;
    }

    /** 
     * <p>
     * To get all projects.
     * </p>
     *
     * @return it returns set of projectDto objects;
     */
    public Set<ProjectDto> getAllProject() throws CustomException {   
        Set<ProjectDto> projectDtos = new HashSet<ProjectDto>();
        for (Project project : projectDao.retrieveAllProjects()) {
            projectDtos.add(mapper.toDto(project));
        }
        return projectDtos;	              
    } 

    /** 
     * <p>
     * To perform update project.
     * </p>
     * 
     * @param projectDto it contains project dto object.
     *
     * @return it returns the string value.
     */
    public String updateProject(ProjectDto projectDto) throws CustomException {
        projectDao.updateProject(mapper.fromDto(projectDto));
        return "UPDATED SUCCESSFULLY";
    }

    /** 
     * <p>
     * To perform delete project.
     * </p>
     * 
     * @param projectId id of an project.
     *
     * @return it returns the string value.
     */
    public String deleteProject(int projectId) throws CustomException {
        Project project = projectDao.retrieveProjectById(projectId);
        project.setStatus(Constants.INACTIVE);
        projectDao.updateProject(project);
        return "DELETED SUCCESSFULLY";
    } 

    /** 
     * <p>
     * To get assigned project by using employee id.
     * </p>
     * 
     * @param employeeId id of an employee.
     *
     * @return it returns the set of employeeProjectDto object;
     */
    public Set<EmployeeProjectDto> getAssignedProjectsByEmployeeId(int employeeId) throws CustomException {
        EmployeeProjectMapper mapper = new EmployeeProjectMapper();
        Set<EmployeeProjectDto> employeeProjectDto = new HashSet<>();
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        if (employeeDto != null) {         
            for (EmployeeProject project: employeeDto.getEmployeeProjects()) {
	        employeeProjectDto.add(mapper.toDto(project));
            }
            return employeeProjectDto;
        }
        return null;
    }

    /** 
     * <p>
     * To get assigned project by using project id.
     * </p>
     * 
     * @param projectId id of the project.
     *
     * @return it returns the set of employeeProjectDto object;
     */
    public Set<EmployeeProjectDto> getAssignedProjectsByProjectId(int projectId) throws CustomException {
        EmployeeProjectMapper mapper = new EmployeeProjectMapper();
        Set<EmployeeProjectDto> employeeProjectDto = new HashSet<>();
        Project project = projectDao.retrieveProjectById(projectId);
        if (project != null) {         
            for (EmployeeProject employeeProject: project.getEmployeeProjects()) {
	        employeeProjectDto.add(mapper.toDto(employeeProject));
            }
            return employeeProjectDto;
        }
        return null;
    }

}