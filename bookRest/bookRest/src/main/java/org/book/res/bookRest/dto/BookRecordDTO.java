package org.book.res.bookRest.dto;

import java.util.HashSet;
import java.util.Set;

import org.book.res.bookRest.BookOrder;

public class BookRecordDTO {
	private int bookid;
	private String title;
	private String author;
	private String publisher;
	private String edition;
	private String subject;
	private String publicationDate;
	private int ISBN;
	private int ISSN;
	private int totalBooks;
	private int booksAvailable;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public int getISSN() {
		return ISSN;
	}
	public void setISSN(int iSSN) {
		ISSN = iSSN;
	}
	public int getTotalBooks() {
		return totalBooks;
	}
	public void setTotalBooks(int totalBooks) {
		this.totalBooks = totalBooks;
	}
	public int getBooksAvailable() {
		return booksAvailable;
	}
	public void setBooksAvailable(int booksAvailable) {
		this.booksAvailable = booksAvailable;
	}
	
}
