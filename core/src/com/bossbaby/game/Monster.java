package com.bossbaby.game;

import com.badlogic.gdx.math.Vector2;

public class Monster {
	private static final float SPEED = (float) 0.5;
	private World world;
	//private Maze maze = world.getMaze();
	private Vector2 position;
	private int life;
	public String[] MONS = new String [] {
            "0","1","2","3","4","5",
    };
	
	public Monster(int x,int y,int life,World world) {
		this.life = life;
		this.world = world;
		position = new Vector2(x,y);
		
	}
	public void update() {
    	Move();
	}
	public Vector2 getPosition() {
        return position;    
    }
	private int getRow() {
        return ((int)position.y) / WorldRenderer.BLOCK_SIZE; 
    }
    private int getColumn() {
        return ((int)position.x) / WorldRenderer.BLOCK_SIZE; 
    }
    private boolean canMoveX() {
    	Maze maze = world.getMaze();
    	//int newRow = getRow()+1; 
        int newCol = getColumn()+1; ///UP
        return   maze.hasWaterAt(getRow(),newCol);   
    }
    private boolean isStopMoving() {
    	Maze maze = world.getMaze();
    	int Row = getRow(); 
        int Col = getColumn(); ///UP
        return   !maze.hasCastleAt(Row,Col); 
    }
    private boolean isKilled() {
    	if(life<=0) {
    		return true;
    	}else {
    		return false;
    	}
    } 
    public void takeDamage(int damage) {
    	life-=damage;
    }
    
	public void Move(){	
		if(canMoveX() && isStopMoving()) {
			position.x += SPEED;
		}
		else if(isStopMoving()) {
			choose_y_direction();
		}
 	}
	
	public void choose_y_direction() {
		Maze maze = world.getMaze();
		int CountRow_Up,CountRow_Down ; 
		for( CountRow_Up=1;CountRow_Up<=15;CountRow_Up++) { //count_up
			if(!maze.hasWaterAt(getRow()+CountRow_Up,getColumn())) {
				CountRow_Up-=1;
				break;
			}	
		}
		for( CountRow_Down=1;CountRow_Down>=0;CountRow_Down++) { //count_up
			if(!maze.hasWaterAt(getRow()-CountRow_Down,getColumn())) {
				if(maze.hasCastleAt(getRow()-CountRow_Down,getColumn())) {
					CountRow_Down+=20;
				}
				else {
					CountRow_Down-=1;
				}
				break;
			}
		}
		if(CountRow_Down>CountRow_Up) {
			position.y -= SPEED;
		}else if(CountRow_Down<CountRow_Up){
			position.y += SPEED;
		}else if(CountRow_Up==CountRow_Down) {
			choose_x_direction(CountRow_Up, CountRow_Down);
		}
	}
	
	public void choose_x_direction(int CountRow_Up, int CountRow_Down) {
		Maze maze = world.getMaze();
		int CountCol_Up,CountCol_Down ; 
		for( CountCol_Up=1;CountCol_Up<=31;CountCol_Up++) { //count_up
			if(!maze.hasWaterAt(getRow()+CountRow_Up,getColumn()+CountCol_Up)) {
				CountCol_Up-=1;
				break;
			}
		}
		for( CountCol_Down=1;CountCol_Down<=31;CountCol_Down++) { //count_up
			if(!maze.hasWaterAt(getRow()-CountRow_Down,getColumn()+CountCol_Down)) {
				CountCol_Down-=1;
				break;
			}
		}
		if(CountCol_Down>CountCol_Up) {
			position.y -= SPEED;
		}else if(CountCol_Down<CountCol_Up){
			position.y += SPEED;
		}
	}
	
}
