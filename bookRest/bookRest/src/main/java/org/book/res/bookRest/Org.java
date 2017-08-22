package org.book.res.bookRest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="organization")
public class Org {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idorganization")
    private int orgid;


	@Column(name = "NameofOrg")
    private String NameOfOrg;
	@Column(name = "IssuePeriod")
    private int issueperiod;
	@Column(name = "latefee")
    private int latefee;
    @OneToMany
    private Set<admin> a= new HashSet<admin>();
	


	public int getIssueperiod() {
		return issueperiod;
	}
	public void setIssueperiod(int issueperiod) {
		this.issueperiod = issueperiod;
	}
	public int getLatefee() {
		return latefee;
	}
	public void setLatefee(int latefee) {
		this.latefee = latefee;
	}
	public Set<admin> getA() {
		return a;
	}
	public void setA(Set<admin> a) {
		this.a = a;
	}
	/*public List<admin> getAdmin() {
		return admin;
	}
	public void setAdmin(List<admin> admin) {
		this.admin = admin;
	}*/
	public int getOrgid() {
		return orgid;
	}
	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}
	public String getNameOfOrg() {
		return NameOfOrg;
	}
	public void setNameOfOrg(String nameOfOrg) {
		NameOfOrg = nameOfOrg;
	}

}
