package com.wow.battlebirds.engine;

import android.graphics.Point;

/**
 * Created by Jake on 22/02/14.
 */
public class Block extends Asset {


    Block(Point createPosition){
        super(createPosition, 10, 10);

    }/*BlockConstructor*/

    public void update(float deltaT)
    {
        if(position.y < 550)
            position.y += 10;
    }

}/*BlockClass*/
