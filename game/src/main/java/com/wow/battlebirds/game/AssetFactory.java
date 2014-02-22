package com.wow.battlebirds.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChrisH on 22/02/14.
 */
public class AssetFactory
{
    private List<Asset> Assets;

    public AssetFactory()
    {
        Assets = new ArrayList<Asset>();
    }

    public void addAsset(Asset asset)
    {
        Assets.add(asset);
    }

    public void deleteAssets()
    {
        Assets = null;
        Assets = new ArrayList<Asset>();
    }

    public List<Asset> retrieveAssets()
    {
        return Assets;
    }
}
