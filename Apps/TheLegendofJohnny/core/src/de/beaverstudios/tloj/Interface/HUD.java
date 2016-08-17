package de.beaverstudios.tloj.Interface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.sql.Time;

import de.beaverstudios.tloj.Interface.characterScreen.CharacterScreenActor;
import de.beaverstudios.tloj.Interface.inventory.InventoryActor;
import de.beaverstudios.tloj.MyGame;
import de.beaverstudios.tloj.Screens.GameScreen;

/**
 * Created by Grass on 5/11/2016.
 */
public class HUD {

    public static Stage hudStage;
    private Viewport hudPort;
    private OrthographicCamera hudCam;
    private Skin skin;
    private GameScreen gameScreen;

    private Table hudTable;
    private Table playerInfo;

    private Label inGameTime;
    private Time gameTime;
    private Label playerHealth;
    private Label playerResource;
    private Label playerName;
    private Textures textures;
    private HealthBar healthBar;
    private ResourceBar resourceBar;
    private static InventoryActor inventoryActor;
    private static CharacterScreenActor characterScreenActor;

    public HUD(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        skin = new Skin(Gdx.files.internal("Skins/uiskin.json"));
        skin.getFont("default-font").getData().setScale(1f);
        hudCam = new OrthographicCamera();
        hudPort = new FitViewport(MyGame.V_WIDTH,MyGame.V_HEIGHT,hudCam);
        hudStage = new Stage(hudPort, gameScreen.getBatch());

        textures=new Textures();

        hudTable = new Table(skin);
        hudTable.setFillParent(true);
        hudTable.debug();

        playerInfo = new Table(skin);
        playerInfo.setSize(MyGame.V_WIDTH*0.2f, MyGame.V_HEIGHT*0.2f);
        playerInfo.setBackground(textures.getPlayerInfo().getDrawable());
        playerInfo.setPosition(0,hudPort.getWorldHeight()-playerInfo.getHeight());
        playerInfo.debug();

        healthBar = new HealthBar(0,playerInfo.getY()+playerInfo.getHeight()/4,playerInfo.getWidth(),playerInfo.getHeight()/4,gameScreen.getPlayer());
        resourceBar = new ResourceBar(0,playerInfo.getY(),playerInfo.getWidth(),playerInfo.getHeight()/4,gameScreen.getPlayer());

        gameTime = new Time(0);
        inGameTime = new Label("Time: " + gameTime,skin);

        playerName = new Label("Name",skin);
        playerHealth = new Label("Health: "+ gameScreen.getPlayer().getHealth() + "/" + gameScreen.getPlayer().getMaxHealth(),skin);
        playerResource = new Label(gameScreen.getPlayer().getHeroClass().getResource() + "/" + gameScreen.getPlayer().getHeroClass().getMaxResource(),skin);

        playerInfo.row().height(playerInfo.getHeight()/2);
        playerInfo.add().padLeft(playerInfo.getWidth()/4);
        playerInfo.add(playerName).top().expandX();
        playerInfo.row().height(playerInfo.getHeight()/4);
        playerInfo.add(playerHealth).colspan(2);
        playerInfo.row().height(playerInfo.getHeight()/4);
        playerInfo.add(playerResource).colspan(2);

        DragAndDrop dnd = new DragAndDrop();
        inventoryActor = new InventoryActor(gameScreen.getPlayer().getInventory(),dnd,skin);
        characterScreenActor = new CharacterScreenActor(gameScreen.getPlayer().getCharacterScreen(),skin);

        hudStage.addActor(healthBar);
        hudStage.addActor(resourceBar);
        hudStage.addActor(playerInfo);
        hudStage.addActor(hudTable);
        hudStage.addActor(inventoryActor);
        hudStage.addActor(characterScreenActor);
    }

    public void update(float dt){
        inGameTime.setText("Time: " + gameTime);
        playerHealth.setText("Health: " + gameScreen.getPlayer().getHealth() + "/" + gameScreen.getPlayer().getMaxHealth());
        playerResource.setText(gameScreen.getPlayer().getHeroClass().getResourceName() + ":" + gameScreen.getPlayer().getHeroClass().getResource() + "/" + gameScreen.getPlayer().getHeroClass().getMaxResource());
        hudStage.act();
    }

    public static Stage getHudStage() {
        return hudStage;
    }

    public void setHudStage(Stage hudStage) {
        this.hudStage = hudStage;
    }

    public static InventoryActor getInventoryActor() {
        return inventoryActor;
    }

    public static CharacterScreenActor getCharacterScreenActor() {
        return characterScreenActor;
    }
}
