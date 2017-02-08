package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	//Don't need to initialize health
	public static int HEALTH = 100;
	
	public void tick(){
		HEALTH = Game.clamp(HEALTH, 0, 100);
	}
	public void render(Graphics g){
		//Health Bar on top left corner
		g.setColor(Color.red);
		g.fillRect(15, 15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		//Change health message based off health value
		if (HEALTH > 0){
		g.drawString("HEALTH", 75, 35);
		g.drawString(String.valueOf(HEALTH), 125, 35);
		}else{
			g.drawString("You dead homie", 75, 35);
		}
	}
}
