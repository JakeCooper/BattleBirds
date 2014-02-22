package com.wow.battlebirds.game;

import android.view.Gravity;

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



}/*BlockClass*/
