package org.book.res.bookRest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.book.res.bookRest.BookingClose;
import org.json.JSONObject;

@Path("/close")
public class BookingCloseREST {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String setbookstatusClose(@QueryParam("orderid") int orderid) {
		JSONObject obj = new JSONObject();
		BookingClose close = new BookingClose();
		if (close.setstatustoClose(orderid)) {
			obj.put("res", "Closed");
		} else {
			obj.put("res", "error");
		}
		return obj.toString();
	}
}
