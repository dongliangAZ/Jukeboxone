package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.*;

public class GUI extends JFrame{
	private JPanel JP;
	private JButton songOne;
	private JButton songTwo;
	private JTextField userID;
	private JTextField passwd;
	private JLabel songStatus;
	private JLabel u;
	private JLabel p;
	public GUI(){
		JP=new JPanel(new GridBagLayout());
		
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
		
		
		
		GridBagConstraints G = new GridBagConstraints();
		G.insets = new Insets(5, 5, 5, 5);
		
		userID = new JTextField("",10);
		u=new JLabel("Account Name");
		userID.setBackground(Color.white);
		//u.setFont(new Font("Serif", Font.PLAIN, 15));
		userID.setSize(100, 30); // width, height
		G.gridx = 150;
		G.gridy = 100;
		//userID.setLocation(150, 100);
		JP.add(userID,G);
		G.gridx = 100;
		G.gridy = 100;
		JP.add(u,G);
		
		passwd = new JTextField("",10);
		p=new JLabel("Password");
		passwd.setBackground(Color.white);
		//passwd.setFont(new Font("Serif", Font.PLAIN, 15));
		passwd.setSize(100, 30); // width, height
		G.gridx = 150;
		G.gridy = 150;
		//passwd.setLocation(250, 250);
		JP.add(passwd,G);
		G.gridx = 100;
		G.gridy = 150;
		JP.add(p,G);
		
		p=new JLabel("Status: 0 played, 25:00:00");
		JP.add(p);
		
		
		
		
	}
	
	public static void main(String[] args) {
		GUI jb=new GUI();
		jb.setLayout(new BorderLayout());
		jb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jb.setSize(500, 500);
		jb.setVisible(true);
	}
}