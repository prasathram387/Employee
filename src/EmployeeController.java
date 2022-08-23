package org.ideas2it.management.controller;

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
	
	    try {
	        System.out.println("1.Trainee ,2.Trainer ,3.Manager, 4.exit");
	        int choice = scanner.nextInt();

	        switch (choice) { 		
	            case 1:
			controller.employee(Constants.TRAINEE);
			break;

		    case 2:
			controller.employee(Constants.TRAINER);
			break;

		    case 3:
			controller.employee(Constants.MANAGER);
			break;
			
		    case 4: 
             	        System.out.println("Thank you");
		        isContinue = false;
	   	        break;

		    default:
	                break;
	        }
		if (choice > 4) {
		    throw new CustomException("Enter valid input");
		}
	    } catch (InputMismatchException error) {
		throw new CustomException("Invalid input",error);
	    }
	}
    }

    public void employee(int choice) throws CustomException {
	if(choice == 1 || choice == 2 || choice == 3) {
	    System.out.println("1.Insert Details\n2.View details\n3.modify detail\n4.update detail\n5.delete detail\n6.Default Employee");
	    int option = scanner.nextInt();
	    switch (option) {				       
                case 1:
                    addEmployee(choice);
                    break;

   /*           case 2:
                    displayEmployee(choice);
                    break;

                case 3: 
		    index = findIndexOfEmployee();
		    System.out.println("Employee detail");
		    if (index >= 0) {
		        updateEmployeeByOption(index, choice);
		    }
	            break;

	        case 4:
	            index = findIndexOfEmployee();
		    if (index >= 0) {
	                updateEmployee(index, choice);
		    }
		    break;

 	        case 5:
		    System.out.println("Enter the employeeId you want to delete");
	            String employeeId = scanner.next();
		    deleteEmployeeById(employeeId, choice);
	            break;

 	        case 6:
		    EmployeeService.defaultAddEmployee();
		    break;
   */
                default:
                    System.out.println("Thank you");
		    System.exit(0);	   
	    }
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
    /** 
     * <p>
     * To get a boolean from validation util to check valid input .
     * </p>
     *
     * @return it returns the mobileNo to add trainees method.
     * 
     */
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

    /** 
     * <p>
     * To get a boolean from validation util to check valid input .
     * </p>
     *
     * @return it returns the date of birth to add trainees method.
     * 
     */
    private String getDateOfBirth() {
	String dateOfBirth = null;
 	while (isContinue) {
    	    System.out.println("Enter your Date Of Birth in this format dd-mm-yyyy");
	    dateOfBirth = scanner.next();
	    boolean isCorrect = ValidationUtil.validateDateOfBirth(dateOfBirth);
  	    if (isCorrect == true) {
	        break;
            } else {
	        System.out.println("enter valid input");
	        isContinue = true;
	    } 
	}
	return dateOfBirth;  
    }

    /** 
     * <p>
     * To get a age from validation util to valid through date of birth .
     * </p>
     *
     * @param dob it gets a dob from add trainees
     * @return it returns the age to add trainees method.
     * 
     */
    public int getAge(String dob) {
	int age = ValidationUtil.calculateAge(dob);
	return age;
    }

    /** 
     * <p>
     * To get a boolean from validation util to check valid input .
     * </p>
     *
     * @return it returns the experience to add trainers method.
     * 
     */
    private byte getExperience() {
	String trainerExperience = null;
	while (isContinue) {
    	    System.out.println("Enter your experience");
	    trainerExperience = scanner.next();
	    boolean isCorrect = ValidationUtil.validateInput(trainerExperience, ValidationUtil.EXPERIENCE_REGEX);
	    if (isCorrect) {
	        break;
            } else {
	        System.out.println("enter valid input");
	        isContinue = true;
	    }
	}
	byte experience = Byte.valueOf(trainerExperience); 
	return experience;  
    }

    /** 
     * <p>
     * To get a boolean from validation util to check valid input .
     * </p>
     *
     * @return it returns the designation to add trainers method.
     * 
     */
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

    /** 
     * <p>
     * To generate employee id automatically.
     * </p>
     *
     * @return It returns the employeeId to add trainees method.
     * 
     */ 
    private String generateEmployeeId() {
        String employeeId = ValidationUtil.generateEmployeeId();
	return employeeId;
    } 

    /** 
     * <p>
     * To get a boolean from validation util to check valid input .
     * </p>
     *
     * @return It returns the emailId to add trainees method.
     * 
     */
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

    /** 
     * <p>
     * To get a boolean from validation util to check valid input .
     * </p> 
     *
     * @return It returns the gender to add trainees method.
     * 
     */
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

    /** 
     * <p>
     * To get user input and send the parameters to service class.
     * </p>
     * 
     * @param choice Choice of a user to perform the task.
     */
    public void addEmployee(int choice) {
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
	   throw new CustomException("enter valid input");
	} catch (CustomException e) {
	   System.out.println(e);
        }
	int age = getAge(dateOfBirth);
	String gender = getGender();
	String emailId = getEmailId();
	String employeeId = generateEmployeeId();
	Byte experience = getExperience();
	String designation = getDesignation();
	System.out.println("Enter the batch");
	int batch = scanner.nextInt();
	mapper.employeeDtoToEmployee(firstName, lastName, address, mobileNo, dateOfBirth, gender, emailId,
            employeeId, batch, experience, designation);
    }
}
