package com.wow.battlebirds.game;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Andrew on 22/02/14.
 */
public abstract class touchScreen implements View.OnTouchListener{
    int dx = 0;
    int dy = 0;
    Cannon cannon = new Cannon(1);
    @Override
    public boolean onTouch(View v, MotionEvent event){
        dx = (int)event.getRawX();
        dy = (int)event.getRawY();

        if(event.getAction() == MotionEvent.ACTION_UP){

            // Makes a new Box
            if(event.getRawX() == dx || event.getRawY() == dy ){
                Block b = new Block();

            // Fires the cannon
            }else if(event.getRawX() == 0 || event.getRawY() == 0 ){
                Bird projectile = new Bird(cannon.player, cannon.angle, cannon.xPos, cannon.yPos);

            // Moves the cannon
            }else if(event.getRawX() != dx || event.getRawY() != dy ){
                for(int i = dx; dx <= event.getRawY(); i++){
                    cannon.angle = cannon.angle + 1;
                }
            }

            return true;
        }
        return false;
    }
}
