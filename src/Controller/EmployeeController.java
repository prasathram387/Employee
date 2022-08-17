package org.ideas2it.management.controller;

import org.ideas2it.management.exception.CustomException;
import org.ideas2it.management.model.Manager;
import org.ideas2it.management.model.Trainer;
import org.ideas2it.management.model.Trainee;
import org.ideas2it.management.service.ManagerService;
import org.ideas2it.management.traineeservice.TraineeService;
import org.ideas2it.management.trainerservice.TrainerService;
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
    private ManagerService managerService = new ManagerService();	            	
    private TrainerService trainerService = new TrainerService();
    private TraineeService traineeService = new TraineeService();

    private static boolean isContinue = true;
    private static int index = 0;

    public static void main(String[] args) throws CustomException {

	EmployeeController controller = new EmployeeController();
	for (int iteration = 1; iteration <= 5; iteration++) {
	    try {
	        System.out.println("1.Trainee ,2.Trainer ,3.Manager, 4.exit");
	        int choice = scanner.nextInt();

	        switch (choice) { 		
	            case 1:
			controller.trainee(choice);
			break;

		    case 2:
			controller.trainer(choice);
			break;

		    case 3:
			controller.manager();
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

    /** 
     * <p>
     * To get a user input to perform trainee CRUD operations based on user choice.
     * </p>
     *
     * @param choice Choice of a user to perform the task.
     * 
     */
    public void trainee(int choice) {
	System.out.println("1.Insert Details\n2.View details\n3.modify detail\n4.update detail\n5.delete Trainee data\n6.Default trainee");
	int option = scanner.nextInt();
	switch (option) {				       
            case 1:
                addEmployee(choice);
                break;

            case 2:
                displayEmployee(choice);
                break;

            case 3: 
		index = findIndexOfTrainee();
		System.out.println("Trainee detail");
		if (index >= 0) {
		    updateEmployeeByOption(index, choice);
		}
	        break;

	    case 4:
	        index = findIndexOfTrainee();
		if (index >= 0) {
	            updateEmployee(index, choice);
		}
		break;

	    case 5:
		System.out.println("Enter the employeeId you want to delete");
	        String employeeId = scanner.next();
		deleteEmployeeByEmployeeId(employeeId, choice);
	        break;

	    case 6:
		traineeService.defaultAddTrainee();
		break;

            default:
                System.out.println("Thank you");
		System.exit(0);	   
	}
    }

    /** 
     * <p>
     * To get a user input to perform trainer CRUD operations based on user choice.
     * </p>
     *
     * @param choice Choice of a user to perform the task.
     * 
     */
    public void trainer(int choice) {
	System.out.println("1.Insert Details \n2.View details\n3.Modify Trainer Detail\n4.Update Trainer Detail\n5.Delete Trainer data\n"
	    +"6.Default Trainer");
	int option = scanner.nextInt();

	switch (option) {				       
            case 1:
                addEmployee(choice);
                break;

            case 2:
		displayEmployee(choice);
                break;

            case 3: 
		index = findIndexOfTrainer();
		System.out.println("Trainee detail");
		if (index >= 0) {
		    updateEmployeeByOption(index, choice);
		}
	        break;

	    case 4:
	        index = findIndexOfTrainer();
		if (index >= 0) {
	            updateEmployee(index, choice);
		}
		break;

	    case 5:
		System.out.println("Enter the employeeId you want to delete");
	        String employeeId = scanner.next();
		deleteEmployeeByEmployeeId(employeeId, choice);
	        break;

	     case 6:
	         trainerService.defaultAddTrainer();
	         break;

             default:
                 System.out.println("Thank you");
		 System.exit(0);	   
	}
    }

    /** 
     * <p>
     * To get a user input to perform trainee CRUD operations based on user choice.
     * </p>
     *
     * 
     */
    public void manager() {
	System.out.println("1.Insert Details\n2.View details\n3.Assign trainees\n4.View Allocated trainers");
	int option = scanner.nextInt();

	switch (option) {				       
	    case 1:
		addManager();
		break;

	    case 2:
		displayManager();
		break;

	    case 3:
		managerPortal();
		break;

	    case 4:
		displayAllocatedTrainers();
		break;

	    default:
		System.exit(0);	
	}
    }

    /** 
     * <p>
     * To get a boolean from validation util to check valid input .
     * </p>
     *
     * @return it returns the name to add trainees method.
     * 
     */
    private String getName() {
	String name = null;	
	while (isContinue) {
	    name = scanner.next();
	    boolean isCorrect = ValidationUtil.validateInput(name, ValidationUtil.NAME_PATTERN);
	    if (isCorrect) {
		break;
            } else {
	        System.out.println("enter valid input");
	        isContinue = true;
	    }
	}
	return name;  
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
     * @return it returns the department to add trainees method.
     * 
     */
    private String getDepartment() {
 	String department = null;
	while (isContinue) {
     	    System.out.println("Enter your department");
	    department = scanner.next();
	    boolean isCorrect = ValidationUtil.validateInput(department, ValidationUtil.DEPARTMENT_REGEX);
	    if (isCorrect) {
	        break;
            } else {
	        System.out.println("enter valid input");
	        isContinue = true;
	    }
	}
	return department;  
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
	String firstName = getName();
	System.out.println("Enter your lastName");
	String lastName = getName();
	String name = firstName + lastName;
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
	if (choice == 1) {
	    String department = getDepartment();
	    boolean isTraineeAdded = traineeService.addTrainee( name, age, address, mobileNo, dateOfBirth, gender, emailId, employeeId, department);
	    if (isTraineeAdded) {
	        System.out.println("ADDED SUCCESSFULLY");
	    }
	} else if (choice == 2) {
	    Byte experience = getExperience();
	    String designation = getDesignation();
	    boolean isTrainerAdded = trainerService.addTrainer(name, age, address, mobileNo, dateOfBirth, gender, emailId, employeeId, experience, designation);
	    if (isTrainerAdded) {
	        System.out.println("ADDED SUCCESSFULLY");
	    }
	}
    }

    /** 
     * <p>
     * To get list of trainees from service class and displays the trainees.
     * </p>
     *
     * @param choice Choice of a user to perform the task.
     * 
     */
    public void displayEmployee(int choice) {
	if (choice == 1) {
	    for(Trainee trainee : traineeService.getTrainee()) {
	        System.out.println(trainee);	   
	    }
	} else if (choice == 2) {
	    for(Trainer trainer : trainerService.getTrainer()) {
	    	System.out.println(trainer);	
	    }
	}
    }

    /** 
     * <p>
     * To get a index from Trainee service by checking valid emaild and mobileNo .
     * </p>
     *
     * @return index - It returns the index.
     *  
     */
    public int findIndexOfTrainee() {
	System.out.println("Enter your emailId");
	String mailId = scanner.next();
	System.out.println("Enter your mobileNo");
	long mobile = scanner.nextLong();
	int index = traineeService.findIndexByEmailIdAndMobileNo(mailId, mobile);
	return index;
    }

    /** 
     * <p>
     * To get user input to update data of both trainer list by checking emailid and mobile no.
     * </p>
     *
     * @param choice Choice of a user to perform the task.
     * @param index Index of a employee.
     * 
     */
    public void updateEmployee(int index, int choice) {
	    System.out.println("Enter your firstName");
	    String firstName = getName();
	    System.out.println("Enter your lastName");
	    String lastName = getName();
	    String name = firstName + lastName;
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
	    if (choice == 1) {
	    	String department = getDepartment();
	    	boolean isTraineeUpdated = traineeService.updateTrainee(index, name, age, address, mobileNo, dateOfBirth, gender, emailId, 
                    employeeId, department);
		if (isTraineeUpdated) {
	            System.out.println("UPDATED SUCCESSFULLY");
		}
	    } else if (choice == 2) {
	        byte experience = getExperience();
	        String designation = getDesignation();
	        boolean isTrainerUpdated = trainerService.updateTrainer(index, name, age, address, mobileNo, dateOfBirth, gender, emailId,
                    employeeId, experience, designation);
		if (isTrainerUpdated) {
	            System.out.println("UPDATED SUCCESSFULLY");
		}
	    }
    }

    /** 
     * <p>
     * To getting user input to update single data of trainer list by checking emailid and mobile no.
     * </p>
     * 
     */
    public void updateEmployeeByOption(int index, int choice) {
	if (choice == 1) {
	    System.out.println("Enter the number u want to modify 1.First name,2.Last name,3.age,4.address,5.mobileNo,6.Trainer id,7.department");
	    int option = scanner.nextInt();
	    System.out.println("Enter new data");
	    String newData = scanner.next();
	    boolean isTraineeUpdated = traineeService.updateTraineeByOption(option, newData);
	    if (isTraineeUpdated) {
		System.out.println("UPDATED SUCCESSFULLY");
	    }
	} else if (choice == 2) {
 	    System.out.println("Enter the number u want to modify 1.First name,2.Last name,3.EmailId,4.Address,5.Designation,6.Gender");
	    int option = scanner.nextInt();
	    System.out.println("Enter new data");
	    String newData = scanner.next();
	    boolean isTrainerUpdated = trainerService.updateTrainerByOption(option, newData);
	    if (isTrainerUpdated) {
		System.out.println("UPDATED SUCCESSFULLY");
	    }
    	} 
    }

    /** 
     * <p>
     * To delete a trainer by using its index from a list.
     * </p>    
     * 
     * @param choice Choice of a user to perform the task.
     * @param index Index of a employee.
     * 
     */
    public void deleteEmployeeByEmployeeId(String employeeId, int choice) {
	if (choice == 1) {
            boolean isTraineeDeleted = traineeService.deleteTraineeByEmployeeId(employeeId);
	    if (isTraineeDeleted) {
                System.out.println("Trainee---deleted sucessfully");
	    }
	} else if (choice == 2) {
            boolean isTrainerDeleted = trainerService.deleteTrainerByEmployeeId(employeeId);
	    if (isTrainerDeleted) {
                System.out.println("Trainer---deleted sucessfully");
	    }
	}
    }

    /** 
     * <p>
     * To get a index from Trainee service by checking valid emaild and mobileNo .
     * </p>
     *
     * @return It returns the index
     * 
     */
    public int findIndexOfTrainer() {
	System.out.println("Enter your emailId");
	String mailId = scanner.next();
	System.out.println("Enter your mobileNo");
	long mobile = scanner.nextLong();
	int index = trainerService.findIndexByEmailIdAndMobileNo( mailId, mobile);
	return index;
    }


    /** 
     * <p>
     * it takes a data from user and send the parameters to manager service class.
     * </p>
     * 
     */
    public void addManager() {
	System.out.println("Enter your emailId");
	String mailId = scanner.next();
	System.out.println("Enter your password");
	String password = scanner.next();
	managerService.addManager(mailId, password);
    }

    /** 
     * <p>
     * To get a list of trainers from service class and displays the trainers.
     * </p>
     * 
     */
    public void displayManager() {
	for (Manager manager : managerService.getManager()) {
	    System.out.println(manager);	
	}
    }

    /** 
     * <p>
     * To get a input from user and transfers to manager service class.
     * </p>
     * 
     */
    public boolean managerLogin() {
	System.out.println("Enter your emailId");
	String mailId = scanner.next();
	System.out.println("Enter your password");
	String password = scanner.next();
	boolean isAvailable = managerService.validateManagerByEmailIdAndPassword(mailId, password);
	return isAvailable;
    }

    /** 
     * <p>
     * To auto assigning trainer to no of trainees and sends it to manager service.
     * </p>
     * 
     */
    public void autoAssignTrainerForTrainee() {
 	List<Trainee> trainees = traineeService.getTrainee();
 	List<Trainer> trainers = trainerService.getTrainer();
	int trainerSize = trainers.size();
	int assignLength = trainees.size()/trainerSize;
  	int traineeLength = assignLength;
        int traineeIndex = 0;
	for (int trainerIndex = 0; trainerIndex < trainerSize ; trainerIndex++) {
	    for (int index = traineeIndex; index < assignLength; index++) {
		managerService.addTrainee(trainees.get(index).getEmployeeId());
	    }
	    List<String> assignedTrainees = managerService.retrieveTrainee();
	    managerService.assignTrainerForTrainee(trainers.get(index).getEmployeeId(), assignedTrainees);
	    traineeIndex = assignLength;
	    assignLength += traineeLength;
	}
    }

    /** 
     * <p>
     * To manual assigning trainer to no of trainees and sends it to manager service.
     * </p>
     * 
     */	
    public void assignTrainerForTrainee() {

	System.out.println("Enter the trainer Id You want to select");
	String trainerId = scanner.next();
  	boolean trainerIsAvailable = trainerService.findTrainerId(trainerId);

	System.out.println("Enter the first trainee Id to assign this trainer");
      	String firstTraineeId = scanner.next();
	boolean firstTraineeIsAvailable = traineeService.findTraineeId(firstTraineeId);

	System.out.println("Enter the second trainee Id to assign this trainer");
	String secondTraineeId = scanner.next();
	boolean secondTraineeIsAvailable = traineeService.findTraineeId(secondTraineeId);
	
	boolean isAlreadyAssigned = managerService.isTraineeAlreadyAssigned(firstTraineeId, secondTraineeId);
	if (isAlreadyAssigned) {
	    managerService.assignedTrainees(firstTraineeId, secondTraineeId);
	} else {
	    System.out.println("The trainees are already assigned");
	    assignTrainerForTrainee();
        }
	List<String> assignedTrainees = managerService.retrieveTrainees();

	boolean isAlreadyMapped = managerService.checkAssignedTrainees(trainerId, firstTraineeId, secondTraineeId);

	if (isAlreadyMapped) {
	    managerService.assignTrainerForTrainee(trainerId, assignedTrainees);  
	} else {
	    System.out.println("The trainer and trainees are already assigned");
            assignTrainerForTrainee();
	}
    }
    /** 
     * <p>
     * The portal can be used for manager operations.
     * </p>
     * 
     */
    public void managerPortal() {
	boolean isValidManager = managerLogin();
 	List<Trainee> trainees = traineeService.getTrainee();
 	List<Trainer> trainers = trainerService.getTrainer();
	System.out.println("----------Trainees List-------");
        for (Trainee trainee : trainees) {
	    System.out.println(trainee);
	}
	System.out.println("----------Trainers List-------");
        for (Trainer trainer : trainers) {
	    System.out.println(trainer);
	}	
	System.out.println("1.Auto selection \n2.Manual selection");
	int option = scanner.nextInt();

	switch (option) {
	    case 1:
		autoAssignTrainerForTrainee();
                break;

            case 2:
		assignTrainerForTrainee();
	        break;

	    default:
	        break;
        }
    }    

    /** 
     * <p>
     * To display the allocated trainers.
     * </p>
     * 
     */
    public void displayAllocatedTrainers() {
	Map<String, List<String>> assignedMap = managerService.getAssignedMap();	
	System.out.println("Allocated Trainers and Trainees");		      
	for (Map.Entry<String, List<String>> hashmap : assignedMap.entrySet()) {    
       	    System.out.println("TrainerId----- "+hashmap.getKey()+" = "+"Trainee Name------  "+hashmap.getValue());    
        }
    }
}		      
