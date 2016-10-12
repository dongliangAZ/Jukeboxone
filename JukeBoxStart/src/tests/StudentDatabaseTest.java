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
		sd.addStudent(a);
		sd.addStudent(b);
		sd.addStudent(c);
		sd.addStudent(d);
		assertFalse(sd.Studentexit("Sean","233"));
		assertEquals(true,sd.Studentexit("Chris","1"));
		assertTrue(sd.Studentexit("Devon","22"));
		assertTrue(sd.Studentexit("River","333"));
		assertTrue(sd.Studentexit("Ryan","4444"));
		
		assertFalse(sd.Studentexit("Ryan","444"));
	}

}
