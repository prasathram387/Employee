package com.ideas2it.management.dto;

import java.util.List;
import java.util.ArrayList;

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