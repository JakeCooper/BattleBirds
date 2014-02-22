package com.wow.battlebirds.game;

/**
 * Created by ChrisH on 22/02/14.
 */
public abstract class Asset
{
    public Image image;
    public Sound sound;

    public abstract void update(float deltaT);
}
