package model;

public class cardReader {
	Student student;

	public Student login(String username, String passwd, StudentDatabase sdb) {
		if (sdb.studentExists(username, passwd)) {
			Student student = sdb.getStudent(username + passwd);
			return student;
		} else {
			return null;
		}

	}

	public void logout() {
		student = null;
	}

	public boolean loginQuery() {
		if (student != null) {
			return true;
		} else {
			return false;
		}
	}

}
