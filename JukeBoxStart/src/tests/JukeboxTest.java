package tests;

import static org.junit.Assert.*;

import java.util.Scanner;

import model.Song;
import model.SongLib;
import model.SongQueue;
import model.Student;
import model.StudentDatabase;

import org.junit.Test;

public class JukeboxTest {

	@Test
	public void fullRunJukeboxTest() {
		StudentDatabase sd = new StudentDatabase();
		Student a = new Student("Chris", "1");
		Student b = new Student("Devon", "22");
		Student c = new Student("River", "333");
		Student d = new Student("Ryan", "4444");
		Student e = new Student("Sean", "233");
		Student f = new Student("Ryan", "444");
		sd.addStudent(a.getUsername() + a.getPassword(), a);
		sd.addStudent(b.getUsername() + b.getPassword(), b);
		sd.addStudent(c.getUsername() + c.getPassword(), c);
		sd.addStudent(d.getUsername() + d.getPassword(), d);
		sd.addStudent(e.getUsername() + e.getPassword(), e);
		sd.addStudent(f.getUsername() + f.getPassword(), f);
		assertFalse(sd.studentExists("Sean", "233"));
		assertEquals(true, sd.studentExists("Chris", "1"));
		assertTrue(sd.studentExists("Devon", "22"));
		assertTrue(sd.studentExists("River", "333"));
		assertTrue(sd.studentExists("Ryan", "4444"));

		assertFalse(sd.studentExists("Ryan", "444"));

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
		while (keyboard.hasNext() && !exit.equals("Kill")) {
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
