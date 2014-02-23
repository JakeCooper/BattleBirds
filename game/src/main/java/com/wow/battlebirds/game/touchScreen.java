package com.wow.battlebirds.game;

import android.view.MotionEvent;
import android.view.View;
import android.graphics.Point;
import java.lang.Math;


/**
 * Created by Andrew on 22/02/14.
 */
public abstract class touchScreen implements Input{
    float dx = 0;
    float dy = 0;
    Cannon cannon;

    // When touchscreen is created, set the current cannon.
    public touchScreen(Cannon a){
        this.cannon = a;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        dx = event.getRawX();
        dy = event.getRawY();
        Point p = new Point((int)dx, (int)dy);

        float diff = event.getRawY() - getMotionEvents().peek().getRawY();
        if(event.getAction() == MotionEvent.ACTION_UP){

            // Makes a new Box
            if(event.getRawX() == getMotionEvents().peek().getRawX() || event.getRawY() == getMotionEvents().peek().getRawY() ){

                Block b = new Block(p);

            // Fires the cannon
            }else if(p == cannon.position ){
                Bird projectile = new Bird(cannon.position, 10, cannon.angle);

            // Moves the cannon
            }else if(event.getRawX() != getMotionEvents().peek().getRawX()){
                // If diff is positive, then increase the angle
                for(int i = 0; i < Math.abs(diff); i++){
                    if(diff > 0){
                        cannon.cannonRotation(1);
                    }else{
                        cannon.cannonRotation(-1);
                    }
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
