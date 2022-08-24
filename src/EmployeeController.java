package org.ideas2it.management.controller;

import org.ideas2it.management.constant.Constants;
import org.ideas2it.management.exception.CustomException;
import org.ideas2it.management.dto.EmployeeDto;
import org.ideas2it.management.service.EmployeeService;
import org.ideas2it.management.utils.ValidationUtil;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;  
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

    private static boolean isContinue = true;
    private static int index = 0;

    public static void main(String[] args) throws CustomException {

	EmployeeController controller = new EmployeeController();	
	System.out.println("1.Trainee ,2.Trainer ,3.Manager, 4.exit");
	int choice = scanner.nextInt();

	switch (choice) { 		
	    case 1:
	        controller.trainee(Constants.TRAINEE);
	        break;
        }
    }


    public void trainee(String userType) {
	System.out.println("1.Insert Details\n2.View details\n3.modify detail\n4.update detail\n5.delete Trainee data\n6.Default trainee");
	int option = scanner.nextInt();
	switch (option) {				       
            case 1:
                addEmployee(userType);
                break;
         }
    }

    private String getFirstName() {
	String firstName = null;	
	while (isContinue) {
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

    private String getDateOfBirth() throws CustomException {
	String dateOfBirth = null;
 	while (isContinue) {
    	    System.out.println("Enter your Date Of Birth in this format dd-mm-yyyy");
	    dateOfBirth = scanner.next();
	    boolean isCorrect = false;
	    try {
	        isCorrect = ValidationUtil.validateDateOfBirth(dateOfBirth);
                
            } catch (CustomException e) {
		throw new CustomException(e.getMessage());
            }
  	    if (isCorrect == true) {
	        break;
            } else {
	        System.out.println("enter valid input");
	        isContinue = true;
	    } 
	}
	return dateOfBirth;  
    }

    private String getDateOfJoining() throws CustomException{
	String dateOfJoining = null;
 	while (isContinue) {
    	    System.out.println("Enter your Date Of joining in this format dd-mm-yyyy");
	    dateOfJoining = scanner.next();
	    boolean isCorrect = false;
	    try {
	        isCorrect = ValidationUtil.validateDateOfJoining(dateOfJoining);
            } catch (CustomException e) {
	        throw new CustomException(e.getMessage());
            }
  	    if (isCorrect == true) {
	        break;
            } else {
	        System.out.println("enter valid input");
	        isContinue = true;
	    } 
	}
	return dateOfJoining;  
    }

    public int getAge(String dob) {
	int age = ValidationUtil.calculateAge(dob);
	return age;
    }

    public int getExperience(String dateOfJoining) {
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

    private String generateEmployeeId() {
        String employeeId = ValidationUtil.generateEmployeeId();
	return employeeId;
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

    public String getGender () {
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

    public void addEmployee(String userType) {
	if (userType == "trainee" || userType == "trainer" || userType == "manager") {
 	    System.out.println("Insert your Details \nEnter your firstName: ");
	    String firstName = getFirstName();
	    System.out.println("Enter your lastName");
	    String lastName = getLastName();
	    System.out.println("Enter your address");
	    String address = scanner.next();
	    long mobileNo = getMobileNo();
	    String dateOfBirth = null;
	    try {
	        dateOfBirth = getDateOfBirth();
	    } catch (CustomException e) {
                System.out.println(e);
            }
	    int age = getAge(dateOfBirth);
	    String gender = getGender();
	    String emailId = getEmailId();
	    String employeeId = generateEmployeeId();
	    String dateOfJoining = null;
	    try {
	        dateOfJoining = getDateOfJoining();
	    } catch (CustomException e) {
                System.out.println(e);
            }
	    String designation = getDesignation();
	    System.out.println("Enter the batch");
	    int batch = scanner.nextInt();
	    
	    EmployeeDto employeeDto = new EmployeeDto(firstName, lastName, address, mobileNo, dateOfBirth, gender, emailId,
                employeeId, batch, dateOfJoining, designation);
            try {
	        employeeService.addEmployee(employeeDto);
            } catch (CustomException e) {
                System.out.println(e);
            }
        } 
    }
}

