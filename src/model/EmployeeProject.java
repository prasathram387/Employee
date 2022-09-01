package com.ideas2it.management.model;

import java.time.LocalDate;
import java.util.List;

public class EmployeeProject {

    private int id;
    private int projectId;
    private int employeeId;
    private LocalDate startedDate;
    private LocalDate relievedDate;
    
    public EmployeeProject(){

    }

    public EmployeeProject(int id, int projectId, int employeeId, LocalDate startedDate, LocalDate relievedDate){

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

    public LocalDate getStartedDate(){
        return startedDate;
    }
  
    public LocalDate getRelievedDate(){
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

    public void setStartedDate(LocalDate startedDate){
        this.startedDate = startedDate;
    } 

    public void setRelievedDate(LocalDate relievedDate){
        this.relievedDate = relievedDate;
    } 
}