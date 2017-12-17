package com.bossbaby.game.desktop;

//import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bossbaby.game.HeavayNavyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = HeavayNavyGame.WIDTH;
        config.height = HeavayNavyGame.HEIGHT;
		new LwjglApplication(new HeavayNavyGame(), config);
	}
}
/*
public class GameScreen extends ScreenAdapter {
	 
	PacmanGame pacmanGame;
	 
	public GameScreen(PacmanGame pacmanGame) {
	    this.pacmanGame = pacmanGame;
	}
}
*/
