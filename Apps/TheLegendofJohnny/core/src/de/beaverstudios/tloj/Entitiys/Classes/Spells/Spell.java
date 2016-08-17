package de.beaverstudios.tloj.Entitiys.Classes.Spells;

/**
 * Created by Grass on 5/11/2016.
 */
public class Spell {
    private Integer spellID;
    private Integer resourceCost;
    private String name;
    private String description;
    private float castTime;
    private Integer levelRequirement;
    private SpellType spellType;

    public Spell(Integer spellID, Integer resourceCost, String name, String description, float castTime, Integer levelRequirement, SpellType spellType) {
        this.spellID = spellID;
        this.resourceCost = resourceCost;
        this.name = name;
        this.description = description;
        this.castTime = castTime;
        this.levelRequirement = levelRequirement;
        this.spellType = spellType;
    }
}
