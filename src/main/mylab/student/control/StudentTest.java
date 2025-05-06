package mylab.student.control;

import mylab.student.entity.GradeException;
import mylab.student.entity.Student;

public class StudentTest {
	public static void main(String[] args) {
		Student s = new Student("1", "��μ�", "��ǻ�Ͱ���", 3);
		
		System.out.println(s.getName() + " / "
						+ s.getMajor() + " / "
						+ s.getGrade());
		
		try {
			s.setGrade(5);
		} catch (GradeException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
