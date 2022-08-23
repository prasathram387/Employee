package org.ideas2it.management.dto;

public class EmployeeDto {
 
    private String firstName;
    private String lastName;
    private String address;
    private long mobileNo;
    private String dateOfBirth; 
    private String gender;
    private String emailId;
    private String employeeId;
    private int batch;
    private byte experience;
    private String designation;
   
    public EmployeeDto(String firstName, String lastName, String address, long mobileNo, String dateOfBirth, String gender, String emailId,
            String employeeId, int batch, byte experience, String designation) {

	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.mobileNo = mobileNo;
	this.dateOfBirth = dateOfBirth;
	this.gender = gender;
	this.emailId = emailId;
	this.employeeId = employeeId;
	this.batch = batch;
	this.experience = experience;
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

    public byte getExperience() {
       return experience;
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

    public void setExperience(byte experience) {
	this.experience = experience;
    }

    public void setDesignation(String designation) {
	this.designation = designation;
    }  

    

    public String toString() {
    return "\n" +"Employee Details" +"\n"+"Name            :" + getFirstName()+getLastName() + "\n" + "Email Id        :" + getEmailId() +"\n"+
		      "Gender          :"+getGender()+"\n"+"Date of Birth   :"+getDateOfBirth()+"\n" + "MobileNo        :" + getMobileNo()+
		      "\n"  + "Address         :" +getAddress()+"\n" +"EmailId         :"+ getEmailId()+"\n" + "EmployeeId      :" + getEmployeeId()+
		      "\n" + "Batch           :"+getBatch()+"\n"+"Experience      :"+getExperience()+"\n"+"Designation      :"+ getDesignation();
    }
}