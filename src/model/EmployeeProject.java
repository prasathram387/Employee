package com.ideas2it.management.model;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.GeneratedValue;
import javax.persistence.Table;  

@Entity
@Table(name = "employee_project")
public class EmployeeProject {

    @Id 
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "project_id")
    private int projectId;
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "started_date")
    private LocalDate startedDate;
    @Column(name = "relieved_date")
    private LocalDate relievedDate;
    @Column(name = "status")
    private String status;
    
    public EmployeeProject(){

    }

    public EmployeeProject(int id, int projectId, int employeeId, LocalDate startedDate, LocalDate relievedDate, String status){

        this.id = id;
        this.projectId = projectId;
        this.employeeId = employeeId;
        this.startedDate = startedDate;
        this.relievedDate = relievedDate;
        this.status = status;
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

    public String getStatus() {
        return status;
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

    public void setStatus(String status) {
	this.status = status;
    }

}