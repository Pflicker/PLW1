package de.beaverstudios.plw;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class PlwGame extends Game {


	public static final int V_WIDTH = 800;
	public static final int V_HEIGHT = 480;
	public BitmapFont font;
	public static final float PPM = 10;

	public SpriteBatch batch;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		this.setScreen(new de.beaverstudios.plw.Screens.MainMenuScreen(this));
	}

	public void render() {
		super.render();
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}

}