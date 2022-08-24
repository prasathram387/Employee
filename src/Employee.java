package org.ideas2it.management.model;

public class Employee {
 
    private String firstName;
    private String lastName;
    private String address;
    private long mobileNo;
    private String dateOfBirth; 
    private String gender;
    private String emailId;
    private String employeeId;
    private int batch;
    private String dateOfJoining;
    private String designation;
   
    public Employee(String firstName, String lastName, String address, long mobileNo, String dateOfBirth, String gender, String emailId,
            String employeeId, int batch, String dateOfJoining, String designation) {

	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.mobileNo = mobileNo;
	this.dateOfBirth = dateOfBirth;
	this.gender = gender;
	this.emailId = emailId;
	this.employeeId = employeeId;
	this.batch = batch;
	this.dateOfJoining = dateOfJoining;
	this.designation = designation;
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

    public String getDateOfBirth() {
	return dateOfBirth;
    }

    public String getGender() {
	return gender;
    }

    public String getEmailId() {
	return emailId;
    }

    public String getEmployeeId() {
	return employeeId;
    }

    public String getDesignation() {
       	return designation;
    }  

    public int getBatch() {
	return batch;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
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

    public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String Gender) {
	this.gender = gender;
    }

    public void setEmailId(String emailId) {
	this.emailId = emailId;
    }

    public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
    }

    public void setBatch(int batch) {
	this.batch = batch;
    }

    public void setDateOfJoining(String dateOfJoining) {
	this.dateOfJoining = dateOfJoining;
    }

    public void setDesignation(String designation) {
	this.designation = designation;
    }  
}