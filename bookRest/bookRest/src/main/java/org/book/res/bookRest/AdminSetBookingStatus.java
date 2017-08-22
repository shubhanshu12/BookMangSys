package org.book.res.bookRest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminSetBookingStatus {
	config co = new config();
	Session session = co.getSession();
	Transaction tx = co.getTx();

	public boolean setbookstat(int id,int adminid) {
		try {
		tx = session.beginTransaction();
		Query q = session.createQuery("from BookOrder where OrderID=" + id);
		BookOrder b = new BookOrder();
		
		b = (BookOrder) session.get(BookOrder.class, id);
		
		admin AdminObj=new admin();
		AdminObj=(admin)session.get(admin.class,adminid);
		int days=AdminObj.getOrg().getIssueperiod();
		Date date=new Date();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		System.out.println(cal.getTime());
		b.setStatusOfBooking("Book issued");
		b.setIssuetimestamp();
		b.setReturntimestamp(cal.getTime());
		session.update(b);
		tx.commit();
		return true;
			
		} catch (Exception e) {
		return false;
		}
		
	}
}
