package com.bossbaby.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class ButtonKol {
	private World world;
	private Vector2 position;
	//int x,y;
	int countsequen;

	public ButtonKol(int x, int y,World world) {
		this.world = world;
		position= new Vector2(x,y);
	}
	public	boolean clickedOrNot() {
		MouseDetector mouse = world.getMouse();
		return mouse.clickedKol_one_time;
	}
	public void update() {
		MouseDetector mouse = world.getMouse();
		SetPositionWithMouse(mouse);
		//position.y+=1;
        
	}
	public void SetPositionWithMouse(MouseDetector mouse) {
		//if(clickedOrNot()) {
		if(mouse.clickedKol_one_time) {
			position.x=Gdx.input.getX();
			position.y=Gdx.input.getY();
			//mouse.clicked_onetime=false;
		}
		else if(mouse.checkPasteArea()&& mouse.clickedKol_one_time) {
			//world.createKolGun();
			//mouse.clickedKol_one_time=false;
			//position.x=;
			//position.y=;
			//mouse.clicked_one_time=false;
			
			//if() {
			position=mouse.pastAreaPosition();
			//world.createKolGun();
			//	countsequen=1;
			///////////////////change with another gun
		}
		
	}
	public Vector2 getPosition() {
        return position;    
    }
	public int getRow() {
        return ((int)position.y) / WorldRenderer.BLOCK_SIZE; 
    }
    public int getColumn() {
        return ((int)position.x) / WorldRenderer.BLOCK_SIZE; 
    }
   
	
}
