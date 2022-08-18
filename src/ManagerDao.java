package org.ideas2it.management.dao;

import org.ideas2it.management.model.Manager;

import java.util.ArrayList;
import java.util.HashMap; 
import java.util.List;
import java.util.Map; 


/**
 * It can be implemented for storing manager data
 **/
public class ManagerDao {
       
    private static Map<String , List<String>> assignedMap = new HashMap<>();
    private static List<Manager> managers = new ArrayList<>();

    /** 
     * <p>
     * To get input from the Manager Service and insert in manager List.
     * </p>
     * 
     * @param manager Manager contains a parametres of manager. 
     *
     * @return it returns the boolean to manager service. 
     */	
    public boolean insertManager(Manager manager) {
	boolean isAdded = managers.add(manager);
	return isAdded;
    }

    /** 
     * <p>
     * To retrieve list from the dao and transfers to the manager service.
     * </p>
     * 
     * @return managers it returns list of managers. 
     */
    public List<Manager> retrieveManager() {
	return managers;
    }

    /** 
     * <p>
     * To get input from the Manager Service and put in a assigned map.
     * </p>
     * 
     * @param trainerId TrainerId contains a id of trainer.
     * @param assignedTrainee assignedTrainee contains a assigned trainees list. 
     *
     * @return it returns the boolean to manager service.
     *
     */	
    public boolean assignTrainerForTrainee(String trainerId, List<String> assignedTrainee) {
	assignedMap.put(trainerId,assignedTrainee);
	return true;
    }

    /** 
     * <p>
     * To retrieve assigned map of trainer and trainees from the dao and transfers to the manager service.
     * </p>
     * 
     * @return assignedMap - it returns assigned map of trainer and trainees. 
     */
    public Map<String, List<String>> retrieveTrainerAndTrainee() {
	return assignedMap;
    }
}  
