package org.book.res.bookRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AfterUserLogin {
public void options(String args[],int clientid)
{     searching se= new searching();
      List<Object[]> res;
      Scanner sc= new Scanner(System.in);
      ArrayList<Integer> bookid = new ArrayList<Integer>();
      int sno=1;
	 System.out.println("Search book using \n1.Book Title \n2.Book Author's Name \n3.ISBN \n4.ISSN \n5.Publisher \n6.Subject");
	 int op=sc.nextInt();
	 switch(op)
	  {
	  case 1:{
		       System.out.println("Enter book title:");
		       String s=sc.next();
		       res=se.searchUsingBookTitle(s);
		       if(res==null)
		       { System.out.println("No match found");
		        return;}
		       String status;
		       System.out.println("S No. \tBook Title \tAuthor's Name \tPublisher \tStatus");
		       
		       for(Object[] Book : res)
		       { if(Book[4].equals(0))
		    	   status="Not Available";
		    	   else
		    		   status="Available";
		           System.out.print(sno);
		           bookid.add((Integer)Book[0]);
		           
		    	   System.out.println("\t"+Book[1]+"\t"+Book[2]+"\t"+Book[3]+"\t"+status);
		    	   sno++;
		       }
	         }
	  break;
	  case 2:{
	       System.out.println("Enter book Author's Name:");
	       String s=sc.next();
	       res=se.searchUsingBookAuthorName(s);
	       if(res==null)
	       { System.out.println("No match found");
	        return;}
	       String status;
	       System.out.println("Book Title \tAuthor's Name \tPublisher \tStatus");
	       for(Object[] Book : res)
	       { if(Book[4].equals(0))
	    	   status="Not Available";
	    	   else
	    		   status="Available";
	       System.out.print(sno);
           bookid.add((Integer)Book[0]);
	    	   System.out.println(Book[1]+"\t"+Book[2]+"\t"+Book[3]+"\t"+status);
	    	   sno++;
	       }
        }
	  break;
	  case 3:{
		       System.out.println("Enter ISBN:");
		       int s=sc.nextInt();
		       res=se.searchUsingBookISBN(s);
		       if(res==null)
		       { System.out.println("No match found");
		        return;}
		       String status;
		       System.out.println("Book Title \tAuthor's Name \tPublisher \tStatus");
		       for(Object[] Book : res)
		       { if(Book[4].equals(0))
		    	   status="Not Available";
		    	   else
		    		   status="Available";
		       System.out.print(sno);
	           bookid.add((Integer)Book[0]);
		    	   System.out.println(Book[1]+"\t"+Book[2]+"\t"+Book[3]+"\t"+status);
		    	   sno++;
		       }
        }
	  break;
	  case 4:{
		       System.out.println("Enter ISSN:");
		       int s= sc.nextInt();
		       res=se.searchUsingBookISSN(s);
		       if(res==null)
		       { System.out.println("No match found");
		        return;}
		       String status;
		       System.out.println("Book Title \tAuthor's Name \tPublisher \tStatus");
		       for(Object[] Book : res)
		       { if(Book[4].equals(0))
		    	   status="Not Available";
		    	   else
		    		   status="Available";
		       System.out.print(sno);
	           bookid.add((Integer)Book[0]);
		    	   System.out.println(Book[1]+"\t"+Book[2]+"\t"+Book[3]+"\t"+status);
		    	   sno++;
		       }
        }
	  break;
	  case 5:{
		       System.out.println("Enter Publisher:");
		       String s=sc.next();
		       res=se.searchUsingPublisher(s);
		       if(res==null)
		       { System.out.println("No match found");
		        return;}
		       String status;
		       System.out.println("Book Title \tAuthor's Name \tPublisher \tStatus");
		       for(Object[] Book : res)
		       { if(Book[4].equals(0))
		    	   status="Not Available";
		    	   else
		    		   status="Available";
		       System.out.print(sno);
	           bookid.add((Integer)Book[0]);
		    	   System.out.println(Book[1]+"\t"+Book[2]+"\t"+Book[3]+"\t"+status);
		    	   sno++;
		       }
        }
	  break;
	  case 6:{
	       System.out.println("Enter Subject:");
	       String s=sc.next();
	       res=se.searchUsingSubject(s);
	       if(res==null)
	       { System.out.println("No match found");
	        return;}
	       String status;
	       System.out.println("Book Title \tAuthor's Name \tPublisher \tStatus");
	       for(Object[] Book : res)
	       { if(Book[4].equals(0))
	    	   status="Not Available";
	    	   else
	    		   status="Available";
	       System.out.print(sno);
           bookid.add((Integer)Book[0]);
	    	   System.out.println(Book[1]+"\t"+Book[2]+"\t"+Book[3]+"\t"+status);
	    	   sno++;
	       }
        }
	  break;
	  
	  }
	  System.out.println("To view details of any book enter its S.no:");
	  int k=sc.nextInt();
	  if(k!=0)
	  {
		  ViewDetails v =new ViewDetails();
		  v.view(bookid.get(k-1),clientid,args);
	  }
	  else
	  {
		  return;
	  }
	  
}
}
