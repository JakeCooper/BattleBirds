package com.wow.battlebirds.game;

/**
 * Created by Jake on 22/02/14.
 */
public class Cannon extends Asset {
    //Random Angle calibration
    public final float Velocity = 20;
    public float angle;
    public int ammo;
    public int xPos;
    public int yPos;
    public float randomNum;
    public int player;
    public float Vx;
    public float Vy;



    Cannon(int player, Point point){
        ammo = 10;
        cannonCalibration();
        switch (player){
            case 1: //RENDER PLAYER1 HERE
                    break;

            case 2: //RENDER PLAYER2 HERE
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

    public void launchBird(Point point){
        Bird projectile = new Bird(player, angle);
        Vx = Velocity * (float)Math.cos(angle);
        Vy = Velocity * (float)Math.sin(angle);
        projectile.launch(Vx, Vy, point);
    }

    @Override
    public void update(float deltaT)
    {

    }
}
