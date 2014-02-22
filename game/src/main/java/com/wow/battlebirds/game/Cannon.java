package com.wow.battlebirds.game;

/**
 * Created by Jake on 22/02/14.
 */
public class Cannon {
    //Random Angle calibration
    public float angle;
    public int ammo;
    public int xPos;
    public float randomNum;

    Cannon(){

    }

    public void cannonCalibration(Cannon Cannon){
        //Check random to see if True random or Pseudo random (Seed?)
        Cannon.angle = 15 + (int)(Math.random()*((75 - 15) + 1));
    }
}
