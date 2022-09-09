package com.ideas2it.model;

import java.time.LocalDate;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
import javax.persistence.OneToMany;
import javax.persistence.Table;  

@Entity
@Table(name = "project")
public class Project {

    @Id 
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "started_date")
    private LocalDate startedDate;
    @Column(name = "deadline")
    private LocalDate deadline;
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<EmployeeProject> employeeProjects = new ArrayList<EmployeeProject>();
   
    public Project() {
    
    }    

    public Project(int id, String name, String clientName, String companyName, LocalDate startedDate, LocalDate deadline,
        String status, List<EmployeeProject> employeeProject) {

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

    public List<EmployeeProject> getEmployeeProject(){
        return employeeProjects;
    }
   
    public void setEmployeeProject(List<EmployeeProject> employeeProject){
        this.employeeProjects = employeeProjects;
    }
}