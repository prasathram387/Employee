package com.ideas2it.management.dto;

import java.util.Date;

public class EmployeeDto {
 
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private long mobileNo;
    private Date dateOfBirth; 
    private String gender;
    private String emailId;
    private int batch;
    private Date dateOfJoining;
    private String designation;
    private Date createdDate;
    private Date modifiedDate;

    public EmployeeDto() {

    }
   
    public EmployeeDto(int id, String firstName, String lastName, String address, long mobileNo, Date dateOfBirth, String gender, String emailId,
            int batch, Date dateOfJoining, String designation,  Date createdDate, Date modifiedDate) {
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

    public Date getDateOfBirth() {
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

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public Date getCreatedDate() {
	return createdDate;
    }

    public Date getModifiedDate() {
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

    public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
	this.gender = gender;
    }

    public void setEmailId(String emailId) {
	this.emailId = emailId;
    }

    public void setBatch(int batch) {
	this.batch = batch;
    }

    public void setDateOfJoining(Date dateOfJoining) {
	this.dateOfJoining = dateOfJoining;
    }

    public void setDesignation(String designation) {
	this.designation = designation;
    }  

    public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
    }

    public void setModifiedDate(Date modifiedDate) {
	this.modifiedDate = modifiedDate;
    }

    public String toString() {
    return "\n" +"Employee Details" +"\n"+"Name            :" + getFirstName()+getLastName() + "\n" + "Email Id        :" + getEmailId() +"\n"+
		      "Gender          :"+getGender()+"\n"+"Date of Birth   :"+getDateOfBirth()+"\n" + "MobileNo        :" + getMobileNo()+
		      "\n"  + "Address         :" +getAddress()+"\n" +"EmailId         :"+ getEmailId()+"\n" +
		      "\n" + "Batch           :"+getBatch()+"\n"+"Designation      :"+ getDesignation()+"\n"+"dateofjoining  :"+getDateOfJoining();
    }
}