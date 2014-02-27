package com.wow.battlebirds.game;

import android.graphics.Point;

import com.wow.battlebirds.engine.entity.asset.Asset;

/**
 * Created by Jake on 22/02/14.
 */
public class Block extends Asset {


    public Block(Point createPosition){
        super(createPosition, 10, 10);

    }/*BlockConstructor*/

    public void update(float deltaT)
    {
        if(position.y < 550)
            position.y += 10;
    }

}/*BlockClass*/
