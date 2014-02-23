package com.wow.battlebirds.game;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by ChrisH on 22/02/14.
 */
public class GameScreen extends Screen
{
    public enum GameState { STATE_INIT, STATE_RUN, STATE_PAUSE }
    private int tickCount;
    GameState state;

    public GameScreen(Game game)
    {
        super(game);
        state = GameState.STATE_INIT;

        Block block = new Block(new android.graphics.Point(0, 0), 0, 0);
        block.image = game.getRenderer().newImage("block.bmp");
        game.getAssetFactory().addAsset(block);

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

            tickCount += deltaTime;
        }
    }

    @Override
    public  void draw()
    {
        if(state == GameState.STATE_RUN)
        {
            List<Asset> assets = game.getAssetFactory().retrieveAssets();
            for (ListIterator<Asset> iter = assets.listIterator(); iter.hasNext(); )
            {
                Asset asset = iter.next();

                if(tickCount > 10)
                {
                    int x = (int)(Math.random() * ((800 - 0) + 1));
                    int y = (int)(Math.random() * ((800 - 0) + 1));
                    game.getRenderer().drawImage(asset.image, x, y);
                    tickCount = 0;
                }
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
