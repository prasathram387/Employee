package org.ideas2it.management.dao;

import org.ideas2it.management.model.Trainee;
import org.ideas2it.management.model.Trainer;

import java.util.ArrayList;
import java.util.List;

/**
 * It can be implemented for storing trainee data
 **/
public class TraineeDao {

    private static List<Trainee> trainees = new ArrayList<Trainee>();	

    /** 
     * <p>
     * To get input from the traineeService and insert traineesList.
     * </p>
     * 
     * @param trainee it takes a parameters of trainee from service class.
     *
     * @return it returns the boolean to trainee service. 
     *    
     */
    public boolean insertTrainee(Trainee trainee) {   
	boolean isAdded = trainees.add(trainee);
	return isAdded;
    }
 
    /** 
     * <p>
     * To get input from the traineeService and stores as a traineeList.
     * </p>
     * 
     * @param trainer Trainee of a parameter
     * @param index Index of a trainee
     *
     * @return it returns the boolean to service.
     *
     */
    public boolean updateTrainee(int index, Trainee trainee) {
	trainees.set(index, trainee);
	return true;
    }

    /** 
     * <p>
     * To retrieve list from the dao and transfers to the traineeService.
     * </p>
     * 
     * @return trainees it returns trainees list to service class.
     *
     */
    public List<Trainee> retrieveTrainee() {	
    	return trainees ;
    }

    /** 
     * <p>
     * To delete trainee from the dao using trainee index.
     * </p>
     * 
     * @param index Index of the trainer from service class.
     *
     * @return it returns the boolean to service.
     *
     */
    public boolean deleteTraineeByEmployeeId(Trainee trainee) {
 	trainees.remove(trainee);
	return true;
    }
}
