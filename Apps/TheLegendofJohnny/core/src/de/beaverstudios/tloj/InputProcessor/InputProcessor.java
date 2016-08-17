package de.beaverstudios.tloj.InputProcessor;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

import de.beaverstudios.tloj.Interface.HUD;
import de.beaverstudios.tloj.Screens.GameScreen;

/**
 * Created by Grass on 5/11/2016.
 */
public class InputProcessor implements com.badlogic.gdx.InputProcessor {

    private GameScreen gameScreen;

    public InputProcessor(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }


    @Override
        public boolean keyDown(int keycode) {

            switch (keycode)
            {
                case Input.Keys.LEFT:
                    gameScreen.getPlayer().setMoveLeft(true);
                    break;
                case Input.Keys.RIGHT:
                    gameScreen.getPlayer().setMoveRight(true);
                    break;
                case Input.Keys.UP:
                    gameScreen.getPlayer().setMoveUp(true);
                    break;
                case Input.Keys.DOWN:
                    gameScreen.getPlayer().setMoveDown(true);
                    break;
                case Input.Keys.SPACE:
                    if(gameScreen.isCenterCamToPlayer()){
                        gameScreen.setCenterCamToPlayer(false);
                    } else {
                        gameScreen.setCenterCamToPlayer(true);
                    }
                    break;
                case Input.Keys.I:
                    if(HUD.getInventoryActor().isVisible()){
                        HUD.getInventoryActor().setVisible(false);
                    } else {
                        HUD.getInventoryActor().setVisible(true);
                    }
                    break;
                case Input.Keys.C:
                    if(HUD.getCharacterScreenActor().isVisible()){
                        HUD.getCharacterScreenActor().setVisible(false);
                    } else {
                        HUD.getCharacterScreenActor().setVisible(true);
                    }
                    break;
            }
            return true;
        }

        @Override
        public boolean keyUp(int keycode) {
            switch (keycode)
            {
                case Input.Keys.LEFT:
                    gameScreen.getPlayer().setMoveLeft(false);
                    break;
                case Input.Keys.RIGHT:
                    gameScreen.getPlayer().setMoveRight(false);
                    break;
                case Input.Keys.UP:
                    gameScreen.getPlayer().setMoveUp(false);
                    break;
                case Input.Keys.DOWN:
                    gameScreen.getPlayer().setMoveDown(false);
                    break;
            }
            return true;
        }

        @Override
        public boolean keyTyped(char character) {
            return false;
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {

            Vector2 vector;
            vector = new Vector2();

            vector.set(screenX, screenY);
            gameScreen.getGameStage().screenToStageCoordinates(vector);

            System.out.println("ScreenCoords: " + screenX + " " + screenY);
            System.out.println("StageCoords: " + vector.x + " " + vector.y);

            return true;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            return false;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            return false;
        }

        @Override
        public boolean mouseMoved(int screenX, int screenY) {

            return false;
        }

        @Override
        public boolean scrolled(int amount) {
            gameScreen.getGameCam().zoom += 0.1*amount;
            return true;
        }

}
