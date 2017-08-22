package org.book.res.bookRest.resource;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.book.res.bookRest.BookOrder;
import org.book.res.bookRest.admin;
import org.book.res.bookRest.config;
import org.book.res.bookRest.dto.BillingDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.Days;
import org.joda.time.LocalDate;


@Path("/latefee")
public class BillingREST {
	config co = new config();
	Session session = co.getSession();
	Transaction tx = co.getTx();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public BillingDTO getLateFee(@QueryParam("adminid") int adminid,@QueryParam("orderid") int orderid)
	{DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		admin AdminObj=new admin();
		AdminObj=(admin)session.get(admin.class,adminid);
		int latefee=AdminObj.getOrg().getLatefee();
		BookOrder bo= new BookOrder();
		bo=(BookOrder)session.get(BookOrder.class, orderid);
		int copies=bo.getNoOfCopies();
		Date returndate=bo.getReturntimestamp();
		Date today= new Date();
		String todaydate = df.format(today);
		int days= Days.daysBetween(
		           new LocalDate(returndate.getTime()), 
		           new LocalDate(today.getTime())).getDays();
        System.out.println(days);
        int total;
        if(days<0)
        {
        	total=0;
        	days=0;
        }
        else
        {
        	total=copies*days*latefee;
        }
		BillingDTO org= new BillingDTO();
		org.setDays(days);
		org.setTotal(total);
		org.setLatefee(latefee);
		org.setTodaydate(todaydate);
		return org;
	}
}
