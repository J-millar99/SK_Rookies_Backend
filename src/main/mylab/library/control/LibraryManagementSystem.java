package mylab.library.control;

import java.util.List;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		Library library = new Library("중앙 도서관");
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
		System.out.println("===== 도서 검색 테스트 =====");
		System.out.println("제목으로 검색 결과: ");
		Book book = library.findBookByTitle("자바의 정석");
		System.out.println(book.toString());
		
		System.out.println("저자로 검색 결과: ");
		book = library.findBookByAuthor("Robert C. Martin");
		System.out.println(book.toString());
	}
	
	public static void testCheckout(Library library) {
		System.out.println("===== 도서 대출 테스트 =====");
		library.checkOutBook("978-89-01-14077-4");
		System.out.println("도서관 현재 상태: ");
		library.ShowLibraryInformation();
	}
	
	public static void testReturn(Library library) {
		System.out.println("===== 도서 반납 테스트 =====");
		library.returnBook("978-89-01-14077-4");
		System.out.println("도서관 현재 상태: ");
		library.ShowLibraryInformation();
	}
}
