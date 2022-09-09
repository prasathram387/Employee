package com.ideas2it.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.CascadeType; 
import javax.persistence.GeneratedValue; 
import javax.persistence.Id; 
import javax.persistence.JoinColumn;  
import javax.persistence.ManyToOne;
import javax.persistence.Table;  

@Entity
@Table(name = "employee_project")
public class EmployeeProject {

    @Id 
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "started_date")
    private LocalDate startedDate;
    @Column(name = "relieved_date")
    private LocalDate relievedDate;
    @Column(name = "status")
    private String status;
       
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    
    public EmployeeProject(){

    }

    public EmployeeProject(int id, LocalDate startedDate, LocalDate relievedDate, String status, Employee employee, Project project){

        this.id = id;
        this.startedDate = startedDate;
        this.relievedDate = relievedDate;
        this.status = status;
        this.employee = employee;
        this.project = project;
    }

    public int getId(){
        return id;
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

    public Employee getEmployee() {
        return employee;
    } 

    public Project getProject() {
        return project;
    } 

    public void setId(int id){
        this.id = id;
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

    public void setEmployee(Employee employee){
        this.employee = employee;
    } 

    public void setProject(Project project){
        this.project = project;
    } 

}