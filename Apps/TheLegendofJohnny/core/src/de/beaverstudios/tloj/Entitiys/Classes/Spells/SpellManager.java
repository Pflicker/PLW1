package de.beaverstudios.tloj.Entitiys.Classes.Spells;

import com.badlogic.gdx.utils.Array;

/**
 * Created by Grass on 5/25/2016.
 */
public class SpellManager {

    public static Array<Spell> spells = new Array<Spell>();

    public SpellManager() {
        spells.add(new Spell(0,20,"Charge","Charges Target",0,0,SpellType.SINGLETARGET));
    }
}
