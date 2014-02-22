package com.wow.battlebirds.game;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by ChrisH on 22/02/14.
 */
public class GameScreen extends Screen
{
    public GameScreen(Game game)
    {
        super(game);
    }

    @Override
    public void update(float deltaTime)
    {
        List<Asset> assets = game.getAssetFactory().retrieveAssets();
        for (ListIterator<Asset> iter = assets.listIterator(); iter.hasNext(); ) {
            Asset asset = iter.next();
            asset.update(deltaTime);
        }
    }

    @Override
    public  void draw()
    {

    }

    @Override
    public  void pause()
    {

    }

    @Override
    public  void resume()
    {

    }
}
