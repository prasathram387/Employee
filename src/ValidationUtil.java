package org.ideas2it.management.utils;

import org.ideas2it.management.constant.Constants;
import org.ideas2it.management.exception.CustomException;

import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;

enum Gender {
   male,female,MALE,FEMALE
}

public class ValidationUtil {

    private static int COUNT = 0;
    public static String NAME_PATTERN = "([A-Z][a-z]{2,30}\s*)+"; 
    public static String PHONE_NO = "^[6-9][0-9]{9}$";
    public static String DESIGNATION_REGEX = "([a-zA-Z]\s*)+";
    public static String MAILID_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	
    /** 
     * <p>
     * To validate a userInput.
     * </p>
     *
     * @param input , regex pattern it gets a name from controller
     * @return it returns the boolean to controller.
     * 
     */
    public static boolean validateInput(String input, String regex ) {
	boolean matcher = input.matches(regex);		   
	return matcher;
    }

    /** 
     * <p>
     * To generate employee id automatically.
     * </p>
     *
     * @return It returns the employeeId to add trainees method.
     * 
     */ 
    public static String generateEmployeeId() {
	COUNT++;
	String employeeId = Constants.COMPANY_ID_PREFIX + COUNT;
	return employeeId;
    } 

    /** 
     * <p>
     * To validate a date of birth.
     * </p>
     *
     * @param dateOfBirth it gets a dateOfBirth from controller
     * @return it returns the boolean to controller.
     * 
     */
    public static boolean validateDateOfBirth(String dateOfBirth) throws CustomException {
   	boolean isContinue = true;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	try {
            Date date = formatter.parse(dateOfBirth);
	    return true;
	} catch(Exception e) {
	    throw new CustomException("enter valid date of birth",e);
        }
    }

    public static boolean validateDateOfJoining(String dateOfJoining) throws CustomException {
   	boolean isContinue = true;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	try {
            Date date = formatter.parse(dateOfJoining);
	    return true;
	} catch(Exception e) {
	    throw new CustomException("enter valid date ",e);
        }
    }
    
    /** 
     * <p>
     * To calculate a age from date of birth 
     * </p>
     *
     * @param dateOfBirth it gets a dateOfBirth from controller
     * @return it returns the age to controller.
     * 
     */
    public static int calculateAge(String dateOfBirth) {
        int age = 0;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	try {
            Date date = formatter.parse(dateOfBirth);
            Instant instant = date.toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate givenDate = zone.toLocalDate();
            Period period = Period.between(givenDate, LocalDate.now());
	    age = period.getYears();
	} catch (Exception exception) {
            age = 0; 
	}
        return age;
    }

    public static int calculateExperience(String dateOfJoining) {
        int experience = 0;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	try {
            Date date = formatter.parse(dateOfJoining);
            Instant instant = date.toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate givenDate = zone.toLocalDate();
            Period period = Period.between(givenDate, LocalDate.now());
	    experience = period.getYears();
	} catch (Exception exception) {
            experience = 0; 
	}
        return experience;
    }

    /** 
     * <p>
     * To validate a gender.
     * </p>
     *
     * @param emailId it gets a gender from controller
     * @return it returns the boolean to controller.
     * 
     */
    public static boolean validateGender(String gender) {
	try {
    	     Gender genderEnum = Gender.valueOf(gender);
	     return true;		
        } catch(Exception e) {
	     return false;
	}		   
    }
}