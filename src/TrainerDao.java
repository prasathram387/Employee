package org.ideas2it.management.dao;

import org.ideas2it.management.model.Trainee;
import org.ideas2it.management.model.Trainer;

import java.util.ArrayList;
import java.util.List;

/**
 * It can be implemented for storing trainer data
 **/
public class TrainerDao {

    private static List<Trainer> trainers = new ArrayList<Trainer>();	

    /** 
     * <p>
     * To get input from the trainerService and insert as trainerList.
     * </p>
     * 
     * @param trainer Trainer contains a parametres of trainers 
     *
     * @return it returns the boolean to service     
     */	
    public boolean insertTrainer(Trainer trainer) {   
	boolean isAdded = trainers.add(trainer);
	return isAdded;
    }

    /** 
     * <p>
     * To get input from the trainerService and update it in trainerList.
     * </p>
     * 
     * @param trainer Trainer list.
     * @param index Index of a trainer.
     *
     * @return it returns the boolean to controller
     */
    public boolean updateTrainer(int index, Trainer trainer) {
	trainers.set(index, trainer);
	return true;
    }

    /** 
     * <p>
     * To retrieve list from the dao and transfers to the trainerservice.
     * </p>
     * 
     * @return trainers it returns list of trainers. 
     */
    public List<Trainer> retrieveTrainer() {	
    	return trainers ;
    }

    /** 
     * <p>
     * To delete trainer from the dao using trainer index.
     * </p>
     * 
     * @param index Index of the trainer from service class.
     *
     * @return it returns the boolean to service
     */
    public boolean deleteTrainerByEmployeeId(Trainer trainer) {
	return trainers.remove(trainer);
	
    }
}
