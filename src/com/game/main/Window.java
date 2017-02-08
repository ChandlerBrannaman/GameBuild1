package com.game.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas{
	
	private static final long serialVersionUID = -1478604005915452565L;
	//Constructor that creates a new window
	public Window(int width, int height, String title, Game game){
		JFrame frame = new JFrame(title);
		//Set dimensions of window based off parameters
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);//Can it be resized?
		frame.setLocationRelativeTo(null);//Centers window
		frame.setVisible(true);//Can it be seen
		frame.add(game);//What is seen in frame?
		//Start game after it is being displayed in frame
		game.start();	
	}
}
