package org.book.res.bookRest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class config {
	Configuration con = new Configuration().configure().addAnnotatedClass(client.class).addAnnotatedClass(BookRecord.class).addAnnotatedClass(BookOrder.class).addAnnotatedClass(admin.class).addAnnotatedClass(Org.class);
	SessionFactory sf= con.buildSessionFactory();
	Session session=sf.openSession();
	Transaction tx=null;
	public Transaction getTx() {
		return tx;
	}
	public void setTx(Transaction tx) {
		this.tx = tx;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
}
