package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Song;


public class SongTest {

	@Test
	public void test() {
		Song s=new Song("Danse Macabre", "Kevin MacLeod", 34, "songfiles/DanseMacabreViolinHook.mp3");
		assertEquals("Danse Macabre",s.getTitle());
		assertEquals("Kevin MacLeod",s.getArtist());
		assertEquals("songfiles/DanseMacabreViolinHook.mp3",s.getFile());
		assertEquals(0,s.getplaytimes());
		assertEquals(34,s.getSongLength() );
		assertEquals(true,s.validplay());
		s.recordPlayed();
		assertEquals(1,s.getplaytimes());
		s.recordPlayed();
		s.recordPlayed();
		assertEquals(true,s.validplay());
		s.recordPlayed();
		assertEquals(false,s.validplay());
	}



}
