package hashDriver;

import tree.Assignment;

public class Book {
	String title;
	String author;
	int pageCount;
	Date copyRightDate;
	
	public Book(String title, String author, int pageCount, Date copyRightDate) {
		this.title = title;
		this.author = author;
		this.pageCount = pageCount;
		this.copyRightDate = copyRightDate;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getPageCount() {
		return pageCount;
	}

	public Date getCopyRightDate() {
		return copyRightDate;
	}
	
	public int hashCode() {
		int hash = title.hashCode() + author.hashCode() + copyRightDate.hashCode();
		return hash;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Book))
			return false;
		Book book = (Book) obj;
		if(book.getAuthor().equals(this.author) && book.getTitle().equals(this.title) && 
				copyRightDate.equals(book.copyRightDate)) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return title + " " + author + " " + Integer.toString(pageCount) + " " + copyRightDate.toString();
	}

}
