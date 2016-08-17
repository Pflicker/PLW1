package de.beaverstudios.tloj.Entitiys.Items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Grass on 5/11/2016.
 */
public class Item {
    private Integer itemID;
    private String name;
    private Integer slot;

    //MainStats
    private Integer strength;
    private Integer agility;
    private Integer intellect;
    private Integer spirit;

    //SecondaryStats
    private Integer haste;
    private Integer criticalChance;
    private Integer criticalDamage;
    private Integer defensive;

    //LevelReq
    private Integer minLvl;

    private String textureRegion;

    public Item(Integer itemID, String name, Integer slot, Integer strength, Integer agility, Integer intellect, Integer spirit, Integer haste, Integer criticalChance, Integer criticalDamage, Integer defensive, Integer minLvl, String textureRegion) {
        this.itemID = itemID;
        this.name = name;
        this.slot = slot;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.spirit = spirit;
        this.haste = haste;
        this.criticalChance = criticalChance;
        this.criticalDamage = criticalDamage;
        this.defensive = defensive;
        this.minLvl = minLvl;
        this.textureRegion = textureRegion;
    }

    public void create(){

    }

    public String getTextureRegion() {
        return textureRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getIntellect() {
        return intellect;
    }

    public void setIntellect(Integer intellect) {
        this.intellect = intellect;
    }

    public Integer getSpirit() {
        return spirit;
    }

    public void setSpirit(Integer spirit) {
        this.spirit = spirit;
    }

    public Integer getHaste() {
        return haste;
    }

    public void setHaste(Integer haste) {
        this.haste = haste;
    }

    public Integer getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(Integer criticalChance) {
        this.criticalChance = criticalChance;
    }

    public Integer getCriticalDamage() {
        return criticalDamage;
    }

    public void setCriticalDamage(Integer criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    public Integer getDefensive() {
        return defensive;
    }

    public void setDefensive(Integer defensive) {
        this.defensive = defensive;
    }

    public Integer getMinLvl() {
        return minLvl;
    }

    public void setMinLvl(Integer minLvl) {
        this.minLvl = minLvl;
    }

    public void setTextureRegion(String textureRegion) {
        this.textureRegion = textureRegion;
    }
}
