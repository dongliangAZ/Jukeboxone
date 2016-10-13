package songPlayerDemo;

/**
 * This program allows you to play a song every time the button is
 * clicked.  One other GUI components was added to show the GUI 
 * still works even though 1, 2, 3, 4, or more songs are playing
 * The end of song listener simply prints the file name.
 * 
 *   // 1) Create a listener
 *   ObjectWaitingForSongToEnd waiter = new ObjectWaitingForSongToEnd();
 *   // 2) Call a static method that passes the listener and the file name as arguments
 *   SongPlayer.playFile(waiter,  "/.songfiles/tada.wav");
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import model.Song;
import model.SongLib;
import model.SongQueue;
import songplayer.EndOfSongEvent;
import songplayer.EndOfSongListener;
import songplayer.SongPlayer;

public class PlayASongWithEachButtonClick extends JFrame {

	/**
	 * This program allows you to play a song every time the button is clicked.
	 */
	public static void main(String[] args) {
		JFrame smallGUI = new PlayASongWithEachButtonClick();
		smallGUI.setVisible(true);
	}

	// The sound files must be in the project under folder /songfiles/
	// vaseDir will be the absolute folder no matter where this project moves
	// to.
	public static String baseDir = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "songfiles"
			+ System.getProperty("file.separator");

	private JButton button = new JButton("Play a song");

	private JTextField textField = new JTextField(
			"File names here, but can be edited to show GUI still works");

	public PlayASongWithEachButtonClick() {
		// lay out GUI
		this.setSize(600, 120);
		this.setLocation(210, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		button.setSize(120, 30);
		button.setLocation(10, 5);
		button.addActionListener(new ButtonListener());
		add(button);

		textField.setSize(590, 30);
		textField.setLocation(5, 50);
		textField.setBackground(Color.PINK);
		add(textField);

		// set up model
		populateList();
		index--;
	}

	private int index;
	private SongQueue que = new SongQueue();
	private SongLib sl = new SongLib();

	public void populateList() {
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
	}

	private class ButtonListener implements ActionListener {

		// Play one of the songs stored in the file names shown in populate
		// list in a circular buffer. playFile begins each song in a new Thread
		// so many can play at once. It is up to you to figure out what to do
		// when each songs ends. The listener above only prints the file name
		// passed back from the object that just finished playing that song.
		public void actionPerformed(ActionEvent e) {
			index++;
			if (index >= sl.Size())
				index = 0;
			Song song = sl.getSong(index);
			textField.setText(song.getTitle());
			que.addToPlaylist(song);
			// Play yet another song, quite possibly while another is playing
			if (!que.currentPlaying()) {

				que.playNext();

			} else {
				textField.setText("Setting " + song.getTitle() + " " + que.Size());
			}

		}
	}

	/**
	 * This inner class allows us to have an callback function that receive a
	 * songFinishedPlaying message whenever an audio file has been played.
	 * 
	 * Note: this is a static class because it is being called from main, which
	 * is a static context. If you are using a GUI, you won't need static
	 */

	private static class SongWaiter implements EndOfSongListener {

		public void songFinishedPlaying(EndOfSongEvent eosEvent) {
			System.out.println("Finished " + eosEvent.fileName() + ", "
					+ eosEvent.finishedDate() + ", " + eosEvent.finishedTime());

		}
	}

}