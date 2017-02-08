package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{
	//Constructor for a new player
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);	
		this.handler = handler;
	}
	//What happens to this player after a tick
	public void tick(){
		x += velX;
		y += velY;
		//Stops player from going off screen
		x = Game.clamp(x, 0,Game.WIDTH - 38);
		y = Game.clamp(y, 0, Game.HEIGHT - 61);
		//Check for collisions every tick
		collision();
	}
	//How to render this player
	public void render(Graphics g) {
			if (id == ID.Player) g.setColor(Color.BLUE);
			g.fillRect(x, y, 32, 32);
	}
	//Draws a "collision box" around the object essentially
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	//Method to test if the player collides with an object
	private void collision(){
		for (int i = 0; i < handler.object.size(); i++){
			//Make a temp object for each object our game has
			GameObject tempObject =  handler.object.get(i);
			//Test to see if any are enemies
			if (tempObject.getID() == ID.BasicEnemy){
				//If they are an enemy and their rectangle intersects players, take away heakth
				if (getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 1;
				}
			}		
		}
	}
	
}
