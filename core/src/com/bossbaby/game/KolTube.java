package com.bossbaby.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class KolTube {
	private Vector2 position;
	private World world;
	private int position_x_monster;
	private int position_y_monster;
	public float rad;
	private KolBullet kolBullet;

	private int count_degree;
	private int position_x_people;
	private int position_y_people;
	
	
	public KolTube(int x, int y,float angle,World world) {
		this.world = world;
		position= new Vector2(x,y);
		
		
		
		
	}
	public Vector2 getPosition() {
        return position;    
    }
	public void update() {
		if(TouchMonster() ||TouchPeople()) {
			CreatBulletInMap();
		}
		count_degree++ ;
	}
	public void CreatBulletInMap() {
		if(count_degree%15==0) {
			kolBullet= new KolBullet((int)position.x,(int)position.y,rad,1,world);
			world.kolbullet.add(kolBullet);
		}
	}
	//detect monster
	public boolean TouchMonster() {
		int touch =0;
		for(int i=0;i<=(world.getMonster().size()-1);i++) {
       		position_x_monster= (int) world.getMonster().get(i).getPosition().x;
       		position_y_monster= (int) world.getMonster().get(i).getPosition().y;
       		
       		if(Math.abs(position_x_monster-(int)position.x)<=100 && Math.abs(position_y_monster-(int)position.y)<=200) {
       			rad = (float) (90+(90-(Math.atan2(position_y_monster - position.y, -(position_x_monster - position.x)) *( 180.0d / Math.PI))));
       			touch=1;
       			break;
       		}
        }
		if(touch==1)return true;
		else return false;
		
	}//shoot
	public boolean TouchPeople() {
		int touch =0;
		for(int i=0;i<=(world.getPeople().size()-1);i++) {
       		position_x_people= (int) world.getPeople().get(i).getPosition().x;
       		position_y_people= (int) world.getPeople().get(i).getPosition().y;
       		
       		if(Math.abs(position_x_people-(int)position.x)<=100 && Math.abs(position_y_people-(int)position.y)<=200) {
       			rad = (float) (90+(90-(Math.atan2(position_y_people - position.y, -(position_x_people - position.x)) *( 180.0d / Math.PI))));
       		
       			touch=1;
       			break;
       		}
        }
		if(touch==1)return true;
		else return false;
	}//shoot
	
}
