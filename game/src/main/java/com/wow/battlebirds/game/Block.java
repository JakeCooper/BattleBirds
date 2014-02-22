package com.wow.battlebirds.game;

import android.view.Gravity;
import android.graphics.Point;

/**
 * Created by Jake on 22/02/14.
 */
public class Block extends Asset {
    public int length;
    public int height;
    public Point position;
    public Point[] corners;

    Block(Point createPosition, int length, int height){
        this.position = createPosition;
        this.length = length;
        this.height = height;

        this.corners = GetPoints();


    }/*BlockConstructor*/

    public Point[] GetPoints() {
        Point Tl = new Point((this.position.x - (this.length / 2)), (this.position.y + this.height / 2));
        Point Tr = new Point((this.position.x + (this.length / 2)), (this.position.y + this.height / 2));
        Point Bl = new Point((this.position.x - (this.length / 2)), (this.position.y - this.height / 2));
        Point Br = new Point((this.position.x + (this.length / 2)), (this.position.y - this.height / 2));

        Point[] BlockPoints = {Tl, Tr, Bl, Br};

        return BlockPoints;

    @Override
    public void update(float deltaT)
    {

    }

}/*BlockClass*/
