package com.ideas2it.utils;

import com.ideas2it.constant.Constants;
import com.ideas2it.exception.CustomException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

enum Gender {
   male,female,MALE,FEMALE
}

public class ValidationUtil {

    private static int COUNT = 0;
    public static String NAME_PATTERN = "([A-Z][a-z]{2,30}\s*)+"; 
    public static String PHONE_NO = "^[6-9][0-9]{9}$";
    public static String DESIGNATION_REGEX = "([a-zA-Z]\s*)+";
    public static String MAILID_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	
    public static boolean validateInput(String input, String regex ) {
	boolean matcher = input.matches(regex);		   
	return matcher;
    }
    
    public static int calculateAge(Date dateOfBirth) {
        int age = 0;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	try {
            Instant instant = dateOfBirth.toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate givenDate = zone.toLocalDate();
            Period period = Period.between(givenDate, LocalDate.now());
	    age = period.getYears();
	} catch (Exception exception) {
            age = 0; 
	}
        return age;
    }

    public static int calculateExperience(Date dateOfJoining) {
        int experience = 0;
	try {
            Instant instant = dateOfJoining.toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate givenDate = zone.toLocalDate();
            Period period = Period.between(givenDate, LocalDate.now());
	    experience = period.getYears();
	} catch (Exception exception) {
            experience = 0; 
	}
        return experience;
    }

    public static boolean validateGender(String gender) throws CustomException {
	try {
    	     Gender genderEnum = Gender.valueOf(gender);
	     return true;		
        } catch(Exception e) {
             throw new CustomException("enter valid gender",e);
	}		   
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
       return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
}

}
