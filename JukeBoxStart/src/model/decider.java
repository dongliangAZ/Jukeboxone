package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class decider {
	private int playtimes;
	private int currentDay;
	private ArrayList<Integer> playLog = new ArrayList<Integer>();

	public void recordPlayed() {
		int day = LocalDate.now().getDayOfMonth();
		playLog.add(day);
		reset();
	}

	public int getplaytimes() {
		int counter = 0;
		for (int i = 0; i < playLog.size(); i++) {
			if (playLog.get(i) == currentDay()) {
				counter++;
			}
		}
		return counter;

	}

	private int currentDay() {
		// TODO Auto-generated method stub
		return LocalDate.now().getDayOfMonth();
	}

	public boolean validplay(int song, int minutes) {
		if (getplaytimes() <= 2 && ((minutes - song) > 0)) {
			return true;
		}
		return false;
	}

	public boolean validplay() {
		if (getplaytimes() <= 2) {
			return true;
		}
		return false;

	}

	public void reset() {
		if (playLog.size() > 12) {
			playLog.remove(0);
			playLog.remove(1);
			playLog.remove(2);
		}
	}

}
