package model;

import java.util.*;

public class Student {
	private String name;
	private String password;
	private int songplayed;
	private int munites;

	public Student(String str, String pwd) {
		name = str;
		password = pwd;
		songplayed = 0;
		munites=1500;
	}

	public String getUsername() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	public int getmuniteLeft() {
		return munites;
	}
	
	public void playasong(int i){
		songplayed++;
		munites-=i;
	}

	
	public int getplaytimes() {
		return songplayed;
	}
	
	public void resettoday(){
		songplayed = 0;
	}
	
	//Return true if the psw and user name matches
	public boolean validpassword(String name, String pwd) {
		if (name.compareTo(name) == 0 && password.compareTo(pwd) == 0)
			return true;
		return false;
	}
	
	public boolean validplay(){
		return (songplayed<=3)&&(munites>0);
	}
}
