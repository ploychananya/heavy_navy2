package com.bossbaby.game;


import com.badlogic.gdx.math.Vector2;

public class KolBullet extends KolTube {

	private World world;
	private Vector2 position;
	private float rad;
	private int position_x_monster;
	private int position_y_monster;
	private int position_x_people;
	private int position_y_people;
	private int damage;
	public KolBullet(int x, int y, float angle,int damage, World world) {
		super(x, y, angle, world);
		this.world = world;
		position= new Vector2(x,y);
		rad=angle;
		this.damage = damage;
	}
	public Vector2 getPosition() {
        return position;    
    }
	public void update() {
		
		// TODO Auto-generated method stub
		position.x+=10*(Math.cos(rad*(Math.PI/180.0d)));
		position.y+=10*(Math.sin(rad*(Math.PI/180.0d)));
		
		
	}
	public boolean ShootMonster() {
		int shoot =0;
		for(int i=0;i<=(world.getMonster().size()-1);i++) {
       		position_x_monster= (int) world.getMonster().get(i).getPosition().x;
       		position_y_monster= (int) world.getMonster().get(i).getPosition().y;
       		//life_monster = (int) world.getMonster().get(i).life;
       		//index_current_monster=i;
       		
       		if(Math.abs(position.x-position_x_monster)<=35 && Math.abs(position.y-position_y_monster)<=35) {
       			shoot=1;
       			world.getMonster().get(i).life -=this.damage;
       			break;
       			
       		}
       		
        }
		if(shoot==1)return true;
		else return false;
	}
	public boolean ShootPeople() {
		
		int shoot =0;
		for(int i=0;i<=(world.getPeople().size()-1);i++) {
       		position_x_people= (int) world.getPeople().get(i).getPosition().x;
       		position_y_people= (int) world.getPeople().get(i).getPosition().y;
    
       		if(Math.abs(position.x-position_x_people)<=20 && Math.abs(position.y-position_y_people)<=20) {
       			shoot=1;
       			world.getPeople().get(i).life -=this.damage;  //////////Depenon Damage
       			break;
       		}
       		
        }
		if(shoot==1)return true;
		else return false;
	}

}
