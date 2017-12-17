package com.bossbaby.game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;


public class GameScreen extends ScreenAdapter {
	World world;
	WorldRenderer worldRenderer;
	HeavayNavyGame heavanavyGame;

    public GameScreen(HeavayNavyGame heavanavyGame) {
        
    	this.heavanavyGame = heavanavyGame;
        world = new World(heavanavyGame);
        worldRenderer = new WorldRenderer(heavanavyGame,world);
    }
    public void render(float delta) {
		update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        worldRenderer.render(delta);
    }
    public void update(float delta) {
        world.update(delta);
    }
}
