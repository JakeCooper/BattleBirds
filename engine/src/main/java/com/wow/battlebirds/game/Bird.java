package com.wow.battlebirds.game;

import android.graphics.Point;

import com.wow.battlebirds.engine.entity.Entity;

/**
 * Created by Jake on 22/02/14.
 */
public class Bird extends Entity {
    public final float Velocity = 20;
    public final int cannonLength = 200;
    public int team;
    public float Vx;
    public float Vy;
    public int eggXPos;
    public int eggYPos;

    Bird(Point createPosition, int Velocity, float angle){
        super(createPosition, new Point(20, 20));

        Vx = Velocity * (float)Math.cos(angle);
        Vy = Velocity * (float)Math.sin(angle);
    }
    public void launch(float Vix, float Viy, Point point){

        while(point.y > 100){
            //int t = (int)(2*Viy/9.8);
            point.x += Vix;
            point.y += Viy;
            Viy += -9.8;
        }
    }

    @Override
    public void update(float deltaT)
    {
        super.update(deltaT);
    }

}
