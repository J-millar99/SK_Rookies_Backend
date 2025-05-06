package mylab.library.entity;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	public Book(String title, String author, String isbn, int publishYear) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean checkOut() {
		isAvailable = false;
		return isAvailable;
	}
	
	public void returnBook() {
		isAvailable = true;
	}
	
	public boolean getIsAvailable() {
		return isAvailable;
	}
	
	public String getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		String ret = "책 제목: " + title + "\t"
				+ "저자: " + author + "\t"
				+ "isbn: " + isbn + "\t"
				+ "출판년도: " + publishYear + "\t"
				+ "대출 가능 여부: ";
		if (getIsAvailable() == true)
			return ret + "가능" + "\n";
		else
			return ret + "대출 중" + "\n";
	}
	
	
}
