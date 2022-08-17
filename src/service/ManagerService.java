package org.ideas2it.management.service;

import org.ideas2it.management.dao.ManagerDao;
import org.ideas2it.management.model.Manager;

import java.util.ArrayList;
import java.util.HashMap; 
import java.util.List;
import java.util.Map;

/**
 * It can be implemented for transfer data  between Employee controller to managerDao and managerDao to Employeecontroller.
 **/
public class ManagerService {
	
    private ManagerDao managerDao = new ManagerDao();
    private List<String> assignedTrainees = new ArrayList<String>();
    private List<String> assignTrainee = new ArrayList<String>();

    /** 
     * <p>
     * To get input from the controller and transfers to managerDao.
     * </p>
     *
     * @param emailId Emailid of the manager.
     * @param password Password of the manager.
     *
     * @return it returns the boolean to controller.
     *
     */
    public boolean addManager(String emailId, String password) {
	Manager manager = new Manager(emailId, password);
	boolean isAdded = managerDao.insertManager(manager);
	return isAdded;
    }

    /** 
     * <p>
     * To retrieve manager from the managerDao and transfers to controller.
     * </p>
     *
     * @return - it  returns the manager list.
     */
    public List<Manager> getManager() {
	return managerDao.retrieveManager();
    }

    /** 
     * <p>
     * To get input from the controller and checks the emailId,password is in the list.
     * </p>
     * 
     * @param emailId Email-id of manager.
     * @param password Password of manager.
     *
     * @return - it returns boolean to the controller.
     *
     */
    public boolean validateManagerByEmailIdAndPassword(String emailId, String password) {
        for(Manager manager : managerDao.retrieveManager()) {
            if (emailId.equals(manager.getEmailId()) && password.equals(manager.getPassword())) {
		 return true;
	    } 
	}
        return false;	
    }

    /** 
     * <p>
     * To get input from the controller and add assigned trainee in the list.
     * </p>
     * 
     * @param firstTraineeId FirstTraineeId of trainee.
     * @param secondTraineeId SecondTraineeId of trainee.
     *
     * @return it returns the boolean to controller.
     *
     */
    public boolean assignedTrainees(String firstTraineeId, String secondTraineeId) {
	boolean isFirstTraineeAdded = assignedTrainees.add(firstTraineeId);
	boolean isSecondTraineeAdded = assignedTrainees.add(secondTraineeId);
	return isSecondTraineeAdded;
    }

    /** 
     * <p>
     * To retrieve trainees to controller.
     * </p>
     *
     * @return  assignedTrainees - it  returns the assigned trainees list.
     */
    public List<String> retrieveTrainees() {
	return assignedTrainees;
    }

    /** 
     * <p>
     * To add  assigned trainee to the list.
     * </p>
     *
     * @param traineeId  Trainee id of a trainee.
     *
     * @return it returns the boolean to controller.
     *
     */
    public boolean addTrainee(String traineeId) {
	boolean isAssigned = assignTrainee.add(traineeId);
	return isAssigned;
    }

    /** 
     * <p>
     * To retrieve trainees to controller.
     * </p>
     *
     * @return  assignTrainee - it  returns the assign trainee list.
     */
    public List<String> retrieveTrainee() {
	return assignTrainee;
    }

    /** 
     * <p>
     * To get input from the controller and checks the trainee id is in the list.
     * </p>
     * 
     * @param firstTraineeId FirstTraineeId of trainee.
     * @param secondTraineeId SecondTraineeId of trainee.
     *
     * @return - it returns boolean to the controller.
     *
     */
    public boolean isTraineeAlreadyAssigned(String firstTraineeId, String secondTraineeId) {
	List<String> assignedTrainees = retrieveTrainees();
	if(assignedTrainees.contains(firstTraineeId) || assignedTrainees.contains(secondTraineeId)) {
	     return false;
	} else {
	     return true;	     
	}
    }

    /** 
     * <p>
     * To get input from the controller and transfers to dao.
     * </p>
     * 
     * @param traineeId TraineeId of trainer.
     * @param assignedTrainees AssignedTrainees list of trainee.
     *
     * @return it returns the boolean to controller.
     *
     */
    public boolean assignTrainerForTrainee(String trainerId, List<String> assignedTrainees) {	
	boolean isAssigned = managerDao.assignTrainerForTrainee(trainerId, assignedTrainees);
	return isAssigned;
    }

    /** 
     * <p>
     * To retrieve assigned trainer and trainees map to controller.
     * </p>
     *
     * @return- it returns the assigned trainees and trainer map.
     */
    public Map<String, List<String>> getAssignedMap() {
	return managerDao.retrieveTrainerAndTrainee();
    }

    /** 
     * <p>
     * To get input from the controller and checks the trainee id  and trainees are already mapped.
     * </p>
     *
     * @param trainerId Trainer id of trainer.
     * @param firstTraineeId FirstTraineeId of trainee.
     * @param secondTraineeId SecondTraineeId of trainee.
     * 
     * @return - it returns boolean to the controller.
     *
     */
    public boolean checkAssignedTrainees(String trainerId, String firstTraineeId, String secondTraineeId) {
	Map<String, List<String>> assignedMap = managerDao.retrieveTrainerAndTrainee();
        if(assignedMap.containsKey(trainerId) || assignedMap.containsValue(firstTraineeId) || assignedMap.containsValue(secondTraineeId)) {
	     return false;
        } 
	return true;
    }
}