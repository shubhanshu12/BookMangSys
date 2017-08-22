package org.book.res.bookRest;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminEditBook {
	config co = new config();
	Session session = co.getSession();
	Transaction tx = co.getTx();


	public void BookEntryEdit(int bookid,BookRecord book ) {
		BookRecord br = new BookRecord();
		br = (BookRecord) session.get(BookRecord.class, bookid);

		
	
			tx = session.beginTransaction();
		    
			br.setTitle(book.getTitle());
			br.setAuthor(book.getAuthor());
			br.setEdition(book.getEdition());
			br.setISBN(book.getISBN());
			br.setISSN(book.getISSN());
			br.setTotalBooks(book.getTotalBooks());
			
			br.setPublicationDate(book.getPublicationDate());
			br.setPublisher(book.getPublisher());
			br.setSubject(book.getSubject());
			System.out.println(br);
			session.update(br);
			tx.commit();

	}
}
