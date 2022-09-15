/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.dto;

public class RoleDto {

    int id;
    String name;

    public RoleDto() {

    }

    public RoleDto(int id, String name) {
        this.id = id;
        this.name = name;
    }
   
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }    

    public String getName() {
	return name;
    }

    public void setName(String name){
        this.name = name;
    }    

    
    public String toString() {
        return getName();
    }
}