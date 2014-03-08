package com.wow.battlebirds.game;

import android.graphics.Point;

import com.wow.battlebirds.engine.entity.Entity;
import com.wow.battlebirds.engine.input.TouchEvent;

/**
 * Created by Jake on 22/02/14.
 */
public class Block extends Entity {

    private boolean isFalling;

    public Block(Point createPosition){
        super(createPosition, new Point(createPosition.x+80, createPosition.y+80));

        isFalling = true;

    }/*BlockConstructor*/

    public void update(float deltaT)
    {
        if(isFalling)
            if(position.y < 550)
                position.y += 10;

        super.update(deltaT);
    }

    // We return true if the object is touched with a Down event, otherwise we return false.
    // Returning true means a Down event touched inside this objects bounds.
    @Override
    public boolean onTouched(TouchEvent event)
    {
        switch(event.getMotionType())
        {
            case TouchEvent.TOUCH_DOWN:
                if(this.getBounds().contains(new Point((int)event.getX(), (int)event.getY())))
                {
                    isFalling = false;
                    return true;
                }
                break;
            case TouchEvent.TOUCH_UP:
                isFalling = true;
                break;
            case TouchEvent.TOUCH_MOVED:
                if(!isFalling)
                {
                    this.position.x = (int)event.getX();
                    this.position.y = (int)event.getY();
                }
                break;
        }

        return false;
    }

}/*BlockClass*/
