package de.beaverstudios.tloj.Entitiys.Items;

/**
 * Created by Grass on 5/25/2016.
 */
public class Weapon extends Item {
    private Integer weaponDamage;
    private Integer weaponSpeed;

    public Weapon(Integer itemID, String name, Integer slot, Integer strength, Integer agility, Integer intellect, Integer spirit, Integer haste, Integer criticalChance, Integer criticalDamage, Integer defensive, Integer minLvl, String textureRegion,Integer weaponDamage, Integer weaponSpeed) {
        super(itemID,name,slot,strength,agility,intellect,spirit,haste,criticalChance,criticalDamage,defensive,minLvl,textureRegion);
        this.weaponDamage = weaponDamage;
        this.weaponSpeed = weaponSpeed;
    }

    public Integer getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(Integer weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public Integer getWeaponSpeed() {
        return weaponSpeed;
    }

    public void setWeaponSpeed(Integer weaponSpeed) {
        this.weaponSpeed = weaponSpeed;
    }
}
