package com.wow.battlebirds.game;

import android.view.MotionEvent;
import android.view.View;
import android.graphics.Point;


/**
 * Created by Andrew on 22/02/14.
 */
public abstract class touchScreen implements Input{
    int dx = 0;
    int dy = 0;
    Cannon cannon;

    // When touchscreen is created, set the current cannon.
    public touchScreen(Cannon a){
        this.cannon = a;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        dx = (int)event.getRawX();
        dy = (int)event.getRawY();
        Point p = new Point(dx, dy);

        if(event.getAction() == MotionEvent.ACTION_UP){

            // Makes a new Box
            if(event.getRawX() == getMotionEvents().peek().getRawX() || event.getRawY() == getMotionEvents().peek().getRawX() ){

                Block b = new Block(p);

            // Fires the cannon
            }else if(p == cannon.position ){
                Bird projectile = new Bird(cannon.position, 10, cannon.angle);

            // Moves the cannon
            }else if(event.getRawX() != dx || event.getRawY() != dy ){
                for(int i = dx; dx <= event.getRawY(); i++){
                    cannon.angle = cannon.angle + 1;
                }
            }
            // Remove the last element from the queue
            getMotionEvents().remove();
            return true;
        }else{
            // If the event has not been processed, enqueue the event
            getMotionEvents().add(event);
            return false;
        }

    }
}
