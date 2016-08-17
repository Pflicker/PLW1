package de.beaverstudios.tloj.Interface.characterScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import de.beaverstudios.tloj.Interface.HUD;
import de.beaverstudios.tloj.Interface.inventory.Slot;
import de.beaverstudios.tloj.Interface.inventory.SlotTooltip;
import de.beaverstudios.tloj.Interface.inventory.TooltipListener;

/**
 * Created by Grass on 8/17/2016.
 */
public class ItemSlotActor extends ImageButton implements ItemSlotListener{

    private ItemSlot itemSlot;
    private Skin skin;

    public ItemSlotActor(Skin skin, ItemSlot itemSlot) {
        super(createStyle(skin, itemSlot));
        this.itemSlot = itemSlot;
        this.skin = skin;

        itemSlot.addListener(this);

        ItemSlotTooltip tooltip = new ItemSlotTooltip(itemSlot, skin);
        tooltip.setTouchable(Touchable.disabled); // allows for mouse to hit tooltips in the top-right corner of the screen without flashing
        HUD.hudStage.addActor(tooltip);
        addListener(new TooltipListener(tooltip, true));
    }

    private static ImageButtonStyle createStyle(Skin skin, ItemSlot itemSlot) {
        TextureAtlas icons = new TextureAtlas(Gdx.files.internal("Heroes/soldier.atlas"));
        TextureRegion image;
        if (itemSlot.getItem() != null) {
            image = icons.findRegion(itemSlot.getItem().getTextureRegion());
        } else {
            image = icons.findRegion("1");
        }
        ImageButtonStyle style = new ImageButtonStyle(skin.get(ButtonStyle.class));
        style.imageUp = new TextureRegionDrawable(image);
        style.imageDown = new TextureRegionDrawable(image);

        return style;
    }

    public ItemSlot getItemSlot() {
        return itemSlot;
    }

    //@Override
    public void hasChanged(ItemSlot itemSlot) {
        setStyle(createStyle(skin, itemSlot));
    }

}
