package de.beaverstudios.tloj.Interface.inventory;

/**
 * Created by Grass on 5/24/2016.
 */
public interface SlotListener {

    /**
     * Will be called whenever the slot has changed.
     *
     * @param slot
     *            The changed slot.
     */
    void hasChanged(Slot slot);

}