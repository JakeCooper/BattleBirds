package com.wow.battlebirds.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by ChrisH on 22/02/14.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private GameEntry thread;
    private Bitmap framebuffer;
    public Game game;

    public GameView(Context context, Game game, Bitmap framebuffer)
    {
        super(context);
        getHolder().addCallback(this);
        thread = new GameEntry(getHolder(), this);
        this.framebuffer = framebuffer;
        this.game = game;

        setFocusable(true);
    }

    public Bitmap getFramebuffer()
    {
        return framebuffer;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        while (retry)
        {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {

            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas)
    {

    }
}
