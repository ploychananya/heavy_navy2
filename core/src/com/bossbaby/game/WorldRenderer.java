package com.bossbaby.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer{
	private Texture pacmanImg;
	private Texture shipImg;
	private Texture peopleImg;
	private Texture kolImg;
	private MazeRenderer mazeRenderer;
	PacmanGame pacmanGame;
	Pacman pacman;
	public static final int BLOCK_SIZE = 40;
	private BitmapFont font;
	
	
	World world;
	Monster monster;
	//Pacman pacman = world.getPacman();
	SpriteBatch batch;
	//Sprite sprite;
	//private Sprite sprite;
	
	//SpriteBatch batch;
	
	public WorldRenderer(PacmanGame pacmanGame, World world) {
        this.pacmanGame = pacmanGame;
        this.world = world;
        mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
       // kol = new MazeRenderer(pacmanGame.batch, world.getMaze());
        batch = pacmanGame.batch;
        font = new BitmapFont();
        
 
        
        pacmanImg = new Texture("pacman.png");
        shipImg = new Texture("ship1.png");
        peopleImg = new Texture("people.png");
        kolImg = new Texture("kol_button.png");
        //shipImg = new Texture(Gdx.files.internal("ship1.png"));
        //sprite = new Sprite(shipImg);
       
        
      
    }

	public void render(float delta) {
	   //SpriteBatch batch = pacmanGame.batch;
	   
       batch.begin();
       mazeRenderer.render(delta);
       
       //Vector2 posi = world.getPacman().getPosition();
       //batch.draw(pacmanImg,posi.x,posi.y);
       SpriteBatch batch = pacmanGame.batch;
       Vector2 pos = world.getPacman().getPosition();
       
       
       for(int i=0;i<=(world.getMonster().size()-1);i++) {
       		Vector2 pos_ship = world.getMonster().get(i).getPosition();
            batch.draw(shipImg, pos_ship.x - BLOCK_SIZE/2,  PacmanGame.HEIGHT - pos_ship.y - BLOCK_SIZE/2) ;
       }
       for(int i=0;i<=(world.getPeople().size()-1);i++) {
    	   Vector2 pos_people = world.getPeople().get(i).getPosition();
           batch.draw(peopleImg, pos_people.x - BLOCK_SIZE/2,  PacmanGame.HEIGHT - pos_people.y - BLOCK_SIZE/2) ;
       }
       for(int i=0;i<=(world.getKol().size()-1);i++) {
    	   //Vector2 pos_people = world.getPeople().get(i).getPosition();
    	   Vector2 pos_kol=world.getKol().get(i).getPosition();
           batch.draw(kolImg, pos_kol.x - BLOCK_SIZE/2,  PacmanGame.HEIGHT - pos_kol.y - BLOCK_SIZE/2) ;
       }      
      // batch.draw(kolImg, pos_kol.x- BLOCK_SIZE/2,PacmanGame.HEIGHT -pos_kol.y- BLOCK_SIZE/2);
       batch.draw(pacmanImg, pos.x - BLOCK_SIZE/2, PacmanGame.HEIGHT - pos.y - BLOCK_SIZE/2);
       
       //batch.draw(shipImg, pos_ship.x - BLOCK_SIZE/2, PacmanGame.HEIGHT - pos_ship.y - BLOCK_SIZE/2);
       //batch.end();
       font.draw(batch, "" + world.getScore(), 700, 60);
       
       batch.end();
    }    

}
