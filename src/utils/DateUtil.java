package com.ideas2it.utils;

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

public class DateUtil {

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

    public static Date validateDate(String date) throws CustomException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	try {
            Date parsedDate = formatter.parse(date);
	    return parsedDate;
	} catch(Exception e) {
	    throw new CustomException("enter valid date ",e);
        }
    }

    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
       
    public static Date convertToDate(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}