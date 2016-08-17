package de.beaverstudios.tloj.Entitiys.playerExtensions;

import com.badlogic.gdx.utils.Array;

import de.beaverstudios.tloj.Entitiys.Items.Item;
import de.beaverstudios.tloj.Entitiys.Items.ItemDB;
import de.beaverstudios.tloj.Interface.inventory.Slot;

/**
 * Created by Grass on 5/25/2016.
 */
public class Inventory {

    private Array<Slot> slots;

    public Inventory() {
        slots = new Array<Slot>(25);
        for (int i = 0; i < 25; i++) {
            slots.add(new Slot(null, 0));
        }
        slots.get(0).add(ItemDB.itemDB[0],1);
    }

    public int checkInventory(Item item) {
        int amount = 0;

        for (Slot slot : slots) {
            if (slot.getItem() == item) {
                amount += slot.getAmount();
            }
        }
        return amount;
    }

    public boolean store(Item item, int amount) {
        // first check for a slot with the same item type
        Slot itemSlot = firstSlotWithItem(item);
        if (itemSlot != null) {
            itemSlot.add(item, amount);
            return true;
        } else {
            // now check for an available empty slot
            Slot emptySlot = firstSlotWithItem(null);
            if (emptySlot != null) {
                emptySlot.add(item, amount);
                return true;
            }
        }
        // no slot to add
        return false;
    }

    public Array<Slot> getSlots() {
        return slots;
    }

    private Slot firstSlotWithItem(Item item) {
        for (Slot slot : slots) {
            if (slot.getItem() == item) {
                return slot;
            }
        }

        return null;
    }

}
