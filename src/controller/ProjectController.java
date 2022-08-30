package com.ideas2it.management.controller;

import java.util.Date;  
import java.time.LocalDate;
import java.util.Scanner;

import com.ideas2it.management.exception.CustomException;
import com.ideas2it.management.service.ProjectService;
import com.ideas2it.management.dto.ProjectDto;
import com.ideas2it.management.utils.DateUtil;

public class ProjectController {
   
    private static Scanner scanner = new Scanner(System.in);
    private ProjectService projectService = new ProjectService();

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
        projectDto.setStartedDate(startedDate);
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
            projectService.addProject(projectDto);  
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    public void displayProject() {
        System.out.println("Enter the Project Id");
        int projectId = scanner.nextInt(); 
        try {
            ProjectDto projectDto = projectService.getProject(projectId);
	    System.out.println(projectDto);	   
        } catch (CustomException error) {
            System.out.println(error.getMessage());
        }
    }

    public void modifyProject() {
        System.out.println("Enter your Project Id");
        int projectId = scanner.nextInt();
        try {
            boolean isAvailable = projectService.findProjectId(projectId);
            if (isAvailable) {
	        System.out.println("1.Project Name 2.Client Name 3.Company Name ");
	        int option = scanner.nextInt();
	        switch (option) {				       
                    case 1:
                        System.out.println("Enter your Name");
		        String name = scanner.next();
                        projectService.modifyProject("name", name, projectId);
                        break;
                    case 2:
                        System.out.println("Enter your Client Name");
		        String clientName = scanner.next();
                        projectService.modifyProject("client_name", clientName, projectId);
                        break;
                    case 3:
                        System.out.println("Enter your Company Name ");
		        String companyName = scanner.next();
                        projectService.modifyProject("address", companyName, projectId);
                        break;
                }
            }  
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    public void deleteProject() {
        System.out.println("Enter your EmployeeId");
        int projectId = scanner.nextInt();
        try {
            boolean isAvailable = projectService.findProjectId(projectId);
            if (isAvailable) {
                boolean isDeleted = projectService.deleteProjectById(projectId);
                if (isDeleted) {
                    System.out.println("Project deleted successfully");
                }
            } else {
                System.out.println("Your Id is not found");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }


    public void updateProject() {
        System.out.println("Enter your Project Id");
        int projectId = scanner.nextInt();
        try {
            boolean isAvailable = projectService.findProjectId(projectId);
        } catch (CustomException e) {
            System.out.println(e);
        }           
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
        projectDto.setStartedDate(startedDate);
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
            projectService.updateProject(projectDto, projectId);  
        } catch (CustomException e) {
            System.out.println(e);
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