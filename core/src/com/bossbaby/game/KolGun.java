package com.bossbaby.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class KolGun {
	private World world;
	public static final int SPEED=500;
	
	public static Texture bullet;
	public static boolean remove;
	private Vector2 position;
	
	float x,y;
	
	public KolGun(int x,int y,World world) {
		this.world = world;
		position= new Vector2(x,y);

		
		///if(bullet==null) {
		//	bullet = new Texture("kol_bul.png");
		//}
	}
	public Vector2 getPosition() {
        return position;    
    }
	public Vector2 meetMonster() {
		int row = getRow();
		int col = getColumn();
		int i;
		for(i=0;i<=(world.getMonster().size()-1);i++) {
			int count =0;
			int row_mons = world.getMonster().get(i).getRow();
			int col_mons = world.getMonster().get(i).getColumn();
			if(row_mons > row-3 && row_mons < row+3) {
				count++;
			}
			if(col_mons > col-3 && col_mons < col+3) {
				count++;
			}
			if(count==2) {
				break;
			}
			else {
				return null;
			}
		}
		return world.getMonster().get(i).getPosition();
	}
	
	public int getRow() {
        return ((int)position.y) / WorldRenderer.BLOCK_SIZE; 
    }
    public int getColumn() {
        return ((int)position.x) / WorldRenderer.BLOCK_SIZE; 
    }
    
	public void update (float delta) {
		Actions.addAction(Actions.moveTo(500, 500, 1));
		y+= SPEED * delta;
		if(y>HeavayNavyGame.HEIGHT || x>HeavayNavyGame.WIDTH) {
			remove=true;
		}
	}
	public void render (SpriteBatch batch) {
		batch.draw(bullet, x, y);
	}
	
	
}
