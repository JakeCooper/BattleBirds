package com.wow.battlebirds.game;

/**
 * Created by Jake on 22/02/14.
 */
public class Bird {
    public float Velocity;
    public int team;
    public float Vx;
    public float Vy;

    Bird(int team, float angle){
        switch (team){
            case 1: //RENDER BIRD(RED)
                    Vy = Velocity * (float)Math.sin(angle);

            case 2: //RENDER BIRD(BLUE)
        }
    }

}
