package org.book.res.bookRest.dto;

public class ClientDTO {
	private int ClientID;
	@Override
	public String toString() {
		return "ClientDTO [ClientID=" + ClientID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", EmailID="
				+ EmailID + ", PhoneNo=" + PhoneNo + "]";
	}
	private String FirstName;
	private String LastName;
	private String EmailID;
	
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

	public int getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		PhoneNo = phoneNo;
	}
}
