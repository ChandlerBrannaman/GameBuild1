package com.game.main;

import java.awt.Graphics;
import java.awt.Rectangle;
	//Abstract class for different objects to inherit, gives an Id, coords, and Velocities
public abstract class GameObject {
	//Class variables
	protected int x, y;
	protected ID id;
	protected int velX, velY;
	protected Handler handler;
	//Constructor
	public GameObject(int x, int y, ID id, Handler handler){
		this.x = x;
		this.y = y;
		this.id = id;
		this.handler = handler;
		handler.addObject(this);
	}
	//Getters and Setters
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();//Handles collision of rectangles
	
	public void setX (int x){
		this.x = x;
	}
	public void setY (int y){
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setID(ID id){
		this.id = id;
	}
	public ID getID(){
		return id;
	}
	public void setVelX(int velX){
		this.velX = velX;
	}
	public void setVelY(int velY){
		this.velY = velY;
	}
	public int getvelX(){
		return velX;
	}
	public int getvelY(){
		return velY;
	}
}
