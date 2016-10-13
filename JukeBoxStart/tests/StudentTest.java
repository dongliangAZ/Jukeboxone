package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Student;

public class StudentTest {

	@Test
	public void test() {
		Student s=new Student("Chris","1");
		assertEquals(1500,s.getmuniteLeft());
		assertEquals("1",s.getPassword());
		assertEquals(0,s.getplaytimes());
		assertEquals("Chris",s.getUsername());
		assertEquals(true,s.validpassword("Chris", "1"));
		assertEquals(false,s.validpassword("sean", "233"));
		assertEquals(true,s.validplay());
		s.recordPlayed(60);
		s.recordPlayed(60);
		s.recordPlayed(60);;
		s.recordPlayed(60);
		assertEquals(false,s.validplay());
		s.reset();
		assertEquals(true,s.validplay());
	}

}
