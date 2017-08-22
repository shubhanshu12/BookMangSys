package org.book.res.bookRest.dto;

import javax.persistence.Column;

public class JustClientAdmin {

	private int ClientID;

	private String FirstName;

	private String LastName;
	
	private String TypeAcc;
	
	@Override
	public String toString() {
		return "JustClient [ClientID=" + ClientID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", EmailID="
				+ EmailID + ", Password=" + Password + ", PhoneNo=" + PhoneNo + "]";
	}

	private String EmailID;
	
	private String Password;

	private int PhoneNo;

	public int getClientID() {
		return ClientID;
	}

	public void setClientID(int clientID) {
		ClientID = clientID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmailID() {
		return EmailID;
	}

	public void setEmailID(String emailID) {
		EmailID = emailID;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		PhoneNo = phoneNo;
	}

	public String getTypeAcc() {
		return TypeAcc;
	}

	public void setTypeAcc(String typeAcc) {
		TypeAcc = typeAcc;
	}



	
}
