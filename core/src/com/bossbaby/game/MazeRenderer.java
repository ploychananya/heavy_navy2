package com.bossbaby.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MazeRenderer {
	private Maze maze;
    private SpriteBatch batch;
    private Texture sandImage;
    private Texture blockImage;
    private Texture waterImage;
    private Texture coinImage;///////////////////////
    private Texture kol_buttonImage;
    private Texture bomb_buttonImage;
    private Texture freez_buttonImage;
    private Texture kol_priceImage;
    private Texture bomb_priceImage;
    private Texture freez_priceImage;
    private Texture area_weaponImage;
    private Texture treeImage;
    private Texture grassImage;
    private Texture castleImage;
    World world;
 
    public MazeRenderer(SpriteBatch batch, Maze maze) {
        sandImage = new Texture("sand.png");
        waterImage = new Texture("water.png");
        blockImage = new Texture("block.png");
        coinImage = new Texture("coin_canuse.png");
        kol_buttonImage = new Texture("kol_button.png");
        bomb_buttonImage = new Texture("bomb_button.png");
        freez_buttonImage = new Texture("freez_button.png");
        kol_priceImage = new Texture("kol_price.png");
        bomb_priceImage = new Texture("bomb_price.png");
        freez_priceImage = new Texture("freez_price.png");
        area_weaponImage = new Texture("past.png");
        treeImage = new Texture("trees.png");
        grassImage = new Texture("green.png");
        castleImage = new Texture("castle.png");
        
        this.maze = maze;
        this.batch = batch;
      
  
    }
 
    public void render(float delta) {
    	//this.batch.begin();
        for(int r = 0; r < maze.getHeight(); r++) {
            for(int c = 0; c < maze.getWidth(); c++) {
                int x = c * WorldRenderer.BLOCK_SIZE;
                int y = PacmanGame.HEIGHT - (r * WorldRenderer.BLOCK_SIZE) - WorldRenderer.BLOCK_SIZE;
         
                if(maze.hasSandAt(r, c)) {
                    batch.draw(sandImage, x, y);
                }else if(maze.hasWaterAt(r, c)) {
                    batch.draw(waterImage, x, y);
                }else if(maze.hasBlockAt(r, c)) {
                    batch.draw(blockImage, x, y);
                }else if(maze.hasCoinAt(r, c)) {///////////////
                    batch.draw(coinImage, x, y);
                }else if(maze.hasKol_butAt(r, c)) {
                    batch.draw(kol_buttonImage, x, y);
                }else if(maze.hasBomb_butAt(r, c)) {
                    batch.draw(bomb_buttonImage, x, y);
                }else if(maze.hasFreez_butAt(r, c)) {
                    batch.draw(freez_buttonImage, x, y);
                }else if(maze.hasKol_priceAt(r, c)) {
                    batch.draw(kol_priceImage, x, y);
                }else if(maze.hasBomb_priceAt(r, c)) {
                    batch.draw(bomb_priceImage, x, y);
                }else if(maze.hasFreez_priceAt(r, c)) {
                    batch.draw(freez_priceImage, x, y);
                }else if(maze.hasArea_weaponAt(r, c)) {
                    batch.draw(area_weaponImage, x, y);
                }else if(maze.hasTreeAt(r, c)) {
                    batch.draw(treeImage, x, y);
                }else if(maze.hasGrassAt(r, c)) {
                    batch.draw(grassImage, x, y);
                }else if(maze.hasCastleAt(r, c)) {
                    batch.draw(castleImage, x, y);
                }
            }
        }
       // this.batch.end();
    }
}
