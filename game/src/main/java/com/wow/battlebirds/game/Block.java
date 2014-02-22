package com.wow.battlebirds.game;

/**
 * Created by Jake on 22/02/14.
 */
public class Block {
    public int length;
    public int height;
    public int numBlocks = 15;

    Block(){
        if(numBlocks > 0){
            int length = 20;
            int height = 20;
            numBlocks--;
        } else {
            System.out.println("Max Blocks Reached");
        }
    }/*BlockConstructor*/



}/*BlockClass*/
