package com.bossbaby.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer{
	private Texture pacmanImg;
	private Texture shipImg;
	private MazeRenderer mazeRenderer;
	PacmanGame pacmanGame;
	Pacman pacman;
	public static final int BLOCK_SIZE = 40;
	private BitmapFont font;
	
	
	World world;
	//Pacman pacman = world.getPacman();
	SpriteBatch batch;
	
	//SpriteBatch batch;
	
	public WorldRenderer(PacmanGame pacmanGame, World world) {
        this.pacmanGame = pacmanGame;
        this.world = world;
        mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
        
        batch = pacmanGame.batch;
        font = new BitmapFont();
        
 
        
        pacmanImg = new Texture("pacman.png");
        shipImg = new Texture("ship1.png");
      
    }

	public void render(float delta) {
	   //SpriteBatch batch = pacmanGame.batch;
       batch.begin();
       mazeRenderer.render(delta);
       //Vector2 posi = world.getPacman().getPosition();
       //batch.draw(pacmanImg,posi.x,posi.y);
       SpriteBatch batch = pacmanGame.batch;
       Vector2 pos = world.getPacman().getPosition();
       Vector2 pos_ship = world.getShip().getPosition();
       //batch.begin();
       batch.draw(pacmanImg, pos.x - BLOCK_SIZE/2, PacmanGame.HEIGHT - pos.y - BLOCK_SIZE/2);
       batch.draw(shipImg, pos_ship.x - BLOCK_SIZE/2, PacmanGame.HEIGHT - pos_ship.y - BLOCK_SIZE/2);
       //batch.end();
       font.draw(batch, "" + world.getScore(), 700, 60);
       batch.end();
    }    

}
