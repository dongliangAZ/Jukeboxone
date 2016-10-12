package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Song;
import model.SongLib;

public class SongLibTest {

	@Test
	public void test() {
		SongLib sb=new SongLib();
		Song s1=new Song("Kevin MacLeod","Danse Macabre",34,"songfiles/DanseMacabreViolinHook.mp3");
		Song s2=new Song("FreePlay Music","Determined Tumbao",20,"songfiles/DeterminedTumbao.mp3");
		sb.addsong(s1);
		assertEquals(true,sb.exit(s1));
		assertEquals(false,sb.exit(s2));
		sb.addsong(s2);
		assertEquals(true,sb.exit(s2));
	}

}
