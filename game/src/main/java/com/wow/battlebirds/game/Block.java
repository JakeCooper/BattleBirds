package com.wow.battlebirds.game;

/**
 * Created by Jake on 22/02/14.
 */
public class Block {
    public int length;
    public int height;
    public int width;
    Block(int blockNumber){
        //!!!!!!!!FIX ARBITRARY VALUES!!!!!
        switch(blockNumber){
            case 1:
                //BLOCK 1 (LONGBLOCK)
                width = 5;
                height = 30;
                length = 20;
                break;
            case 2:
                //BLOCK 2 (THICKBLOCK)
                width = 5;
                height = 30;
                length = 20;
                break;
            case 3:
                //BLOCK 3 (THICKBLOCK)
                width = 5;
                height = 30;
                length = 20;
                break;
            case 4:
                //BLOCK 4 (THICKBLOCK)
                width = 5;
                height = 30;
                length = 20;
                break;
            case 5:
                //BLOCK 5 (THICKBLOCK)
                width = 5;
                height = 30;
                length = 20;
                break;
        }/*case*/


    }/*BlockConstructor*/
}/*BlockClass*/
