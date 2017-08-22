package org.book.res.bookRest;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class clientback {
	config co=new config();
	Session session=co.getSession();
	Transaction tx=co.getTx();
	public boolean createUser(String firstname,String lastname, String email, String password, int number)
	{

		

		try {
			tx = session.beginTransaction();
			client cl=new client();
			cl.setEmailID(email);
			cl.setFirstName(firstname);
			cl.setLastName(lastname);
			cl.setPassword(password);
			cl.setPhoneNo(number);
			session.save(cl);
			tx.commit();
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}
	
	public client login(String username,String password)
	{ 
	

	client cli= new client();
	Transaction tx=null;
	try {
		tx = session.beginTransaction();
		
        Query q= session.createQuery("from client where EmailID=:username and Password=:password");
        q.setParameter("username", username);
        q.setParameter("password", password);
        cli=(client)q.uniqueResult();
		tx.commit();
	} catch (HibernateException e) {
		tx.rollback();
		e.printStackTrace();
	} finally {
		
	}
		return cli;
		
	}
	public admin adminlogin(String username,String password)
	{ 
	

	admin cl= new admin();
	Transaction tx=null;
	try {
		tx = session.beginTransaction();
		
        Query q= session.createQuery("from admin where Username=:username and Password=:password");
        q.setParameter("username", username);
        q.setParameter("password", password);
        cl=(admin)q.uniqueResult();
		tx.commit();
	} catch (HibernateException e) {
		tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
	}
		return cl;
		
	}
}

	

