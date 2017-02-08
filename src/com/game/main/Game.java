package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
	//Variables and Constants
	private static final long serialVersionUID = -6680875776510531796L;
	public static final int WIDTH = 900, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	//Actual Game Method, Builds the JFrame and adds objects
	public Game(){
		//create instance of Handler class
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		//Creates window and calls game.start method
		new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);	
		//Gotta make that HUD youknowwhatimsaying
		hud = new HUD();
		//Focus's JFrame initially so that user doesn't have to click first
		this.setFocusable(true);
		//Objects
		new Player(WIDTH/2 - 32, HEIGHT/2 - 32, ID.Player, this.handler);
		new BasicEnemy(WIDTH/2 - 32, HEIGHT/2 - 32, ID.BasicEnemy, this.handler);
		
	}
	//Starts the thread and runs game
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//Stolen code method of keeping track of time
	public void run()
    {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while(delta >=1)
                            {
                                tick();
                                delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                                System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
        }
                stop();
    }
	//Calls handler class every nanosecond
	private void tick(){
		handler.tick();
		hud.tick();
	}
	//Renders the objects every tick by calling the handler class
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		//Sets color of JFrame initally
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//Draw all objects
		handler.render(g);
		hud.render(g); //hud below render so the hud is on top
		g.dispose(); //Gets rid of all existing images
		bs.show(); //Starts new images next tick
	}
	//Maintains player pos in screen
	public static int clamp(int var, int min, int max){
		if ( var >= max)
			return var = max;
		else if ( var <= min)
			return var = min;
		else
			return var;
	}
	
	
	//Main method, creates new instance of Game class
	public static void main(String[] args) {
		new Game();
	}
}
