package com.wow.battlebirds.engine.entity.asset;

import com.wow.battlebirds.engine.renderer.IRenderer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chris on 22/02/14.
 *
 * Container class for reusable Assets.
 * When an asset is requested, this class checks if an asset with the same name
 * has already been previously loaded. If it has, then the preloaded asset is returned.
 * If the asset is not yet loaded, then it is loaded into memory, returned, and kept track of.
 */
public class AssetFactory
{
    private Map<String, Asset> Assets;
    private IRenderer renderer;

    public AssetFactory(IRenderer renderer)
    {
        this.renderer = renderer;
        Assets = new HashMap<String, Asset>();
    }

    public void addAsset(String fileName, Asset asset)
    {
        Assets.put(fileName, asset);
    }

    public Asset getAsset(String fileName)
    {
        if(Assets.containsKey(fileName))
        {
            Asset asset = Assets.get(fileName);
            asset.refCount++;
            return asset;
        }
        else
        {
            Asset asset = new Asset();
            asset.image = this.renderer.newImage(fileName);
            asset.refCount++;

            this.addAsset(fileName, asset);

            return asset;
        }
    }

    public void removeAsset(String fileName)
    {
        if(Assets.containsKey(fileName))
        {
            Asset asset = Assets.get(fileName);

            if(--asset.refCount <= 0)
                Assets.remove(fileName);
        }
    }

    public void deleteAssets()
    {
        Assets.clear();
    }

    public Map<String, Asset> retrieveAssets()
    {
        return Assets;
    }
}
