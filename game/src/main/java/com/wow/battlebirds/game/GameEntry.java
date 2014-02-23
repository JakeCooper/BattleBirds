package com.wow.battlebirds.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.util.Log;

/**
 * Created by ChrisH on 22/02/14.
 */
public class GameEntry extends Thread {

    private SurfaceHolder surfaceHolder;
    private GameView gamePanel;

    private boolean running;

    public GameEntry(SurfaceHolder surfaceHolder, GameView gamePanel)
    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    public void setRunning(boolean running)
    {
            this.running = running;
    }

    @Override
    public void run()
    {
        Rect dstRect = new Rect();
        long startTime = System.nanoTime();

        while (running)
        {
            if(!gamePanel.getHolder().getSurface().isValid())
                continue;

            float deltaTime = (System.nanoTime() - startTime) / 10000000.000f;
            startTime = System.nanoTime();

//            gamePanel.game.getRenderer().clearScreen();

            gamePanel.game.getCurrentScreen().update(deltaTime);
            gamePanel.game.getCurrentScreen().draw();

            Canvas canvas = gamePanel.getHolder().lockCanvas();
            canvas.getClipBounds(dstRect);
            canvas.drawBitmap(gamePanel.getFramebuffer(), null, dstRect, null);
            gamePanel.getHolder().unlockCanvasAndPost(canvas);
        }
    }
}
