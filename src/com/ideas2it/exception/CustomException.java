/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.exception;

import java.lang.Exception; 

/**
 * <p>
 * CustomException class can be used for handle exceptions.
 * </p> 
 * @author Ramprasath 
 * @version 1.0
 **/
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