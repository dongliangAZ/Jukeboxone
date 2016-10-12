package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.*;

public class GUI extends JFrame{
	private JPanel JP;
	private JButton one;
	private JButton two;

	public GUI(){
		JP=new JPanel();
		
		one = new JButton("Select song1");
		two = new JButton("Select song2");
		
		one.setSize(150, 30);
		one.setFont(new Font(null, Font.BOLD, 15));
		one.setLocation(10,0);
		this.add(one);
		
		two.setSize(150, 30);
		two.setFont(new Font(null, Font.BOLD, 15));
		two.setLocation(10,35);
		this.add(two);
		
		
		
		JP.setSize(360, 200);
		JP.setBackground(Color.WHITE);
		JP.setLocation(70, 150);
		this.add(JP,BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		GUI jb=new GUI();
		jb.setLayout(new BorderLayout());
		jb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jb.setSize(500, 500);
		jb.setVisible(true);
	}
}
