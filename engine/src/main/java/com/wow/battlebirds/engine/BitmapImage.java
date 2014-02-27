package com.wow.battlebirds.engine;

import android.graphics.Bitmap;

/**
 * Created by ChrisH on 22/02/14.
 */
public class BitmapImage implements ImageInterface
{
    private Bitmap bitmap;

    public BitmapImage(Bitmap bitmap)
    {
        this.bitmap = bitmap;
    }

    @Override
    public int getWidth()
    {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight()
    {
        return bitmap.getHeight();
    }

    @Override
    public Bitmap getBitmap()
    {
        return bitmap;
    }
}
