package com.wow.battlebirds.engine;

import android.view.MotionEvent;
import android.view.View;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by Andrew on 22/02/14.
 */
public class touchScreen implements Input{

    public float scaleX;
    public float scaleY;
    private Queue<MotionEvent> eventlist;
    public Queue<MotionEvent> getMotionEvents(){
        return eventlist;
    }

    touchScreen(float scaleX, float scaleY)
    {
        eventlist = new LinkedList<MotionEvent>();
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        eventlist.add(event);
        return true;
    }
}
