package com.wow.battlebirds.engine.input;

/**
 * Created by ChrisH on 27/02/14.
 *
 * The Engine will use this class to directly receive input events from the TouchInput classes.
 */
public interface ITouchEventCallback {

    public void onTouch(TouchEvent event);
}
