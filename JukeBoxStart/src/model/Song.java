package model;
import java.time.LocalDate;
import java.util.ArrayList;


public class Song {
	private String name;
	private String Artist;
	private int Length;
	private String File;
	private decider dc = new decider();
	
	public Song(String str, String singer, int length, String file) {
		name= str;
		Artist = singer;
		Length = length;
		File = file;
	}
	
	
	
	public String getTitle(){
		return name;
	}
	
	public String getArtist(){
		return Artist;
	}
	
	public String getFile(){
			return File;
	}

	
	public int getSongLength(){
		return Length;
	}



	public boolean validplay() {
		// TODO Auto-generated method stub
		return dc.validplay();
	}



	public void recordPlayed() {
		dc.recordPlayed();
		
	}



	public int getplaytimes() {
		// TODO Auto-generated method stub
		return dc.getplaytimes();
	}



	
	




	
	
	
	
}