package com.bossbaby.game;

import java.util.LinkedList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class Pacman {
	public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    
    public static final int SPEED = 2;
    
	public Vector2 position;
	
	private int currentDirection;
	private int nextDirection;
	//private LinkedList<DotEattenListener> listeners;
	
	private World world;
	private LinkedList<DotEattenListener> listeners;
	//Maze maze;
	//int count =0;
	public Pacman(int x, int y,World world) { //pacman can refference maze 
		this.world = world;
		//Maze maze = world.getMaze();
		position = new Vector2(x,y);
		listeners = new LinkedList<DotEattenListener>();
		//listeners = new LinkedList<DotEattenListener>(); //score
		currentDirection = DIRECTION_STILL;
        nextDirection = DIRECTION_STILL;
		
	        //if(count==0) {
	    //position.x=100;
	    //position.y=100;
	        	//count++;
	       // }
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public interface DotEattenListener {
        void notifyDotEatten();			
    }
	
	public void registerDotEattenListener(DotEattenListener l) {
        listeners.add(l);
    }
 
    private void notifyDotEattenListeners() {
        for(DotEattenListener l : listeners) {
            l.notifyDotEatten();
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////   
	
	public void setNextDirection(int dir) {
        nextDirection = dir;
    }
	
	public Vector2 getPosition() {
        return position;    
    }
	
	/*public void move(int dir) { 
        switch(dir) {
        case DIRECTION_UP:
            position.y += 10;
            break;
        case DIRECTION_RIGHT:
            position.x += 10;
            break;
        case DIRECTION_DOWN:
            position.y -= 10;
            break;
        case DIRECTION_LEFT:
            position.x -= 10;
            break;
        }
    }*/
	private static final int [][] DIR_OFFSETS = new int [][] {
        {0,0},
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };
 
    // ...
 
    public void move(int dir) { 
        position.x += SPEED * DIR_OFFSETS[dir][0];
        position.y += SPEED * DIR_OFFSETS[dir][1];
    }
    
    protected boolean isAtCenter() {
        int blockSize = WorldRenderer.BLOCK_SIZE;
 
        return ((((int)position.x - blockSize/2) % blockSize) == 0) &&
                ((((int)position.y - blockSize/2) % blockSize) == 0);
    }
    
    public void update() {
    	Maze maze = world.getMaze();
        if(isAtCenter()) {
            //currentDirection = nextDirection;
        	if(canMoveInDirection(nextDirection)) {
                currentDirection = nextDirection;    
            } else {
                currentDirection = DIRECTION_STILL;    
            }
        	if(maze.hasDotAt(getRow(),getColumn())) {
        		//world.increaseScore();
        		notifyDotEattenListeners();
        		maze.removeDotAt(getRow(),getColumn()); 
        	}
        }
        position.x += SPEED * DIR_OFFSETS[currentDirection][0];
        position.y += SPEED * DIR_OFFSETS[currentDirection][1];
    }
    
    private boolean canMoveInDirection(int dir) {
    	Maze maze = world.getMaze();
    	int newRow = getRow()+(DIR_OFFSETS[dir][1]); 
        int newCol = getColumn()+(DIR_OFFSETS[dir][0]);
        return  ! maze.hasSandAt(newRow,newCol);   
    }
    
    private int getRow() {
        return ((int)position.y) / WorldRenderer.BLOCK_SIZE; 
    }
 
    private int getColumn() {
        return ((int)position.x) / WorldRenderer.BLOCK_SIZE; 
    }
    
}
