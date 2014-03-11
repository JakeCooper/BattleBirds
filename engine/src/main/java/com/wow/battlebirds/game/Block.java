package com.wow.battlebirds.game;

import android.graphics.Point;

import com.wow.battlebirds.engine.entity.Entity;
import com.wow.battlebirds.engine.entity.EntityManager;
import com.wow.battlebirds.engine.entity.collision.CollisionDetector;
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
        {
            if(this.position.y < 550)
            {
                for(Entity a : EntityManager.retrieveEntities())
                {
                    if(this == a)
                        continue;
                    if(this.getClass() != a.getClass())
                        continue;

                    if(CollisionDetector.isCollidedWith(this, a))
                    {
                        isFalling = false;
                        break;
                    }
                }

                if(isFalling) {
                    this.position.y += 5 * deltaT;
                    if(this.position.y >= 550)
                        this.isFalling = false;
                }
            }
            else
                this.isFalling = false;
        }

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
                    this.isFalling = false;
                    this.touchDown = true;
                    return true;
                }
                break;
            case TouchEvent.TOUCH_UP:
                this.touchDown = false;

                if(this.position.y < 550)
                    this.isFalling = true;
                break;
            case TouchEvent.TOUCH_MOVED:
                if(!isFalling && this.touchDown)
                {
                    this.position.x = (int)event.getX();
                    this.position.y = (int)event.getY();

                    this.getBounds().setExtents(this.position, this.size);
                }
                break;
        }

        return false;
    }

}/*BlockClass*/
