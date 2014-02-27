package com.wow.battlebirds.engine.entity.asset;

import android.graphics.Point;

import com.wow.battlebirds.engine.BitmapImage;
import com.wow.battlebirds.engine.sound.ISound;

/**
 * Created by ChrisH on 22/02/14.
 */
public abstract class Asset
{
    public BitmapImage image;
    public ISound sound;

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

    public Asset(Point createPosition, int length, int height){
        this.length = length;
        this.height = height;

        this.position = createPosition;
        this.corners = GetPoints();
    }

    public abstract void update(float deltaT);



}
