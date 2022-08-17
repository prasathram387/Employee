package org.ideas2it.management.model;

public class Manager {

    protected String emailId;
    protected String password;

    public Manager(String emailId, String password) {
	this.emailId = emailId;
	this.password = password;
    }

    public String getEmailId() {
	return emailId;
    }

    public String getPassword() {
	return password;
    }

    public void setEmailId(String emailId) {
	this.emailId = emailId;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}