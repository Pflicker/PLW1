package de.beaverstudios.tloj.Entitiys;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import de.beaverstudios.tloj.Entitiys.Classes.*;
import de.beaverstudios.tloj.Entitiys.playerExtensions.CharacterScreen;
import de.beaverstudios.tloj.Entitiys.playerExtensions.Inventory;

/**
 * Created by Grass on 5/10/2016.
 */
public class Player extends Unit{

    private Inventory inventory;
    private CharacterScreen characterScreen;
    private de.beaverstudios.tloj.Entitiys.Classes.HeroClass heroClass;
    private Integer xp;
    private Integer gold;
    private Integer location;

    private float walkStateTime;
    private float loadStateTime;
    private float shootStateTime;
    private enum State {
        STAND,WALK, LOAD, SHOOT;
    }
    private State state;
    private boolean moveLeft;
    private boolean moveRight;
    private boolean moveUp;
    private boolean moveDown;

    public Player() {

        inventory=new Inventory();
        characterScreen = new CharacterScreen();
        heroClass = new Warrior();
        xp = 0;
        gold = 0;
        setMaxHealth(100);
        setHealth(getMaxHealth());
        state = State.STAND;

    }

    public void update(float dt){
        if(moveLeft){
            setX(getX()-1);
            walkStateTime += dt;
        }
        if(moveRight){
            setX(getX()+1);
            walkStateTime += dt;
        }
        if(moveUp){
            setY(getY()+1);
            walkStateTime += dt;
        }
        if(moveDown){
            setY(getY()-1);
            walkStateTime += dt;
        }

        switch(state){
            case STAND:{
                break;
            }
            case WALK:{
                walkStateTime += dt;
                break;
            }
            case LOAD:{
                loadStateTime += dt;
                break;
            }
            case SHOOT:{
                shootStateTime +=dt;
                break;
            }
        }
    }

    public void draw(SpriteBatch batch){
        switch (state){
            case STAND:{
                heroClass.walkAnimation.getKeyFrame(0);
                break;
            }
            case WALK:{
                heroClass.walkAnimation.getKeyFrame(walkStateTime);
                break;
            }
            case LOAD:{
                heroClass.loadingAnimation.getKeyFrame(loadStateTime);
                break;
            }
            case SHOOT:{
                heroClass.shootAnimation.getKeyFrame(shootStateTime);
                break;
            }
        }
        batch.draw(heroClass.walkAnimation.getKeyFrame(walkStateTime, true), getX(),getY());
    }


    public de.beaverstudios.tloj.Entitiys.Classes.HeroClass getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(de.beaverstudios.tloj.Entitiys.Classes.HeroClass heroClass) {
        this.heroClass = heroClass;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setMoveLeft(boolean b){
        moveLeft = b;
    }
    public void setMoveRight(boolean b){
        moveRight = b;
    }
    public void setMoveUp(boolean b){
        moveUp = b;
    }
    public void setMoveDown(boolean b){
        moveDown = b;
    }

    public CharacterScreen getCharacterScreen() {
        return characterScreen;
    }


}
