package com.bossbaby.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {
		private Maze maze;
	    Pacman pacman;
	    Monster ship;
	    People person;
	    PacmanGame pacmanGame;
	    MouseDetector mouse;
	    ButtonKol kolGun;
	    private int score;
	    
	    private int delaytime=300;
	    private int countloopcreateShip=0;
	    private int countloopcreatePeople=0;
	    
	    public float delta = 30;
	    public float millsec = 0;
	    public int sec = 0;
	    ArrayList<Monster> monsters = new ArrayList<Monster>();
	    ArrayList<People> people = new ArrayList<People>();
	    ArrayList<ButtonKol> kolgun = new ArrayList<ButtonKol>();
	    
	   
	
	 
	    World(PacmanGame pacmanGame) {
	        this.pacmanGame = pacmanGame;
	        maze = new Maze();
	        pacman = new Pacman(-30,220,this); //////-30
	        mouse = new MouseDetector(640,320,this);
	     //   kolGun = new ButtonKol(this);
	        registerDotEattenListener();
	        score = 0;
	        
	    }
	    
	    private void registerDotEattenListener() {
	        pacman.registerDotEattenListener(new Pacman.DotEattenListener() {
	            @Override
	            public void notifyDotEatten() {
	                score += 1;
	            }
	        });
	    }
	    
	    public void increaseScore() {
	        score += 1;
	    }
	    
	    public int getScore() {
	        return score;
	    }
	    
	    Pacman getPacman() {
	        return pacman;
	    }
	    ArrayList<ButtonKol> getKol() {
	    	return kolgun;
	    }
	    ArrayList<Monster> getMonster() {
	    	return monsters;
	    }
	    ArrayList<People> getPeople() {
	    	return people;
	    }
	    
	    Maze getMaze() { //for worldrenderer
	        return maze;
	    }
	    MouseDetector getMouse() { 
	        return mouse;
	    }
	    
	    public void update(float delta) {
	    	millsec++;
	    	sec=(int)millsec/60;
	    	if(millsec==60)
	    		millsec=0;
	    	//System.out.println(sec);
	    	//if(Gdx.input.isKeyPressed(Keys.SPACE)) {
	    	//	bullet.add(new KolGun(x+4))
	    	//}
	    	//mouseInWorld2D.x = Gdx.input.getX();
	        //mouseInWorld2D.y = Gdx.input.getY();
	    	//System.out.print("X:");
	    	//System.out.print(mouseInWorld2D.x);//////////////////////////////mouse position
	    	//System.out.print("       Y:");
	    	//System.out.println(mouseInWorld2D.y);
	    	/*if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
	    		System.out.println("Clicked");
	    		System.out.print("X:");
		    	System.out.print(mouseInWorld2D.x);//////////////////////////////mouse position
		    	System.out.print("       Y:");
		    	System.out.println(mouseInWorld2D.y);

	    	}*/
	    	
	    	
	    	genALotOfShip(5,40,5,30);
	    	genALotOfPeople(10,40,5,20);/////specify how much you want to gen  num,life,speed,intervaltime
	    	//for(int i=0;i<=(this.getKol().size()-1);i++) { 
	    	if(this.getMouse().clicked_KolButton(maze) ) {
	    		//if(this.getKol().isEmpty()) {	
	    		if(millsec%2==0) {
	    			
	    				createKolGun();
	    				System.out.print("CREATE");
	    				System.out.println(this.getKol().size());
	    		}
	    	}
	    	
	    	
	    	
	 	    callAllShip();
	 	    callAllPeople();//////call for building
	 	    callAllKol();
	 	    
	 	    deleteShip();
	 	    deletePeople();///////check it should to  delete or not ?
	 	    
	        pacman.update();
	        mouse.update(delta);
	        //kolGun.update();
	        
	        
	    }


		
		public void createKolGun() {
			
			kolGun = new ButtonKol(540,540,this);
			kolgun.add(kolGun);
			
		}
		public void callAllKol() {
			for(int i=0;i<=(this.getKol().size()-1);i++) {
	       		kolgun.get(i).update();
	        }
		}
		public void genALotOfShip(int NumberOfMonsterThatYouWant,int life,float speed,int interval) {
			if(millsec%interval==0 && countloopcreateShip<NumberOfMonsterThatYouWant) {
	    		createShip(life,speed);
	    		countloopcreateShip++;
	    	}
	    	else if(millsec%delaytime==0){
	    		countloopcreateShip=0;
	    	}
		}

		public void callAllShip() {
			for(int i=0;i<=(this.getMonster().size()-1);i++) {
	       		monsters.get(i).update();
	        }
		}

		public void createShip(int life,float speed) {
			ship = new Monster(20,300,life,speed,this);
			monsters.add(ship);
		}
		public void genALotOfPeople(int NumberOfMonsterThatYouWant,int life,float speed,int interval) {
			if(millsec%interval==0 && countloopcreatePeople<NumberOfMonsterThatYouWant) {
	    		createPeople(life,speed);
	    		countloopcreatePeople++;
	    	}
	    	else if(millsec%delaytime==0){
	    		countloopcreatePeople=0;
	    	}
		}

		public void callAllPeople() {
			for(int i=0;i<=(this.getPeople().size()-1);i++) {
	       		people.get(i).update();
	        }
		}

		public void createPeople(int life,float speed) {
			person = new People(20,300,life,speed,this);
			people.add(person);
		}
		public void deleteShip() {
			for(int i=0;i<=(this.getMonster().size()-1);i++) {
				if(!this.getMonster().get(i).isStopMoving()) {
					monsters.remove(i);
				}
			}
		}
		public void deletePeople() {
			for(int i=0;i<=(this.getPeople().size()-1);i++) {
				if(!this.getPeople().get(i).isStopMoving()) {
					people.remove(i);
				}
			}
		}
	
}
