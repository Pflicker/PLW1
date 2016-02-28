package de.beaverstudios.plw.Sprites;

/**
 * Created by Grass on 11/8/2015.
 */
public class Building {
    Integer unit;
    Long spawnTime;
    Long timeSinceSpawn;

    public void spawn(Long spawnTimer,Integer unit){
        timeSinceSpawn = System.currentTimeMillis() - spawnTime;

        if (timeSinceSpawn >= spawnTimer){
            // spawn Unit
        }

    }
}
