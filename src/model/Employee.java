package com.ideas2it.management.model;

import java.time.LocalDate;

public class Employee {
 
    public int id;
    private String firstName;
    private String lastName;
    private String address;
    private long mobileNo;
    private LocalDate dateOfBirth; 
    private String gender;
    private String emailId;
    private int batch;
    private LocalDate dateOfJoining;
    private String designation;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
  
    public Employee() {
    
    }
 
    public Employee(int id, String firstName, String lastName, String address, long mobileNo, LocalDate dateOfBirth, String gender, String emailId,
            int batch, LocalDate dateOfJoining, String designation, LocalDate createdDate, LocalDate modifiedDate) {
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
}