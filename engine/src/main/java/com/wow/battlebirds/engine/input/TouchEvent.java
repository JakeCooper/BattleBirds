package com.wow.battlebirds.engine.input;

import android.view.MotionEvent;

/**
 * Created by ChrisH on 27/02/14.
 */
public class TouchEvent
{
    public static final int TOUCH_DOWN = MotionEvent.ACTION_DOWN;
    public static final int TOUCH_UP = MotionEvent.ACTION_UP;
    public static final int TOUCH_MOVED = MotionEvent.ACTION_MOVE;
    public static final int TOUCH_CANCEL = MotionEvent.ACTION_CANCEL;

    protected int type;
    protected float x, y;
    protected int pointer;
    protected int pointerIndex;

    private MotionEvent mEvent;

    public TouchEvent(MotionEvent event)
    {
        this.mEvent = event;
        this.x = event.getX();
        this.y = event.getY();
        this.pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        this.pointer = event.getPointerId( this.pointerIndex );

        final int action = event.getAction() & MotionEvent.ACTION_MASK;
        switch(action)
        {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                this.type = TOUCH_DOWN;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                this.type = TOUCH_UP;
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_OUTSIDE:
                this.type = TOUCH_CANCEL;
                break;
            case MotionEvent.ACTION_MOVE:
                this.type = TOUCH_MOVED;
                break;
        }

    }

    public float getX()
    {
        return this.x;
    }

    public float getY()
    {
        return this.y;
    }

    public int getMotionType()
    {
        return type;
    }

    public int getPointerIndex()
    {
        return this.pointerIndex;
    }

    public int getPointerID()
    {
        return this.pointer;
    }

    public MotionEvent getMotionEvent()
    {
        return this.mEvent;
    }
}
