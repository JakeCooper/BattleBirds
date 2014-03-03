package com.wow.battlebirds.engine.entity.asset;

import com.wow.battlebirds.engine.BitmapImage;

/**
 * Created by ChrisH on 22/02/14.
 *
 * A container for different types of assets such as sounds or images.
 */
public class Asset
{
    public BitmapImage image;

    public int refCount;

    public Asset()
    {
        refCount = 0;
    }
}
