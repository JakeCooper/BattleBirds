package com.wow.battlebirds.game;

import android.view.MotionEvent;
import android.view.View;
import android.graphics.Point;
import java.lang.Math;
import java.util.Queue;


/**
 * Created by Andrew on 22/02/14.
 */
public class touchScreen implements Input{

    private Queue<MotionEvent> eventlist;
    public Queue<MotionEvent> getMotionEvents(){
        return eventlist;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        eventlist.add(event);
        return true;
    }
}
