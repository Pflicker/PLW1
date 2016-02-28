package de.beaverstudios.plw.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.beaverstudios.plw.PlwGame;

/**
 * Created by Grass on 10/25/2015.
 */
public class Hud implements Disposable {

    private Viewport viewport;
    BitmapFont font;

    public String timeS;

    public Integer incomeCom, incomePlayer;
    public Integer moneyCom, moneyPlayer;
    public long timeSinceInc;

    public String incomeComS;
    public String incomePlayerS;
    public String moneyComS;
    public String moneyPlayerS;

    Texture hudback;

    public Hud(SpriteBatch sb){

        timeSinceInc = System.nanoTime();

        incomeCom = 5;
        incomePlayer = 5;

        moneyCom = 100;
        moneyPlayer = 100;

        font = new BitmapFont();

        viewport = new FitViewport(PlwGame.V_WIDTH,PlwGame.V_HEIGHT, new OrthographicCamera());

        hudback = new Texture(Gdx.files.internal("hudback.png"));
    }


    public void update(float dt){



        if ( TimeUtils.timeSinceNanos(timeSinceInc)/1000 >= 5000000){
            moneyCom = moneyCom + incomeCom;
            moneyPlayer = moneyPlayer + incomePlayer;
            timeSinceInc = System.nanoTime();
        }

        incomeComS = "Income COM: " + incomeCom;
        incomePlayerS = "Income Player: " + incomePlayer;

        moneyComS = "Money COM: " + moneyCom;
        moneyPlayerS = "Money Player: " + moneyPlayer;


    }

    public void draw(SpriteBatch sb){
        sb.draw(hudback, (int) (Gdx.graphics.getWidth() * 0.8), 0, (int) Gdx.graphics.getWidth(), (int) Gdx.graphics.getHeight());
        font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        font.draw(sb, incomeComS, (int) (Gdx.graphics.getWidth() * 0.1f), (int) (Gdx.graphics.getHeight() * 0.9f));
        font.draw(sb, moneyComS,(int)(Gdx.graphics.getWidth()*0.1f)  ,(int) (Gdx.graphics.getHeight() * 0.9f)-15);

        font.draw(sb, timeS,(int)(Gdx.graphics.getWidth()*0.4f)  ,(int) (Gdx.graphics.getHeight() * 0.9f));

        font.draw(sb, moneyPlayerS,(int)(Gdx.graphics.getWidth()*0.7f)  ,(int) (Gdx.graphics.getHeight() * 0.9f)-15);
        font.draw(sb, incomePlayerS,(int)(Gdx.graphics.getWidth()*0.7f)  ,(int) (Gdx.graphics.getHeight() * 0.9f));




    }

    @Override
    public void dispose(){


    }


}
