package com.ideas2it.management.controller;

import com.ideas2it.management.constant.Constants;
import com.ideas2it.management.exception.CustomException;
import com.ideas2it.management.dto.EmployeeDto;
import com.ideas2it.management.service.EmployeeService;
import com.ideas2it.management.service.ProjectService;
import com.ideas2it.management.dto.ProjectDto;
import com.ideas2it.management.utils.DateUtil;
import com.ideas2it.management.utils.ValidationUtil;

import java.util.ArrayList;
import java.util.Date;  
import java.util.InputMismatchException;
import java.util.List;
import java.time.LocalDate; 
import java.util.Map;
import java.util.Scanner;

/**
 * It can be implemented for input and output operation of trainer,trainee and manager.
 **/
public class EmployeeController {
   
    private static Scanner scanner = new Scanner(System.in);
    private EmployeeService employeeService = new EmployeeService();
    private ProjectService projectService = new ProjectService();	           

    private static boolean isContinue = true;
    private static int index = 0;

    public static void main(String[] args) throws CustomException {

	EmployeeController controller = new EmployeeController();
	
	System.out.println("1.Trainee ,2.Trainer ,3.Manager, 4.exit");
	int choice = scanner.nextInt();
        while (isContinue) {
	    switch (choice) { 		
	        case 1:
	            controller.trainee(Constants.TRAINEE);
	            break;
	        case 2:
	            controller.trainer(Constants.TRAINER);
	            break;
	        case 3:
	            controller.manager(Constants.MANAGER);
	            break;
            } 
        }
    }

    public void trainee(String userType) {
	System.out.println("1.Insert Details\n2.Display Trainee\n3.Update Trainee\n4.Delete Trainee data\n5.Modify Trainee");
	int option = scanner.nextInt();
	switch (option) {				       
            case 1:
                addEmployee(userType, option);
                break;
            case 2:
                displayEmployee();
                break;
            case 3:
                addEmployee(userType, option);
                break;
            case 4:
                deleteEmployee(userType);
                break;
            case 5:
                modifyEmployee(userType);
                break;
         }
    }


    public void trainer(String userType) {
	System.out.println("1.Insert Details\n2.Display Trainer\n3.Update Trainer\n4.Delete Trainer\n5.Modify Trainer");
	int option = scanner.nextInt();
	switch (option) {				       
            case 1:
                addEmployee(userType, option);
                break;
            case 2:
                displayEmployee();
                break;
            case 3:
                addEmployee(userType, option);
                break;
            case 4:
                deleteEmployee(userType);
                break;
            case 5:
                modifyEmployee(userType);
                break;
         }
    }

    public void manager(String userType) {
	System.out.println("1.Insert Details\n2.Display Trainer\n3.Update Trainer\n4.Delete Trainer\n5.All Employees\n6.Modify Trainer");
	int option = scanner.nextInt();
	switch (option) {				       
            case 1:
                addEmployee(userType, option);
                break;
            case 2:
                displayEmployee();
                break;
            case 3:
                addEmployee(userType, option);
                break;
            case 4:
                deleteEmployee(userType);
                break;
            case 5:
                displayAllEmployee(userType);
                break;
            case 6:
                modifyEmployee(userType);
                break;
            case 7:
                manageProject();
                break;
         }
    }

    private String getFirstName() {
	String firstName = null;	
	while (isContinue) {
            System.out.println("Enter your First Name");
	    firstName = scanner.next();
	    boolean isCorrect = ValidationUtil.validateInput(firstName, ValidationUtil.NAME_PATTERN);
	    if (isCorrect) {
		break;
            } else {
	        System.out.println("enter valid input");
	        isContinue = true;
	    }
	}
	return firstName;  
    }

    private String getLastName() {
	String lastName = null;	
	while (isContinue) {
            System.out.println("Enter your Last Name");
	    lastName = scanner.next();
	    boolean isCorrect = ValidationUtil.validateInput(lastName, ValidationUtil.NAME_PATTERN);
	    if (isCorrect) {
		break;
            } else {
	        System.out.println("enter valid input");
	        isContinue = true;
	    }
	}
	return lastName;  
    }

    private long getMobileNo() {
	String phoneNumber = null;
	while (isContinue) {
	    System.out.println("Enter your mobileNo");
	    phoneNumber = scanner.next();
	    boolean isCorrect = ValidationUtil.validateInput(phoneNumber, ValidationUtil.PHONE_NO);
	    if (isCorrect) {
	        break;
            } else {
	        System.out.println("enter valid input");
	        isContinue = true;
	    }
	}
	long mobileNo = Long.valueOf(phoneNumber);
	return mobileNo; 
    }

    public String getGender() throws CustomException {
        String gender = null;
	while (isContinue) {
    	    System.out.println("Enter your gender");
	    gender = scanner.next();
	    boolean isCorrect = ValidationUtil.validateGender(gender);
	    if (isCorrect) {
	        break;
            } else {
	        System.out.println("enter valid input");
	        isContinue = true;
	    }
	}
	return gender;  
    }

    private Date getDateOfBirth() throws CustomException {
    	System.out.println("Enter your Date Of Birth in this format dd-mm-yyyy");
	String birthDate = scanner.next();
	Date dateOfBirth = DateUtil.validateDateOfBirth(birthDate);
	return dateOfBirth;  
    }

    private Date getDateOfJoining() throws CustomException{
    	System.out.println("Enter your Date Of joining in this format dd-mm-yyyy");
	String join_date = scanner.next();
	Date dateOfJoining = DateUtil.validateDateOfJoining(join_date);
	return dateOfJoining;  
    }

    public int getAge(Date dob) {
	int age = ValidationUtil.calculateAge(dob);
	return age;
    }

    public int getExperience(Date dateOfJoining) {
	int experience = ValidationUtil.calculateExperience(dateOfJoining);
	return experience;
    }

    private String getDesignation() {
	String designation = null;
	while (isContinue) {
    	    System.out.println("Enter your designation");
	    designation = scanner.next();
	    boolean isCorrect = ValidationUtil.validateInput(designation, ValidationUtil.DESIGNATION_REGEX);
	    if (isCorrect ) {
	        break;
            } else {
	        System.out.println("enter valid input");
	        isContinue = true;
	    }
	}
	return designation;
    }

    private String getEmailId() {
	String emailId = null;
	while (isContinue) {
    	    System.out.println("Enter your emailId");
	    emailId = scanner.next();
	    boolean isCorrect = ValidationUtil.validateInput(emailId, ValidationUtil.MAILID_REGEX);
	    if (isCorrect) {
	        break;
            } else {
	        System.out.println("enter valid input");
	        isContinue = true;
	    }
	}
	return emailId;  
    }


    public void addEmployee(String userType,int option) {
        EmployeeDto employeeDto = new EmployeeDto();
        int employeeId = 0;
        if (option == 1) {
            employeeId = 0;
            employeeDto.setId(employeeId);
        } else if (option == 3) {
            System.out.println("Enter your employee id");
            employeeId = scanner.nextInt();
            employeeDto.setId(employeeId);
        }
	employeeDto.setFirstName(getFirstName());
	employeeDto.setLastName(getLastName());
	System.out.println("Enter your address");
	String address = scanner.next();
        employeeDto.setAddress(address);
	employeeDto.setMobileNo(getMobileNo());
	Date dateOfBirth = null;
	try {
	    dateOfBirth = getDateOfBirth();
	} catch (CustomException e) {
            System.out.println(e);
        }
        employeeDto.setDateOfBirth(dateOfBirth);
        String gender = null;
        try {
	    gender = getGender();
        } catch (CustomException e) {
            System.out.println(e);
        }
        employeeDto.setGender(gender);
	employeeDto.setEmailId(getEmailId());
	Date dateOfJoining = null;
	try {
	    dateOfJoining = getDateOfJoining();
	} catch (CustomException e) {
            System.out.println(e);
        }
        employeeDto.setDateOfJoining(dateOfJoining);
	employeeDto.setDesignation(getDesignation());
	System.out.println("Enter the batch");
	int batch = scanner.nextInt();	    
        employeeDto.setBatch(batch);
        Date createdDate = new Date();
        employeeDto.setCreatedDate(createdDate);
        Date modifiedDate = new Date();
        employeeDto.setModifiedDate(modifiedDate);
        if (option == 1) {
            try {
	        employeeService.addEmployee(employeeDto, userType);
            } catch (CustomException e) {
                System.out.println(e);
            }
        } else if (option == 3) {
            try {
	        employeeService.updateEmployee(employeeDto, employeeId);
            } catch (CustomException e) {
                System.out.println(e);
            }
        } 
    }
  
    public void displayAllEmployee(String userType) {
        try {
	    for (EmployeeDto employeeDto : employeeService.getAllEmployee()) {
	        System.out.println(employeeDto);	   
	    }
        } catch (CustomException error) {
            System.out.println(error.getMessage());
        }
    }

    public void displayEmployee() {
        System.out.println("Enter the Employee Id");
        int employeeId = scanner.nextInt(); 
        try {
            EmployeeDto employeeDto = employeeService.getEmployee(employeeId);
	    System.out.println(employeeDto);	   
        } catch (CustomException error) {
            System.out.println(error.getMessage());
        }
    }

    public void modifyEmployee(String userType) {
        System.out.println("Enter your Employee Id");
        int employeeId = scanner.nextInt();
        try {
            boolean isAvailable = employeeService.findEmployeeId(employeeId);
            if (isAvailable) {
	        System.out.println("1.First name 2.Last Name 3.address 4.Gender 5.Email Id 6.Designation");
	        int option = scanner.nextInt();
	        switch (option) {				       
                    case 1:
		        String firstName = getFirstName();
                        employeeService.modifyEmployee("first_name", firstName, employeeId);
                        break;
                    case 2:
		        String lastName = getLastName();
                        employeeService.modifyEmployee("last_name", lastName, employeeId);
                        break;
                    case 3:
                        System.out.println("Enter your address");
		        String address = scanner.next();
                        employeeService.modifyEmployee("address", address , employeeId);
                        break;
                    case 4:
	                String gender = getGender();
                        employeeService.modifyEmployee("gender", gender, employeeId);
                        break;
                    case 5:
                        String emailId = getEmailId();
                        employeeService.modifyEmployee("email_id", emailId, employeeId);
                        break;
                    case 6:
                        String designation = getDesignation();
                        employeeService.modifyEmployee("designation", designation, employeeId);
                        break;
                }

            } else {
            System.out.println("Id Not Found"); 
            }
        } catch (CustomException error) {
            System.out.println(error.getMessage());
        }
    }

    public void deleteEmployee(String userType) {
        System.out.println("Enter your EmployeeId");
        int employeeId = scanner.nextInt();
        try {
            boolean isAvailable = employeeService.findEmployeeId(employeeId);
            if (isAvailable) {
                boolean isAdded = employeeService.deleteEmployeeById(employeeId);
                if (isAdded) {
                    System.out.println("employee deleted successfully");
                }
            } else {
                System.out.println("Your Id is not found");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    public void manageProject() {
	System.out.println("1.Create Project\n2.Update Project\n3.Delete Project\n4.Display project");
	int option = scanner.nextInt();
	switch (option) {				       
            case 1:
                createProject();
                break;
       /*     case 2:
                updateProject();
                break;
            case 3:
                deleteProject();
                break;
            case 4:
                displayProject();
                break;      */
         }
    }

    private Date getProjectDate() throws CustomException{
    	System.out.println("Enter your Project Started Date in this format dd-mm-yyyy");
	String startDate = scanner.next();
	Date startedDate = DateUtil.validateDateOfJoining(startDate);
	return startedDate;  
    }

    private Date getDeadline() throws CustomException{
    	System.out.println("Enter your Project DeadLine Date in this format dd-mm-yyyy");
	String deadlineDate = scanner.next();
	Date deadline = DateUtil.validateDateOfJoining(deadlineDate);
	return deadline;  
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
        try {
            projectDto.setStartedDate(getProjectDate());
            projectDto.setDeadline(getDeadline());
            System.out.println("Enter the project Status: ");
            String status= scanner.next();
            projectDto.setStatus(status);
            projectService.addProject(projectDto);  
        } catch (CustomException e) {
            System.out.println(e);
        }
   }
}