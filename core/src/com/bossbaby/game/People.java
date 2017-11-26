package com.bossbaby.game;

import com.badlogic.gdx.math.Vector2;

public class People extends Monster {

	private int life;
	private float SPEED;
	private World world;
	private Vector2 position;

	public People(int x, int y, int life, float SPEED, World world) {
		super(x, y, life, SPEED, world);


	}

}
