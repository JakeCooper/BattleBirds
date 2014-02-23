package com.wow.battlebirds.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.util.Log;
import java.util.Queue;
import android.graphics.Point;
import java.lang.Math;

/**
 * Created by ChrisH on 22/02/14.
 */
public class GameEntry extends Thread {

    private SurfaceHolder surfaceHolder;
    private GameView gamePanel;

    private boolean running;
    private touchScreen events;

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
        events = new touchScreen();
        while (running)
        {
            if(!gamePanel.getHolder().getSurface().isValid())
                continue;

            // Traverses all the current touch events

            Queue<MotionEvent> eventlist = events.getMotionEvents();
            MotionEvent upEvent;
            MotionEvent downEvent;

            while(eventlist.peek() != null){

                if(eventlist.peek().getAction() == MotionEvent.ACTION_UP){
                    upEvent = eventlist.remove();
                    downEvent = eventlist.remove();
                    int diff = (int)(upEvent.getRawY() - downEvent.getRawY());
                    GameScreen screen = (GameScreen)gamePanel.game.getCurrentScreen();


                    // Create a new Block
                    if(downEvent.getRawX() == upEvent.getRawX() || downEvent.getRawY() == upEvent.getRawY() ){

                        Block b = new Block(new Point((int)upEvent.getRawX(), (int)downEvent.getRawY()));
                        gamePanel.game.getAssetFactory().addAsset(b);


                    // Fires the cannon
                    }else if(new Point((int)downEvent.getRawX(), (int)upEvent.getRawY()) == screen.redCannon.position ){
                            Bird projectile = new Bird(screen.redCannon.position,20, (int)screen.redCannon.angle);
                            gamePanel.game.getAssetFactory().addAsset(projectile);

                    // Moves the cannon
                    }else if(upEvent.getRawX() != downEvent.getRawX()){
                        // If diff is positive, then increase the angle
                        for(int i = 0; i < Math.abs(diff); i++){
                            if(diff > 0){
                                screen.redCannon.cannonRotation(1);
                            }else{
                                screen.redCannon.cannonRotation(-1);
                            }
                        }
                    }

                }else{
                    continue;
                }

            }



            float deltaTime = (System.nanoTime() - startTime) / 10000000.000f;
            startTime = System.nanoTime();

            gamePanel.game.getRenderer().clearScreen(0);

            gamePanel.game.getCurrentScreen().update(deltaTime);
            gamePanel.game.getCurrentScreen().draw();

            Canvas canvas = gamePanel.getHolder().lockCanvas();
            canvas.getClipBounds(dstRect);
            canvas.drawBitmap(gamePanel.getFramebuffer(), null, dstRect, null);
            gamePanel.getHolder().unlockCanvasAndPost(canvas);
        }
    }
}
