package model;
import java.time.LocalDate;
import java.util.*;

public class Song {
	private String name;
	private String Artist;
	private int Length;
	private String File;
	private int playtimes;
	
	private LocalDate today;
	private LocalDate tomorrow;
	private LocalDate time;
	
	public Song(String str, String singner, int length, String file) {
		playtimes=0;
		name= str;
		Artist = singner;
		Length = length;
		File = file;
		setdates();
		
	}
	
	
	
	private void setdates() {
		today=LocalDate.now();
		time=today;
		tomorrow=today;
		tomorrow.plusDays(1);	
	}



	public String getTitle(){
		
		return name;
	}
	
	public String getArtist(){
		return Artist;
	}
	
	
	public void recordPlayed() {
		playtimes+=1;
		if(playtimes==3){
			time.plusDays(1);
		}
	}
	
	public int getSongLength(){
		return Length;
	}
	
	public int getplaytimes(){
		return playtimes;
	}
	
	public String getFile(){
			return File;
	}
	
	public boolean validplay(){

		return (time.equals(today));
	}
	
	public void reset(){
		playtimes=0;
		time=today;
	}
	
	public static void main(String[] args) {

	}
}
