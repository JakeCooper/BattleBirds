package com.wow.battlebirds.game;

import java.util.List;
import android.graphics.Point;

import com.wow.battlebirds.engine.EngineInterface;
import com.wow.battlebirds.engine.Screen;
import com.wow.battlebirds.engine.entity.Entity;
import com.wow.battlebirds.engine.entity.EntityManager;

/**
 * Created by ChrisH on 22/02/14.
 */
public class GameScreen extends Screen
{
    public enum GameState { STATE_INIT, STATE_RUN, STATE_PAUSE }
    GameState state;
    public Map map;
    public Cannon redCannon;
    public Cannon blueCannon;
    Entity redBarrel;
    Entity blueBarrel;

    public GameScreen(EngineInterface engine)
    {
        super(engine);
        state = GameState.STATE_INIT;

        map = new Map();
        map.asset = engine.getAssetFactory().getAsset("Background2.png");
        map.setOffset(-1000);

        redCannon = new Cannon(new Point(40,720-302), 20, 0);
        redCannon.asset = engine.getAssetFactory().getAsset("cannon_chassis2.png");
        redBarrel = new Cannon(new Point(redCannon.position.x+138, redCannon.position.y+110), 20, 0);
        redBarrel.asset = engine.getAssetFactory().getAsset("cannon_main2.png");

        blueCannon = new Cannon(new Point(4200,40), 20, 1);
        blueCannon.asset = engine.getAssetFactory().getAsset("cannon_chassis2.png");
        blueBarrel = new Cannon(new Point(blueCannon.position.x+67, blueCannon.position.y+12), 20, 1);
        blueBarrel.asset = engine.getAssetFactory().getAsset("cannon_main2.png");

        EntityManager.addEntity(map);
        EntityManager.addEntity(redCannon);
        EntityManager.addEntity(blueCannon);
        EntityManager.addEntity(redBarrel);
        EntityManager.addEntity(blueBarrel);

        state = GameState.STATE_RUN;
    }

    @Override
    public void update(float deltaTime)
    {
        if(state == GameState.STATE_RUN)
        {
            List<Entity> entities = EntityManager.retrieveEntities();
            for(Entity a : entities)
            {
                a.update(deltaTime);
            }
        }
    }

    @Override
    public  void draw()
    {
        if(state == GameState.STATE_RUN)
        {
            List<Entity> entities = EntityManager.retrieveEntities();
            for(Entity a : entities)
            {
                a.draw(engine.getRenderer());
            }
        }
    }

    @Override
    public  void pause()
    {
        state = GameState.STATE_PAUSE;
    }

    @Override
    public  void resume()
    {
        state = GameState.STATE_RUN;
    }
}
