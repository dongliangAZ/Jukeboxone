package tests;

import static org.junit.Assert.*;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import model.Song;
import model.SongLib;
import model.SongQueue;

import org.junit.Test;

public class SongQueueTest {

	@Test
	public void test() throws InterruptedException {
		int index = 0;
		Scanner keyboard = new Scanner(System.in);
		SongLib sl = new SongLib();
		SongQueue sq = new SongQueue();
		Song s1 = new Song("Kevin MacLeod", "Danse Macabre", 34,
				"songfiles/DanseMacabreViolinHook.mp3");
		Song s2 = new Song("FreePlay Music", "Determined Tumbao", 20,
				"songfiles/DeterminedTumbao.mp3");
		Song s3 = new Song("FreePlay Music", "Determined Tumbao", 20,
				"songfiles/spacemusic.au");
		Song s4 = new Song("FreePlay Music", "Determined Tumbao", 20,
				"songfiles/flute.aif");
		sl.addsong(s1);
		sl.addsong(s2);
		sl.addsong(s3);
		sl.addsong(s4);
		keyboard.nextLine();
		String exit = "";
		while (keyboard.hasNext()&& !exit.equals("Kill")) {
			index++;
			if (index >= sl.Size()) {
				index = 0;
			}
			Song song = sl.getSong(index);
			System.out.println(song.getTitle());
			sq.addToPlaylist(song);
			// Play yet another song, quite possibly while another is playing
			if (!sq.currentPlaying()) {

				sq.playNext();

			} else {
				System.out.println("Setting " + song.getTitle() + " "
						+ sq.Size());
			}
			exit = keyboard.nextLine();
		}
	}
}
