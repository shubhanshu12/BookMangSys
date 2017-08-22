package org.book.res.bookRest.dto;

public class IssueLateDTO {
private int orgid;
private int latefee;
private int issue;
public int getLatefee() {
	return latefee;
}
public void setLatefee(int latefee) {
	this.latefee = latefee;
}
public int getIssue() {
	return issue;
}
public void setIssue(int issue) {
	this.issue = issue;
}
public int getOrgid() {
	return orgid;
}
public void setOrgid(int orgid) {
	this.orgid = orgid;
}


}
