package de.beaverstudios.tloj.Entitiys.Classes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import de.beaverstudios.tloj.Entitiys.Classes.Spells.Spell;

/**
 * Created by Grass on 5/11/2016.
 */

public abstract class HeroClass {
    public Array<Integer> spellbook;
    private String resourceName;
    private Integer resource;
    private Integer minResource;
    private Integer maxResource;
    private Color resourceColor;
    public TextureAtlas atlas;
    public Animation walkAnimation;
    public Animation loadingAnimation;
    public Animation shootAnimation;
    public TextureRegion[] walkFrames = new TextureRegion[4];
    public TextureRegion[] loadingFrames = new TextureRegion[4];
    public TextureRegion[] shootFrames = new TextureRegion[4];

    public HeroClass() {
        spellbook = new Array<Integer>();
    }

    public Array<Integer> getSpellbook() {
        return spellbook;
    }

    public void setSpell(Array<Integer> spellbook) {
        this.spellbook = spellbook;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getResource() {
        return resource;
    }

    public void setResource(Integer resource) {
        this.resource = resource;
    }

    public Integer getMinResource() {
        return minResource;
    }

    public void setMinResource(Integer minResource) {
        this.minResource = minResource;
    }

    public Integer getMaxResource() {
        return maxResource;
    }

    public void setMaxResource(Integer maxResource) {
        this.maxResource = maxResource;
    }

    public Color getResourceColor() {
        return resourceColor;
    }

    public void setResourceColor(Color resourceColor) {
        this.resourceColor = resourceColor;
    }


}


