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
public class HealthBar extends Actor{

    private Texture healthBar;
    private Color color;
    private Texture healthBarBackground;
    private Player player;

    public HealthBar(float x, float y, float width, float height, Player player) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        this.player = player;
        color = new Color(Color.GREEN);
        createTexture((int) width, (int) height, color);
        createBackgroundTexture((int) width, (int) height);
    }

    private void createTexture(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(0, 0, width, height);
        healthBar = new Texture(pixmap);
        pixmap.dispose();
    }

    private void createBackgroundTexture(int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.fillRectangle(0, 0, width, height);
        healthBarBackground = new Texture(pixmap);
        pixmap.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(healthBarBackground, getX(), getY(), getWidth(), getHeight());
        if (player.getHealth() >= (player.getMaxHealth() * 2 / 3)) {
            healthBar.dispose();
            createTexture((int)getWidth(), (int) getHeight(), Color.GREEN);
        } else if (player.getHealth() >= (player.getMaxHealth() * 1 / 3)) {
            healthBar.dispose();
            createTexture((int) getWidth(), (int) getHeight(), Color.YELLOW);
        } else {
            healthBar.dispose();
            createTexture((int) getWidth(), (int) getHeight(), Color.RED);
        }
        batch.draw(healthBar, getX(), getY(), (float) getWidth() * (float) player.getHealth() / (float) player.getMaxHealth(), getHeight());
    }

    public void dispose() {
        healthBar.dispose();
        healthBarBackground.dispose();
    }
}
