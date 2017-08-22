package org.book.res.bookRest;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class booking {
public void reserveBook(int bookid,int clientid,String args[])
{   
	int bookscount=0;
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter number book of you want to reserve?");
	int num=sc.nextInt();
	
	config co=new config();
	Session session=co.getSession();
	Transaction tx=co.getTx();
		tx = session.beginTransaction();

        Query q=session.createQuery("select booksAvailable from BookRecord where bookid=:bookid");
        q.setParameter("bookid", bookid);
        bookscount=(Integer)q.uniqueResult();
		tx.commit();


	if(bookscount==0)
		{System.out.println("Book Not available right now");
		return;
		}
	else if(bookscount<num)
	{
		System.out.println("Not enough books available");
		return;
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
    
     b.getBooks().add(bo);
     b.setClient(c);
     session1.save(b);
     
     
    
    
    bo.setBooksAvailable(newcount);
    session1.save(bo);
    tx1.commit();
     System.out.println("Booking Confirmed");
     return;
	}
}
}
