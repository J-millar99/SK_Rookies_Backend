package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books;
	private String name;
	
	public Library(String name) {
		books = new ArrayList<>();
		this.name = name;
		Book book = new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022);
		addBook(book);
		book = new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015);
		addBook(book);
		book = new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008);
		addBook(book);
		book = new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018);
		addBook(book);
		book = new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005);
		addBook(book);
		book = new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019);
		addBook(book);
		System.out.println("===== " + name + " =====");
		ShowLibraryInformation();
	}
	
	public void addBook(Book book) {
		System.out.println("도서가 추가되었습니다: " + book.getTitle());
		books.add(book);
	}
	
	public Book findBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equals(title))
				return book;
		}
		System.out.println(title + "제목을 가진 책이 존재하지 않습니다.");
		return null;
	}
	
	public Book findBookByAuthor(String author) {
		for (Book book : books) {
			if (book.getAuthor().equals(author))
				return book;
		}
		System.out.println(author + "저자의 책이 존재하지 않습니다.");
		return null;
	}
	
	public boolean checkOutBook(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn) && book.getIsAvailable() == true) {
				book.checkOut();
				System.out.println("도서 대출 성공!");
				System.out.println("대출된 도서 정보: ");
				System.out.println(book.toString());
				return true;
			} else if (book.getIsAvailable() == false) {
				System.out.println("도서 대출 실패!");
				System.out.println("도서가 대출 중 입니다.");
				return false;
			}
		}
		System.out.println("도서 대출 실패!");
		System.out.println("해당하는 도서가 없습니다.");
		return false;
	}
	
	public boolean returnBook(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn) && book.getIsAvailable() == false) {
				book.returnBook();
				System.out.println("도서 반납 성공!");
				System.out.println("반납된 도서 정보: ");
				System.out.println(book.toString());
				return true;
			}
		}
		return false;
	}
	
	public List<Book> getAvailableBooks() {
		System.out.println("===== 대출 가능한 도서 목록 =====");
		List<Book> availableBooks = new ArrayList<>();
		for (Book book : books) {
			if (book.getIsAvailable() == true)
				availableBooks.add(book);
		}
		return availableBooks;
	}
	
	public void ShowLibraryInformation() {
		System.out.println("전체 도서 수: " + books.size());
		int cnt = 0;
		for (Book book : books) {
			if (book.getIsAvailable() == true)
				cnt++;
		}
		System.out.println("대출 가능 도서 수: " + cnt);
		System.out.println("대출 중인 도서 수: " + (books.size() - cnt));
		System.out.println();
	}
	
	
}
