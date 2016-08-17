package de.beaverstudios.tloj.Interface.characterScreen;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import de.beaverstudios.tloj.Entitiys.playerExtensions.CharacterScreen;
import de.beaverstudios.tloj.Interface.inventory.HidingClickListener;
import de.beaverstudios.tloj.Interface.inventory.Slot;
import de.beaverstudios.tloj.Interface.inventory.SlotActor;
import de.beaverstudios.tloj.Interface.inventory.SlotSource;
import de.beaverstudios.tloj.Interface.inventory.SlotTarget;

/**
 * Created by Grass on 8/17/2016.
 */
public class CharacterScreenActor extends Window {

    public CharacterScreenActor(CharacterScreen characterScreen, Skin skin){
        super("Character Screen",skin);

        TextButton closeButton = new TextButton("X", skin);
        closeButton.addListener(new HidingClickListener(this));

        setPosition(400, 100);
        defaults().space(8);
        row().fill().expandX();

        int i = 0;
        for (ItemSlot itemSlot : characterScreen.getItemSlots()) {
            ItemSlotActor itemSlotActor = new ItemSlotActor(skin, itemSlot);
            //dragAndDrop.addSource(new SlotSource(slotActor));
            //dragAndDrop.addTarget(new SlotTarget(slotActor));
            add(itemSlotActor);

            i++;
            if (i % 5 == 0) {
                row();
            }
        }
        pack();

        // it is hidden by default
        setVisible(true);
    }



}
