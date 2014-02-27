package com.wow.battlebirds.engine.renderer;

import android.graphics.Paint;

import com.wow.battlebirds.engine.Image;

/**
 * Created by ChrisH on 22/02/14.
 */
public interface IRenderer
{

    public Image newImage(String file);

    public void clearScreen(int colour);

    public void drawLine();

    public void drawBox();

    public void drawImage(Image img, int x, int y);

    public void drawImageScaled(Image img, int x, int y, int width, int height, int srcX, int srcY, int srcWidth, int srcHeight);

    public void drawString(String str, Paint paint);
}
