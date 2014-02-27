package com.wow.battlebirds.engine.sound;

/**
 * Created by ChrisH on 22/02/14.
 */
public interface IAudio
{

    public IMusic createMusic(String file);

    public ISound createSound(String file);
}
