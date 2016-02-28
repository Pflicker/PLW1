package de.beaverstudios.plw.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.beaverstudios.plw.PlwGame;
import de.beaverstudios.plw.Scenes.Hud;
import de.beaverstudios.plw.Sprites.Base;
import de.beaverstudios.plw.Sprites.Unit;
import de.beaverstudios.plw.Tools.B2WorldCreator;

public class GameScreen implements Screen {
    private PlwGame game;


    private Hud hud;

    public long startTime;
    public long gameTime;
    public long gameTimeInt;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;


    private SpriteBatch sb;

    private OrthographicCamera gamecam;
    private Viewport gamePort;

    //box2D variables

    private World world;
    private Box2DDebugRenderer b2dr;


    private Integer PLAYER = 0;
    private Integer COM = 1;


    Base playerBase;
    Base comBase;

    Unit unit;



    public GameScreen(final PlwGame gam) {
        this.game = gam;

        startTime = System.nanoTime();
        gameTimeInt = 0;

        // create the camera and the SpriteBatch
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(PlwGame.V_WIDTH / PlwGame.PPM, PlwGame.V_HEIGHT/ PlwGame.PPM, gamecam);

        hud = new Hud(game.batch);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1 / PlwGame.PPM);

        sb = new SpriteBatch();


        gamecam.position.set(gamePort.getWorldWidth() / 2   , gamePort.getWorldHeight() / 2, 0);

        world = new World(new Vector2(0,0), true);
        b2dr = new Box2DDebugRenderer();

        new B2WorldCreator(world, map);

        playerBase = new Base(PLAYER);
        comBase = new Base(COM);


    }

    public void handleInput(float dt){
        if (Gdx.input.isTouched()){
           // if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {

           // }
            //if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x <= 2){
               // player.b2body.applyLinearImpulse(new Vector2(0.1f, 0), player.b2body.getWorldCenter(), true);
           // }
           // if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && (player.b2body.getLinearVelocity().x <= -2)){
               // player.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), player.b2body.getWorldCenter(), true);
            //}

        }

    }
    public void update(float dt){
        handleInput(dt);
        world.step(1 / 60f, 6, 2);

        gameTime = System.nanoTime() - startTime;
        gameTimeInt = TimeUtils.timeSinceNanos(startTime)/1000000;
        hud.timeS = "Time: " + gameTimeInt / 1000;

        gamecam.update();
        renderer.setView(gamecam);
        hud.update(dt);

    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        b2dr.render(world, gamecam.combined);

        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();


        game.batch.end();

        sb.begin();
        comBase.draw(sb);
        playerBase.draw(sb);
        hud.draw(sb);
        sb.end();


    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);

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
        world.dispose();
        b2dr.dispose();
        hud.dispose();
        sb.dispose();

    }

}