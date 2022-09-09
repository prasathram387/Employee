package com.ideas2it.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ideas2it.model.EmployeeProject;

public class ProjectDto {
    private int id;
    private String name;
    private String clientName;
    private String companyName;
    private Date startedDate;
    private Date deadline;
    private String status;
    private List<EmployeeProject> employeeProjects = new ArrayList<EmployeeProject>();
   
    public ProjectDto() {
    
    }    

    public ProjectDto(int id, String name, String clientName, String companyName, Date startedDate, Date deadline, String status,
                      List<EmployeeProject> employeeProjects) {

        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.clientName = clientName;
        this.startedDate = startedDate;
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

    public Date getStartedDate() {
	return startedDate;
    }

    public Date getDeadline() {
	return deadline;
    }

    public String getStatus() {
	return status;
    }

    public List<EmployeeProject> getEmployeeProject() {
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

    public void setStartedDate(Date startedDate) {
	this.startedDate = startedDate;
    }

    public void setDeadline(Date deadline) {
	this.deadline = deadline;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public void setEmployeeProjectDto(List<EmployeeProject> employeeProjects) {
	this.employeeProjects = employeeProjects;
    }

    public String toString() {
        return "\n" +"Project Details" +"\n"+"Project Name        :" + getName()+ "\n" + "Company Name        :" + getCompanyName() +"\n"+
		      "Client Name         :"+getClientName()+"\n"+"Project Started Date:"+getStartedDate()+"\n"+"Project Deadline    :"+getDeadline()+
                      "\n"+"Status              :"+getStatus();   
    }
}