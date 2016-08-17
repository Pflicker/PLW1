package de.beaverstudios.tloj.Entitiys.playerExtensions;

import java.util.ArrayList;

import de.beaverstudios.tloj.Entitiys.Items.Item;
import de.beaverstudios.tloj.Interface.characterScreen.ItemSlot;

/**
 * Created by Grass on 8/17/2016.
 */
public class CharacterScreen {

    private ArrayList<ItemSlot> itemSlots;

    public CharacterScreen() {

        itemSlots = new ArrayList<ItemSlot>();

        itemSlots.add(new ItemSlot(null,0,"Head"));
        itemSlots.add(new ItemSlot(null,1,"Neck"));
        itemSlots.add(new ItemSlot(null,2,"Shoulders"));
        itemSlots.add(new ItemSlot(null,3,"Chest"));
        itemSlots.add(new ItemSlot(null,4,"Bracers"));
        itemSlots.add(new ItemSlot(null,5,"Hands"));
        itemSlots.add(new ItemSlot(null,6,"Legs"));
        itemSlots.add(new ItemSlot(null,7,"Boots"));
        itemSlots.add(new ItemSlot(null,8,"Ring 1"));
        itemSlots.add(new ItemSlot(null,9,"Ring 2"));
        itemSlots.add(new ItemSlot(null,10,"Trinket 1"));
        itemSlots.add(new ItemSlot(null,11,"Trinket 2"));
        itemSlots.add(new ItemSlot(null,12,"MainHand"));
        itemSlots.add(new ItemSlot(null,13,"Offhand"));

    }



    public Item equip(Item item){
        Item returnItem;

        if(item != null){
            //remove Item from slot to inventory and item from inventory to slot

        } else {
            //equip Item and remove from inventory
            returnItem = null;
        }
        return item;
    }

    public ArrayList<ItemSlot> getItemSlots() {
        return itemSlots;
    }
}
