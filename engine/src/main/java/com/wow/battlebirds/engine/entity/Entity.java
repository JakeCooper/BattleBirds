package com.wow.battlebirds.engine.entity;

import android.graphics.Point;
import com.wow.battlebirds.engine.entity.asset.Asset;
import com.wow.battlebirds.engine.entity.collision.BoundingRectangle;
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

    public Entity(Point createPosition, Point createSize){

        this.size = createSize;
        this.position = createPosition;

        // Create our bounding rectangle
        this.bounds = new BoundingRectangle(this.position, this.size);
    }

    public void update(float deltaT)
    {
        // We update our bounding box each frame in case the size or position of our object changes
        this.bounds.setExtents(this.position, this.size);
    }

    public void draw(IRenderer renderer)
    {
        renderer.drawImage(this.asset, this.position.x, this.position.y);
    }
}
