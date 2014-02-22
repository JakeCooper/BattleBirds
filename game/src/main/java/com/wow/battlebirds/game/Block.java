package com.wow.battlebirds.game;

/**
 * Created by Jake on 22/02/14.
 */
public class Block {
    public int length;
    public int height;
    public int numBlocks;

    Block(){
        if(numBlocks > 0){
            int length = 20;
            int height = 20;
        } else {
            System.out.println("Max Blocks reached");
        }
    }/*BlockConstructor*/

}/*BlockClass*/
