package com.wow.battlebirds.engine.renderer;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;

import com.wow.battlebirds.engine.Engine;

/**
 * Created by ChrisH on 22/02/14.
 *
 * Thread that handles all rendering and drawing calls.
 */
public class RenderThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private Engine engine;

    private boolean running;

    public RenderThread(SurfaceHolder surfaceHolder, Engine engine)
    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.engine = engine;
    }

    public void setRunning(boolean running)
    {
            this.running = running;
    }

    public void pause()
    {
        running = false;
    }

    public void unpause()
    {
        running = true;
    }

    @Override
    public void run()
    {
        Rect dstRect = new Rect();
        long startTime = System.nanoTime();
        while (running)
        {
            if(!this.surfaceHolder.getSurface().isValid())
                continue;

            float deltaTime = (System.nanoTime() - startTime) / 10000000.000f;
            startTime = System.nanoTime();

            if(deltaTime > 1.9f)
                deltaTime = 1.9f;

            try {
                engine.getEngineLock().lock();

                engine.getRenderer().clearScreen(0);

                engine.getCurrentScreen().update(deltaTime);
                engine.getCurrentScreen().draw();

                Canvas canvas = this.surfaceHolder.lockCanvas();

                // Its possible for the canvas to be null if the user navigates away from the game
                if(canvas != null)
                {
                    canvas.getClipBounds(dstRect);
                    Renderer render = (Renderer)engine.getRenderer();
                    canvas.drawBitmap(render.getView().getFramebuffer(), null, dstRect, null);

                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
            finally {
                engine.getEngineLock().unlock();
            }
        }
    }
}
