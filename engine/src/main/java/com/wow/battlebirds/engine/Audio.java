package com.wow.battlebirds.engine;

/**
 * Created by ChrisH on 22/02/14.
 */
public interface Audio
{

    public Music createMusic(String file);

    public Sound createSound(String file);
}
