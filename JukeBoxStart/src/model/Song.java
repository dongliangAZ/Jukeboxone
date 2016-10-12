package model;

import java.util.*;

public class Song {
	private String name;
	private String Artist;
	private int Length;
	private String File;
	private int playtimes;
	
	
	
	public Song(String str, String singner, int length, String file) {
		playtimes=0;
		name= str;
		Artist = singner;
		Length = length;
		File = file;
		
	}
	
	
	public String getTitle(){
		
		return name;
	}
	
	public String getArtist(){
		return Artist;
	}
	
	//The play times increase 1 when this is played
	public void recordPlayed() {
		playtimes+=1;
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

		return (playtimes<=3);
	}
	
	public void reset(){
		playtimes=0;
	}
}
