package org.book.res.bookRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminViewOrders {
	public List<BookOrder> ViewOrder(String ox,int orderID) {
		config co = new config();
		List<BookOrder> res = new ArrayList<BookOrder>();
		Session session = co.getSession();
		Transaction tx = co.getTx();

		switch (ox) {
		case "orderID": {
			tx = session.beginTransaction();
			BookOrder bookOrder = new BookOrder();
			bookOrder = (BookOrder) session.get(BookOrder.class, orderID);
			System.out.println(bookOrder);
			res.add(bookOrder);
		}
		break;
		case "pending": {
			tx = session.beginTransaction();
			Query q = session.createQuery("from BookOrder where StatusOfBooking='Booking Confirmed'");
			res = (List<BookOrder>) q.list();
		}
			break;
		case "issued": {
			tx = session.beginTransaction();
			Query q = session.createQuery("from BookOrder where StatusOfBooking='Book issued'");
			res = (List<BookOrder>) q.list();

		}
			break;

		case "all": {
			tx = session.beginTransaction();
			Query q = session.createQuery("from BookOrder");
			res = (List<BookOrder>) q.list();

		}
			break;
		case "defaulters": {
			tx = session.beginTransaction();
			Query q = session.createQuery("from BookOrder where returntimestamp < CURRENT_TIMESTAMP");
			res = (List<BookOrder>) q.list();

		}
			break;
		}
		return res;
	}
}
