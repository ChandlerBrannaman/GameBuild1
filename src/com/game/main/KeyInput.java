package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	//Gets input when key is pressed
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		//Search through all game objects in linked list
		for (int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			//If ID is player, allow him to move with WASD
			if (tempObject.getID() == ID.Player){
				if (key == KeyEvent.VK_W) tempObject.setVelY(-5);
				if (key == KeyEvent.VK_A) tempObject.setVelX(-5);
				if (key == KeyEvent.VK_S) tempObject.setVelY(5);
				if (key == KeyEvent.VK_D) tempObject.setVelX(5);
			}
		}
		//Quickly terminate program
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	//What to do after keys that were pressed are no longer pressed
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		//Search through all game objects in linked list
		for (int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			//If id is player allow him to stop when keys arent pressed anymore
			if (tempObject.getID() == ID.Player){
				if (key == KeyEvent.VK_W) tempObject.setVelY(0);
				if (key == KeyEvent.VK_A) tempObject.setVelX(0);
				if (key == KeyEvent.VK_S) tempObject.setVelY(0);
				if (key == KeyEvent.VK_D) tempObject.setVelX(0);
			}
		}
	}
	
	
}
