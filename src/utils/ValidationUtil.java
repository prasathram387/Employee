/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
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

/**
 * <p>
 * Validation util class can be used for validation process.
 * </p> 
 * @author Ramprasath
 * @version 1.0
 **/
public class ValidationUtil {

    private static int COUNT = 0;
    public static String NAME_PATTERN = "([A-Z][a-z]{2,30}\s*)+"; 
    public static String PHONE_NO = "^[6-9][0-9]{9}$";
    public static String DESIGNATION_REGEX = "([a-zA-Z]\s*)+";
    public static String MAILID_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

    /** 
     * <p>
     * To validate user input.
     * </p>
     * 
     * @param input it contains the user input in string format .
     * @param regex it contains the regex value.
     *
     * @return it returns the boolean;
     */	
    public static boolean validateInput(String input, String regex ) {
	boolean matcher = input.matches(regex);		   
	return matcher;
    }

    /** 
     * <p>
     * To calculate age.
     * </p>
     * 
     * @param dateOfBirth it contains the dateOfBirth value.
     *
     * @return it returns the age;
     */    
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

    /** 
     * <p>
     * To calculate experience.
     * </p>
     * 
     * @param dateOfJoining it contains the dateOfJoining date.
     *
     * @return it returns the experience;
     */
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

    /** 
     * <p>
     * To validate gender.
     * </p>
     * 
     * @param gender it contains the gender value .
     *
     * @return it returns the boolean;
     */
    public static boolean validateGender(String gender) throws CustomException {
	try {
    	     Gender genderEnum = Gender.valueOf(gender);
	     return true;		
        } catch(Exception e) {
             throw new CustomException("enter valid gender",e);
	}		   
    }
}
