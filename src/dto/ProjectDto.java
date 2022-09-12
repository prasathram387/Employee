package com.ideas2it.dto;

import com.ideas2it.model.EmployeeProject;

import java.util.HashSet;
import java.util.Date;
import java.util.Set;

public class ProjectDto {
    private int id;
    private String name;
    private String clientName;
    private String companyName;
    private Date startDate;
    private Date deadline;
    private String status;
    private Set<EmployeeProject> employeeProjects = new HashSet<EmployeeProject>(); 

    public ProjectDto() {
    
    }    

    public ProjectDto(int id, String name, String clientName, String companyName, Date startDate, Date deadline, String status,
                      Set<EmployeeProject> employeeProjects) {

        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.clientName = clientName;
        this.startDate = startDate;
        this.deadline = deadline;
        this.status = status; 
        this.employeeProjects = employeeProjects;   
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

    public Date getStartDate() {
	return startDate;
    }

    public Date getDeadline() {
	return deadline;
    }

    public String getStatus() {
	return status;
    }

    public Set<EmployeeProject> getEmployeeProjects() {
	return employeeProjects;
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

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public void setDeadline(Date deadline) {
	this.deadline = deadline;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public void setEmployeeProjectDto(Set<EmployeeProject> employeeProjects) {
	this.employeeProjects = employeeProjects;
    }

    public String toString() {
        return "\n" +"Project Details" +"\n"+"Project Name        :" + getName()+ "\n" + "Company Name        :" + getCompanyName() +"\n"+
		      "Client Name         :"+getClientName()+"\n"+"Project Started Date:"+getStartDate()+"\n"+"Project Deadline    :"+getDeadline()+
                      "\n"+"Status              :"+getStatus();   
    }
}