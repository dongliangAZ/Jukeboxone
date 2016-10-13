package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.*;

public class GUI extends JFrame{
	private JPanel JP;
	private JButton songOne;
	private JButton songTwo;
	private JTextField userID;
	private JTextField passwd;
	public GUI(){
		JP=new JPanel();
		
		songOne = new JButton("Select song 1");
		songTwo = new JButton("Select song 2");
		
		songOne.setSize(150, 30);
		songOne.setFont(new Font(null, Font.BOLD, 15));
		songOne.setLocation(10,0);
		this.add(songOne);
		
		songTwo.setSize(150, 30);
		songTwo.setFont(new Font(null, Font.BOLD, 15));
		songTwo.setLocation(10,35);
		this.add(songTwo);
				
		
		JP.setSize(360, 200);
		JP.setBackground(Color.WHITE);
		JP.setLocation(70, 150);
		this.add(JP,BorderLayout.CENTER);
		
		userID = new JTextField();
		userID.setEditable(true);
		userID.setBackground(Color.white);
		userID.setFont(new Font("Serif", Font.PLAIN, 15));
		userID.setSize(150, 30); // width, height
		userID.setLocation(250, 200);
		add(userID);
		
		passwd = new JTextField();
		passwd.setEditable(true);
		passwd.setBackground(Color.white);
		passwd.setFont(new Font("Serif", Font.PLAIN, 15));
		passwd.setSize(150, 30); // width, height
		passwd.setLocation(250, 250);
		add(passwd);
		
		
	}
	
	public static void main(String[] args) {
		GUI jb=new GUI();
		jb.setLayout(new BorderLayout());
		jb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jb.setSize(500, 500);
		jb.setVisible(true);
	}
}