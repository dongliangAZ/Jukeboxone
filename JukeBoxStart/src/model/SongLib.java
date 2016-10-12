package model;
import java.util.*;
import javax.swing.*;

public class SongLib {
	private ArrayList<Song> songList;
	
	public SongLib(){
		songList = new ArrayList<Song>();
		
	}
	public void addsong(Song song){
		songList.add(song);
	}
	
	public boolean exit(Song s){
		if(songList.contains(s))
			return true;
		return false;
	}
	
}
