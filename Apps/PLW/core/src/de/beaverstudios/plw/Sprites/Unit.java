package de.beaverstudios.plw.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import de.beaverstudios.plw.Screens.GameScreen;

/**
 * Created by Grass on 11/3/2015.
 */
public class Unit{


    protected World world;
    protected GameScreen screen;
    public Body b2body;
    public Vector2 velocity;

    Integer x,y;
    Integer w;

    Integer h;
    Integer dx,dy;
    Integer life;
    Integer armor, movementspeed, range, damage, damageType;
    float timeSinceShot, attackspeed;
    Texture skin;
    Boolean invisible, flying;
    Boolean attackFlying, attackGround;
    Boolean stealthDetect;
    Boolean direction;
    float rotate;


    public Unit(){

    }

    public Integer getW() {
        return w;
    }

    public Integer getH() {
        return h;
    }

    public float getTimeSinceShot() {
        return timeSinceShot;
    }

    public void setTimeSinceShot(float timeSinceShot) {
        this.timeSinceShot = timeSinceShot;
    }

    public float getRotate() {
        return rotate;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getDx() {
        return dx;
    }

    public void setDx(Integer dx) {
        this.dx = dx;
    }

    public Integer getDy() {
        return dy;
    }

    public void setDy(Integer dy) {
        this.dy = dy;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Integer getArmor() {
        return armor;
    }

    public Integer getMovementspeed() {
        return movementspeed;
    }

    public Float getAttackspeed() {
        return attackspeed;
    }

    public Integer getRange() {
        return range;
    }

    public Integer getDamage() {
        return damage;
    }

    public Integer getDamageType() {
        return damageType;
    }

    public Texture getSkin() {
        return skin;
    }

    public Boolean getInvisible() {
        return invisible;
    }

    public Boolean getFlying() {
        return flying;
    }

    public Boolean getAttackFlying() {
        return attackFlying;
    }

    public Boolean getAttackGround() {
        return attackGround;
    }

    public Boolean getStealthDetect() {
        return stealthDetect;
    }

    public Boolean getDirection() {
        return direction;
    }

    public void spawnUnit(){

    }
    public Boolean rangeCheck(int x,int r){

        return true;
    }

    public void update(){
        if(life <= 0){
            // Game Over
        }

    }


    public void draw(SpriteBatch sb){

        if(direction){
            rotate = 180;
        }
        sb.draw(skin,x,y,0,0,16,16,1,1,0,1,1,16,16,direction,false);


    }

    public void dispose(){

    }


}
