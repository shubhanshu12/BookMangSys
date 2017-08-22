package org.book.res.bookRest.resource;

import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.book.res.bookRest.BookRecord;
import org.book.res.bookRest.config;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;


@Path("/delete")
public class DeleteREST {
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public String deleteentry(@PathParam("id") int bookid)
	{
		config co=new config();
		Session session=co.getSession();
		Transaction tx=co.getTx();
		JSONObject obj = new JSONObject();
		BookRecord br =new BookRecord();
		br=(BookRecord)session.load(BookRecord.class,bookid);
       System.out.println(br.getBm());
       if(br.getBm().size()==0)
    	   {
    	   tx=session.beginTransaction();
    	   session.delete(br);
    	   tx.commit();
    	   obj.put("res", "Book Deleted");
    	   
    	   }
       else
       {
    	  obj.put("res", "Book Cannot be deleted as one of the book is issued.");
       }
		return obj.toString();
	}
}
