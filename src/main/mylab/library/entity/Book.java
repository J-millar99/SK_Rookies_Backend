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
		String ret = "å ����: " + title + "\t"
				+ "����: " + author + "\t"
				+ "isbn: " + isbn + "\t"
				+ "���ǳ⵵: " + publishYear + "\t"
				+ "���� ���� ����: ";
		if (getIsAvailable() == true)
			return ret + "����" + "\n";
		else
			return ret + "���� ��" + "\n";
	}
	
	
}
