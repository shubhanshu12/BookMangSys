package org.book.res.bookRest.dto;

public class BillingDTO {
private int latefee;
private int total;
private int days;
private String todaydate;
public int getLatefee() {
	return latefee;
}

public void setLatefee(int latefee) {
	this.latefee = latefee;
}

public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}

public int getDays() {
	return days;
}

public void setDays(int days) {
	this.days = days;
}

public String getTodaydate() {
	return todaydate;
}

public void setTodaydate(String todaydate) {
	this.todaydate = todaydate;
}

}
