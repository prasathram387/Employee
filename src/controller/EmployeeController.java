/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.controller;

import com.ideas2it.constant.Constants;
import com.ideas2it.dto.EmployeeDto;
import com.ideas2it.dto.RoleDto;
import com.ideas2it.exception.CustomException;
import com.ideas2it.service.EmployeeService;
import com.ideas2it.utils.DateUtil;
import com.ideas2it.utils.ValidationUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;  
import java.util.InputMismatchException;
import java.util.List; 
import java.util.Map;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

/**
 * <p>
 * EmployeeController can be used for control the full flow of project. It gets the input from user and sends its to 
 * the employee service. 
 * </p> 
 * @author Ramprasath
 * @version 1.0
 **/
public class EmployeeController {
   
    private static Scanner scanner = new Scanner(System.in);
    private EmployeeService employeeService = new EmployeeService();
    private ProjectController projectController = new ProjectController();
    private static Logger logger = Logger.getLogger(EmployeeController.class);	           

    private static boolean isContinue = true;
    private static int index = 0;

    public static void main(String[] args) throws CustomException {

	EmployeeController controller = new EmployeeController();
	BasicConfigurator.configure();
        controller.userInput();
    }

    /** 
     * <p>
     * it displays role for a user to select role.
     * </p>
     * 
     */
    public void userInput() {
        Scanner userInput = new Scanner(System.in); 
        try {
 	    logger.info("1.Trainee ,2.Trainer ,3.Manager, 4.exit");
	    int choice = userInput.nextInt();
	    switch (choice) { 		
	        case 1:
	            trainee(Constants.TRAINEE);
	            break;
	        case 2:
	            trainer(Constants.TRAINER);
	            break;
	        case 3:
	            manager(Constants.MANAGER);
	            break;
	        case 4:
	            logger.info("Thank you");
	            break;     
                default:
                    logger.info("Please Enter the valid input");
                    userInput();   
             }
         } catch (InputMismatchException error) {
             logger.error("Enter Valid Input",error);
         }        
    }

    /** 
     * <p>
     * To get a user input to perform trainee CRUD operations.
     * </p>
     * 
     */
    public void trainee(String userType) {
	logger.info("1.Insert Details\n2.Display Trainee\n3.Update Trainee\n4.Delete Trainee data");
	int option = scanner.nextInt();
	switch (option) {				       
            case 1:
                addAndUpdateEmployee(userType, option);
                break;
            case 2:
                displayEmployee();
                break;
            case 3:
                addAndUpdateEmployee(userType, option);
                break;
            case 4:
                deleteEmployee(userType);
                break;
            default:
                logger.info("Enter the Valid Input");
                trainee(userType);
         }
    }

    /** 
     * <p>
     * To get a user input to perform trainer CRUD operations.
     * </p>
     * 
     */
    public void trainer(String userType) {
	logger.info("1.Insert Details\n2.Display Trainer\n3.Update Trainer\n4.Delete Trainer");
	int option = scanner.nextInt();
	switch (option) {				       
            case 1:
                addAndUpdateEmployee(userType, option);
                break;
            case 2:
                displayEmployee();
                break;
            case 3:
                addAndUpdateEmployee(userType, option);
                break;
            case 4:
                deleteEmployee(userType);
                break;
            default:
                logger.info("Enter the Valid Input");
                trainer(userType);
         }
    }

    /** 
     * <p>
     * To get a user input to perform manager CRUD operations and project management process.
     * </p>
     * 
     */
    public void manager(String userType) {
	logger.info("1.Insert Details\n2.Display Manager\n3.Update Manager\n4.Delete Manager\n5.Display All Trainers\n6.Display All Trainees"
            + "\n7.Manage Projects");
	int option = scanner.nextInt();
	switch (option) {				       
            case 1:
                addAndUpdateEmployee(userType, option);
                break;
            case 2:
                displayEmployee();
                break;
            case 3:
                addAndUpdateEmployee(userType, option);
                break;
            case 4:
                deleteEmployee(userType);
                break;
            case 5:
                displayEmployeeByRole(Constants.TRAINEE);
                break;
            case 6:
                displayEmployeeByRole(Constants.TRAINER);
                break;
            case 7:
                projectController.manageProject();
                break;
            default:
                logger.info("Enter the Valid Input");
                manager(userType);
         }
    }   

    /** 
     * <p>
     * To get a first name from user.
     * </p>
     * 
     */
    private String getFirstName() {
	String firstName = null;	
	while (isContinue) {
            logger.info("Enter your First Name");
	    firstName = scanner.next();
	    boolean isCorrect = ValidationUtil.validateInput(firstName, ValidationUtil.NAME_PATTERN);
	    if (isCorrect) {
		break;
            } else {
	        logger.info("enter valid input");
	        isContinue = true;
	    }
	}
	return firstName;  
    }

    /** 
     * <p>
     * To get a last name from user.
     * </p>
     * 
     */
    private String getLastName() {
	String lastName = null;	
	while (isContinue) {
            logger.info("Enter your Last Name");
	    lastName = scanner.next();
	    boolean isCorrect = ValidationUtil.validateInput(lastName, ValidationUtil.NAME_PATTERN);
	    if (isCorrect) {
		break;
            } else {
	        logger.info("enter valid input");
	        isContinue = true;
	    }
	}
	return lastName;  
    }

    /** 
     * <p>
     * To get a mobile number input from user.
     * </p>
     * 
     */
    private long getMobileNo() {
	String phoneNumber = null;
	while (isContinue) {
	    logger.info("Enter your mobileNo");
	    phoneNumber = scanner.next();
	    boolean isCorrect = ValidationUtil.validateInput(phoneNumber, ValidationUtil.PHONE_NO);
	    if (isCorrect) {
	        break;
            } else {
	        logger.info("enter valid input");
	        isContinue = true;
	    }
	}
	long mobileNo = Long.valueOf(phoneNumber);
	return mobileNo; 
    }

    /** 
     * <p>
     * To get a gender input from user.
     * </p>
     * 
     */
    public String getGender() {
        String gender = null;
    	logger.info("Enter your gender");
	gender = scanner.next();
        try {
	    boolean isCorrect = ValidationUtil.validateGender(gender);
        } catch (CustomException error) {
            logger.error(error);
            getGender();
	}
	return gender;  
    }

    /** 
     * <p>
     * To get a date of birth input from user.
     * </p>
     * 
     */
    private Date getDateOfBirth() {
        Date dateOfBirth = null;
        try {
    	    logger.info("Enter your Date Of Birth in this format dd-mm-yyyy");
	    String birthDate = scanner.next();
	    dateOfBirth = DateUtil.validateDateOfBirth(birthDate);
	    return dateOfBirth;
        } catch (CustomException error) {
            logger.error("Enter Valid Date Format");
            getDateOfBirth();
        }   
        return dateOfBirth;  
    }

    /** 
     * <p>
     * To get a date of joining input from user.
     * </p>
     * 
     */
    private Date getDateOfJoining() {
        Date dateOfJoining = null;
        try {
    	    logger.info("Enter your Date Of joining in this format dd-mm-yyyy");
	    String join_date = scanner.next();
	    dateOfJoining = DateUtil.validateDate(join_date);
	    return dateOfJoining;  
        } catch (CustomException error) {
            logger.error("Enter Valid Date Format");
            getDateOfJoining();
        }   
        return dateOfJoining;         
    }

    /** 
     * <p>
     * To calculate user's age from dateOfBirth.
     * </p>
     * 
     * @param dateOfBirth Date of birth of user.
     */
    public int getAge(Date dateOfBirth) {
	int age = ValidationUtil.calculateAge(dateOfBirth);
	return age;
    }

    /** 
     * <p>
     * To calculate user's experience from dateOfJoining.
     * </p>
     * 
     * @param dateOfJoining join date of user.
     */
    public int getExperience(Date dateOfJoining) {
	int experience = ValidationUtil.calculateExperience(dateOfJoining);
	return experience;
    }

    /** 
     * <p>
     * To get a designation input from user.
     * </p>
     * 
     */
    private String getDesignation() {
	String designation = null;
	while (isContinue) {
    	    logger.info("Enter your designation");
	    designation = scanner.next();
	    boolean isCorrect = ValidationUtil.validateInput(designation, ValidationUtil.DESIGNATION_REGEX);
	    if (isCorrect ) {
	        break;
            } else {
	        logger.info("enter valid input");
	        isContinue = true;
	    }
	}
	return designation;
    }

    /** 
     * <p>
     * To get a email id input from user.
     * </p>
     * 
     */
    private String getEmailId() {
	String emailId = null;
	while (isContinue) {
    	    logger.info("Enter your emailId");
	    emailId = scanner.next();
	    boolean isCorrect = ValidationUtil.validateInput(emailId, ValidationUtil.MAILID_REGEX);
	    if (isCorrect) {
	        break;
            } else {
	        logger.info("enter valid input");
	        isContinue = true;
	    }
	}
	return emailId;  
    }

    /** 
     * <p>
     * To perform and add and update process.
     * </p>
     * 
     * @param userType role of an user.
     * @param option it's used for user choice to perform add or update.
     */
    public void addAndUpdateEmployee(String userType,int option) {
        EmployeeDto employeeDto = new EmployeeDto();
        int employeeId = 0;
        if (option == 1) {
            employeeDto.setId(employeeId);
        } else if (option == 3) {
            logger.info("Enter your employee id");
            employeeId = scanner.nextInt();
            employeeDto.setId(employeeId);
        }
	employeeDto.setFirstName(getFirstName());
	employeeDto.setLastName(getLastName());
	logger.info("Enter your address");
	String address = scanner.next();
        employeeDto.setAddress(address);
	employeeDto.setMobileNo(getMobileNo());
        employeeDto.setDateOfBirth(getDateOfBirth());
        String gender = getGender();
        employeeDto.setGender(gender);
	employeeDto.setEmailId(getEmailId());
        employeeDto.setDateOfJoining(getDateOfJoining());
	employeeDto.setDesignation(getDesignation());
	logger.info("Enter the batch");
	int batch = scanner.nextInt();	    
        employeeDto.setBatch(batch);
        Date createdDate = new Date();
        employeeDto.setCreatedDate(createdDate);
        Date modifiedDate = new Date();
        employeeDto.setModifiedDate(modifiedDate);
        employeeDto.setStatus(Constants.ACTIVE);
        try {
            if (option == 1) {
	        logger.info(employeeService.addEmployee(employeeDto, userType));
            } else if (option == 3) {
	        logger.info(employeeService.updateEmployee(employeeDto));
            }
        } catch (CustomException error) {
            logger.info(error.getMessage());
        }
    }

    /** 
     * <p>
     * To display all the employees.
     * </p>
     * 
     */  
    public void displayAllEmployee() {
        try {
	    for (EmployeeDto employeeDto : employeeService.getAllEmployee()) {
	        logger.info(employeeDto);	   
	    }
        } catch (CustomException error) {
            logger.info(error.getMessage());
        }
    }

    /** 
     * <p>
     * To display employees based on role.
     * </p>
     * 
     * @param userType role of a user.
     */ 
    public void displayEmployeeByRole(String userType) {
        try {
	    for (EmployeeDto employeeDto : employeeService.getEmployeeByRole(userType)) {
	        logger.info(employeeDto);	   
	    }
        } catch (CustomException error) {
            logger.info(error.getMessage());
        }
    }

    /** 
     * <p>
     * To display a single employee.
     * </p>
     * 
     */ 
    public void displayEmployee() {
        logger.info("Enter the Employee Id");
        int employeeId = scanner.nextInt(); 
        try {
            EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
	    logger.info(employeeDto);	   
        } catch (CustomException error) {
            logger.info(error.getMessage());
        }
    }

    /** 
     * <p>
     * To delete employee based on role.
     * </p>
     * 
     * @param userType role of a user.
     */ 
    public void deleteEmployee(String userType) {
        logger.info("Enter your EmployeeId");
        int employeeId = scanner.nextInt();
        try {
           logger.info(employeeService.deleteEmployee(employeeId));
        } catch (CustomException e) {
            logger.info(e);
        }
    } 
}