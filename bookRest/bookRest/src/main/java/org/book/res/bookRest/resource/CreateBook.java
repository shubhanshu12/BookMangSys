package org.book.res.bookRest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.book.res.bookRest.AdminCreateBook;
import org.book.res.bookRest.BookRecord;

@Path("/create")
public class CreateBook {
@POST
@Consumes(MediaType.APPLICATION_JSON)
public boolean CreateEntry(BookRecord b){
	AdminCreateBook newBook= new AdminCreateBook();
	return newBook.BookEntryCreate(b.getTitle(), b.getAuthor(), b.getPublisher(), b.getPublicationDate(), b.getEdition(), b.getSubject(), b.getISBN(), b.getISSN(), b.getTotalBooks(), b.getBooksAvailable());
	
}
}
