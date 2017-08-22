package org.book.res.bookRest.dto;

import org.book.res.bookRest.BookRecord;
import org.book.res.bookRest.client;
import java.time.LocalDateTime;
import java.util.Date;
public class BookOrderDTO {
	

	@Override
	public String toString() {
		return "BookOrderDTO [OrderID=" + OrderID + ", client=" + client + ", br=" + br + ", NoOfCopies=" + NoOfCopies
				+ ", StatusOfBooking=" + StatusOfBooking + ", booktimestamp=" + booktimestamp + "]";
	}
	private int OrderID;
	private ClientDTO client;
	private BookRecordDTO br;
	private int NoOfCopies;
	private String StatusOfBooking;
    private String booktimestamp;
    private String returntimestamp;
    




	public BookOrderDTO(ClientDTO client, BookRecordDTO br) {
		super();
		this.client = client;
		this.br = br;
	}
	
		public int getOrderID() {
			return OrderID;
		}
		public void setOrderID(int orderID) {
			OrderID = orderID;
		}

		public ClientDTO getClient() {
			return client;
		}
		public void setClient(ClientDTO client) {
			this.client = client;
		}
		public BookRecordDTO getBr() {
			return br;
		}
		public void setBr(BookRecordDTO br) {
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

		public String getBooktimestamp() {
			return booktimestamp;
		}
		public void setBooktimestamp(String booktimestamp) {
			this.booktimestamp = booktimestamp;
		}

		public String getReturntimestamp() {
			return returntimestamp;
		}

		public void setReturntimestamp(String returntimestamp) {
			this.returntimestamp = returntimestamp;
		}


		
	
}
