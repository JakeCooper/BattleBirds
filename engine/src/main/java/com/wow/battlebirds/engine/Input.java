package com.wow.battlebirds.engine;

import java.util.Queue;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Andrew on 22/02/14.
 * For keeping up with touch events
 */
public interface Input extends View.OnTouchListener{

    public static class TouchEvent{
        public static final int TOUCH_DOWN = 0;
        public static final int TOUCH_UP = 1;
        public static final int TOUCH_DRAGGED = 2;
        public static final int TOUCH_HOLD = 3;

        public int type;
        public int x, y;
        public int pointer;

    }



    public Queue<MotionEvent> getMotionEvents();
}

