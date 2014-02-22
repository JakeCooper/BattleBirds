package com.wow.battlebirds.game;

import android.graphics.Paint;

/**
 * Created by ChrisH on 22/02/14.
 */
public interface Renderer
{

    public Image newImage(String file);

    public void clearScreen();

    public void drawLine();

    public void drawBox();

    public void drawImage(Image img, int x, int y);

    public void drawString(String str, Paint paint);
}
