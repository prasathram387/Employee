package org.ideas2it.management.model;

public class Trainer extends Employee {
   
    byte experience;
    String designation;
   
    public Trainer(String name, int age, String address, long mobileNo, String dateOfBirth, String gender,
            String emailId, String employeeId,  byte experience, String designation) {
        this.name = name;
	this.age = age;
	this.address = address;
	this.mobileNo = mobileNo;
	this.dateOfBirth = dateOfBirth;
	this.gender = gender;
	this.emailId = emailId;
	this.employeeId = employeeId;
	this.experience = experience;
	this.designation = designation;
    }

    public byte getExperience() {
       return experience;
    }

    public String getDesignation() {
       return designation;
    }

    public void setExperience(byte experience) {
	this.experience = experience;
    }

    public void setDesignation(String designation) {
	this.designation = designation;
    }

    public String toString() {
    return "\n" +"Trainer Details" +"\n"+"Name            :" + getName() +"\n"+"Age             :"+getAge() +"\n"+  "Email Id        :" + getEmailId() +"\n"+
                      "Date of Birth   :"+ getDateOfBirth()+"\n" +"Gender          :"+getGender()+"\n"+"MobileNo        :" + getMobileNo()+ "\n"  +
		      "Address         :" +getAddress()+"\n"+"Experience      :"+ getExperience()+"\n" +"EmployeeId      :" + getEmployeeId()+"\n" +
		      "Designation     :"+ getDesignation() ;
    }
}