package com.wow.battlebirds.engine.entity;

import android.graphics.Point;
import com.wow.battlebirds.engine.entity.asset.Asset;
import com.wow.battlebirds.engine.entity.collision.BoundingRectangle;
import com.wow.battlebirds.engine.input.TouchEvent;
import com.wow.battlebirds.engine.renderer.IRenderer;

/**
 * Created by ChrisH on 27/02/14.
 *
 * This class will become the base class for all major game objects.
 */
public abstract class Entity
{
    public Asset asset;

    public Point position;
    public Point size;

    private BoundingRectangle bounds;

    protected boolean touchDown;

    public Entity(Point createPosition, Point createSize){

        this.size = createSize;
        this.position = createPosition;

        // Create our bounding rectangle
        this.bounds = new BoundingRectangle(this.position, this.size);

        // This boolean is set to true when the entity is touched by player input
        // to track pointer movement, and set to false when the entity is released
        this.touchDown = false;
    }

    public BoundingRectangle getBounds()
    {
        return bounds;
    }

    public boolean onTouched(TouchEvent event)
    {
        return false;
    }

    public void update(float deltaT)
    {
        this.size.x = this.position.x+80;
        this.size.y = this.position.y+80;

        // We update our bounding box each frame in case the size or position of our object changes
        this.bounds.setExtents(this.position, this.size);
    }

    public void draw(IRenderer renderer)
    {
        renderer.drawImage(this.asset, this.position.x, this.position.y);
    }
}
