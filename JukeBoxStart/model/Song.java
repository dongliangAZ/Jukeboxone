package model;
import java.time.LocalDate;
import java.util.ArrayList;


public class Song {
	private String name;
	private String Artist;
	private int Length;
	private String File;
	private int playtimes;
	
	private int currentDay;

	private ArrayList<Integer> playLog = new ArrayList<Integer>();
	
	public Song(String str, String singer, int length, String file) {
		playtimes=0;
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



	public void recordPlayed() {
		int day = LocalDate.now().getDayOfMonth();
		playLog.add(day);
	}
	
	public int getSongLength(){
		return Length;
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
	
	private Integer currentDay() {
		// TODO Auto-generated method stub
		return LocalDate.now().getDayOfMonth();
	}



	public boolean validplay(){
		if(getplaytimes()<=2){
			return true;
		}
		return false;
		
	}
	
	public void reset(){
		if(playLog.size() > 12){
			playLog.remove(0);
			playLog.remove(1);
			playLog.remove(2);
		}
	}
	
}