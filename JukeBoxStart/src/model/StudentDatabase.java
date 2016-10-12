package model;

import java.util.*;
import javax.swing.*;

public class StudentDatabase {
	private ArrayList<Student> List;

	public StudentDatabase() {
		List = new ArrayList<Student>();

	}

	public boolean Studentexit(String str, String s) {
		for(int i=0;i<List.size();i++)
		if (List.get(i).getUsername().equals(str)&&List.get(i).getPassword().equals(s))
			return true;
		return false;
	}

	public void addStudent(Student s) {
		List.add(s);
	}

}
