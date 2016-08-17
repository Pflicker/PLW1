package de.beaverstudios.tloj.Entitiys;

/**
 * Created by Grass on 8/17/2016.
 */
public class Unit extends Entity {

    public Unit target;
    private Integer maxHealth;
    private Integer health;

    public Unit() {

        target = null;

    }

    public Unit getTarget() {
        return target;
    }
    public void setTarget(Unit target) {
        this.target = target;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(Integer maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
}
