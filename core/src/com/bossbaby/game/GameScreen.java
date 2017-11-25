package com.bossbaby.game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;


public class GameScreen extends ScreenAdapter {
	//private Pacman pacman;
	//private int x;
    //private int y;
 
	World world;
	//Pacman pacman = world.getPacman();//////////////////////swich
	WorldRenderer worldRenderer;
	PacmanGame pacmanGame;
	
	
    public GameScreen(PacmanGame pacmanGame) {
        
    	this.pacmanGame = pacmanGame;
    	
        //pacmanImg = new Texture("pacman.png");
        
        world = new World(pacmanGame);
        worldRenderer = new WorldRenderer(pacmanGame,world);
        
        //pacman = new Pacman(100,100);
        //x=100;
        //y=100;
    }
   
 


    public void render(float delta) {
        
        
		update(delta);
        /*System.out.println("Hello " + delta);
        SpriteBatch batch = pacmanGame.batch;
        batch.begin();
        
        Vector2 pos = pacman.getPosition();
        batch.draw(pacmanImg, pos.x, pos.y);*/
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        worldRenderer.render(delta);
        
        //batch.end();
    }
    public void update(float delta) {
    	updatePacmanDirection();
    	/*Pacman pacman = world.getPacman();
    	if(Gdx.input.isKeyPressed(Keys.LEFT)) {
    		pacman.setNextDirection(Pacman.DIRECTION_LEFT);
        }
    	else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	pacman.setNextDirection(Pacman.DIRECTION_RIGHT);
        }    
    	else if(Gdx.input.isKeyPressed(Keys.UP)) {
        	pacman.setNextDirection(Pacman.DIRECTION_UP);
        }    
    	else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
        	pacman.setNextDirection(Pacman.DIRECTION_DOWN);
        }
        else {
        	pacman.setNextDirection(Pacman.DIRECTION_STILL);
        }*/
     
        world.update(delta);
    }
    private void updatePacmanDirection() {
    	Pacman pacman = world.getPacman();
    	if(Gdx.input.isKeyPressed(Keys.LEFT)) {
    		pacman.setNextDirection(Pacman.DIRECTION_LEFT);
        }
    	else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	pacman.setNextDirection(Pacman.DIRECTION_RIGHT);
        }    
    	else if(Gdx.input.isKeyPressed(Keys.UP)) {
        	pacman.setNextDirection(Pacman.DIRECTION_UP);
        }    
    	else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
        	pacman.setNextDirection(Pacman.DIRECTION_DOWN);
        }
        else {
        	pacman.setNextDirection(Pacman.DIRECTION_STILL);
        }
     
    }
}
