package org.book.res.bookRest;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ViewDetails {
public void view(int bookid,int clientid,String args[])
{   Scanner sc= new Scanner(System.in);
	config co=new config();
	Session session=co.getSession();
	Transaction tx=co.getTx();
	tx=session.beginTransaction();
	Query q=session.createQuery("from BookRecord where bookid=:bookid");
	q.setParameter("bookid", bookid);
	BookRecord br=(BookRecord)q.uniqueResult();
	System.out.println("Here are your book details");
	System.out.println(br);
	
	  System.out.println("Do you wish to reserve this book in advance(Y/N):");
	  String o=sc.next();
	  if(o.equals("Y") || o.equals("y"))
	  {
          booking book=new booking();
        book.reserveBook(bookid,clientid,args);
	  }
	  else
	  {return;}
}
}
