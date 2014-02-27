package com.wow.battlebirds.game;

import java.util.List;
import java.util.ListIterator;
import android.graphics.Point;

import com.wow.battlebirds.engine.EngineInterface;
import com.wow.battlebirds.engine.BitmapImage;
import com.wow.battlebirds.engine.Screen;
import com.wow.battlebirds.engine.entity.asset.Asset;

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
    BitmapImage redBarrel;
    BitmapImage blueBarrel;

    public GameScreen(EngineInterface engine)
    {
        super(engine);
        state = GameState.STATE_INIT;

        Block block = new Block(new Point(0, 0));
        block.image = engine.getRenderer().newImage("Box2.png");
        engine.getAssetFactory().addAsset(block);

        map = new Map();
        map.image = engine.getRenderer().newImage("Background2.png");
        map.setOffset(-1000);

        redCannon = new Cannon(new Point(40,720-302), 20, 0);
        redCannon.image = engine.getRenderer().newImage("cannon_chassis2.png");
        redBarrel = engine.getRenderer().newImage("cannon_main2.png");

        blueCannon = new Cannon(new Point(4200,40), 20, 1);
        blueCannon.image = engine.getRenderer().newImage("cannon_chassis2.png");
        blueBarrel = engine.getRenderer().newImage("cannon_main2.png");

        state = GameState.STATE_RUN;
    }

    @Override
    public void update(float deltaTime)
    {
        if(state == GameState.STATE_RUN)
        {
            List<Asset> assets = engine.getAssetFactory().retrieveAssets();
            for (ListIterator<Asset> iter = assets.listIterator(); iter.hasNext(); )
            {
                Asset asset = iter.next();
                asset.update(deltaTime);
            }
        }
    }

    @Override
    public  void draw()
    {
        if(state == GameState.STATE_RUN)
        {
            // Draw map
            engine.getRenderer().drawImage(map.image, map.getOffset(), 0);

            engine.getRenderer().drawImage(redCannon.image, redCannon.position.x, redCannon.position.y);
            engine.getRenderer().drawImage(redBarrel, redCannon.position.x+138, redCannon.position.y+110);
            engine.getRenderer().drawImage(blueCannon.image, blueCannon.position.x, blueCannon.position.y);
            engine.getRenderer().drawImage(blueBarrel, blueCannon.position.x+67, blueCannon.position.y+12);

            List<Asset> assets = engine.getAssetFactory().retrieveAssets();
            for (ListIterator<Asset> iter = assets.listIterator(); iter.hasNext(); )
            {
                Asset asset = iter.next();

                engine.getRenderer().drawImage(asset.image, asset.position.x, asset.position.y);
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
