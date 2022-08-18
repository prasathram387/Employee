package org.ideas2it.management.trainerservice;

import org.ideas2it.management.dao.TrainerDao;
import org.ideas2it.management.model.Trainer;
import org.ideas2it.management.traineeservice.TraineeService;

import java.util.ArrayList;
import java.util.Date;
import java.text.Format;
import java.util.List;
import java.text.SimpleDateFormat;

/**
 * It can be implemented for transfer data  between Employee controller
 * to trainerDao and trainerDao to Employeecontroller
 **/
public class TrainerService {	

    private TrainerDao trainerDao = new TrainerDao();

    /** 
     * <p>
     * To get input from the controller and transfers trainer detail to trainerDao.
     * </p>
     * 
     * @param firstName First name of the trainer.
     * @param lastName Last name of the trainer.
     * @param age Age of the trainer.
     * @param address Address of the trainer.
     * @param mobileNo MobileNo of the trainer.
     * @param dateOfBirth Date of the trainer.
     * @param emailId Emailid of the trainer.
     * @param employeeId employeeId of the trainer.
     * @param experience experience of the trainer.
     * @param designation designation of the trainer.
     *
     * @return it returns the boolean to controller    
     */
    public boolean addTrainer(String name, int age, String address, long mobileNo,
            String dateOfBirth, String gender, String emailId, String employeeId, byte experience, String designation) {   
	Trainer trainer = new Trainer(name, age, address, mobileNo, dateOfBirth, gender, emailId, employeeId, experience, designation);
	boolean isAdded = trainerDao.insertTrainer(trainer);
	return isAdded;
    }


    /** 
     * <p>
     * It transfers default entry of trainer detail to trainerDao.
     * </p>
     *
     * @return it returns the boolean to controller
     * 
     */     
    public boolean defaultAddTrainer() {  
     	byte firstExperience = 7;
	byte secondExperience =8; 
        Trainer firstTrainer = new Trainer("prasath", 25, "tvr", 96767689876l, "10-01-1992", "male", "pra@we", "I2IT11", firstExperience, "trainer");
        Trainer secondTrainer = new Trainer("ruban", 28, "padi", 9898912345l, "11-02-1994", "male", "ruban@we", "I2IT12", secondExperience, "trainer"); 
	boolean isFirstTrainerAdded = trainerDao.insertTrainer(firstTrainer);
	boolean isSecondTrainerAdded = trainerDao.insertTrainer(secondTrainer);
	return isSecondTrainerAdded;
    }
   
    /** 
     * <p>
     * To retrieve list from the dao and transfers to the controller.
     * </p>
     * 
     * @return it returns the trainersList.
     */
    public List<Trainer> getTrainer() {	
    	return trainerDao.retrieveTrainer();
    }

    /** 
     * <p>
     * To get input from the controller and checks the emailId,mobileNo is in the list.
     * </p>
     * 
     * @param emailId Email-id of trainer.
     * @param mobileNo Mobile number of trainer.
     *
     * @return index - it returns index of a trainer.
     *
     */
    public int findIndexByEmailIdAndMobileNo(String emailId, long mobileNo) {
        int index = 0;
        for(Trainer trainer : trainerDao.retrieveTrainer()) {
            if (emailId.equals(trainer.getEmailId()) && mobileNo == trainer.getMobileNo()) {
		break;    
            }
	    index++;
        }
        return index;
    }

    /** 
     * <p>
     * To get updated input from the controller and transfers trainer detail to trainerDao.
     * </p>
     * 
     * @param firstName First name of the trainer.
     * @param lastName Last name of the trainer.
     * @param age Age of the trainer.
     * @param address Address of the trainer.
     * @param mobileNo MobileNo of the trainer.
     * @param dateOfBirth Date of the trainer.
     * @param emailId Emailid of the trainer.
     * @param employeeId employeeId of the trainer.
     * @param experience experience of the trainer.
     * @param designation designation of the trainer.
     *
     * @return it returns the boolean to controller
     *
     */
    public boolean updateTrainer(int index, String name, int age, String address, 
            long mobileNo, String dateOfBirth, String gender, String emailId, String employeeId, byte experience, String designation) {   
	Trainer trainer = new Trainer(name, age, address, mobileNo, dateOfBirth, gender, emailId, employeeId, experience, designation);
	boolean isUpdated = trainerDao.updateTrainer(index, trainer);
	return isUpdated;
    }
    
    /** 
     * <p>
     * To get input from the controller and checks the trainer id is in the list.
     * </p>
     *
     * @param trainerId - trainerId of trainer.
     *
     * @return - it returns boolean to the controller.
     *
     */
    public boolean findTrainerId(String trainerId) {
	boolean isContinue = false;	
	for (Trainer trainer : trainerDao.retrieveTrainer()) {
	    if (trainerId.equals(trainer.getEmployeeId())) {
		return true;
	    } 
	}
	return false;
    }

    /** 
     * <p>
     * updateTrainerDataByOption method used to get choice and data from the controller,updates the single trainer data 
     * and transfers trainer object to Dao.
     * </p>
     * 
     * @param choice it can be a input from user and passed to switch option 
     * @param updatedData it can be a data from user to update.
     *
     * @return it returns the boolean to controller
     *
     */
    public boolean updateTrainerByOption(int choice, String updatedData) {
	for(Trainer trainer : trainerDao.retrieveTrainer()) {
	    switch(choice){
		case 1:
		    trainer.setName(updatedData);
		    break;

		case 2:
		    trainer.setEmailId(updatedData);
		    break;

    		case 3:
		    trainer.setAddress(updatedData);
		    break;

		case 4:
		    trainer.setDesignation(updatedData);
		    break;

		case 5:
		    trainer.setGender(updatedData);
		    break;

		default:
		    System.exit(0);
            }   
        }
	return true;
    }

    /** 
     * <p>
     * Get emailId and index from the controller and pass the index to trainerDao for delete.
     * </p>
     * 
     * @param emailid Emailid used for checking it in the list
     * @param index Index used for index position of emailid is present where in the list 
     *
     * @return it returns the boolean to controller
     *
     */
    public boolean deleteTrainerByEmployeeId(String employeeId) {
	for (Trainer trainer : trainerDao.retrieveTrainer()) {
	    if (employeeId.equals(trainer.getEmployeeId())) {
       	        return trainerDao.deleteTrainerByEmployeeId(trainer);
	    }
        }
	return false;
    }
}

