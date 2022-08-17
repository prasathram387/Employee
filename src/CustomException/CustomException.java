package org.ideas2it.management.exception;

import java.lang.RuntimeException; 

public class CustomException extends Exception {
    public CustomException() {
	super();
    }

    public CustomException (String message) {  
        super(message);  
    }

    public CustomException (String message, Throwable error) {  
        super(message, error);  
    }
}  
