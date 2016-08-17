package de.beaverstudios.tloj.Entitiys;

/**
 * Created by Grass on 5/24/2016.
 */
public class UnitManager {
    private Player[] players;

    public UnitManager() {

    }

    public void update(float dt){
        for (Player p : players){
            p.update(dt);
        }
    }

    public void render(){
        for (Player p : players){
           // p.draw();
        }
    }
}
