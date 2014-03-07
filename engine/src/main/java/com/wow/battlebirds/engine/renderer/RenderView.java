package com.wow.battlebirds.engine.renderer;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by ChrisH on 22/02/14.
 *
 * This class creates a framebuffer, for double buffering.
 * Everything is drawn to this framebuffer before it is blitted to the screen.
 */
public class RenderView extends SurfaceView implements SurfaceHolder.Callback
{
    private RenderThread thread;
    private Bitmap frameBuffer;
    public Context context;

    public int deviceWidth;
    public int deviceHeight;

    public boolean isPortrait;

    public RenderView(Context context, int deviceWidth, int deviceHeight)
    {
        super(context);
        this.context = context;

        this.getHolder().addCallback(this);

        this.deviceWidth = deviceWidth;
        this.deviceHeight = deviceHeight;

        isPortrait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;

        int frameBufferWidth = isPortrait ? 720: 1280;
        int frameBufferHeight = isPortrait ? 1280: 720;

        this.frameBuffer = Bitmap.createBitmap(frameBufferWidth, frameBufferHeight, Bitmap.Config.ARGB_8888);

        this.setFocusable(true);
    }

    public Bitmap getFramebuffer()
    {
        return frameBuffer;
    }

    public void setThread(RenderThread thread)
    {
        this.thread = thread;
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
