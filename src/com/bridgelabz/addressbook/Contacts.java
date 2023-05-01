package com.bridgelabz.addressbook;

public class Contacts {
	String firstName;
	String lastName;
	String state;
	String zip;
	String phoneNumber;
	String email;

	public Contacts(String FirstName, String readLine, String readLine1, String readLine2, String readLine3) {
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contacts(String firstName, String lastName, String state, String zip, String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Contacts() {
		super();
	}

	@Override
	public String toString() {
		return " name " + this.firstName + " lastName " + this.lastName + " state " + this.state + " zip" + this.zip + " phoneNumber " + this.phoneNumber +
				"gmail" + this.email;
	}

}
