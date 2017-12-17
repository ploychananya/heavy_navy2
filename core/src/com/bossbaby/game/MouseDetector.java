package com.bossbaby.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class MouseDetector {
	World world;
	public Vector2 mouseInWorld2D;  
	public boolean clicked_onetime=false;
	public boolean clicked_twotime=false;
	public boolean clickedKol_one_time=false;
	public boolean clickedBomb_one_time=false;
	public boolean clickedFreez_one_time=false;
	public boolean oldbutton = false;
	int count_check_click=0;
	public MouseDetector(int x,int y,World world) {
		this.world = world;
		mouseInWorld2D = new Vector2(x,y);
	}
	public void update(float delta) {
    	updateMouse();
    	clickedDetector();
    	checkPasteArea();
	}
	public boolean clickedDetector() {
		count_check_click++;
		if(count_check_click%1==1) {
		oldbutton = Clicked();
		}
		if( !(Clicked()==oldbutton) && oldbutton==false ) {
			return true;
		}else return false;
	}
	public boolean Clicked() {
		Maze maze = world.getMaze();
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			return true;
		}else return false;
	}
	private void updateMouse() {
		mouseInWorld2D.x = Gdx.input.getX();
        mouseInWorld2D.y = Gdx.input.getY();
	}
	public int getRow() {
        return ((int)mouseInWorld2D.y) / WorldRenderer.BLOCK_SIZE; 
    }
    public int getColumn() {
        return ((int)mouseInWorld2D.x) / WorldRenderer.BLOCK_SIZE; 
    }
    public boolean clicked_KolButton(Maze maze) {
    	if(maze.hasKol_butAt(getRow(), getColumn())) {
    		return true;
    	}else return false;
    }
    public boolean clicked_BombButton(Maze maze) {
    	if(maze.hasBomb_butAt(getRow(), getColumn())) {
    		
    		return true;
    	}else return false;
    }
    public boolean clicked_FreezButton(Maze maze) {
    	if(maze.hasFreez_butAt(getRow(), getColumn())) {
    		return true;
    	}else return false;
    }
    public boolean checkPasteArea() {
    	Maze maze = world.getMaze(); 
    	if(maze.hasArea_weaponAt(getRow(),getColumn())) {
    		return true;
    	}else return false;
    }
    public Vector2 pastAreaPosition() {
    	return mouseInWorld2D;
    }
}
