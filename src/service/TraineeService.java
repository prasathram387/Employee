package org.ideas2it.management.traineeservice;

import org.ideas2it.management.dao.TraineeDao;
import org.ideas2it.management.model.Trainee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * It can be implemented for transfer data between Employee controller
 * to traineeDao and traineeDao to Employeecontroller
 **/
public class TraineeService {

    private TraineeDao traineeDao = new TraineeDao();

    /** 
     * <p>
     * To get  input from the controller and transfers trainee detail to traineeDao.
     * </p>
     * 
     * @param firstName First name of the trainee.
     * @param lastName Last name of the trainee.
     * @param age Age of the trainee.
     * @param address Address of the trainee.
     * @param mobileNo MobileNo of the trainee.
     * @param dateOfBirth Date of the trainee.
     * @param emailId Emailid of the trainee.
     * @param employeeId employeeId of the trainee.
     * @param department experience of the trainee.
     *
     * @return it returns the boolean to controller.
     *
     */
    public boolean addTrainee(String name, int age, String address, long mobileNo,
            String dateOfBirth, String gender, String emailId, String employeeId, String department) {   
        Trainee trainee = new Trainee(name, age, address, mobileNo, dateOfBirth, gender, emailId, employeeId, department);  
	boolean isAdded = traineeDao.insertTrainee(trainee);
	return true;
    }

    /** 
     * <p>
     * It transfers default entry of trainer detail to trainerDao.
     * </p>
     *
     * @return it returns the boolean to controller. 
     * 
     */  
    public boolean defaultAddTrainee() {   
        Trainee firstTrainee = new Trainee("ram", 22, "tvr", 9898989890l, "10-01-1999", "male", "prasath@we", "I2IT6", "cse");
        Trainee secondTrainee = new Trainee("agnel", 22, "padi", 9898988765l, "11-02-1999", "male", "agnel@we", "I2IT7", "cse"); 
        Trainee thirdTrainee = new Trainee("vellaiyan", 22, "guindy", 9898989123l, "15-06-1999", "male", "vellaiyan@we", "I2IT8", "cse");
        Trainee fourthTrainee = new Trainee("guna", 22, "kknagar", 9898989098l, "14-05-1999", "male", "guna@we", "I2IT9", "cse"); 
	boolean isAddedFirstTrainee = traineeDao.insertTrainee(firstTrainee);
	boolean isAddedSecondTrainee = traineeDao.insertTrainee(secondTrainee);
	boolean isAddedThirdTrainee = traineeDao.insertTrainee(thirdTrainee);
	boolean isAddedFourthTrainee = traineeDao.insertTrainee(fourthTrainee);
	return isAddedFourthTrainee;
    }

   /** 
    * <p>
    * To get input from the controller and checks the emailId,mobileNo is in the list.
    * </p>
    * 
    * @param emailId Email-id of trainee.
    * @param mobileNo Mobile number of trainee.
    *
    * @return index - index of a trainee.
    *
    */
    public int findIndexByEmailIdAndMobileNo(String emailId, long mobileNo) {
        int index = 0;
        for(Trainee trainee : traineeDao.retrieveTrainee()) {
            if (emailId.equals(trainee.getEmailId()) && mobileNo == trainee.getMobileNo()) {
 		break;
            }
	    index++;
        }
        return index;
    }


    /** 
     * <p>
     * To get updated input from the controller and transfers trainee detail to traineeDao.
     * </p>
     * 
     * @param firstName First name of the trainee.
     * @param lastName Last name of the trainee.
     * @param age Age of the trainee.
     * @param address Address of the trainee.
     * @param mobileNo MobileNo of the trainee.
     * @param dateOfBirth Date of the trainee.
     * @param emailId Emailid of the trainee.
     * @param employeeId employeeId of the trainee.
     * @param experience experience of the trainee.
     * @param designation designation of the trainee.
     *
     * @return it returns the boolean to controller.
     *
     */
    public boolean updateTrainee(int index, String name, int age, String address, 
            long mobileNo, String dateOfBirth, String gender, String emailId, String employeeId, String department) {   
	Trainee trainee = new Trainee(name, age, address, mobileNo, dateOfBirth, gender, emailId, employeeId, department);
	boolean isUpdated = traineeDao.updateTrainee(index, trainee);
	return isUpdated;
    }

    /** 
     * <p>
     * To get input from the controller and checks the trainee id is in the list.
     * </p>
     *
     * @param traineeId - traineeId of trainer.
     *
     * @return - it returns boolean to the controller.
     *
     */    
    public boolean findTraineeId(String traineeId) {	
	for (Trainee trainee : traineeDao.retrieveTrainee()) {
	    return traineeId.equals(trainee.getEmployeeId());
	}
	return false;
    }

    /** 
     * <p>
     * updatetraineeDataByOption method used to get choice and data from the controller,updates the single trainee data 
     * and transfers trainee object to Dao.
     * </p>
     * 
     * @param choice it can be a input from user and passed to switch option 
     * @param updatedData it can be a data from user to update.
     *
     * @return it returns the boolean to controller.
     *
     */
    public boolean updateTraineeByOption(int choice, String updatedData) {
	for(Trainee trainee : traineeDao.retrieveTrainee()) {
	    switch(choice){
		case 1:
		    trainee.setName(updatedData);
		    break;

		case 2:
		    trainee.setEmailId(updatedData);
		    break;

    		case 3:
		    trainee.setAddress(updatedData);
		    break;

		case 4:
		    trainee.setDepartment(updatedData);
		    break;

		case 5:
		    trainee.setGender(updatedData);
		    break;

		default:
		    System.exit(0);
            }
	}
	return true;
    }


    /** 
     * <p>
     * To retrieve list from the dao and transfers to the controller.
     * </p>
     * 
     * @return trainees it returns list of trainee to controller. 
     */
    public List<Trainee> getTrainee() {
	return traineeDao.retrieveTrainee();
    }

    /** 
     * <p>
     * Get emailId and index from the controller and pass the index to traineeDao for delete.
     * </p>
     * 
     * @param emailid Emailid used for checking it in the list
     * @param index Index used for index position of emailid is present where in the list 
     *
     * @return it returns the boolean to controller.
     *
     */
    public boolean deleteTraineeByEmployeeId(String employeeId) {
	for(Trainee trainee : traineeDao.retrieveTrainee()) {
	    if(employeeId.equals(trainee.getEmployeeId())) {
       	        return traineeDao.deleteTraineeByEmployeeId(trainee);
	    }
        }
	return false;
    }
}