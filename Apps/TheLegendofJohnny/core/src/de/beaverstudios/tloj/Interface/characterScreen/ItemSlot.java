package de.beaverstudios.tloj.Interface.characterScreen;

import com.badlogic.gdx.utils.Array;

import de.beaverstudios.tloj.Entitiys.Items.Item;
import de.beaverstudios.tloj.Interface.inventory.SlotListener;

/**
 * Created by Grass on 8/17/2016.
 */
public class ItemSlot {

    private Item item;
    private Integer itemSlotID;
    private String description;
    private Array<ItemSlotListener> itemSlotListeners = new Array<ItemSlotListener>();

    public ItemSlot(Item item, Integer itemSlotID, String description) {
        this.item = item;
        this.itemSlotID = itemSlotID;
        this.description = description;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getItemSlotID() {
        return itemSlotID;
    }

    public void setItemSlotID(Integer itemSlotID) {
        this.itemSlotID = itemSlotID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addListener(ItemSlotListener itemSlotListener) {
        itemSlotListeners.add(itemSlotListener);
    }

    public boolean isEmpty() {
        if (item == null){
            return true;
        } else {
            return false;
        }
    }
}
