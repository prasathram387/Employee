package com.ideas2it.management.model;

import java.time.LocalDate;

public class Project {

    private int id;
    private String name;
    private String clientName;
    private String companyName;
    private LocalDate startedDate;
    private LocalDate deadline;
    private String status;
   
    public Project() {
    
    }    

    public Project(int id, String name, String clientName, String companyName, LocalDate startedDate, LocalDate deadline, String status) {

        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.clientName = clientName;
        this.startedDate = startedDate;
        this.deadline = deadline;
        this.status = status;    
    }    

    public int getId() {
        return id;
    }
  	
    public String getName() {
	return name;
    }

    public String getClientName() {
	return clientName;
    }

    public String getCompanyName() {
	return companyName;
    }

    public LocalDate getStartedDate() {
	return startedDate;
    }

    public LocalDate getDeadline() {
	return deadline;
    }

    public String getStatus() {
	return status;
    }


    public void setId(int id) {
	this.id = id;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setCompanyName(String companyName) {
	this.companyName = companyName;
    }

    public void setClientName(String clientName) {
	this.clientName = clientName;
    }

    public void setStartedDate(LocalDate startedDate) {
	this.startedDate = startedDate;
    }

    public void setDeadline(LocalDate deadline) {
	this.deadline = deadline;
    }

    public void setStatus(String status) {
	this.status = status;
    }
}