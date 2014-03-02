package com.wow.battlebirds.engine.input;

import android.view.MotionEvent;
import android.view.View;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by Andrew on 22/02/14.
 *
 * This extension of the BaseTouchInput class will serve to correctly handle multi touch input events.
 */
public class MultiTouchInput extends BaseTouchInput
{
    public MultiTouchInput(float scaleX, float scaleY)
    {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        this.fireTouchEvent(new TouchEvent(event));
        return true;
    }
}
