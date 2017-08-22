package org.book.res.bookRest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="book_order",catalog="bookmang")
public class BookOrder {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderID")
	private int OrderID;

	
	
	@Override
	public String toString() {
		return "BookOrder [OrderID=" + OrderID + ", client=" + client + ", br=" + br + ", NoOfCopies=" + NoOfCopies
				+ ", StatusOfBooking=" + StatusOfBooking + ", issuetimestamp=" + issuetimestamp + ", booktimestamp="
				+ booktimestamp + "]";
	}
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	
	private client client;
    @ManyToOne(fetch=FetchType.LAZY)

  private BookRecord br;
    
	@Column(name = "NoOfCopies")
	private int NoOfCopies;
	@Column(name = "StatusOfBooking")
	private String StatusOfBooking;
	@Column(name="IssueTimestamp")
	
	private Date issuetimestamp;
	@Column(name="BookTimestamp")
	private Date booktimestamp;
	@Column(name="ReturnTimestamp")
	private Date returntimestamp;
	public Date getIssuetimestamp() {
		return issuetimestamp;
	}
	
	public Date getBooktimestamp() {
		return booktimestamp;
	}

	public void setBooktimestamp(Date booktimestamp) {
		this.booktimestamp = booktimestamp;
	}

	@PreUpdate
	public void setIssuetimestamp() {
		this.issuetimestamp = new Date();;
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}



	public Date getReturntimestamp() {
		return returntimestamp;
	}
	public void setReturntimestamp(Date returntimestamp) {
		this.returntimestamp = returntimestamp;
	}
	public client getClient() {
		return client;
	}
	public void setClient(client client) {
		this.client = client;
	}


	public BookRecord getBr() {
		return br;
	}
	public void setBr(BookRecord br) {
		this.br = br;
	}
	public int getNoOfCopies() {
		return NoOfCopies;
	}
	public void setNoOfCopies(int noOfCopies) {
		NoOfCopies = noOfCopies;
	}
	public String getStatusOfBooking() {
		return StatusOfBooking;
	}
	public void setStatusOfBooking(String statusOfBooking) {
		StatusOfBooking = statusOfBooking;
	}
}
