package com.wow.battlebirds.game;

import android.graphics.Point;

import com.wow.battlebirds.engine.entity.Entity;

/**
 * Created by Jake on 22/02/14.
 */
public class Cannon extends Entity {
    //Random Angle calibration
    public final float Velocity = 20;
    public float angle;
    public int ammo;
    public float randomNum;
    public float Vx;
    public float Vy;

    private final int length = 20; //Hardcoded sizes for the cannon
    private final int height = 20;

    Cannon(Point createPosition, int ammo, int player){
        super(createPosition, 50, 50);
        this.ammo = ammo;

        cannonCalibration();
    }

    public void cannonCalibration(){
        //Check random to see if True random or Pseudo random (Seed?)
        angle = 15 + (float)(Math.random()*((75 - 15) + 1));

    }


    public void cannonRotation(int direction){
        if(angle > 0 && angle < 90){
            angle += direction;
        }
    }

    public void ammoReset(){
        ammo = 10;
    }

    @Override
    public void update(float deltaT)
    {

    }
}
