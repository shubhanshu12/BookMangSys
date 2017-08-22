package org.book.res.bookRest;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class searching {
	config co=new config();
	Session session=co.getSession();
	Transaction tx=co.getTx();
	
public BookRecord searchUsingBookID(int bookid)
{
	BookRecord br=(BookRecord)session.get(BookRecord.class, bookid);
	return br;

}
public List<BookRecord> searchUsingBookTitle(String title)
{	List<BookRecord> results=null;

	try {
		tx = session.beginTransaction();
        Query q=session.createQuery(" from BookRecord where Title like '%"+title+"%'");
      //  q.setParameter("title", title);
        results=(List<BookRecord>)q.list();
		tx.commit();
	} catch (HibernateException e) {
		tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
	}
	return results;
	}
public List<BookRecord> searchUsingBookAuthorName(String name)
{List<BookRecord> results=null;

try {
	tx = session.beginTransaction();
    Query q=session.createQuery(" from BookRecord where author like '%"+name+"%'");
    //q.setParameter("name", name);
    results=(List<BookRecord>)q.list();
	tx.commit();
} catch (HibernateException e) {
	tx.rollback();
	e.printStackTrace();
} finally {
	session.close();
}
return results;}
public List<BookRecord> searchUsingBookISBN(int num)
{
	List<BookRecord> results=null;

	try {
		tx = session.beginTransaction();
	    Query q=session.createQuery(" from BookRecord where ISBN=:isbn");
	    q.setParameter("isbn", num);
	    results=(List<BookRecord>)q.list();
		tx.commit();
	} catch (HibernateException e) {
		tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
	}
	return results;
	}
public List<BookRecord> searchUsingBookISSN(int num)
{
	List<BookRecord> results=null;

	try {
		tx = session.beginTransaction();
	    Query q=session.createQuery("from BookRecord where ISSN=:issn");
	    q.setParameter("issn", num);
	    results=(List<BookRecord>)q.list();
		tx.commit();
	} catch (HibernateException e) {
		tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
	}
	return results;
}
public List<BookRecord> searchUsingPublisher(String publisher)
{
	List<BookRecord> results=null;

	try {
		tx = session.beginTransaction();
	    Query q=session.createQuery("from BookRecord where publisher like '%"+publisher+"%'");
	    //q.setParameter("publish", publisher);
	    results=(List<BookRecord>)q.list();
		tx.commit();
	} catch (HibernateException e) {
		tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
	}
	return results;	
}
public List<BookRecord> searchUsingSubject(String subject)
{
	List<BookRecord> results=null;

	try {
		tx = session.beginTransaction();
	    Query q=session.createQuery("from BookRecord where subject=:sub");
	    q.setParameter("sub", subject);
	    results=(List<BookRecord>)q.list();
		tx.commit();
	} catch (HibernateException e) {
		tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
	}
	return results;		
}
}
