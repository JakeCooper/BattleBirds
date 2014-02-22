package com.wow.battlebirds.game;

/**
 * Created by Jake on 22/02/14.
 */
public class Cannon {
    //Random Angle calibration
    public float angle;
    public int ammo;
    public int xPos;
    public int yPos;
    public float randomNum;
    public int player;


    Cannon(int player){
        ammo = 10;
        yPos = 100;
        cannonCalibration();
        switch (player){
            case 1: xPos = 100; //XPOS RELATIVE TO 1000 PIXELS IN THE X AXIS
                    //RENDER PLAYER1 HERE
                    break;

            case 2: xPos = 900; //XPOS RELATIVE TO 1000 PIXELS IN THE X AXIS
                    //RENDER PLAYER2 HERE
                    break;
        }
    }

    public void cannonCalibration(){
        //Check random to see if True random or Pseudo random (Seed?)
        angle = 15 + (int)(Math.random()*((75 - 15) + 1));
    }

    public void ammoReset(){
        ammo = 10;
    }

    public void launchBird(){

        Bird projectile = new Bird(player, angle, xPos, yPos);
    }
}
