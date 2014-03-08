package com.wow.battlebirds.engine.input;

import java.util.Queue;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Andrew on 22/02/14.
 * For keeping up with touch events
 *
 * This base class will be inherited by either a Single or Multi touch class.
 */
public abstract class BaseTouchInput implements View.OnTouchListener
{
    protected ITouchEventCallback TouchEventCallback;

    public float scaleX;
    public float scaleY;

    public void setTouchEventCallback(ITouchEventCallback callback)
    {
        this.TouchEventCallback = callback;
    }

    public void fireTouchEvent(TouchEvent event)
    {
        event.x *= scaleX;
        event.y *= scaleY;

        this.TouchEventCallback.onTouch(event);
    }
}

