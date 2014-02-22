package com.wow.battlebirds.game;

/**
 * Created by Jake on 22/02/14.
 */
public class Bird {
    public final int cannonLength = 200;
    public int team;
    public float eggXPos;
    public float eggYPos;


    Bird(int team, float angle){
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
            int t = (int)(2*Viy/9.8);
            eggXPos += Vix * t;


        }

    }

}
