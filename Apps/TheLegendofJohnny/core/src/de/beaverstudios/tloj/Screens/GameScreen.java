package de.beaverstudios.tloj.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.beaverstudios.tloj.AssetManager;
import de.beaverstudios.tloj.Entitiys.Player;
import de.beaverstudios.tloj.InputProcessor.InputProcessor;
import de.beaverstudios.tloj.Interface.HUD;
import de.beaverstudios.tloj.MyGame;

/**
 * Created by Grass on 5/10/2016.
 */
public class GameScreen implements Screen {

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    private SpriteBatch batch;
    private BitmapFont font;

    private InputProcessor ip;

    private OrthographicCamera gameCam;
    private static Stage gameStage;
    private Viewport gamePort;
    private float gameCamX;
    private float gameCamY;

    private Player player;
    private boolean centerCamToPlayer;

    public static AssetManager am;

    private HUD hud;

    private final MyGame game;

    public GameScreen(final MyGame game) {
        this.game = game;

        // create Batch
        batch = new SpriteBatch();
        font = new BitmapFont();

        // create the camera and the SpriteBatch
        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(MyGame.V_WIDTH, MyGame.V_HEIGHT, gameCam);
        gameStage = new Stage(gamePort,batch);

        // create Map and Maprenderer
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("map2.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1);

        gameCamX = gamePort.getWorldWidth() / 2;
        gameCamY = gamePort.getWorldHeight() / 2;
        gameCam.position.set(gameCamX, gameCamY, 0);

        am = new AssetManager();

        player = new Player();
        hud = new HUD(this);

        ip = new InputProcessor(this);
        InputMultiplexer im = new InputMultiplexer();
        im.addProcessor(hud.getHudStage());
        im.addProcessor(ip);
        im.addProcessor(gameStage);
        Gdx.input.setInputProcessor(im);
    }

    public void update(float dt) {

        gameCam.update();
        renderer.setView(gameCam);
        if(centerCamToPlayer){
            gameCamX = player.getX();
            gameCamY = player.getY();
            gameCam.position.set(gameCamX,gameCamY,0);
        }
        hud.update(dt);


        player.update(dt);

    }
    @Override
    public void render(float dt) {

        update(dt);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gamePort.apply();
        renderer.render();
        batch.setProjectionMatrix(gameCam.combined);
        batch.begin();
        player.draw(batch);
        batch.end();

        hud.getHudStage().draw();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
        gameCam.update();
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        batch.dispose();
        font.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }

    public OrthographicCamera getGameCam() {
        return gameCam;
    }

    public void setGameCam(OrthographicCamera gameCam) {
        this.gameCam = gameCam;
    }

    public static Stage getGameStage() {
        return gameStage;
    }

    public void setGameStage(Stage gameStage) {
        this.gameStage = gameStage;
    }

    public Viewport getGamePort() {
        return gamePort;
    }

    public void setGamePort(Viewport gamePort) {
        this.gamePort = gamePort;
    }

    public float getGameCamX() {
        return gameCamX;
    }

    public void setGameCamX(float gameCamX) {
        this.gameCamX = gameCamX;
    }

    public float getGameCamY() {
        return gameCamY;
    }

    public void setGameCamY(float gameCamY) {
        this.gameCamY = gameCamY;
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCenterCamToPlayer(boolean b){
        centerCamToPlayer = b;
    }

    public boolean isCenterCamToPlayer() {
        return centerCamToPlayer;
    }
}


