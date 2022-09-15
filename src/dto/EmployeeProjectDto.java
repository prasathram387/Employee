/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.dto;

import java.util.Date;

public class EmployeeProjectDto {

    private int id;
    private Date startDate;
    private Date relievedDate;
    private String status;
    private EmployeeDto employeeDto;
    private ProjectDto projectDto;
    
    public EmployeeProjectDto(){

    }

    public EmployeeProjectDto(int id, Date startDate, Date relievedDate, String status, EmployeeDto employeeDto, ProjectDto projectDto){

        this.id = id;
        this.startDate = startDate;
        this.relievedDate = relievedDate;
        this.status = status;
        this.employeeDto = employeeDto;
        this.projectDto = projectDto;
    }

    public int getId(){
        return id;
    }

    public Date getStartDate(){
        return startDate;
    }
  
    public Date getRelievedDate(){
        return relievedDate;
    } 

    public String getStatus() {
        return status;
    } 

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    } 

    public ProjectDto getProjectDto() {
        return projectDto;
    } 

    public void setId(int id){
        this.id = id;
    }    

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    } 

    public void setRelievedDate(Date relievedDate){
        this.relievedDate = relievedDate;
    } 

    public void setStatus(String status) {
	this.status = status;
    }

    public void setEmployeeDto(EmployeeDto employeeDto){
        this.employeeDto = employeeDto;
    } 

    public void setProject(ProjectDto projectDto){
        this.projectDto = projectDto;
    } 

    public String toString() {
        return "\n" +"Employee Project Details" +"\n"+"Employee Project Id  :" + getId()+"\n"+"Employee Id     :"+ employeeDto.getId() +
		    "\n"+"Project Id          :"+projectDto.getId()+"\n"+"Employee Started Date:"+getStartDate()+"\n"+
                    "Employee Relieved Date:"+getRelievedDate();   
    }
}