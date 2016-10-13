package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Student;
import model.StudentDatabase;

public class StudentDatabaseTest {

	@Test
	public void test() {
		StudentDatabase sd=new StudentDatabase();
		Student a = new Student("Chris", "1");
		Student b = new Student("Devon", "22");
		Student c = new Student("River", "333");
		Student d = new Student("Ryan", "4444");
		Student e = new Student("Sean", "233");
		Student f = new Student("Ryan", "444");
		sd.addStudent(a.getUsername()+a.getPassword(), a);
		sd.addStudent(b.getUsername()+b.getPassword(), b);
		sd.addStudent(c.getUsername()+c.getPassword(), c);
		sd.addStudent(d.getUsername()+d.getPassword(), d);
		assertFalse(sd.studentExists("Sean", "233"));
		assertEquals(true,sd.studentExists("Chris","1"));
		assertTrue(sd.studentExists("Devon","22"));
		assertTrue(sd.studentExists("River","333"));
		assertTrue(sd.studentExists("Ryan","4444"));
		
		assertFalse(sd.studentExists("Ryan","444"));
	}

}
