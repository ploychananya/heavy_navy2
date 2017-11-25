package com.bossbaby.game;

import com.badlogic.gdx.utils.Array;

public class World {
		private Maze maze;
	    Pacman pacman;
	    Monster ship;
	    PacmanGame pacmanGame;
	    private int score;
	    public float delta = 30;
	    public float sec = 0;
	   // Array<Monster> monsters = new Array<Monster>();
	    
	
	 
	    World(PacmanGame pacmanGame) {
	        this.pacmanGame = pacmanGame;
	        maze = new Maze();
	        pacman = new Pacman(-30,220,this); //////-30
	        ship = new Monster(20,300,40,this);
	        registerDotEattenListener();
	        score = 0;
	      
	    }
	    
	    private void registerDotEattenListener() {
	        pacman.registerDotEattenListener(new Pacman.DotEattenListener() {
	            @Override
	            public void notifyDotEatten() {
	                score += 1;
	            }
	        });
	    }
	    
	    public void increaseScore() {
	        score += 1;
	    }
	    
	    public int getScore() {
	        return score;
	    }
	    
	    Pacman getPacman() {
	        return pacman;
	    }
	    Monster getShip() {
	    	return ship;
	    }
	    Maze getMaze() { //for worldrenderer
	        return maze;
	    }
	    
	    public void update(float delta) {
	    	sec++;
	    	if(sec%300==0) {
	        ship = new Monster(20,300,40,this);
	        }
	 	    ship.update();
	        pacman.update();
	        
	    }
	
}
