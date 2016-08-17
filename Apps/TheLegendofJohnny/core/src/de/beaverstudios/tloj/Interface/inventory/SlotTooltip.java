package de.beaverstudios.tloj.Interface.inventory;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

/**
 * Created by Grass on 5/24/2016.
 */
public class SlotTooltip extends Window implements SlotListener {

    private Skin skin;

    private Slot slot;

    public SlotTooltip(Slot slot, Skin skin) {
        super("Tooltip...", skin);
        this.slot = slot;
        this.skin = skin;
        hasChanged(slot);
        slot.addListener(this);
        setVisible(false);
    }

    @Override
    public void hasChanged(Slot slot) {
        if (slot.isEmpty()) {
            setVisible(false);
            return;
        }

        // title displays the amount
        getTitleLabel().setText(slot.getAmount() + "x " +slot.getItem().getName());
        clear();
        Label label = new Label("Super awesome description of " + slot.getItem().getName(), skin);

        Label strength = new Label("Strength: " + slot.getItem().getStrength(),skin);
        Label agility = new Label("Agility: " + slot.getItem().getAgility(),skin);
        Label intellect = new Label("Intellect: " + slot.getItem().getIntellect(),skin);
        Label spirit = new Label("Spirit: " + slot.getItem().getSpirit(),skin);

        Label haste = new Label("Haste: " + slot.getItem().getHaste(),skin);
        Label criticalChance = new Label("CHC: " + slot.getItem().getCriticalChance(),skin);
        Label criticalDamage = new Label("CHD: " + slot.getItem().getCriticalDamage(),skin);
        Label defense = new Label("Defense: " + slot.getItem().getDefensive(),skin);

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
        // the listener sets this to true in case the slot is hovered
        // however, we don't want that in case the slot is empty
        if (slot.isEmpty()) {
            super.setVisible(false);
        }
    }


}