package com.wow.battlebirds.game;

import android.graphics.Point;
import android.view.Gravity;

import java.util.ArrayList;

/**
 * Created by Jake on 22/02/14.
 */
public class Block extends Asset {
    public int length;
    public int height;
    public Point position;
    public Point[] points;
    public int Vy;
    public int team;

    Block(){
        this.points = GetPoints();

        //GET INPUT AND CONVERT TO YPOS AND XPOS!
        if(position.y < 100) position.y = 100;
        while(position.y > 100) position.y--; //Dat Gravity


    }/*BlockConstructor*/

    public Point[] GetPoints() {
        Point Tl = new Point((position.x - (this.length / 2)), (position.y + this.height / 2));
        Point Tr = new Point((position.x + (this.length / 2)), (position.y + this.height / 2));
        Point Bl = new Point((position.x - (this.length / 2)), (position.y - this.height / 2));
        Point Br = new Point((position.x + (this.length / 2)), (position.y - this.height / 2));

        Point[] BlockPoints = {Tl, Tr, Bl, Br};

        return BlockPoints;
    }



}/*BlockClass*/
