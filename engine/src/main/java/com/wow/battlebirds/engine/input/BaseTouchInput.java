package com.wow.battlebirds.engine.input;

import java.util.Queue;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Andrew on 22/02/14.
 * For keeping up with touch events
 */
public abstract class BaseTouchInput implements View.OnTouchListener
{
    protected ITouchEventCallback TouchEventCallback;

    public float scaleX;
    public float scaleY;

    protected Queue<MotionEvent> eventlist;

    public void setTouchEventCallback(ITouchEventCallback callback)
    {
        this.TouchEventCallback = callback;
    }

    public void fireTouchEvent(TouchEvent event)
    {
        this.TouchEventCallback.onTouch(event);
    }

    public Queue<MotionEvent> getMotionEvents()
    {
        return eventlist;
    }
}

