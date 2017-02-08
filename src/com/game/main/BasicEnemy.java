package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
	//Basic enemy inheriting from Game Object
public class BasicEnemy extends GameObject{

	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		this.handler = handler;
		//set initial velocity
		velX = 3;
		velY = 3;
	}
	//What to do per tick
	public void tick() {	
		x += velX;
		y += velY;
		//Reverses velocity when it hits a border
		if (y <= 0 || y >= Game.HEIGHT - 48) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 24) velX *= -1;
	}
	//How to render the player
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}
}