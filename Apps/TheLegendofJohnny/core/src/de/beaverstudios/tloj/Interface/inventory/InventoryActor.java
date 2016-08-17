package de.beaverstudios.tloj.Interface.inventory;

/**
 * Created by Grass on 5/24/2016.
 */
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

import de.beaverstudios.tloj.Entitiys.playerExtensions.Inventory;

/**
 * @author Daniel Holderbaum
 */
public class InventoryActor extends Window {

    public InventoryActor(Inventory inventory, DragAndDrop dragAndDrop, Skin skin) {
        super("Inventory", skin);

        TextButton closeButton = new TextButton("X", skin);
        closeButton.addListener(new HidingClickListener(this));

        setPosition(400, 100);
        defaults().space(8);
        row().fill().expandX();

        int i = 0;
        for (Slot slot : inventory.getSlots()) {
            SlotActor slotActor = new SlotActor(skin, slot);
            dragAndDrop.addSource(new SlotSource(slotActor));
            dragAndDrop.addTarget(new SlotTarget(slotActor));
            add(slotActor);

            i++;
            if (i % 5 == 0) {
                row();
            }
        }
        pack();

        // it is hidden by default
        setVisible(false);
    }

}
