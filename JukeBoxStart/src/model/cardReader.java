package model;

public class cardReader {
	Student student;
	public boolean login(String username, String passwd, StudentDatabase sdb) {
		if (sdb.studentExists(username, passwd)) {
			student = sdb.getStudent(username+passwd);
			 if(student != null){
				 return true;
			 }
		}
		return false;

	}
	
	public void logout(){
		student = null;
	}
	
	public boolean loginQuery(){
		if(student != null){
			return true;
		} else {
			return false;
		}
	}

}
