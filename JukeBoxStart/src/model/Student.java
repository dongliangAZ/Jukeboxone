package model;

import java.util.*;

public class Student {
	private String name;
	private String password;
	private int songplayed;
	private int minutes;
	private decider dc = new decider();

	public Student(String str, String pwd) {
		name = str;
		password = pwd;
		minutes=1500;
	}

	public String getUsername() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	public int getMinutesLeft() {
		return minutes;
	}
	
	public void minutesAdjuster(int songLength){
		minutes-=songLength;
	}

	
	public int getplaytimes() {
		return dc.getplaytimes();
	}
	
	//Return true if the psw and user name matches
	public boolean validpassword(String name, String pwd) {
		if (name.compareTo(name) == 0 && password.compareTo(pwd) == 0)
			return true;
		return false;
	}
	
	public boolean validplay(int song){
		return dc.validplay(song, minutes);
	}
}