package com.bossbaby.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class ButtonKol {
	private World world;
	private Vector2 position;
	//int x,y;
	int countkol=0;
	int count=0;
	boolean click = false;
	boolean click_confirm = false;
	

	public ButtonKol(int x, int y,World world) {
		this.world = world;
		position= new Vector2(x,y);
	}
	public	boolean clickedOrNot() {
		MouseDetector mouse = world.getMouse();
		return mouse.clickedKol_one_time && mouse.clicked_onetime;
	}
	public void update() {
		MouseDetector mouse = world.getMouse();
		Maze maze = world.getMaze();
		SetPositionWithMouse(mouse);
		//clicked_KolButton(maze);
		//position.x+=5;
		//System.out.println(countsequen);
        
	}
	
	public void SetPositionWithMouse(MouseDetector mouse) {
		//if(clickedOrNot()) {
		if(mouse.clickedKol_one_time && count<40) {
			position.x=Gdx.input.getX();
			position.y=Gdx.input.getY();
			//if(mouse.checkPasteArea()&& mouse.clickedKol_one_time) {
			count++;
			//}
			
		}
		else if(mouse.checkPasteArea()&& mouse.clickedKol_one_time) {
		//else if(mouse.Clicked()&& !mouse.clickedKol_one_time) {
		//else if(mouse.checkPasteArea() ) {
		//else {	
		//world.createKolGun();
			//mouse.clickedKol_one_time=false;
			//position.x=;
			//position.y=;
			//mouse.clicked_one_time=false;
			///
			//if() {
			System.out.println("ployployployyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
			
			//if(countsequen==0) {
			position=mouse.pastAreaPosition();
			//count++;
			//world.createKolGun();
				//System.out.println("jinggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
			//countsequen++;
			}
			
			
			//world.createKolGun();
			//	countsequen=1;
			///////////////////change with another gun
		
		
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
