package com.ideas2it.management.controller;

import com.ideas2it.management.constant.Constants;
import com.ideas2it.management.exception.CustomException;
import com.ideas2it.management.dto.EmployeeDto;
import com.ideas2it.management.dto.RoleDto;
import com.ideas2it.management.service.EmployeeService;
import com.ideas2it.management.utils.DateUtil;
import com.ideas2it.management.utils.ValidationUtil;

import java.util.ArrayList;
import java.util.Date;  
import java.util.InputMismatchException;
import java.util.List;
import java.time.LocalDate; 
import java.util.Map;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

/**
 * It can be implemented for input and output operation of trainer,trainee and manager.
 **/
public class EmployeeController {
   
    private static Scanner scanner = new Scanner(System.in);
    private EmployeeService employeeService = new EmployeeService();
    private static Logger logger = Logger.getLogger(EmployeeController.class);	           

    private static boolean isContinue = true;
    private static int index = 0;

    public static void main(String[] args) throws CustomException {

	EmployeeController controller = new EmployeeController();
	BasicConfigurator.configure();

        while (isContinue) {
	    logger.info("1.Trainee ,2.Trainer ,3.Manager, 4.exit");
	    int choice = scanner.nextInt();
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
	        case 4:
	            logger.info("Thank you");
                    System.exit(0);
	            break;                
   
            } 
        }
    }

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
         }
    }

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
         }
    }

    public void manager(String userType) {
	logger.info("1.Insert Details\n2.Display Manager\n3.Update Manager\n4.Delete Manager\n5.Display All Trainers\n6.Display All Trainees");
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
         }
    }   

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

    public String getGender() throws CustomException {
        String gender = null;
	while (isContinue) {
    	    logger.info("Enter your gender");
	    gender = scanner.next();
	    boolean isCorrect = ValidationUtil.validateGender(gender);
	    if (isCorrect) {
	        break;
            } else {
	        logger.info("enter valid input");
	        isContinue = true;
	    }
	}
	return gender;  
    }

    private Date getDateOfBirth() throws CustomException {
    	logger.info("Enter your Date Of Birth in this format dd-mm-yyyy");
	String birthDate = scanner.next();
	Date dateOfBirth = DateUtil.validateDateOfBirth(birthDate);
	return dateOfBirth;  
    }

    private Date getDateOfJoining() throws CustomException{
    	logger.info("Enter your Date Of joining in this format dd-mm-yyyy");
	String join_date = scanner.next();
	Date dateOfJoining = DateUtil.validateDate(join_date);
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

    public void addAndUpdateEmployee(String userType,int option) {
        
        EmployeeDto employeeDto = new EmployeeDto();
        int employeeId = 0;
        if (option == 1) {
            employeeId = 0;
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
	Date dateOfBirth = null;
	try {
	    dateOfBirth = getDateOfBirth();
	} catch (CustomException e) {
            logger.info(e);
        }
        employeeDto.setDateOfBirth(dateOfBirth);
        String gender = null;
        try {
	    gender = getGender();
        } catch (CustomException e) {
            logger.info(e);
        }
        employeeDto.setGender(gender);
	employeeDto.setEmailId(getEmailId());
	Date dateOfJoining = null;
	try {
	    dateOfJoining = getDateOfJoining();
	} catch (CustomException e) {
            logger.info(e);
        }
        employeeDto.setDateOfJoining(dateOfJoining);
	employeeDto.setDesignation(getDesignation());
	logger.info("Enter the batch");
	int batch = scanner.nextInt();	    
        employeeDto.setBatch(batch);
        Date createdDate = new Date();
        employeeDto.setCreatedDate(createdDate);
        Date modifiedDate = new Date();
        employeeDto.setModifiedDate(modifiedDate);
        employeeDto.setStatus("active");

        if (option == 1) {
            try {
	        employeeService.addEmployee(employeeDto, userType);
            } catch (CustomException e) {
                logger.info(e);
            }
        } else if (option == 3) {
            try {
	        employeeService.updateEmployee(employeeDto);
            } catch (CustomException e) {
                logger.info(e);
            }
        } 
    }
  
    public void displayAllEmployee() {
        try {
	    for (EmployeeDto employeeDto : employeeService.getAllEmployee()) {
	        logger.info(employeeDto);	   
	    }
        } catch (CustomException error) {
            logger.info(error.getMessage());
        }
    }

    public void displayEmployeeByRole(String userType) {
        try {
	    for (EmployeeDto employeeDto : employeeService.getEmployeeByRole(userType)) {
	        logger.info(employeeDto);	   
	    }
        } catch (CustomException error) {
            logger.info(error.getMessage());
        }
    }

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

   public void deleteEmployee(String userType) {
        logger.info("Enter your EmployeeId");
        int employeeId = scanner.nextInt();
        try {
            employeeService.deleteEmployee(employeeId);
        } catch (CustomException e) {
            logger.info(e);
        }
    }  
}