package com.wow.battlebirds.game;

import android.graphics.Point;

/**
 * Created by ChrisH on 22/02/14.
 */
public abstract class Asset
{
    public Image image;
    public Sound sound;

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

    Asset(Point createPosition, int length, int height){
        this.length = length;
        this.height = height;

        this.position = createPosition;
        this.corners = GetPoints();
    }

    public abstract void update(float deltaT);



}
