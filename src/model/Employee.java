package org.ideas2it.management.model;

public class Employee {
 
    protected String name;
    protected int age;
    protected String address;
    protected long mobileNo;
    protected String dateOfBirth; 
    protected String gender;
    protected String emailId;
    protected String employeeId;
  	
    public String getName() {
	return name;
    }

    public int getAge() {
	return age;
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
  

    public void setName(String name) {
	this.name = name;
    }

    public void setAge(int age) {
	this.age = age;
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
}