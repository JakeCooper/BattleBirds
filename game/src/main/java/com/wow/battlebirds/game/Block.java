package com.wow.battlebirds.game;

/**
 * Created by Jake on 22/02/14.
 */
public class Block {
    public int length;
    public int height;
    public int numBlocks = 15;
    public int xPos;
    public int yPos;
    public int Vy;
    public float gravity;

    Block(){
        if(numBlocks > 0){
            int length = 20;
            int height = 20;
            numBlocks--;
            while(yPos > 100){
                Vy += gravity;
            }
        } else {
            System.out.println("Max Blocks Reached");
        }


    }/*BlockConstructor*/



}/*BlockClass*/
