/*
 * Copyright (c) 2021, 2022, Ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ideas2it.model;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.CascadeType;
import javax.persistence.FetchType; 
import javax.persistence.GeneratedValue; 
import javax.persistence.Id; 
import javax.persistence.JoinColumn;  
import javax.persistence.ManyToOne;
import javax.persistence.Table;  


/**
 * <p>
 * EmployeeProject class contains the employee project data.
 * </p> 
 * @author Ramprasath
 * @version 1.0
 **/
@Entity
@Table(name = "employee_project")
public class EmployeeProject {

    @Id 
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "started_date")
    private LocalDate startDate;

    @Column(name = "relieved_date")
    private LocalDate relievedDate;

    @Column(name = "status")
    private String status;
       
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;
    
    public EmployeeProject(){

    }

    public EmployeeProject(int id, LocalDate startedDate, LocalDate relievedDate, String status, Employee employee, Project project){

        this.id = id;
        this.startDate = startDate;
        this.relievedDate = relievedDate;
        this.status = status;
        this.employee = employee;
        this.project = project;
    }

    public int getId(){
        return id;
    }

    public LocalDate getStartDate(){
        return startDate;
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

    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
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