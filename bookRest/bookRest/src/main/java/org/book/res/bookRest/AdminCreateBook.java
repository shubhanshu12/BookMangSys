package org.book.res.bookRest;

import java.util.Scanner;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminCreateBook {
public boolean BookEntryCreate(String title,String author,String pub,String pubdate,String edition,String sub,int isbn,int issn,int total,int available)
{
BookRecord br =new BookRecord();
System.out.println("Enter Title:");
br.setTitle(title);
System.out.println("Enter Author:");
br.setAuthor(author);
System.out.println("Enter Publisher: ");
br.setPublisher(pub);
System.out.println("Enter Publication Date:");
br.setPublicationDate(pubdate);
System.out.println("Enter edition: ");
br.setEdition(edition);
System.out.println("Enter Subject:");
br.setSubject(sub);
System.out.println("Enter ISBN:");
br.setISBN(isbn);
System.out.println("Enter ISSN:");
br.setISSN(issn);
System.out.println("Enter total no of books: ");
br.setTotalBooks(total);
System.out.println("Enter number of books available");
br.setBooksAvailable(available);
config co=new config();
Session session=co.getSession();
Transaction tx=co.getTx();
try {
	tx = session.beginTransaction();
	session.save(br);
	tx.commit();
	System.out.println("Book Added Successfully");
} catch (HibernateException e) {
	tx.rollback();
	e.printStackTrace();
} finally {
	session.close();
}
return true;
}
}
