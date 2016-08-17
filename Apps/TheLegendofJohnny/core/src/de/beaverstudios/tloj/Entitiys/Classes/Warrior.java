package de.beaverstudios.tloj.Entitiys.Classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import de.beaverstudios.tloj.Entitiys.Classes.Spells.SpellManager;

/**
 * Created by Grass on 5/11/2016.
 */
public class Warrior extends HeroClass {



    public Warrior() {

        setMinResource(0);
        setResource(50);
        setMaxResource(100);
        setResourceName("Fury");
        setResourceColor(Color.RED);

        atlas = new TextureAtlas(Gdx.files.internal("Heroes/soldier.atlas"));
        walkFrames[0] = (atlas.findRegion("1"));
        walkFrames[1] = (atlas.findRegion("2"));
        walkFrames[2] = (atlas.findRegion("3"));
        walkFrames[3] = (atlas.findRegion("4"));
        walkAnimation = new Animation(1/4f, walkFrames);

        spellbook.add(0);

    }
}
