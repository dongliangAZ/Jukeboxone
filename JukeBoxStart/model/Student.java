package model;

import java.time.LocalDate;
import java.util.*;

public class Student {
	private String name;
	private String password;
	private int songplayed;
	private int munites;
	
	private int currentDay;
	private ArrayList<Integer> playLog = new ArrayList<Integer>();
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
	
	public void recordPlayed(int i) {
		int day = LocalDate.now().getDayOfMonth();
		playLog.add(day);
		munites-=i;
	}

	public int getplaytimes(){
		int counter = 0;
		for (int i = 0; i < playLog.size(); i++) {
			if(playLog.get(i) == currentDay()){
				counter++;
			}
		}
		return counter;
		
	}
	
	private int currentDay() {
		
		return LocalDate.now().getDayOfMonth();
	}

	public void reset(){
		
	playLog=new ArrayList<Integer>();
	
	
	}
	
	//Return true if the psw and user name matches
	public boolean validpassword(String name, String pwd) {
		if (name.compareTo(name) == 0 && password.compareTo(pwd) == 0)
			return true;
		return false;
	}
	
	public boolean validplay(){
		return (getplaytimes()<=2)&&(munites>0);
	}
}
