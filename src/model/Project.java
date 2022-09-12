package com.ideas2it.model;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

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
    private LocalDate startDate;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<EmployeeProject> employeeProjects = new HashSet<EmployeeProject>();
   
    public Project() {
    
    }    

    public Project(int id, String name, String clientName, String companyName, LocalDate startDate, LocalDate deadline,
        String status, Set<EmployeeProject> employeeProjects) {

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

    public LocalDate getStartDate() {
	return startDate;
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

    public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
    }

    public void setDeadline(LocalDate deadline) {
	this.deadline = deadline;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public Set<EmployeeProject> getEmployeeProjects(){
        return employeeProjects;
    }
   
    public void setEmployeeProject(Set<EmployeeProject> employeeProjects){
        this.employeeProjects = employeeProjects;
    }
}