package org.ideas2it.management.model;

public class Trainee extends Employee {
    
    protected String department;
   
    public Trainee(String name, int age, String address, long mobileNo, String dateOfBirth, String gender, String emailId,
            String employeeId, String department) {
	this.name = name;
	this.age = age;
	this.address = address;
	this.mobileNo = mobileNo;
	this.dateOfBirth = dateOfBirth;
	this.gender = gender;
	this.emailId = emailId;
	this.employeeId = employeeId;
	this.department = department;
    }

    public String getDepartment() {
       	return department;
    }

    public void setDepartment(String department) {
	this.department = department;
    }  

    public String toString() {
    return "\n" +"Trainee Details" +"\n"+"Name            :" + getName() + "\n" + "Email Id        :" + getEmailId() +"\n"+"Gender          :"+getGender()+"\n"+
		      "Date of Birth   :"+getDateOfBirth()+"\n" + "MobileNo        :" + getMobileNo()+ "\n"  + "Address         :" +getAddress()+"\n" + 
		      "EmailId         :"+ getEmailId()+"\n" + "EmployeeId      :" + getEmployeeId()+"\n" +"Department      :"+ getDepartment();
    }
}

	   