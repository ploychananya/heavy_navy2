package com.bossbaby.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer{
	private Texture pacmanImg;
	private Texture shipImg;
	private Texture peopleImg;
	private Texture kolImg;
	private MazeRenderer mazeRenderer;
	HeavayNavyGame heavanavyGame;
	public static final int BLOCK_SIZE = 40;
	
	private BitmapFont font;
	private BitmapFont quata; ///////////TEXT
	private BitmapFont time;
	
	
	World world;
	Monster monster;
	//Pacman pacman = world.getPacman();
	SpriteBatch batch;
	Sprite sprite;
	//private Sprite sprite;
	private Texture koltubeImg;
	private TextureRegion koltube;
	
	private Texture kolbulletImg;
	private TextureRegion kolbullet;
	
	private Texture kolbuttonImg;
	private Texture bombbuttonImg;
	private Texture freezbuttonImg;
	private Texture bombImg;
	private TextureRegion bombbullet;
	private TextureRegion bombtube;
	private Texture freezImg;
	private TextureRegion freezbullet;
	private TextureRegion freeztube;
	private Texture bombtubeImg;
	private Texture freeztubeImg;
	private Texture bombbulletImg;
	private Texture freezbulletImg;
	private Texture winImg;
	private Texture lossImg;
	
	
	//SpriteBatch batch;
	
	public WorldRenderer(HeavayNavyGame heavynavyGame, World world) {
        this.heavanavyGame = heavynavyGame;
        this.world = world;
        mazeRenderer = new MazeRenderer(heavynavyGame.batch, world.getMaze());
       // kol = new MazeRenderer(pacmanGame.batch, world.getMaze());
        batch = heavynavyGame.batch;
        font = new BitmapFont();
        quata = new BitmapFont();
        time = new BitmapFont();
        
        
 
        winImg = new Texture("win.jpg");
        lossImg = new Texture("loss.png");
        pacmanImg = new Texture("pacman.png");
        shipImg = new Texture("ship1.png");
        peopleImg = new Texture("people.png");
        kolbuttonImg=new Texture("kol_button.png");
        bombbuttonImg=new Texture("bomb_button.png");
        freezbuttonImg=new Texture("freez_button.png");
        
        kolImg = new Texture("kol.png");
        bombImg = new Texture("bomb.png");
        freezImg = new Texture("freez.png");
        
        koltubeImg = new Texture(Gdx.files.internal("kol_gun.png"));////////////////textureregion
        koltube = new TextureRegion(koltubeImg);
        bombtubeImg = new Texture(Gdx.files.internal("bomb_gun.png"));////////////////textureregion
        bombtube = new TextureRegion(bombtubeImg);
        freeztubeImg = new Texture(Gdx.files.internal("freez_gun.png"));////////////////textureregion
        freeztube = new TextureRegion(freeztubeImg);
        
        kolbulletImg = new Texture(Gdx.files.internal("kol_bul2.png"));
        kolbullet = new TextureRegion(kolbulletImg);
        bombbulletImg = new Texture(Gdx.files.internal("bomb_bul2.png"));
        bombbullet = new TextureRegion(bombbulletImg);
        freezbulletImg = new Texture(Gdx.files.internal("freez_bul2.png"));
        freezbullet = new TextureRegion(freezbulletImg);
       
        
      
    }

	public void render(float delta) {
	   //SpriteBatch batch = pacmanGame.batch;
	   
       batch.begin();
       mazeRenderer.render(delta);
       
       //Vector2 posi = world.getPacman().getPosition();
       //batch.draw(pacmanImg,posi.x,posi.y);
       SpriteBatch batch = heavanavyGame.batch;
       
     //  Vector2 pos = world.getPacman().getPosition();
       
       
       for(int i=0;i<=(world.getMonster().size()-1);i++) {
    	   	//Sprite mon = world.getMonster().get(i).batch;
       		Vector2 pos_ship = world.getMonster().get(i).getPosition();
       		//mon.get
       		//mon.setRotation(mon.getRotation());
       		//mon.draw(batch);
            batch.draw(shipImg, pos_ship.x - BLOCK_SIZE/2,  HeavayNavyGame.HEIGHT - pos_ship.y - BLOCK_SIZE/2) ;
       }
       for(int i=0;i<=(world.getPeople().size()-1);i++) {
    	   Vector2 pos_people = world.getPeople().get(i).getPosition();
           batch.draw(peopleImg, pos_people.x - BLOCK_SIZE/2,  HeavayNavyGame.HEIGHT - pos_people.y - BLOCK_SIZE/2) ;
       }
      //////////////////KOL
       for(int i=0;i<=(world.getKol().size()-1);i++) {
    	   Vector2 pos_kol=world.getKol().get(i).getPosition();
           batch.draw(kolImg, pos_kol.x - BLOCK_SIZE/2,  HeavayNavyGame.HEIGHT - pos_kol.y - BLOCK_SIZE/2) ;
       }  
       for(int i=0;i<=(world.getKolTube().size()-1);i++) {
    	   Vector2 pos_koltube=world.getKolTube().get(i).getPosition();
    	   batch.draw(koltube, pos_koltube.x- BLOCK_SIZE/6, HeavayNavyGame.HEIGHT - pos_koltube.y - BLOCK_SIZE/2-5,6,30,12,30,1,1,90-(world.getKolTube().get(i).rad)); 
       }for(int i=0;i<=(world.getKolBullet().size()-1);i++) {
    	   Vector2 pos_kolbullet=world.getKolBullet().get(i).getPosition();
    	   batch.draw(kolbullet, pos_kolbullet.x- BLOCK_SIZE/6, HeavayNavyGame.HEIGHT - pos_kolbullet.y - BLOCK_SIZE/2,5,5,10,10,1,1,0);
       }         
       
       ////////////////BOMB
       for(int i=0;i<=(world.getBomb().size()-1);i++) {
    	   Vector2 pos_bomb=world.getBomb().get(i).getPosition();
           batch.draw(bombImg, pos_bomb.x - BLOCK_SIZE/2,  HeavayNavyGame.HEIGHT - pos_bomb.y - BLOCK_SIZE/2) ;
       }  
       for(int i=0;i<=(world.getBombTube().size()-1);i++) {
    	   Vector2 pos_bombtube=world.getBombTube().get(i).getPosition();
    	   batch.draw(bombtube, pos_bombtube.x- BLOCK_SIZE/6, HeavayNavyGame.HEIGHT - pos_bombtube.y - BLOCK_SIZE/2-5,9,26,18,26,1,1,90-(world.getBombTube().get(i).rad)); 
       }for(int i=0;i<=(world.getBombBullet().size()-1);i++) {
    	   Vector2 pos_bombbullet=world.getBombBullet().get(i).getPosition();
    	   batch.draw(bombbullet, pos_bombbullet.x- BLOCK_SIZE/6, HeavayNavyGame.HEIGHT - pos_bombbullet.y - BLOCK_SIZE/2,5,5,10,10,1,1,0);
       }       
       
       //////////////FREEZ
       for(int i=0;i<=(world.getFreez().size()-1);i++) {
    	   Vector2 pos_freez=world.getFreez().get(i).getPosition();
           batch.draw(freezImg, pos_freez.x - BLOCK_SIZE/2,  HeavayNavyGame.HEIGHT - pos_freez.y - BLOCK_SIZE/2) ;
       } 
      for(int i=0;i<=(world.getFreezTube().size()-1);i++) {
    	   Vector2 pos_freeztube=world.getFreezTube().get(i).getPosition();
    	   batch.draw(freeztube, pos_freeztube.x- BLOCK_SIZE/6, HeavayNavyGame.HEIGHT - pos_freeztube.y - BLOCK_SIZE/2-5,6,30,12,30,1,1,90-(world.getFreezTube().get(i).rad) ); 
       } for(int i=0;i<=(world.getFreezBullet().size()-1);i++) {
    	   Vector2 pos_freezbullet=world.getFreezBullet().get(i).getPosition();
    	   batch.draw(freezbullet, pos_freezbullet.x- BLOCK_SIZE/6, HeavayNavyGame.HEIGHT - pos_freezbullet.y - BLOCK_SIZE/2,5,5,10,10,1,1,0);
       }       
       
       
       
       
       
       
      
       if(world.getMouse().clickedKol_one_time) {
       		batch.draw(kolbuttonImg, Gdx.input.getX() - BLOCK_SIZE/2,  HeavayNavyGame.HEIGHT - Gdx.input.getY() - BLOCK_SIZE/2) ;
       		
       }else if(world.getMouse().clickedBomb_one_time) {
      		batch.draw(bombbuttonImg, Gdx.input.getX() - BLOCK_SIZE/2,  HeavayNavyGame.HEIGHT - Gdx.input.getY() - BLOCK_SIZE/2) ;
       }else if(world.getMouse().clickedFreez_one_time) {
     		batch.draw(freezbuttonImg, Gdx.input.getX() - BLOCK_SIZE/2,  HeavayNavyGame.HEIGHT - Gdx.input.getY() - BLOCK_SIZE/2) ;   		
       }
       
      
       font.draw(batch, "" + world.getScore(), 740, 105);
       quata.draw(batch, "" + world.quata, 1080, 580);
       time.draw(batch, "" + world.time, 520, 625);
       
       DrawWinOrLossImg(batch);
       
       batch.end();
    }

	public void DrawWinOrLossImg(SpriteBatch batch) {
		if(world.time<=0 && world.quata>0 && world.getMonster().isEmpty() && world.getPeople().isEmpty()) {
			 batch.draw(winImg, 0,0, HeavayNavyGame.WIDTH, HeavayNavyGame.HEIGHT); 
		   }else if(world.quata<=0){
			   batch.draw(lossImg,0,0, HeavayNavyGame.WIDTH, HeavayNavyGame.HEIGHT); 
		   }
	}    

}
