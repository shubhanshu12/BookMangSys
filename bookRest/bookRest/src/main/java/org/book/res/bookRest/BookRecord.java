package org.book.res.bookRest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="book_record", catalog="bookmang")
public class BookRecord {
	@Override
	public String toString() {
		return "BookRecord [ISBN=" + ISBN + ", ISSN=" + ISSN + ", author="
				+ author + ", bookid=" + bookid + ", booksAvailable="
				+ booksAvailable + ", edition=" + edition
				+ ", publicationDate=" + publicationDate + ", publisher="
				+ publisher + ", subject=" + subject + ", title=" + title
				+ ", totalBooks=" + totalBooks + "]";
	}
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BookID")
	private int bookid;

	@Column(name = "Title")
	private String title;
	@Column(name = "Author")
	private String author;
	@Column(name = "Publisher")
	private String publisher;
	@Column(name = "Edition")
	private String edition;
	@Column(name = "Subject")
	private String subject;
	@Column(name = "PublicationDate")
	private String publicationDate;
	@Column(name = "ISBN")
	private int ISBN;
	@Column(name = "ISSN")
	private int ISSN;
	@Column(name = "TotalNoOfBooks")
	private int totalBooks;
	@Column(name = "NoOfBooksAvailable")
	private int booksAvailable;
	@OneToMany (fetch = FetchType.EAGER,mappedBy="br")
	private Set<BookOrder> bm= new HashSet<BookOrder>();
	
	public Set<BookOrder> getBm() {
		return bm;
	}
	public void setBm(Set<BookOrder> bm) {
		this.bm = bm;
	}
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
