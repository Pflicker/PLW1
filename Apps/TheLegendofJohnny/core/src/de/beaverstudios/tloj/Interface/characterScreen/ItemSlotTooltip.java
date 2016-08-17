package de.beaverstudios.tloj.Interface.characterScreen;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import de.beaverstudios.tloj.Interface.inventory.Slot;
import de.beaverstudios.tloj.Interface.inventory.SlotListener;

/**
 * Created by Grass on 8/17/2016.
 */
public class ItemSlotTooltip extends Window implements ItemSlotListener{

        private Skin skin;
        private ItemSlot itemSlot;

        public ItemSlotTooltip(ItemSlot itemSlot, Skin skin) {
            super("Tooltip...", skin);
            this.itemSlot = itemSlot;
            this.skin = skin;
            hasChanged(itemSlot);
            itemSlot.addListener(this);
            setVisible(false);
        }

        @Override
        public void hasChanged(ItemSlot itemSlot) {
            if (itemSlot.isEmpty()) {
                setVisible(false);
                return;
            }

            // title displays the amount
            getTitleLabel().setText(itemSlot.getItem().getName());
            clear();
            Label label = new Label("Super awesome description of " + itemSlot.getItem().getName(), skin);

            Label strength = new Label("Strength: " + itemSlot.getItem().getStrength(),skin);
            Label agility = new Label("Agility: " + itemSlot.getItem().getAgility(),skin);
            Label intellect = new Label("Intellect: " + itemSlot.getItem().getIntellect(),skin);
            Label spirit = new Label("Spirit: " + itemSlot.getItem().getSpirit(),skin);

            Label haste = new Label("Haste: " + itemSlot.getItem().getHaste(),skin);
            Label criticalChance = new Label("CHC: " + itemSlot.getItem().getCriticalChance(),skin);
            Label criticalDamage = new Label("CHD: " + itemSlot.getItem().getCriticalDamage(),skin);
            Label defense = new Label("Defense: " + itemSlot.getItem().getDefensive(),skin);

            columnDefaults(0);
            columnDefaults(1);
            add(label).colspan(2);
            row();
            add(strength).left();
            add(haste).left();
            row();
            add(agility).left();
            add(criticalChance).left();
            row();
            add(intellect).left();
            add(criticalDamage).left();
            row();
            add(spirit).left();
            add(defense).left();

            pack();
        }

        @Override
        public void setVisible(boolean visible) {
            super.setVisible(visible);
            // the listener sets this to true in case the itemSlot is hovered
            // however, we don't want that in case the itemSlot is empty
            if (itemSlot.isEmpty()) {
                super.setVisible(false);
            }
        }


    }
