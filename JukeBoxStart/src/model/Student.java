package model;

import java.time.LocalDate;
import java.util.*;

public class Student {
	private String name;
	private String password;
	private int songplayed;
	private int munites;

	private LocalDate today;
	private LocalDate tomorrow;
	private LocalDate time;
	
	public Student(String str, String pwd) {
		name = str;
		password = pwd;
		songplayed = 0;
		munites=1500;
		setdates();
	}
	
	private void setdates() {
		today=LocalDate.now();
		time=today;
		tomorrow=today;
		tomorrow.plusDays(1);	
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
		if(songplayed==3){
			time.plusDays(1);
		}
	}

	
	public int getplaytimes() {
		return songplayed;
	}
	
	public void resettoday(){
		songplayed = 0;
		time=today;
	}
	
	//Return true if the psw and user name matches
	public boolean validpassword(String name, String pwd) {
		if (name.compareTo(name) == 0 && password.compareTo(pwd) == 0)
			return true;
		return false;
	}
	
	public boolean validplay(){
		return ((time==today)&&(munites>0));
	}
}
