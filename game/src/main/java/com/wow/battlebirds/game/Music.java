package com.wow.battlebirds.game;

/**
 * Created by ChrisH on 22/02/14.
 */
public interface Music {

    public void play();

    public void stop();

    public void pause();

    public void setLooping(boolean looping);

    public void setVolume(float volume);

    void seekBegin();
}
