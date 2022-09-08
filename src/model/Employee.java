package com.ideas2it.management.model;

import java.time.LocalDate;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.GeneratedValue;
import javax.persistence.Table;  

@Entity
@Table(name = "employee")
public class Employee {
 
    @Id 
    @GeneratedValue
    @Column(name = "id")
    public int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "mobile_no")
    private long mobileNo;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth; 
    @Column(name = "gender")
    private String gender;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "batch")
    private int batch;
    @Column(name = "date_of_joining")
    private LocalDate dateOfJoining;
    @Column(name = "designation")
    private String designation;
    @Column(name = "created_date")
    private LocalDate createdDate;
    @Column(name = "modified_date")
    private LocalDate modifiedDate;
    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(
        name = "employee_role", 
        joinColumns = { @JoinColumn(name = "employee_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private List<Role> roles = new ArrayList<Role>();
  
    public Employee() {
    
    }
 
    public Employee(int id, String firstName, String lastName, String address, long mobileNo, LocalDate dateOfBirth, String gender, String emailId,
            int batch, LocalDate dateOfJoining, String designation, LocalDate createdDate, LocalDate modifiedDate, String status, List<Role> roles) {
        this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.mobileNo = mobileNo;
	this.dateOfBirth = dateOfBirth;
	this.gender = gender;
	this.emailId = emailId;
	this.batch = batch;
	this.dateOfJoining = dateOfJoining;
	this.designation = designation;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.status = status;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }
  	
    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public String getAddress() {
	return address;
    }

    public long getMobileNo() {
	return mobileNo;
    }

    public LocalDate getDateOfBirth() {
	return dateOfBirth;
    }

    public String getGender() {
	return gender;
    }

    public String getEmailId() {
	return emailId;
    }

    public String getDesignation() {
       	return designation;
    }  

    public int getBatch() {
	return batch;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public LocalDate getCreatedDate() {
	return createdDate;
    }

    public LocalDate getModifiedDate() {
	return modifiedDate;
    }
    
    public String getStatus() {
        return status;
    } 

    public List<Role> getRole() {
        return roles;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public void setAddress(String address) {
  	this.address = address;
    }

    public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String Gender) {
	this.gender = gender;
    }

    public void setEmailId(String emailId) {
	this.emailId = emailId;
    }

    public void setBatch(int batch) {
	this.batch = batch;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
	this.dateOfJoining = dateOfJoining;
    }

    public void setDesignation(String designation) {
	this.designation = designation;
    }  

    public void setCreatedDate(LocalDate createdDate) {
	this.createdDate = createdDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
	this.modifiedDate = modifiedDate;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public void setRole(List<Role> roles) {
        this.roles = roles;
    } 

}