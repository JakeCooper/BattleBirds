package com.wow.battlebirds.engine.input;

import android.view.MotionEvent;
import android.view.View;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by Andrew on 22/02/14.
 */
public class MultiTouchInput extends BaseTouchInput
{
    public Queue<MotionEvent> getMotionEvents(){
        return eventlist;
    }

    public MultiTouchInput(float scaleX, float scaleY)
    {
        eventlist = new LinkedList<MotionEvent>();
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        this.fireTouchEvent(new TouchEvent(event));
        return true;
    }
}
