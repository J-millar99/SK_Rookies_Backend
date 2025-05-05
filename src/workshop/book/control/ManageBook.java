package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;

public class ManageBook {

	public static void main(String[] args) {
		// Publication 타입 배열을 선언 및 생성
		Publication[] pubs = new Publication[5];
		
		// Magazine 객체 생성
		// Magazine mz = new Magazine();
		// Novel 객체 생성
		// Novel novel = new Novel();
		
		// 묶어서 배열에 쓰기 위해서 부모 타입으로 사용
		Publication pub1 = new Magazine();
		Publication pub2 = new Novel();
	}
}
