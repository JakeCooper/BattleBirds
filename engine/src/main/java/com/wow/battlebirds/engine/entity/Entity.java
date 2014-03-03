package com.wow.battlebirds.engine.entity;

import android.graphics.Point;
import com.wow.battlebirds.engine.entity.asset.Asset;
import com.wow.battlebirds.engine.renderer.IRenderer;

/**
 * Created by ChrisH on 27/02/14.
 *
 * This class will become the base class for all major game objects.
 */
public abstract class Entity
{
    public Asset asset;
    public int team;

    public Point position;

    public int length;
    public int height;

    public Point[] corners;

    public Point[] GetPoints() {
        Point Tl = new Point((this.position.x - (this.length / 2)), (this.position.y + this.height / 2));
        Point Tr = new Point((this.position.x + (this.length / 2)), (this.position.y + this.height / 2));
        Point Bl = new Point((this.position.x - (this.length / 2)), (this.position.y - this.height / 2));
        Point Br = new Point((this.position.x + (this.length / 2)), (this.position.y - this.height / 2));

        Point[] BlockPoints = {Tl, Tr, Bl, Br};

        return BlockPoints;
    }

    public Entity(Point createPosition, int length, int height){
        this.length = length;
        this.height = height;

        this.position = createPosition;
        this.corners = GetPoints();
    }

    public abstract void update(float deltaT);

    public void draw(IRenderer renderer)
    {
        renderer.drawImage(this.asset, position.x, position.y);
    }
}
