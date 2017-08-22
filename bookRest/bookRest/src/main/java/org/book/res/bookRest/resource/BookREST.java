package org.book.res.bookRest.resource;

import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.book.res.bookRest.BookOrder;
import org.book.res.bookRest.BookRecord;
import org.book.res.bookRest.client;
import org.book.res.bookRest.config;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;
@Path("/booking")
public class BookREST {
@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public String bookOrder(@QueryParam("clientid") int clientid,@QueryParam("bookid") int bookid,@QueryParam("num") int  num)
{ JSONObject obj = new JSONObject();
	int bookscount=0;

	
	config co=new config();
	Session session=co.getSession();
	Transaction tx=co.getTx();
		tx = session.beginTransaction();

        Query q=session.createQuery("select booksAvailable from BookRecord where bookid=:bookid");
        q.setParameter("bookid", bookid);
        bookscount=(Integer)q.uniqueResult();
		tx.commit();


	if(bookscount==0)
		{obj.put("res", "Book not available");
		
		}
	else if(bookscount<num)
	{
		obj.put("res","Not enough books available");
		
	}
	else
	{
		Configuration con1 = new Configuration().configure().addAnnotatedClass(BookRecord.class).addAnnotatedClass(client.class).addAnnotatedClass(BookOrder.class);
		SessionFactory sf1= con1.buildSessionFactory();
		Session session1=sf1.openSession();
		Transaction tx1=null;
		tx1 = session1.beginTransaction();
     client c=new client();
     c=(client)session1.get(client.class, clientid);
     
     BookRecord bo= new BookRecord();
     bo=(BookRecord)session1.get(BookRecord.class, bookid);
     BookOrder b=new BookOrder();
     int booksordered=num;
     int newcount=bookscount-booksordered;
     b.setNoOfCopies(num);
     b.setStatusOfBooking("Booking Confirmed");
    
     b.setBr(bo);
     b.setClient(c);
     session1.save(b);
    bo.setBooksAvailable(newcount);
    session1.save(bo);
    
    tx1.commit();
    obj.put("res","Booking Confirmed");
    obj.put("orderid", b.getOrderID());

    obj.put("firstName", c.getFirstName())    ;
    obj.put("lastName", c.getLastName());
    obj.put("title", bo.getTitle());
    obj.put("copiesBooked", b.getNoOfCopies());
    
}
	return obj.toString();
}
}
