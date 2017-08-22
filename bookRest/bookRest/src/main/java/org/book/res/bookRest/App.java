package org.book.res.bookRest;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		client log= new client();
		admin adminlog= new admin();
		clientback cb= new clientback();
		Scanner sc= new Scanner(System.in);
      System.out.println("Select your role: \n 1.Client \n 2.Admin");
      int op=sc.nextInt();
    
      if(op==1)
      {  
    	  
    	  System.out.println("Select whether new or existing user \n 1. New User \n 2. Existing User");
    	 int o=sc.nextInt();
    	  if(o==1)
    	  { 
    	  System.out.println("First Name:");
    	  String fname=sc.next();
    	  System.out.println("Last Name:");
    	  String lname=sc.next();
    	  System.out.println("EmailID:");
    	  String email=sc.next();
    	  System.out.println("Password:");
    	  String pass=sc.next();
    	  System.out.println("Phone Number:"+Integer.parseInt(args[6]));
    	  int num=sc.nextInt();
    		  cb.createUser(fname,lname,email,pass,num);}
    	  else
    	  {  
    		  System.out.println("Enter Emaild:");
    		  String email=sc.next();
    		  System.out.println("Enter Password:");
    		  String pass=sc.next();
    		  log=cb.login(email,pass);
    	  if(log!=null)
    	  {System.out.println("Welcome "+log.getFirstName()+" "+log.getLastName());
    	    AfterUserLogin a= new AfterUserLogin();
    	    a.options(args,log.getClientID());
    	  }
    	  else
    		  System.out.println("Wrong EmailID/Password");}
      }
      else if(op==2)
      {
    	  System.out.println("Enter Username:");
    	  String un=sc.next();
		  System.out.println("Enter Password:");
		  String pass=sc.next();
		  adminlog=cb.adminlogin(un,pass);
	  if(adminlog!=null)
	  {System.out.println("Welcome "+adminlog.getFirstName()+" "+adminlog.getLastName());
	  AfterAdminLogin a= new AfterAdminLogin();
	  a.options(args, adminlog.getAdminID());
      }
	  else
		  {System.out.println("Wrong Username/Password");}
  
	  
      }
      else
      {
    	  System.out.println("Wrong Choice");
      }
	
	
	}

	}
	
