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
		/* ___________________________Set_UP_DATABASE_Start________________________________ */
		StudentDatabase sd = new StudentDatabase();
		int index = 0;
		Scanner keyboard = new Scanner(System.in);
		SongLib sl = new SongLib();
		SongQueue sq = new SongQueue();
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
		Song s1 = new Song("FreePlay Music", "Determined Tumbao", 20,
				"songfiles/spacemusic.au");
		Song s2 = new Song("FreePlay Music", "Determined Tumbao", 20,
				"songfiles/flute.aif");
		sl.addsong(s1);
		sl.addsong(s2);

		/* ___________________________Set_UP_DATABASE_END__________________________________ */

		while (keyboard.next().equals("quitProgram")) {
			Student currentUser = a;

			/* ______________________________Login_Attempt_Start__________________________________ */
			/* ______________________________Login_Attempt_End____________________________________ */

			/* ___________________________Playing_Songs________________________________ */
			String exit = "";
			while (keyboard.hasNext() && !keyboard.nextLine().equals("logout")) {
				String userRequest = keyboard.next();
				System.out.println("Choose 1 or 2");
				Song song = sl.getSong(Integer.parseInt(userRequest));
				System.out.println(song.getTitle());
				if (sq.addToPlaylist(song)) {
					//userCurrent
					if (!sq.currentPlaying()) {
						sq.playNext();
					} else {
						System.out.println("Adding " + userRequest
								+ " to queue." + sq.Size() + " songs in queue");
					}
				}
			}
		}
	}
}
