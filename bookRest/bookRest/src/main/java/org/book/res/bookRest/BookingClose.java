package org.book.res.bookRest;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookingClose {
public boolean setstatustoClose(int orderid)
{
	config co=new config();
	Session session=co.getSession();
	Transaction tx=co.getTx();
	try {
		tx=session.beginTransaction();
		BookOrder bo = new BookOrder();
		bo=(BookOrder)session.get(BookOrder.class, orderid);
		bo.setStatusOfBooking("Booking Closed");
		session.update(bo);
		tx.commit();
		session.close();
		return true;
	} catch (Exception e) {
		return false;
	}

}
}
