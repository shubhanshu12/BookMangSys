package org.book.res.bookRest.resource;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.book.res.bookRest.BookOrder;
import org.book.res.bookRest.BookRecord;
import org.book.res.bookRest.searching;
import org.book.res.bookRest.dto.BookOrderDTO;
import org.book.res.bookRest.dto.BookRecordDTO;
@Path("searchREST")
public class SearchREST {
@GET
@Produces(MediaType.APPLICATION_JSON)
public List<BookRecordDTO> getBookRecords(@QueryParam("searchby") String searchby, @QueryParam("input") String input)
{BookRecord res=new BookRecord();;
List<BookRecord> re=new ArrayList<BookRecord>();
searching se= new searching();
	 switch(searchby)
	  {
	  case "bookid":{
	       
	       res=se.searchUsingBookID(Integer.parseInt(input));
	       re.add(res);
	       
        }
 break;
	  case "title":{
		       
		       re=se.searchUsingBookTitle(input);
		     
	         }
	  break;
	  case "author":{

	       re=se.searchUsingBookAuthorName(input);
	  
	
       }
	  break;
	  case "isbn":{
		       
		       re=se.searchUsingBookISBN(Integer.parseInt(input));
		
       }
	  break;
	  case "issn":{
		    
		       re=se.searchUsingBookISSN(Integer.parseInt(input));
		 
       }
	  break;
	  case "publisher":{
		       
		       re=se.searchUsingPublisher(input);
		
       }
	  break;
	  case "subject":{
	   
	       re=se.searchUsingSubject(input);
	    
       }
	  break;
	  
	  }
	
	List<BookRecordDTO> booklist=new ArrayList<BookRecordDTO>();
    for(BookRecord br: re)
    {BookRecordDTO bookRecord = new BookRecordDTO();
    	bookRecord.setBookid(br.getBookid());
    	bookRecord.setAuthor(br.getAuthor());
    	bookRecord.setBooksAvailable(br.getBooksAvailable());
    	bookRecord.setEdition(br.getEdition());
    	bookRecord.setISBN(br.getISBN());
    	bookRecord.setISSN(br.getISSN());
    	bookRecord.setPublicationDate(br.getPublicationDate());
    	bookRecord.setPublisher(br.getPublisher());
    	bookRecord.setSubject(br.getSubject());
    	bookRecord.setTitle(br.getTitle());
    	bookRecord.setTotalBooks(br.getTotalBooks());
    booklist.add(bookRecord);
    }
    return booklist;
}
}
