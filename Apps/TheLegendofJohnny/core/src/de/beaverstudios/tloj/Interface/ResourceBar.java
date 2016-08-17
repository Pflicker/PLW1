package de.beaverstudios.tloj.Interface;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import de.beaverstudios.tloj.Entitiys.Player;

/**
 * Created by Grass on 5/11/2016.
 */
public class ResourceBar extends Actor {
        private Texture resourceBar;
        private Color color;
        private Texture resourceBarBackground;
        private Player player;

        public ResourceBar(float x, float y, float width, float height, Player player) {
            setX(x);
            setY(y);
            setWidth(width);
            setHeight(height);
            this.player = player;
            color = player.getHeroClass().getResourceColor();
            createTexture((int) width, (int) height, color);
            createBackgroundTexture((int) width, (int) height);
        }

        private void createTexture(int width, int height, Color color) {
            Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
            pixmap.setColor(color);
            pixmap.fillRectangle(0, 0, width, height);
            resourceBar = new Texture(pixmap);
            pixmap.dispose();
        }

        private void createBackgroundTexture(int width, int height) {
            Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
            pixmap.setColor(Color.BLACK);
            pixmap.fillRectangle(0, 0, width, height);
            resourceBarBackground = new Texture(pixmap);
            pixmap.dispose();
        }
        @Override
        public void draw(Batch batch, float parentAlpha) {
        batch.draw(resourceBarBackground, getX(), getY(), getWidth(), getHeight());
        batch.draw(resourceBar, getX(), getY(), (float) getWidth() * (float) player.getHeroClass().getResource() / (float) player.getHeroClass().getMaxResource(), getHeight());
    }

        public void dispose() {
            resourceBar.dispose();
            resourceBarBackground.dispose();
        }
    }

