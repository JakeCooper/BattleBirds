package com.wow.battlebirds.game;

/**
 * Created by Jake on 22/02/14.
 */
public class Bird extends Asset {
    public final float Velocity = 20;
    public final int cannonLength = 200;
    public int team;
    public float Vx;
    public float Vy;
    public int eggXPos;
    public int eggYPos;



    Bird(int team, float angle, int xPos, int yPos){
        Vx = Velocity * (float)Math.cos(angle);
        Vy = Velocity * (float)Math.sin(angle);
        //eggXPos = xPos + cannonLength * (int)Math.cos(angle);
        //eggYPos = yPos + cannonLength * (int)Math.sin(angle);
        switch (team){
            case 1: //RENDER BIRD(RED)
                    break;

            case 2: //RENDER BIRD(BLUE)
                    break;
        }
    }
    public void launch(float Vix, float Viy, float xPos, float yPos){

        while(eggYPos > 100){
            //int t = (int)(2*Viy/9.8);
            eggXPos += Vix;
            eggYPos += Viy;
            Viy += -9.8;
        }
    }
    @Override
    public void update(float deltaT)
    {

    }

}
