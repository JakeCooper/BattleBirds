package com.wow.battlebirds.game;

import android.graphics.Point;

import com.wow.battlebirds.engine.entity.Entity;

/**
 * Created by ChrisH on 22/02/14.
 */
public class Map extends Entity {

    private int offsetX;

    Map()
    {
        super(new Point(0,0), new Point(0, 0));
    }

    void updateOffset(int newOffset)
    {
        offsetX += newOffset;
    }

    void setOffset(int newOffset)
    {
        offsetX = newOffset;
    }

    int getOffset()
    {
        return offsetX;
    }

    @Override
    public void update(float deltaT)
    {

    }
}
