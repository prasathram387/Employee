package com.ideas2it.management.dto;

import java.util.Date;

public class EmployeeProjectDto {

    private int id;
    private int projectId;
    private int employeeId;
    private Date startedDate;
    private Date relievedDate;
    
    public EmployeeProjectDto(){

    }

    public EmployeeProjectDto(int id, int projectId, int employeeId, Date startedDate, Date relievedDate){

        this.id = id;
        this.projectId = projectId;
        this.employeeId = employeeId;
        this.startedDate = startedDate;
        this.relievedDate = relievedDate;
    }

    public int getId(){
        return id;
    }

    public int getProjectId(){
        return projectId;
    }
    
    public int getEmployeeId(){
        return employeeId;
    }

    public Date getStartedDate(){
        return startedDate;
    }
  
    public Date getRelievedDate(){
        return relievedDate;
    } 

    public void setId(int id){
        this.id = id;
    }    

    public void setProjectId(int projectId){
        this.projectId = projectId;
    }     

    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    } 

    public void setStartedDate(Date startedDate){
        this.startedDate = startedDate;
    } 

    public void setRelievedDate(Date relievedDate){
        this.relievedDate = relievedDate;
    } 

    public String toString() {
        return "\n" +"Employee Project Details" +"\n"+"Employee Project Id  :" + getId()+ "\n" + "Project Id           :" + getProjectId() +"\n"+
		     "Employee Id          :"+getEmployeeId()+"\n"+"Employee Started Date:"+getStartedDate()+"\n"+"Employee Relieved Date:"+getRelievedDate();   
    }
}