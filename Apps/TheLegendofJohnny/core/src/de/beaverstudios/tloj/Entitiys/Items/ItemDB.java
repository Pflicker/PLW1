package de.beaverstudios.tloj.Entitiys.Items;

/**
 * Created by Grass on 5/25/2016.
 */
public class ItemDB {
    public static Item[] itemDB;

    public ItemDB() {
        itemDB = new Item[10];
        itemDB[0] = new Weapon(0,"Sword",0,1,0,0,0,1,1,1,1,1,"2",2,1);
    }

    public Item[] getItemDB() {
        return itemDB;
    }

    public Item getItemByID(Integer itemID){
        return itemDB[itemID];
    }

}
