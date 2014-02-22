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

    Block(){
        if(numBlocks > 0){
            int length = 20;
            int height = 20;
            numBlocks--;

        } else {
            System.out.println("Max Blocks Reached");
        }
        Point point = new Point(/*NEED XPOS FROM TOUCH RECORD, NEED YPOS FROM TOUCH RECORD*/);
        //GET INPUT AND CONVERT TO YPOS AND XPOS!
        if(yPos < 100) yPos = 100;
        while(yPos > 100) yPos--; //Dat Gravity


    }/*BlockConstructor*/



}/*BlockClass*/
