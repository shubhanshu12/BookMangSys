package org.book.res.bookRest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.book.res.bookRest.admin;
import org.book.res.bookRest.client;
import org.book.res.bookRest.clientback;
import org.book.res.bookRest.dto.JustClientAdmin;

@Path("/client")
public class ClientREST {
	admin adminlog = new admin();
	clientback cb = new clientback();
	client log = new client();
	JustClientAdmin c = new JustClientAdmin();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JustClientAdmin getClientData(@QueryParam("uname") String uname, @QueryParam("pass") String pass) {

		try {
			System.out.println(uname);
			log = cb.login(uname, pass);
			adminlog = cb.adminlogin(uname, pass);

			if (log != null) {
				c.setClientID(log.getClientID());
				c.setEmailID(log.getEmailID());
				c.setFirstName(log.getFirstName());
				c.setLastName(log.getLastName());
				//c.setPassword(log.getPassword());
				c.setPhoneNo(log.getPhoneNo());
				c.setTypeAcc("client");
				System.out.println(c);
			} else {
				c.setClientID(adminlog.getAdminID());
				c.setEmailID(adminlog.getUsername());
				c.setFirstName(adminlog.getFirstName());
				c.setLastName(adminlog.getLastName());
				//c.setPassword(adminlog.getPassword());
				c.setTypeAcc("admin");
			}

		} catch (NullPointerException e) {
			c.setEmailID("");
			c.setPassword("");

		}

		return c;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean setClientData(client c) {
		System.out.println(c.toString());
		return cb.createUser(c.getFirstName(), c.getLastName(), c.getEmailID(), c.getPassword(), c.getPhoneNo());

	}

}
