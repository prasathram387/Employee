/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */package com.ideas2it.utils;

import com.ideas2it.exception.CustomException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * <p>
 * DateUtil class can be used for date validation and conversion process.
 * </p> 
 * @author Ramprasath 
 * @version 1.0
 **/
public class DateUtil {

    /** 
     * <p>
     * To validate date of birth.
     * </p>
     * 
     * @param dateOfBirth it contains the dateOfBirth value .
     *
     * @return it returns the date;
     */
    public static Date validateDateOfBirth(String dateOfBirth) throws CustomException {
   	boolean isContinue = true;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
	try {
            Date date = formatter.parse(dateOfBirth);
	    return date;
	} catch(Exception e) {
	    throw new CustomException("enter valid date of birth",e);
        }
    }

    /** 
     * <p>
     * To validate date.
     * </p>
     * 
     * @param date it contains the date value .
     *
     * @return it returns the parsed date;
     */
    public static Date validateDate(String date) throws CustomException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	try {
            Date parsedDate = formatter.parse(date);
	    return parsedDate;
	} catch(Exception e) {
	    throw new CustomException("enter valid date ",e);
        }
    }

    /** 
     * <p>
     * To convert util date to local date. 
     * </p>
     * 
     * @param dateToConvert it contains the util.date.
     *
     * @return it returns the local date;
     */
    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /** 
     * <p>
     * To convert util local date to util date. 
     * </p>
     * 
     * @param dateToConvert it contains the local date.
     *
     * @return it returns the util date;
     */       
    public static Date convertToDate(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /** 
     * <p>
     * To convert local date time to util date. 
     * </p>
     * 
     * @param dateToConvert it contains the local date time.
     *
     * @return it returns the util date ;
     */
    public static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

    /** 
     * <p>
     * To convert util local date time to util date. 
     * </p>
     * 
     * @param dateToConvert it contains the util date.
     *
     * @return it returns the local date time;
     */
    public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}