package com.ideas2it.dto;

import java.util.Date;

public class EmployeeProjectDto {

    private int id;
    private Date startedDate;
    private Date relievedDate;
    private String status;
    private EmployeeDto employeeDto;
    private ProjectDto projectDto;
    
    public EmployeeProjectDto(){

    }

    public EmployeeProjectDto(int id, Date startedDate, Date relievedDate, String status, EmployeeDto employeeDto, ProjectDto projectDto){

        this.id = id;
        this.startedDate = startedDate;
        this.relievedDate = relievedDate;
        this.status = status;
        this.employeeDto = employeeDto;
        this.projectDto = projectDto;
    }

    public int getId(){
        return id;
    }

    public Date getStartedDate(){
        return startedDate;
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

    public void setStartedDate(Date startedDate){
        this.startedDate = startedDate;
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
		    "\n"+"Employee Started Date:"+getStartedDate()+"\n"+"Employee Relieved Date:"+getRelievedDate();   
    }
}