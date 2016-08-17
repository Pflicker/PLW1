package de.beaverstudios.tloj.Interface.characterScreen;

/**
 * Created by Grass on 8/17/2016.
 */
public interface ItemSlotListener {

    /**
     * Will be called whenever the slot has changed.
     *
     * @param itemSlot
     *            The changed slot.
     */
    void hasChanged(ItemSlot itemSlot);

}
