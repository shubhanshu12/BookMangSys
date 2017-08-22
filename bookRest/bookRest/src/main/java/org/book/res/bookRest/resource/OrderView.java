package org.book.res.bookRest.resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.book.res.bookRest.AdminSetBookingStatus;
import org.book.res.bookRest.AdminViewOrders;
import org.book.res.bookRest.BookOrder;
import org.book.res.bookRest.dto.BookOrderDTO;
import org.book.res.bookRest.dto.BookRecordDTO;
import org.book.res.bookRest.dto.ClientDTO;

@Path("/viewing")
public class OrderView {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookOrderDTO> getOrder(@QueryParam("view") String v, @QueryParam("orderID") int orderID) {
		List<BookOrder> bookOrderList = null;
		List<BookOrderDTO> m = new ArrayList<BookOrderDTO>();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		AdminViewOrders adm = new AdminViewOrders();
		System.out.println(orderID);
		if (v.equals("orderID")) {
			System.out.println("order");
			bookOrderList = adm.ViewOrder(v, orderID);
		} else {
			bookOrderList = adm.ViewOrder(v, 0);
		}
		for (BookOrder bookOrder : bookOrderList) {
			ClientDTO cl = new ClientDTO();
			cl.setClientID(bookOrder.getClient().getClientID());
			cl.setEmailID(bookOrder.getClient().getEmailID());
			cl.setFirstName(bookOrder.getClient().getFirstName());
			cl.setLastName(bookOrder.getClient().getLastName());
			cl.setPhoneNo(bookOrder.getClient().getPhoneNo());
			BookRecordDTO br = new BookRecordDTO();
			br.setAuthor(bookOrder.getBr().getAuthor());
			br.setBookid(bookOrder.getBr().getBookid());
			br.setBooksAvailable(bookOrder.getBr().getBooksAvailable());
			br.setEdition(bookOrder.getBr().getEdition());
			br.setISBN(bookOrder.getBr().getISBN());
			br.setISSN(bookOrder.getBr().getISSN());
			br.setPublicationDate(bookOrder.getBr().getPublicationDate());
			br.setPublisher(bookOrder.getBr().getPublisher());
			br.setSubject(bookOrder.getBr().getSubject());
			br.setTitle(bookOrder.getBr().getTitle());
			br.setTotalBooks(bookOrder.getBr().getTotalBooks());
			BookOrderDTO bo = new BookOrderDTO(cl, br);
			bo.setOrderID(bookOrder.getOrderID());
			bo.setStatusOfBooking(bookOrder.getStatusOfBooking());
			if (bookOrder.getReturntimestamp() == null) {
				bo.setReturntimestamp(null);
			} else {
				String reportDate = df.format(bookOrder.getReturntimestamp());
				System.out.println(reportDate);
				bo.setReturntimestamp(reportDate);
			}
			bo.setNoOfCopies(bookOrder.getNoOfCopies());
			String bookdate = df.format(bookOrder.getBooktimestamp());
			bo.setBooktimestamp(bookdate);
			System.out.println(bo);
			m.add(bo);

		}

		return m;
	}

	@POST
	public boolean setissuestatus(@QueryParam("orderid") int id, @QueryParam("adminid") int adminid) {
		AdminSetBookingStatus changeStatus = new AdminSetBookingStatus();
		return changeStatus.setbookstat(id, adminid);

	}

}
