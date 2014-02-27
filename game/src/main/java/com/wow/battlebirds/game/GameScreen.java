package com.wow.battlebirds.game;

import java.util.List;
import java.util.ListIterator;
import android.graphics.Point;

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
    Image redBarrel;
    Image blueBarrel;

    public GameScreen(Game game)
    {
        super(game);
        state = GameState.STATE_INIT;

        Block block = new Block(new Point(0, 0));
        block.image = game.getRenderer().newImage("Box2.png");
        game.getAssetFactory().addAsset(block);

        map = new Map();
        map.image = game.getRenderer().newImage("Background2.png");
        map.setOffset(-1000);

        redCannon = new Cannon(new Point(40,720-302), 20, 0);
        redCannon.image = game.getRenderer().newImage("cannon_chassis2.png");
        redBarrel = game.getRenderer().newImage("cannon_main2.png");

        blueCannon = new Cannon(new Point(4200,40), 20, 1);
        blueCannon.image = game.getRenderer().newImage("cannon_chassis2.png");
        blueBarrel = game.getRenderer().newImage("cannon_main2.png");

        state = GameState.STATE_RUN;
    }

    @Override
    public void update(float deltaTime)
    {
        if(state == GameState.STATE_RUN)
        {
            List<Asset> assets = game.getAssetFactory().retrieveAssets();
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
            game.getRenderer().drawImage(map.image, map.getOffset(), 0);

            game.getRenderer().drawImage(redCannon.image, redCannon.position.x, redCannon.position.y);
            game.getRenderer().drawImage(redBarrel, redCannon.position.x+138, redCannon.position.y+110);
            game.getRenderer().drawImage(blueCannon.image, blueCannon.position.x, blueCannon.position.y);
            game.getRenderer().drawImage(blueBarrel, blueCannon.position.x+67, blueCannon.position.y+12);

            List<Asset> assets = game.getAssetFactory().retrieveAssets();
            for (ListIterator<Asset> iter = assets.listIterator(); iter.hasNext(); )
            {
                Asset asset = iter.next();

                game.getRenderer().drawImage(asset.image, asset.position.x, asset.position.y);
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
