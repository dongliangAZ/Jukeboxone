package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Song;
import model.SongLib;
import model.SongQueue;
import model.Student;
import model.StudentDatabase;
import model.cardReader;
import model.decider;

public class GUI extends JFrame {
	private String ID;
	private String pwd;

	private JPanel JP;
	private JPanel jp;

	private JButton songOne;
	private JButton songTwo;
	private JButton out;
	private JButton in;

	private JTextField userID;
	private JTextField passwd;
	private JLabel songStatus;
	private JLabel u;
	private JLabel p;

	private SongLib Songs;
	private StudentDatabase StudentList;
	private SongQueue playlist;
	private cardReader reader;

	// private decider deicide;

	public GUI() {
		JP = new JPanel(new GridBagLayout());
		jp = new JPanel(new GridBagLayout());

		songOne = new JButton("Select song 1");
		songTwo = new JButton("Select song 2");
		out = new JButton("Sign out");
		in = new JButton("Login");

		songOne.setSize(150, 30);
		songOne.setFont(new Font(null, Font.BOLD, 15));
		songOne.setLocation(10, 0);
		this.add(songOne);

		songTwo.setSize(150, 30);
		songTwo.setFont(new Font(null, Font.BOLD, 15));
		songTwo.setLocation(10, 35);
		this.add(songTwo);

		JP.setSize(360, 100);
		JP.setBackground(Color.WHITE);
		JP.setLocation(70, 150);
		this.add(JP, BorderLayout.CENTER);
		jp.setSize(360, 100);
		jp.setBackground(Color.WHITE);
		jp.setLocation(70, 250);
		this.add(jp, BorderLayout.SOUTH);

		GridBagConstraints G = new GridBagConstraints();
		G.insets = new Insets(5, 5, 5, 5);

		userID = new JTextField("", 10);
		u = new JLabel("Account Name");
		userID.setBackground(Color.white);
		// u.setFont(new Font("Serif", Font.PLAIN, 15));
		userID.setSize(50, 15); // width, height
		G.gridx = 75;
		G.gridy = 50;
		// userID.setLocation(150, 100);
		JP.add(userID, G);
		G.gridx = 50;
		G.gridy = 50;
		JP.add(u, G);

		passwd = new JTextField("", 10);
		p = new JLabel("Password");
		passwd.setBackground(Color.white);
		// passwd.setFont(new Font("Serif", Font.PLAIN, 15));
		passwd.setSize(50, 15); // width, height
		G.gridx = 75;
		G.gridy = 75;
		// passwd.setLocation(250, 250);
		JP.add(passwd, G);
		G.gridx = 50;
		G.gridy = 75;
		JP.add(p, G);

		out.setSize(180, 30);
		out.setFont(new Font(null, Font.BOLD, 17));
		G.gridx = 0;
		G.gridy = 0;
		jp.add(out, G);
		in.setSize(180, 30);
		in.setFont(new Font(null, Font.BOLD, 17));
		G.gridx = 180;
		G.gridy = 0;
		jp.add(in, G);

		songStatus = new JLabel("Status: 0 played, 25:00:00");
		G.gridx = 150;
		G.gridy = 40;
		jp.add(songStatus, G);

		setmodels();
		Actions();

	}

	private void Actions() {
		songOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		songTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		in.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		out.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		userID.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ID = userID.getText();
			}
		});

		passwd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pwd = passwd.getText();
			}
		});
	}

	private void setmodels() {
		Songs = new SongLib();
		Song s1 = new Song("Unknown", "Space Music", 6,
				"songfiles/spacemusic.au");
		Song s2 = new Song("Sun Microsystems", "Flute", 6,
				"songfiles/flute.aif");
		Songs.addsong(s1);
		Songs.addsong(s2);
		
		
		
		StudentList = new StudentDatabase();
		StudentList.addStudent( new Student("Chris", "1"));
		StudentList.addStudent( new Student("Devon", "22"));
		StudentList.addStudent( new Student("River", "333"));
		StudentList.addStudent( new Student("Ryan", "4444"));
		
		playlist = new SongQueue();
		reader = new cardReader();
		
	}

	public static void main(String[] args) {
		GUI jb = new GUI();
		jb.setLayout(new BorderLayout());
		jb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jb.setSize(500, 500);
		jb.setVisible(true);

	}
}