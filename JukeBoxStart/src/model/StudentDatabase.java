package model;

import java.util.*;

import javax.swing.*;

public class StudentDatabase {
	private TreeMap<String, Student> List;

	public StudentDatabase() {
		List = new TreeMap<String, Student>();

	}

	public void addStudent(String key, Student student) {
		List.put(key, student);
	}

	public Student getStudent(String key) {
		return List.get(key);
	}

	public boolean studentExists(String username, String passwd) {
		String key = username+passwd;
		if (List.containsKey(key))
			return true;
		return false;
	}

}
