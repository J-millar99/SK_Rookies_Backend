package mylab.library.control;

import java.util.List;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		Library library = new Library("�߾� ������");
		testFindBook(library);
		
		testCheckout(library);
		
		testReturn(library);
		
		List<Book> availableBooks = library.getAvailableBooks();
		
		for (Book book : availableBooks) {
			System.out.print(book.toString());
			System.out.println("-----------------");			
		}
	}
	
	public void addSampleBooks(Library library) {
		
	}
	
	public static void testFindBook(Library library) {
		System.out.println("===== ���� �˻� �׽�Ʈ =====");
		System.out.println("�������� �˻� ���: ");
		Book book = library.findBookByTitle("�ڹ��� ����");
		System.out.println(book.toString());
		
		System.out.println("���ڷ� �˻� ���: ");
		book = library.findBookByAuthor("Robert C. Martin");
		System.out.println(book.toString());
	}
	
	public static void testCheckout(Library library) {
		System.out.println("===== ���� ���� �׽�Ʈ =====");
		library.checkOutBook("978-89-01-14077-4");
		System.out.println("������ ���� ����: ");
		library.ShowLibraryInformation();
	}
	
	public static void testReturn(Library library) {
		System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
		library.returnBook("978-89-01-14077-4");
		System.out.println("������ ���� ����: ");
		library.ShowLibraryInformation();
	}
}
