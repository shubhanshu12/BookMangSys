package org.book.res.bookRest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="admin")
public class admin {



	@Override
	public String toString() {
		return "admin [AdminID=" + AdminID + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", Password=" + Password
				+ ", Username=" + Username + ", org=" + org + "]";
	}
	@Id 
	@Column(name = "AdminId")
	private int AdminID;
    @OneToOne(fetch=FetchType.EAGER)
    private Org org;
    

	@Column(name = "FirstName")
	private String FirstName;
	@Column(name = "LastName")
	private String LastName;
	@Column(name = "Username")
	private String Username;
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	@Column(name = "Password")
	private String Password;
	public int getAdminID() {
		return AdminID;
	}
	public void setAdminID(int adminID) {
		AdminID = adminID;
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
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

}
