package tests;

import static org.junit.Assert.*;

import java.util.Scanner;

import model.Song;
import model.SongLib;
import model.SongQueue;
import model.Student;
import model.StudentDatabase;
import model.cardReader;

import org.junit.Test;

public class JukeboxTest {

	@Test
	public void fullRunJukeboxTest() {
		/* ___________________________Set_UP_DATABASE_Start________________________________ */
		StudentDatabase sd = new StudentDatabase();
		int index = 0;
		Scanner keyboard = new Scanner(System.in);
		cardReader cr = new cardReader();
		SongLib sl = new SongLib();
		SongQueue sq = new SongQueue();
		Student a = new Student("Chris", "1");
		Student b = new Student("Devon", "22");
		Student c = new Student("River", "333");
		Student d = new Student("Ryan", "4444");
		Student e = new Student("Sean", "233");
		Student f = new Student("Ryan", "444");
		sd.addStudent(a);
		sd.addStudent(b);
		sd.addStudent(c);
		sd.addStudent(d);
		Song s1 = new Song("FreePlay Music", "Determined Tumbao", 20,
				"songfiles/spacemusic.au");
		Song s2 = new Song("FreePlay Music", "Determined Tumbao", 20,
				"songfiles/flute.aif");
		sl.addsong(s1);
		sl.addsong(s2);

		/* ___________________________Set_UP_DATABASE_END__________________________________ */

		do {
			System.out.print("Please Type Kill to Kill program:");
			

			/* ______________________________Login_Attempt_Start__________________________________ */
			System.out.println("Username:");
			String user = keyboard.next();
			System.out.println("Passwd:");
			String passwd = keyboard.next();
			Student currentUser = cr.login(user, passwd, sd);
			
			
			/* ______________________________Login_Attempt_End____________________________________ */

			/* ___________________________Playing_Songs________________________________ */
			String exit = "";
			Song song = null;
			while (keyboard.hasNext() && !exit.equals("Kill")) {
				index++;
				if (index >= sl.Size()) {
					index = 0;
				}
				song = sl.getSong(index);

				if (sq.addToPlaylist(song)) {
					System.out.println(song.getTitle());
					// Play yet another song, quite possibly while another is
					// playing
					if (!sq.currentPlaying()) {

						sq.playNext();

					} else {
						System.out.println("Setting " + song.getTitle() + " "
								+ sq.Size());
					}
				} else {
					System.out.println("Song has reached its day limit");
				}
				exit = keyboard.nextLine();
			}
		} while (!keyboard.next().equals("quitProgram"));
	}
}
