package com.wow.battlebirds.engine.renderer;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import java.util.Iterator;
import java.util.Queue;
import android.graphics.Point;

import com.wow.battlebirds.engine.Engine;
import com.wow.battlebirds.engine.input.MultiTouchInput;
import com.wow.battlebirds.game.Block;

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

            // Traverses all the current touch events
            /*
            Queue<MotionEvent> eventlist = engine.getInput().getMotionEvents();
            MultiTouchInput input = (MultiTouchInput) engine.getInput();

            for(Iterator<MotionEvent> iter = eventlist.iterator(); iter.hasNext(); )
            {
                MotionEvent event = eventlist.peek();

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    downEvent = eventlist.remove();
                }
               else  if(event.getAction() == MotionEvent.ACTION_UP){
                    upEvent = eventlist.remove();
                }
                else
                    eventlist.remove();
                /*
                if(upEvent != null && downEvent != null)
                {
                    int diff = (int)(upEvent.getRawY() - downEvent.getRawY());
                    GameScreen screen = (GameScreen)view.engine.getCurrentScreen();

                    // Create a new Block
                    if(downEvent.getRawX() == upEvent.getRawX() || downEvent.getRawY() == upEvent.getRawY() ){

                        Block b = new Block(new Point((int)upEvent.getRawX(), (int)downEvent.getRawY()));
                        b.image = view.engine.getRenderer().newImage("Box2.png");
                        view.engine.getAssetFactory().addAsset(b);


                    // Fires the cannon
                    }else if(new Point((int)downEvent.getRawX(), (int)upEvent.getRawY()) == screen.redCannon.position ){
                            Bird projectile = new Bird(screen.redCannon.position,20, (int)screen.redCannon.angle);
                            view.engine.getAssetFactory().addAsset(projectile);

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

                    upEvent = null;
                    downEvent = null;

                }else{
                    continue;
                }
                */

          //  }

            float deltaTime = (System.nanoTime() - startTime) / 10000000.000f;
            startTime = System.nanoTime();

            try {
                engine.getEngineLock().lock();

                engine.getRenderer().clearScreen(0);

                engine.getCurrentScreen().update(deltaTime);
                engine.getCurrentScreen().draw();

                Canvas canvas = this.surfaceHolder.lockCanvas();

                if(canvas != null)
                {
                    canvas.getClipBounds(dstRect);
                    Renderer render = (Renderer)engine.getRenderer();
                    canvas.drawBitmap(render.getView().getFramebuffer(), null, dstRect, null);

                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            } finally {
                engine.getEngineLock().unlock();
            }
        }
    }
}
