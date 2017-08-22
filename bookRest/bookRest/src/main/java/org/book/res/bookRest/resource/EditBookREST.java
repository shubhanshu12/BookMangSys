package org.book.res.bookRest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.book.res.bookRest.AdminEditBook;
import org.book.res.bookRest.BookRecord;

@Path("/edit")
public class EditBookREST {
@POST
@Consumes(MediaType.APPLICATION_JSON)
public boolean editentry(BookRecord bookObject){
	
	AdminEditBook editbook= new AdminEditBook();
	try {
		editbook.BookEntryEdit(bookObject.getBookid(), bookObject);
		return true;
	} catch (Exception e) {
		System.out.println(e);
		return false;
	}
	
	
}
}
