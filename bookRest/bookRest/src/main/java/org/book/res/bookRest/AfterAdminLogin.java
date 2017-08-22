package org.book.res.bookRest;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AfterAdminLogin {
	public void options(String args[],int clientid)
	{	config co=new config();
	Scanner sc= new Scanner(System.in);
	Session session=co.getSession();
	Transaction tx=co.getTx();
		System.out.println("1. Create New Book Entry \n2. Edit a Book Entry \n3. Delete a book Entry \n4. View Orders \n5. Rules");
		int op=sc.nextInt();
		switch(op)
		{
		case 1:{
			AdminCreateBook b =new AdminCreateBook();
			//b.BookEntryCreate(args);
		}
		break;
		case 2:{
			AdminEditBook b= new AdminEditBook();
			b.BookEntryEdit(args);
		}
		break;
		case 3:{
			AdminDeleteBook b= new AdminDeleteBook();
			b.BookEntryDelete(args);
		}
		break;
		case 4:{
			AdminViewOrders b= new AdminViewOrders();
			b.ViewOrder(args,clientid);
		}
		break;
		case 5:{
			admin a= new admin();
           Org o= new Org();
           
           tx=session.beginTransaction();
           a=(admin)session.get(admin.class, clientid);
           o=a.getOrg();
           
           
           
          System.out.println("Issue Period:"+ o.getIssueperiod()+"\n Late Fee: "+ o.getLatefee());
          System.out.println("Do you wish to update(Y/N): ");
          String ol=sc.next();
           if(ol.equals("y")||ol.equals("Y"))
           {
        	  System.out.println("Enter issue period: ");
        	  int issue=sc.nextInt();
        	  System.out.println("Enter late fee: ");
        	  int late=sc.nextInt();
               o.setIssueperiod(issue);
               o.setLatefee(late);
               session.save(o); 
               tx.commit();
               System.out.println("Update Successful");
           }
         
		}
		break;
		}
				
	}
}
