/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.controller;

import java.util.Date;  
import java.util.Set;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import com.ideas2it.constant.Constants;
import com.ideas2it.exception.CustomException;
import com.ideas2it.dto.EmployeeDto;
import com.ideas2it.dto.EmployeeProjectDto;
import com.ideas2it.dto.ProjectDto;
import com.ideas2it.service.ProjectService;
import com.ideas2it.utils.DateUtil;

/**
 * <p>
 * ProjectController can be used for control the project. It gets the input from user and sends its to 
 * the project service. 
 * </p> 
 * @author Ramprasath
 * @version 1.0
 **/
public class ProjectController {
   
    private static Scanner scanner = new Scanner(System.in);
    private ProjectService projectService = new ProjectService();
    private static boolean isAvailable = true;
    private static Logger logger = Logger.getLogger(ProjectController.class);	

    /** 
     * <p>
     * To get a user input to perform CRUD operation on project management and assign employees to the project .
     * </p>
     * 
     */
    public void manageProject() {
	logger.info("1.Create Project\n2.Update Project\n3.Delete Project\n4.Display Project\n5.Assign Employees For Project"
            + "\n6.Display All Projects\n7.Display Assigned Projects to Employee\n8.Display Assigned Employees to Project");
	int option = scanner.nextInt();
	switch (option) {				       
            case 1:
                createProject();
                break;
            case 2:
                updateProject();
                break;
            case 3:
                deleteProject();
                break;
            case 4:
                displayProjectById();
                break;   
            case 5:
                assignEmployeesForProject();
                break;    
            case 6:
                displayAllProjects();
                break;  
            case 7:
                displayAssignedProjectsByEmployeeId();
                break;  
            case 8:
                displayAssignedProjectsByProjectId();
                break; 
            case 9:
                logger.info("Thank You");
                System.exit(0); 
            default:
                manageProject();
        }
    }

    /** 
     * <p>
     * To get a user input to perform project Create operation.
     * </p>
     * 
     */
    public void createProject() {
        ProjectDto projectDto = new ProjectDto();
        logger.info("Enter your project name: ");
        String name = scanner.next();
        projectDto.setName(name);
        logger.info("Enter the project client name: ");
        String clientName = scanner.next();
        projectDto.setClientName(clientName);
        logger.info("Enter the company name: ");
        String companyName = scanner.next();
        projectDto.setCompanyName(companyName);
        projectDto.setStartDate(getStartDate());
        projectDto.setDeadline(getDeadline());
        logger.info("Enter the project Status: ");
        String status= scanner.next();
        projectDto.setStatus(status);
        try {
            String isAdded = projectService.addProject(projectDto); 
            logger.info(isAdded); 
        } catch (CustomException e) {
            logger.info(e);
        }
    }

    /** 
     * <p>
     * To get a employee dto from the project service.
     * </p>
     * 
     */
    public EmployeeDto getEmployee() {
        EmployeeDto employeeDto = null;
        logger.info("Enter the Employee Id to Assign");
        int employeeId = scanner.nextInt();
        try {
            employeeDto = projectService.getEmployeeById(employeeId);
            if (employeeDto == null) {
                logger.info("Enter the valid Employee Id");
                getEmployee();
            } 
            return employeeDto;
        } catch (CustomException error) {
            logger.error(error);
        }
        return employeeDto;
    }

    /** 
     * <p>
     * Assign of employees to the project.
     * </p>
     * 
     */            
    public void assignEmployeesForProject() {
        EmployeeProjectDto employeeProjectDto = new EmployeeProjectDto();
        logger.info("Enter the Project Id ");
        int projectId = scanner.nextInt();
        try {
            ProjectDto projectDto = projectService.getProjectById(projectId);
            if (projectDto == null) {
                logger.info("Enter the valid ProjectId");
                assignEmployeesForProject();
            }
            employeeProjectDto.setProject(projectDto);
            logger.info("How Many Employees to Assign for this Project");
            int employeeCount = scanner.nextInt();
            for (int count = 0; count < employeeCount; count++) {  
                employeeProjectDto.setEmployeeDto(getEmployee());
                logger.info("Enter the started Date in this format DD-MM-YYYY");
                String startDate = scanner.next();
                Date startedDate = DateUtil.validateDate(startDate);
                employeeProjectDto.setStartDate(startedDate);                  
                logger.info("Enter the releive Date in this format DD-MM-YYYY");
                String date = scanner.next();
	        Date relievedDate = DateUtil.validateDate(date);
                employeeProjectDto.setRelievedDate(relievedDate);
                employeeProjectDto.setStatus(Constants.ACTIVE);
                logger.info(projectService.assignEmployeesForProject(employeeProjectDto));
            }
        } catch (CustomException error) {
            logger.info(error);
        }
    }

    /** 
     * <p>
     * To display all the projects.
     * </p>
     * 
     */
    public void displayAllProjects() {
        try {
	    for (ProjectDto projectDto : projectService.getAllProject()) {
	        logger.info(projectDto);	   
	    }
        } catch (CustomException error) {
            logger.info(error.getMessage());
        }
    }

    /** 
     * <p>
     * To display project based on id.
     * </p>
     * 
     */
    public void displayProjectById() {
        try {
            logger.info("Enter the Project Id ");
            int projectId = scanner.nextInt();
            ProjectDto projectDto = projectService.getProjectById(projectId);
            if (projectDto == null) {
                logger.info("Enter the valid ProjectId");
                manageProject();
            }  
	    logger.info (projectDto); 
        } catch (CustomException error) {
            logger.error(error.getMessage());
        }
    }

    /** 
     * <p>
     * Update process of the project .
     * </p>
     * 
     */
    public void updateProject() {
        logger.info("Enter your Project Id");
        int projectId = scanner.nextInt();
        try {
            ProjectDto projectDto = projectService.getProjectById(projectId);
            if (projectDto == null) {
                logger.info("Enter the valid ProjectId");
                updateProject();
            }     
            logger.info("Enter your project name: ");
            String name = scanner.next();
            projectDto.setName(name);
            logger.info("Enter the project client name: ");
            String clientName = scanner.next();
            projectDto.setClientName(clientName);
            logger.info("Enter the company name: ");
            String companyName = scanner.next();
            projectDto.setCompanyName(companyName);
            projectDto.setStartDate(getStartDate());
            projectDto.setDeadline(getDeadline());
            projectDto.setStatus(Constants.ACTIVE);
            logger.info( projectService.updateProject(projectDto));
        } catch (CustomException e) {
            logger.info(e);
        }
    }

    /** 
     * <p>
     * Delete process of the project.
     * </p>
     * 
     */
    public void deleteProject() {
        logger.info("Enter your Project Id");
        int projectId = scanner.nextInt();
        try {
            logger.info(projectService.deleteProject(projectId));
        } catch (CustomException e) {
            logger.info(e);
        }
    }

    /** 
     * <p>
     * To display assigned projects of an employee.
     * </p>
     * 
     */
    public void displayAssignedProjectsByEmployeeId() {
        logger.info("Enter Your Employee Id");
        int employeeId = scanner.nextInt();
        try {
	    for (EmployeeProjectDto employeeProjectDto : projectService.getAssignedProjectsByEmployeeId(employeeId)) {
	        logger.info(employeeProjectDto);	   
	    }
        } catch (CustomException error) {
            logger.error(error.getMessage());
        }
    }

    /** 
     * <p>
     * To display assigned employees of the project.
     * </p>
     * 
     */
    public void displayAssignedProjectsByProjectId() {
        logger.info("Enter Your Project Id");
        int projectId = scanner.nextInt();
        try {
	    for (EmployeeProjectDto employeeProjectDto : projectService.getAssignedProjectsByProjectId(projectId)) {
	        logger.info(employeeProjectDto);	   
	    }
        } catch (CustomException error) {
            logger.error(error.getMessage());
        }
    }

    /** 
     * <p>
     * To get a start date of project from user.
     * </p>
     * 
     */
    private Date getStartDate() {
        Date startDate = null;
        try {
    	    logger.info("Enter your Project Started Date in this format dd-mm-yyyy");
	    String startedDate = scanner.next();
	    startDate = DateUtil.validateDate(startedDate);
        } catch (CustomException error) {
            logger.error(error.getMessage());
            getStartDate();
        }
	return startDate;  
    }

    /** 
     * <p>
     * To get a deadline date of project from user.
     * </p>
     * 
     */
    private Date getDeadline() {
        Date deadline = null;
        try { 
    	    logger.info("Enter your Project DeadLine Date in this format dd-mm-yyyy");
	    String deadlineDate = scanner.next();
            deadline = DateUtil.validateDate(deadlineDate);
        } catch (CustomException error) {
            logger.error(error.getMessage());
            getDeadline();
        }
	return deadline;  
    }
}