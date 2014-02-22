package com.wow.battlebirds.game;

/**
 * Created by ChrisH on 22/02/14.
 */
public interface Game {

    public Audio getAudio();

    public FileIO getFileIO();

    public Input getInput();

    public Renderer getRenderer();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();
}
