package com.bossbaby.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class MouseDetector {
	World world;
	public Vector2 mouseInWorld2D;  
	public int gun_positionX,gun_positionY;
	public boolean clicked_onetime=false;
	private boolean clicked_twotime=false;
	public boolean can_incre=false;
	public boolean clickedKol_one_time=false;
	public boolean clickedBomb_one_time=false;
	public boolean clickedFreez_one_time=false;
	public boolean clickedPasteArea=false;
	int countkol=0;
	public MouseDetector(int x,int y,World world) {
		this.world = world;
		mouseInWorld2D = new Vector2(x,y);
	}
	public void update(float delta) {
    	updateMouse();
    	
    	clickedDetector();
    	checkPasteArea();
    	//System.out.println(clicked_onetime);
    
	}
	public void clickedDetector() {
		if(Clicked()) {
			Maze maze = world.getMaze();
			//if(countkol==0) 
				clicked_KolButton(maze);
	    	
	    	clicked_BombButton(maze);
	    	
	    	clicked_FreezButton(maze);
		}
	}
	public boolean Clicked() {
		Maze maze = world.getMaze();
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			System.out.println("Clicked!");
			return true;
		}else return false;
	}
	private void updateMouse() {
		mouseInWorld2D.x = Gdx.input.getX();
        mouseInWorld2D.y = Gdx.input.getY();
        System.out.print(mouseInWorld2D.x);
        System.out.print("              ");
        System.out.println(mouseInWorld2D.y);
        
	}
	public int getRow() {
        return ((int)mouseInWorld2D.y) / WorldRenderer.BLOCK_SIZE; 
    }
    public int getColumn() {
        return ((int)mouseInWorld2D.x) / WorldRenderer.BLOCK_SIZE; 
    }
    public boolean clicked_KolButton(Maze maze) {
    	if(maze.hasKol_butAt(getRow(), getColumn()) && Clicked()) {
    	
    		//world.createKolGun();
    		System.out.println("Kol_GUN");
    		if(countkol==0)
    			clicked_onetime=true;
    		clickedKol_one_time=true;
    		countkol++;
    			
    		return true;
    	}else return false;
    }
    public boolean clicked_BombButton(Maze maze) {
    	if(maze.hasBomb_butAt(getRow(), getColumn()) && Clicked()) {
    	//if(maze.hasBomb_butAt(getRow(), getColumn())) {
    		System.out.println("Bomb_GUN");
    		clicked_onetime=true;
    		//clicked_twotime=true;
    		clickedBomb_one_time=true;
    		//clickedPasteArea=false;
    		return true;
    	}else return false;
    }
    public boolean clicked_FreezButton(Maze maze) {
    	if(maze.hasFreez_butAt(getRow(), getColumn()) && Clicked()) {
    		System.out.println("freez_GUN");
    		clicked_onetime=true;
    		clickedFreez_one_time=true;
    		return true;
    	}else return false;
    }
    public boolean checkPasteArea() {
    	Maze maze = world.getMaze();
    	boolean check = clicked_onetime && Clicked(); 
    	if(maze.hasArea_weaponAt(getRow(),getColumn()) && check) {

    		//clicked_onetime=false;
    		clickedKol_one_time=false;
    		clickedBomb_one_time=false;
    		clickedFreez_one_time=false;
    		return true;
    	}else return false;
    }
    
    public Vector2 pastAreaPosition() {
    	return mouseInWorld2D;
    }
}
