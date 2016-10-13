package model;

import java.util.LinkedList;
import java.util.Queue;
import songplayer.EndOfSongEvent;
import songplayer.EndOfSongListener;
import songplayer.SongPlayer;

public class SongQueue {

	/**
	 * Play three songs assuming you close the modal dialog box. When run, you
	 * can actually have two songs playing at the same time.
	 * 
	 * @param args
	 *            An array of strings not often used by anybody
	 */
	static Queue<Song> playlist = new LinkedList<Song>();
	private static boolean running = false;
 
	public boolean addToPlaylist(Song song) {
		if (song.validplay()) {
			song.recordPlayed();
			playlist.add(song);
			return true;
		}
		return false;
	}

	public static void playNext() {
		ObjectWaitingForSongToEnd waiter = new ObjectWaitingForSongToEnd();
		running = true;
		Song song = playlist.poll();
		SongPlayer.playFile(waiter, song.getFile());
		// TimeUnit.SECONDS.sleep(song.getSongLength());

	}

	public boolean currentPlaying() {
		if (running) {
			return true;
		}
		return false;
	}

	public static boolean songInQueue() {
		if (!playlist.isEmpty())
			return true;
		return false;

	}

	public int Size() {
		return playlist.size();
	}

	/**
	 * This inner class allows us to have an callback function that receive a
	 * songFinishedPlaying message whenever an audio file has been played.
	 * 
	 * Note: this is a static class because it is being called from main, which
	 * is a static context. If you are using a GUI, you won't need static
	 */
	private static class ObjectWaitingForSongToEnd implements EndOfSongListener {

		public void songFinishedPlaying(EndOfSongEvent eosEvent) {
			running = false;
			System.out.println("Finished " + eosEvent.fileName() + ", "
					+ eosEvent.finishedDate() + ", " + eosEvent.finishedTime());
			if (songInQueue()) {
				playNext();
			}
		}
	}
}