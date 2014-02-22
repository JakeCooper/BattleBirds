package com.wow.battlebirds.game;

import android.view.SurfaceHolder;
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
        long tickCount = 0L;

        while (running)
        {
            tickCount++;
        }
    }
}
