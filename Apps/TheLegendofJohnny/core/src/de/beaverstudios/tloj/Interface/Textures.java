package de.beaverstudios.tloj.Interface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 * Created by Grass on 5/11/2016.
 */
public class Textures {
    private final Image playerInfo;


    public Textures() {
        playerInfo = new Image(new Texture(Gdx.files.internal("UI/PlayerInfo.png")));
        playerInfo.setDrawable(new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal("UI/PlayerInfo.png")))));
    }

    public Image getPlayerInfo() {
        return playerInfo;
    }
}
