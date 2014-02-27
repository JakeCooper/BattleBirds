package com.wow.battlebirds.game;

import java.io.IOException;
import java.io.InputStream;

import android.graphics.Paint;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;

/**
 * Created by ChrisH on 22/02/14.
 */
public class AndroidRenderer implements Renderer
{
    private Canvas canvas;
    private AssetManager assets;
    Bitmap framebuffer;
    Game game;
    Rect srcRect = new Rect();
    Rect dstRect = new Rect();

    public AndroidRenderer(Game game, AssetManager assets, Bitmap frameBuffer)
    {
        this.game = game;
        this.assets = assets;
        this.framebuffer = frameBuffer;
        canvas = new Canvas(framebuffer);
    }

    public Image newImage(String file)
    {
        Options options = new Options();
        options.inPreferredConfig = Config.ARGB_8888;

        InputStream in = null;
        Bitmap bitmap = null;

        try {
            in = assets.open(file);
            if(in == null)
                throw new RuntimeException("Unable to find asset named '"
                        + file + "'");
            bitmap = BitmapFactory.decodeStream(in, null, options);
            if(bitmap == null)
                throw new RuntimeException("Couldn't load bitmap from asset '"
                    + file + "'");
        } catch(IOException e) {
            throw new RuntimeException("Couldn't load bitmap from asset '"
                    + file + "'");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }

        return new AndroidImage(bitmap);
    }

    @Override
    public void clearScreen(int colour)
    {
        canvas.drawRGB((colour & 0xff0000) >> 16, (colour & 0xff00) >> 8,
                (colour & 0xff));
    }

    public void drawLine()
    {

    }

    public void drawBox()
    {

    }

    @Override
    public void drawImage(Image img, int x, int y)
    {
        canvas.drawBitmap(img.getBitmap(), x, y, null);
    }

    @Override
    public void drawImageScaled(Image img, int x, int y, int width, int height, int srcX, int srcY, int srcWidth, int srcHeight)
    {
        srcRect.left = srcX;
        srcRect.top = srcY;
        srcRect.right = srcX + srcWidth;
        srcRect.bottom = srcY + srcHeight;

        dstRect.left = x;
        dstRect.top = y;
        dstRect.right = x + width;
        dstRect.bottom = y + height;

        canvas.drawBitmap(img.getBitmap(), srcRect, dstRect, null);
    }
    public void drawString(String str, Paint paint)
    {

    }
}
