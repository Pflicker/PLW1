package de.beaverstudios.plw.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Grass on 11/3/2015.
 */
public class Base extends Unit {

    public Base(Integer p) {

        life = 100;
        armor = 50;
        damage = 50;
        range = 5;
        stealthDetect = true;
        attackGround = true;
        attackFlying = true;
        movementspeed = 0;
        attackspeed = 1;

        skin =  new Texture(Gdx.files.internal("base.png"));

        if (p == 0) {
            x = 0;
            direction = false;
        } else {
            x = (int)(Gdx.graphics.getWidth()*0.8 - 16);
            direction = true;
        }

        y = 32;

    }




}
