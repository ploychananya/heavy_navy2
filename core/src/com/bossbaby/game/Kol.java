package com.bossbaby.game;

import com.badlogic.gdx.math.Vector2;

public class Kol {
	private World world;
	private Vector2 position;

	public Kol(int x, int y,World world) {
		this.world = world;
		position= new Vector2(x,y);
	}
	public Vector2 getPosition() {
        return position;    
    }
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
