package com.wow.battlebirds.engine.entity.collision;

import android.graphics.Point;

/**
 * Package com.wow.battlebirds.engine.entity.collision
 * Created by ChrisH on 07/03/14.
 *
 * Holds information relating to the bounds of a 2D rectangle.
 * Used for the collision detection of entities.
 */
public class BoundingRectangle
{
    private Point minimum;
    private Point maximum;

    public BoundingRectangle(Point min, Point max)
    {
        this.setMinimum(min);
        this.setMaximum(max);
    }

    public BoundingRectangle(int minX, int minY, int maxX, int maxY)
    {
        this.minimum = new Point(minX, minY);
        this.maximum = new Point(maxX, maxY);
    }

    public boolean contains(Point pt)
    {
        return this.minimum.x <= pt.x && pt.x <= this.maximum.x &&
               this.minimum.y <= pt.y && pt.y <= this.maximum.y;
    }

    public void setMinimum(Point min)
    {
        this.minimum = min;
    }

    public void setMaximum(Point max)
    {
        this.maximum = max;
    }

    public void setMinimum(int x, int y)
    {
        this.minimum.x = x;
        this.minimum.y = y;
    }

    public void setMaximum(int x, int y)
    {
        this.maximum.x = x;
        this.maximum.y = y;
    }

    public void setExtents(Point minimum, Point maximum)
    {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Point getMinimum()
    {
        return this.minimum;
    }

    public Point getMaximum()
    {
        return this.maximum;
    }

    // Returns the center point of the rectangle
    public Point getCenter()
    {
        // This could cause some rounding errors..
        return new Point( (int)((this.minimum.x + this.maximum.x) * 0.5f),
                (int)((this.minimum.y + this.maximum.y) * 0.5f ));
    }
}
