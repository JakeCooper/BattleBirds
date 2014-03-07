package com.wow.battlebirds.engine;

import android.graphics.Bitmap;

/**
 * Created by ChrisH on 22/02/14.
 *
 * Base class for any different types of Images the Engine will use.
 */
public interface ImageInterface
{
    public int getWidth();
    public int getHeight();
    public Bitmap getBitmap();
}
