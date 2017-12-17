package com.bossbaby.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {
		private Maze maze;
	    Monster ship;
	    People person;
	    HeavayNavyGame pacmanGame;
	    MouseDetector mouse;
	    Kol kolGun;
	    public double score;
	    
	    private int delaytime=500;
	    private int countloopcreateShip=0;
	    private int countloopcreatePeople=0;
	    
	    public float delta = 30;
	    public float millsec = 0;
	    public int sec = 0;
	    public boolean create_kol_first_already = false;
	    public boolean create_bomb_first_already = false;
	    public boolean create_freez_first_already = false;
	    
	    ArrayList<Monster> monsters = new ArrayList<Monster>();
	    ArrayList<People> people = new ArrayList<People>();
	    
	    ArrayList<Kol> kolgun = new ArrayList<Kol>();
	    ArrayList<KolTube> koltube = new ArrayList<KolTube>();
	    ArrayList<KolBullet> kolbullet = new ArrayList<KolBullet>();
		private KolTube kolTube;
		KolBullet kolBullet;
		ArrayList<Bomb> bombgun = new ArrayList<Bomb>();
	    ArrayList<BombTube> bombtube = new ArrayList<BombTube>();
	    ArrayList<BombBullet> bombbullet = new ArrayList<BombBullet>();
		private BombTube BombTube;
		BombBullet bombBullet;
		ArrayList<Freez> freezgun = new ArrayList<Freez>();
	    ArrayList<FreezTube> freeztube = new ArrayList<FreezTube>();
	    ArrayList<FreezBullet> freezbullet = new ArrayList<FreezBullet>();
		private FreezTube freezTube;
		FreezBullet freezBullet;
		public int quata;
		public int time;
		private Bomb BombGun;
		private Freez FreezGun;
	    World(HeavayNavyGame pacmanGame) {
	        this.pacmanGame = pacmanGame;
	        maze = new Maze();
	        mouse = new MouseDetector(640,320,this);
	        score = 10; // start coin =10
	        quata = 15;  // can go in the castle only 15 if more than this will loss
	        time = 180; // sec = 3 minute 
	    }   
	    public double getScore() {
	        return score;
	    }
	    ArrayList<Kol> getKol() {
	    	return kolgun;
	    }
	    ArrayList<Bomb> getBomb() {
	    	return bombgun;
	    }
	    ArrayList<Freez> getFreez() {
	    	return freezgun;
	    }
	    ArrayList<KolBullet> getKolBullet() {
	    	return kolbullet;
	    }
	    ArrayList<BombBullet> getBombBullet() {
	    	return bombbullet;
	    }
	    ArrayList<FreezBullet> getFreezBullet() {
	    	return freezbullet;
	    }
	    ArrayList<Monster> getMonster() {
	    	return monsters;
	    }
	    ArrayList<People> getPeople() {
	    	return people;
	    }
	    ArrayList<KolTube> getKolTube() {
	    	return koltube;
	    }
	    ArrayList<BombTube> getBombTube() {
	    	return bombtube;
	    }
	    ArrayList<FreezTube> getFreezTube() {
	    	return freeztube;
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
	    	CountDownTime();
	    	 	
	    	ChangePatternEvery30Sec();
	    		
	    	CreateKolgunInMap();
	    	CreateBombgunInMap();
	    	CreateFreezgunInMap();
	    	
	    	
	    	
	 	    callAllShip();
	 	    callAllPeople();//////call for building
	 	    
	 	    callAllKol();
	 	    callAllBomb();
	 	    callAllFreez();
	 	    
	 	    callAllKolTube();
	 	    callAllBombTube();
	 	    callAllFreezTube();
	 	    
	 	    callAllKolbullet();
	 	    callAllBombbullet();
	 	    callAllFreezbullet();
	 	    
	 	    deleteShip();
	 	    deletePeople();///////check it should to  delete or not ?
	 	    deleteKolBullet();
	 	    deleteBombBullet();
	 	    deleteFreezBullet();
	 	    
	        mouse.update(delta);
	    }
		public void ChangePatternEvery30Sec() {
			if(time>=150) {
	    		//genALotOfShip(5,40,(float) 1.5,100);
	    		genALotOfPeople(12,7,(float) 0.5,60);
	    	}
	    	else if(time>=120 && time<150) {
	    		genALotOfShip(2,30,(float) 1.2,100);
	    		genALotOfPeople(10,15,1,60);
	    	}else if(time>=90 && time<120) {
	    		genALotOfShip(1,30,(float) 1.2,100);
	    		genALotOfPeople(20,30,1,100);
	    	}else if(time>=60 && time<90) {
	    		genALotOfShip(4,45,(float) 1.8,100);
	    		genALotOfPeople(15,30,1,100);
	    	}else if(time>=30 && time<60) {
	    		//genALotOfShip(4,45,(float) 1.2,100);
	    		genALotOfPeople(40,30,1,120);
	    	}else if(time>=0 && time<30) {
	    		genALotOfShip(8,55,(float) 1.2,100);
	    		genALotOfPeople(30,30,1,100);
	    	}
		}

		public void CreateKolgunInMap() {//////////////////////////////////////////////////////////////DEPEND ON EACH GUN
			if(this.getMouse().clicked_KolButton(maze) && this.getMouse().clickedDetector()&& score>=5) {
	    		this.getMouse().clickedKol_one_time=true;
	    		
	    	}
	    	else if(this.getMouse().checkPasteArea() && this.getMouse().clickedDetector() && this.getMouse().clickedKol_one_time) {
	    		createKolGun(Gdx.input.getX(),Gdx.input.getY());
	    		this.score-=5;
	    		
	    		create_kol_first_already=true;
	    		//System.out.println("paste");
	    		
	    		System.out.print("CREATEKol");
	    		System.out.println(this.getKol().size());
	    		
	    		this.getMouse().clickedKol_one_time=false;
	    	}else if(!this.getMouse().checkPasteArea() && this.getMouse().clickedDetector() && this.getMouse().clickedKol_one_time)
	    		this.getMouse().clickedKol_one_time=false;
	    		
		}
		public void CreateBombgunInMap() {//////////////////////////////////////////////////////////////DEPEND ON EACH GUN
			if(this.getMouse().clicked_BombButton(maze) && this.getMouse().clickedDetector()&& score>=10) {
	    		this.getMouse().clickedBomb_one_time=true;
	    		
	    	}
	    	else if(this.getMouse().checkPasteArea() && this.getMouse().clickedDetector() && this.getMouse().clickedBomb_one_time) {
	    		createBombGun(Gdx.input.getX(),Gdx.input.getY());
	    		this.score-=10;  //////10 coin
	    		
	    		create_bomb_first_already=true;
	    
	    		
	    		System.out.print("CREATEBomb");
	    		System.out.println(this.getBomb().size());
	    		
	    		this.getMouse().clickedBomb_one_time=false;
	    	}else if(!this.getMouse().checkPasteArea() && this.getMouse().clickedDetector() && this.getMouse().clickedBomb_one_time)
	    		this.getMouse().clickedBomb_one_time=false;
		}
		private void createBombGun(int x, int y) {
			x=(((int)x/WorldRenderer.BLOCK_SIZE)*WorldRenderer.BLOCK_SIZE)+(WorldRenderer.BLOCK_SIZE/2);
			y=(((int)y/WorldRenderer.BLOCK_SIZE)*WorldRenderer.BLOCK_SIZE)+(WorldRenderer.BLOCK_SIZE/2);
			BombGun = new Bomb(x,y,this);
			BombTube= new BombTube(x,y,0,this);
		
			bombgun.add(BombGun);
			bombtube.add(BombTube);
			
		}

		public void CreateFreezgunInMap() {//////////////////////////////////////////////////////////////DEPEND ON EACH GUN
			if(this.getMouse().clicked_FreezButton(maze) && this.getMouse().clickedDetector()&& score>=20) {
	    		this.getMouse().clickedFreez_one_time=true;
	    		
	    	}
	    	else if(this.getMouse().checkPasteArea() && this.getMouse().clickedDetector() && this.getMouse().clickedFreez_one_time) {
	    		createFreezGun(Gdx.input.getX(),Gdx.input.getY());
	    		this.score-=20; //spent 20 coins
	    		
	    		create_freez_first_already=true;
	
	    		System.out.print("CREATEFreez");
	    		System.out.println(this.getFreez().size());
	    		
	    		this.getMouse().clickedFreez_one_time=false;
	    	
	    	}else if(!this.getMouse().checkPasteArea() && this.getMouse().clickedDetector() && this.getMouse().clickedFreez_one_time)
	    		this.getMouse().clickedFreez_one_time=false;
		}	

		private void createFreezGun(int x, int y) {
			x=(((int)x/WorldRenderer.BLOCK_SIZE)*WorldRenderer.BLOCK_SIZE)+(WorldRenderer.BLOCK_SIZE/2);
			y=(((int)y/WorldRenderer.BLOCK_SIZE)*WorldRenderer.BLOCK_SIZE)+(WorldRenderer.BLOCK_SIZE/2);
			FreezGun = new Freez(x,y,this);
			freezTube= new FreezTube(x,y,0,this);
		
			freezgun.add(FreezGun);
			freeztube.add(freezTube);
			
		}

		public void CountDownTime() {
			if(millsec%60==0) {
	    		time--;
	    	}
		}


		
		public void createKolGun(int x,int y) {
			x=(((int)x/WorldRenderer.BLOCK_SIZE)*WorldRenderer.BLOCK_SIZE)+(WorldRenderer.BLOCK_SIZE/2);
			y=(((int)y/WorldRenderer.BLOCK_SIZE)*WorldRenderer.BLOCK_SIZE)+(WorldRenderer.BLOCK_SIZE/2);
			kolGun = new Kol(x,y,this);
			kolTube= new KolTube(x,y,0,this);
		
			kolgun.add(kolGun);
			koltube.add(kolTube);
		}
		public void callAllKol() {
			for(int i=0;i<=(this.getKol().size()-1);i++) {
	       		kolgun.get(i).update();
	        }
		}
		public void callAllBomb() {
			for(int i=0;i<=(this.getBomb().size()-1);i++) {
	       		bombgun.get(i).update();
	        }
		}
		public void callAllFreez() {
			for(int i=0;i<=(this.getFreez().size()-1);i++) {
	       		freezgun.get(i).update();
	        }
		}
		
		public void callAllKolTube() {
			for(int i=0;i<=(this.getKolTube().size()-1);i++) {
	       		koltube.get(i).update();
	        }
		}
		public void callAllBombTube() {
			for(int i=0;i<=(this.getBombTube().size()-1);i++) {
	       		bombtube.get(i).update();
	        }
		}
		public void callAllFreezTube() {
			for(int i=0;i<=(this.getFreezTube().size()-1);i++) {
	       		freeztube.get(i).update();
	        }
		}
		
		
		public void callAllKolbullet() {
			for(int i=0;i<=(this.getKolBullet().size()-1);i++) {
	       		kolbullet.get(i).update();
	        }
		}
		public void callAllBombbullet() {
			for(int i=0;i<=(this.getBombBullet().size()-1);i++) {
	       		bombbullet.get(i).update();
	        }
		}
		public void callAllFreezbullet() {
			for(int i=0;i<=(this.getFreezBullet().size()-1);i++) {
	       		freezbullet.get(i).update();
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
					this.quata-=1;
				}else if(this.getMonster().get(i).life<=0) {
					monsters.remove(i);
					this.score+=3;  /// add score kill 1 people got 3 coin
				}
			}
		}
		public void deletePeople() {
			for(int i=0;i<=(this.getPeople().size()-1);i++) {
				if(!this.getPeople().get(i).isStopMoving()) {
					people.remove(i);
					this.quata-=1;
				}else if(this.getPeople().get(i).life<=0) {
					people.remove(i);
					this.score+=0.75;  /// add score kill 1 people got 0.5 coin
				}
			}
		}
		public void deleteKolBullet() {
			for(int i=0;i<=(this.getKolBullet().size()-1);i++) {
				if(this.getKolBullet().get(i).getPosition().x<0 || this.getKolBullet().get(i).getPosition().x> HeavayNavyGame.WIDTH||this.getKolBullet().get(i).getPosition().y>HeavayNavyGame.HEIGHT||this.getKolBullet().get(i).getPosition().y<0) {
					kolbullet.remove(i);
				}
				else if(this.getKolBullet().get(i).ShootMonster()||this.getKolBullet().get(i).ShootPeople())
					kolbullet.remove(i);
				
				
			}
		}
		
		public void deleteBombBullet() {
			for(int i=0;i<=(this.getBombBullet().size()-1);i++) {
				if(this.getBombBullet().get(i).getPosition().x<0 || this.getBombBullet().get(i).getPosition().x> HeavayNavyGame.WIDTH||this.getBombBullet().get(i).getPosition().y>HeavayNavyGame.HEIGHT||this.getBombBullet().get(i).getPosition().y<0) {
					bombbullet.remove(i);
				}
				else if(this.getBombBullet().get(i).ShootMonster()||this.getBombBullet().get(i).ShootPeople())
					bombbullet.remove(i);
				
				
			}
		}
		public void deleteFreezBullet() {
			for(int i=0;i<=(this.getFreezBullet().size()-1);i++) {
				if(this.getFreezBullet().get(i).getPosition().x<0 || this.getFreezBullet().get(i).getPosition().x> HeavayNavyGame.WIDTH||this.getFreezBullet().get(i).getPosition().y>HeavayNavyGame.HEIGHT||this.getFreezBullet().get(i).getPosition().y<0) {
					freezbullet.remove(i);
				}
				else if(this.getFreezBullet().get(i).ShootMonster()||this.getFreezBullet().get(i).ShootPeople()) {
					freezbullet.remove(i);
				}		
			}
		}
	
}
