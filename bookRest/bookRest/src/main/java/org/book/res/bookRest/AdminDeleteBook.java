package org.book.res.bookRest;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDeleteBook {
	config co=new config();
    Session session=co.getSession();
    Transaction tx=co.getTx();
    Scanner sc= new Scanner(System.in);
	public void BookEntryDelete(String args[])
	{   tx=session.beginTransaction();
		System.out.println("Enter Book id:");
		int bid=sc.nextInt();
		BookOrder b=new BookOrder();
		
		BookRecord br=(BookRecord)session.get(BookRecord.class,bid);
		
		//session.delete(br);
		tx.commit();		
	}
}
