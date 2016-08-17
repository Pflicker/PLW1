package de.beaverstudios.tloj;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.beaverstudios.tloj.Screens.MainMenuScreen;

public class MyGame extends Game {
	public static final int V_HEIGHT = 640;
	public static final int V_WIDTH = 800;

	@Override
	public void create () {
		setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	public void dispose() {
	}
}

