package org.book.res.bookRest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="client",catalog="bookmang")
public class client{


@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ClientId")
private int ClientID;
@Column(name = "FirstName")
private String FirstName;
@Column(name = "LastName")
private String LastName;
@Column(name = "EmailID")
private String EmailID;
@Column(name = "Password")
private String Password;
@Column(name = "PhoneNo")
private int PhoneNo;

@OneToMany (fetch=FetchType.LAZY,mappedBy="client")
private Set<BookOrder> br= new HashSet<BookOrder>();

public int getClientID() {
	return ClientID;
}


public void setClientID(int clientID) {
	ClientID = clientID;
}


public Set<BookOrder> getBr() {
	return br;
}


public void setBr(Set<BookOrder> br) {
	this.br = br;
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
}
