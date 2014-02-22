package com.wow.battlebirds.game;

import java.io.IOException;
import java.io.InputStream;

import android.graphics.Paint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

/**
 * Created by ChrisH on 22/02/14.
 */
public class AndroidRenderer implements Renderer {

    private Bitmap framebuffer;
    private AssetManager assets;
    private Game game;

    public AndroidRenderer(Game game, AssetManager assets, Bitmap frameBuffer)
    {
        this.game = game;
    }

    public Image newImage(String file)
    {
        Options options = new Options();
        options.inPreferredConfig = Config.ARGB_4444;

        InputStream in = null;
        Bitmap bitmap = null;

        try {
            in = assets.open(file);
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

    public void clearScreen()
    {

    }

    public void drawLine()
    {

    }

    public void drawBox()
    {

    }

    public void drawImage(Image img)
    {

    }

    public void drawString(String str, Paint paint)
    {

    }
}