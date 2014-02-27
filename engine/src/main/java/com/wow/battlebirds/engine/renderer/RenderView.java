package com.wow.battlebirds.engine.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.wow.battlebirds.engine.EngineInterface;

/**
 * Created by ChrisH on 22/02/14.
 */
public class RenderView extends SurfaceView implements SurfaceHolder.Callback {

    private RenderThread thread;
    private Bitmap framebuffer;
    public EngineInterface engine;

    public RenderView(Context context, EngineInterface engine, Bitmap framebuffer)
    {
        super(context);
        this.getHolder().addCallback(this);
        this.thread = new RenderThread(getHolder(), this);
        this.framebuffer = framebuffer;
        this.engine = engine;

        this.setFocusable(true);
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
