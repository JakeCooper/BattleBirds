package com.wow.battlebirds.game;

import android.view.Gravity;

/**
 * Created by Jake on 22/02/14.
 */
public class Block extends Asset {
    public int length;
    public int height;
    public int numBlocks = 15;
    public int xPos;
    public int yPos;
    public int Vy;

    Block(int xPos, int yPos){
        if(numBlocks > 0){
            int length = 20;
            int height = 20;
            numBlocks--;

        } else {
            System.out.println("Max Blocks Reached");
        }
        Point point = new Point(xPos, yPos);
        if(point.y < 100) point.y = 100;
        while(point.y > 100) point.y--; //Dat Gravity


    }/*BlockConstructor*/



}/*BlockClass*/
