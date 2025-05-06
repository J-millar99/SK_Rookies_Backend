package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books;
	private String name;
	
	public Library(String name) {
		books = new ArrayList<>();
		this.name = name;
		Book book = new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022);
		addBook(book);
		book = new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015);
		addBook(book);
		book = new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008);
		addBook(book);
		book = new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018);
		addBook(book);
		book = new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005);
		addBook(book);
		book = new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019);
		addBook(book);
		System.out.println("===== " + name + " =====");
		ShowLibraryInformation();
	}
	
	public void addBook(Book book) {
		System.out.println("������ �߰��Ǿ����ϴ�: " + book.getTitle());
		books.add(book);
	}
	
	public Book findBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equals(title))
				return book;
		}
		System.out.println(title + "������ ���� å�� �������� �ʽ��ϴ�.");
		return null;
	}
	
	public Book findBookByAuthor(String author) {
		for (Book book : books) {
			if (book.getAuthor().equals(author))
				return book;
		}
		System.out.println(author + "������ å�� �������� �ʽ��ϴ�.");
		return null;
	}
	
	public boolean checkOutBook(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn) && book.getIsAvailable() == true) {
				book.checkOut();
				System.out.println("���� ���� ����!");
				System.out.println("����� ���� ����: ");
				System.out.println(book.toString());
				return true;
			} else if (book.getIsAvailable() == false) {
				System.out.println("���� ���� ����!");
				System.out.println("������ ���� �� �Դϴ�.");
				return false;
			}
		}
		System.out.println("���� ���� ����!");
		System.out.println("�ش��ϴ� ������ �����ϴ�.");
		return false;
	}
	
	public boolean returnBook(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn) && book.getIsAvailable() == false) {
				book.returnBook();
				System.out.println("���� �ݳ� ����!");
				System.out.println("�ݳ��� ���� ����: ");
				System.out.println(book.toString());
				return true;
			}
		}
		return false;
	}
	
	public List<Book> getAvailableBooks() {
		System.out.println("===== ���� ������ ���� ��� =====");
		List<Book> availableBooks = new ArrayList<>();
		for (Book book : books) {
			if (book.getIsAvailable() == true)
				availableBooks.add(book);
		}
		return availableBooks;
	}
	
	public void ShowLibraryInformation() {
		System.out.println("��ü ���� ��: " + books.size());
		int cnt = 0;
		for (Book book : books) {
			if (book.getIsAvailable() == true)
				cnt++;
		}
		System.out.println("���� ���� ���� ��: " + cnt);
		System.out.println("���� ���� ���� ��: " + (books.size() - cnt));
		System.out.println();
	}
	
	
}
