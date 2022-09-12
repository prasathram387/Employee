package com.ideas2it.controller;

import java.util.Date;  
import java.util.Set;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import com.ideas2it.exception.CustomException;
import com.ideas2it.dto.EmployeeDto;
import com.ideas2it.dto.EmployeeProjectDto;
import com.ideas2it.dto.ProjectDto;
import com.ideas2it.service.ProjectService;
import com.ideas2it.utils.DateUtil;

public class ProjectController {
   
    private static Scanner scanner = new Scanner(System.in);
    private ProjectService projectService = new ProjectService();
    private static boolean isAvailable = true;
    private static Logger logger = Logger.getLogger(ProjectController.class);	

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
            default:
                manageProject();
        }
    }

    public void createProject() {
        ProjectDto projectDto = new ProjectDto();
        System.out.println("Enter your project name: ");
        String name = scanner.next();
        projectDto.setName(name);
        System.out.println("Enter the project client name: ");
        String clientName = scanner.next();
        projectDto.setClientName(clientName);
        System.out.println("Enter the company name: ");
        String companyName = scanner.next();
        projectDto.setCompanyName(companyName);
        Date startedDate = null;
        try {
            startedDate = getProjectDate();
        } catch (CustomException e) {
            System.out.println(e);
        }
        System.out.println(startedDate);
        projectDto.setStartDate(startedDate);
        Date deadline = null;
        try {
            deadline = getDeadline();
        } catch (CustomException e) {
            System.out.println(e);
        }
        System.out.println(deadline);
        projectDto.setDeadline(deadline);
        System.out.println("Enter the project Status: ");
        String status= scanner.next();
        projectDto.setStatus(status);
        try {
            String isAdded = projectService.addProject(projectDto); 
            logger.info(isAdded); 
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private void assignEmployeesForProject() {
        EmployeeProjectDto employeeProjectDto = new EmployeeProjectDto();
        while (isAvailable) {
            System.out.println("Enter the Project Id ");
            int projectId = scanner.nextInt();
            try {
                ProjectDto projectDto = projectService.getProjectById(projectId);
                if (projectDto == null) {
                    System.out.println("Enter the valid ProjectId");
                    break;
                }
                employeeProjectDto.setProject(projectDto);
                System.out.println("How Many Employees to Assign for this Project");
                int employeeCount = scanner.nextInt();
                for (int count = 0; count < employeeCount; count++) {
                    System.out.println("Enter the Employee Id to Assign");
                    int employeeId = scanner.nextInt();
                    EmployeeDto employeeDto = projectService.getEmployeeById(employeeId);
                    if (employeeDto == null) {
                        System.out.println("Enter the valid Employee Id");
                        break;
                    }
                    employeeProjectDto.setEmployeeDto(employeeDto);
                    System.out.println("Enter the started Date in this format DD-MM-YYYY");
                    String startDate = scanner.next();
                    Date startedDate = DateUtil.validateDate(startDate);
                    employeeProjectDto.setStartDate(startedDate);                  
                    System.out.println("Enter the releive Date in this format DD-MM-YYYY");
                    String date = scanner.next();
	            Date relievedDate = DateUtil.validateDate(date);
                    employeeProjectDto.setRelievedDate(relievedDate);
                    employeeProjectDto.setStatus("active");
                    logger.info(projectService.assignEmployeesForProject(employeeProjectDto));
                }
            } catch (CustomException error) {
                System.out.println(error);
            }
            break;
        }
    }

    public void displayAllProjects() {
        try {
	    for (ProjectDto projectDto : projectService.getAllProject()) {
	        logger.info(projectDto);	   
	    }
        } catch (CustomException error) {
            logger.info(error.getMessage());
        }
    }

    public void displayProjectById() {
        try {
            System.out.println("Enter the Project Id ");
            int projectId = scanner.nextInt();
            ProjectDto projectDto = projectService.getProjectById(projectId);
            if (projectDto == null) {
                System.out.println("Enter the valid ProjectId");
                System.exit(0);
            }  
	    logger.info (projectDto); 
        } catch (CustomException error) {
            logger.info(error.getMessage());
        }
    }

    public void updateProject() {
        do {
            System.out.println("Enter your Project Id");
            int projectId = scanner.nextInt();
            try {
                ProjectDto projectDto = projectService.getProjectById(projectId);
                if (projectDto == null) {
                    System.out.println("Enter the valid ProjectId");
                    isAvailable = true;
                } else {
                    isAvailable = false;
                }
            } catch (CustomException error) {
                logger.info(error);
            }
        } while(isAvailable);   
        ProjectDto projectDto = new ProjectDto();     
        System.out.println("Enter your project name: ");
        String name = scanner.next();
        projectDto.setName(name);
        System.out.println("Enter the project client name: ");
        String clientName = scanner.next();
        projectDto.setClientName(clientName);
        System.out.println("Enter the company name: ");
        String companyName = scanner.next();
        projectDto.setCompanyName(companyName);
        Date startedDate = null;
        try {
            startedDate = getProjectDate();
            System.out.println(startedDate);
        } catch (CustomException e) {
            System.out.println(e);
        }
        System.out.println(startedDate);
        projectDto.setStartDate(startedDate);
        Date deadline = null;
        try {
            deadline = getDeadline();
        } catch (CustomException e) {
            System.out.println(e);
        }
        System.out.println(deadline);
        projectDto.setDeadline(deadline);
        System.out.println("Enter the project Status: ");
        String status= scanner.next();
        projectDto.setStatus(status);
        try {
            String isUpdated = projectService.updateProject(projectDto);  
            logger.info(isUpdated);
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    public void deleteProject() {
        logger.info("Enter your Project Id");
        int projectId = scanner.nextInt();
        try {
            String isDeleted = projectService.deleteProject(projectId);
            logger.info(isDeleted);
        } catch (CustomException e) {
            logger.info(e);
        }
    }

    public void displayAssignedProjectsByEmployeeId() {
        logger.info("Enter Your Employee Id");
        int employeeId = scanner.nextInt();
        try {
	    for (EmployeeProjectDto employeeProjectDto : projectService.getAssignedProjectsByEmployeeId(employeeId)) {
	        logger.info(employeeProjectDto);	   
	    }
        } catch (CustomException error) {
            logger.info(error.getMessage());
        }
    }

    public void displayAssignedProjectsByProjectId() {
        logger.info("Enter Your Project Id");
        int projectId = scanner.nextInt();
        try {
	    for (EmployeeProjectDto employeeProjectDto : projectService.getAssignedProjectsByProjectId(projectId)) {
	        logger.info(employeeProjectDto);	   
	    }
        } catch (CustomException error) {
            logger.info(error.getMessage());
        }
    }

    private Date getProjectDate() throws CustomException{
    	System.out.println("Enter your Project Started Date in this format dd-mm-yyyy");
	String startDate = scanner.next();
	Date startedDate = DateUtil.validateDate(startDate);
	return startedDate;  
    }

    private Date getDeadline() throws CustomException{
    	System.out.println("Enter your Project DeadLine Date in this format dd-mm-yyyy");
	String deadlineDate = scanner.next();
	Date deadline = DateUtil.validateDate(deadlineDate);
	return deadline;  
    }
}