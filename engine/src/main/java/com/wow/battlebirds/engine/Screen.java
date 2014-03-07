package com.wow.battlebirds.engine;

/**
 * Created by ChrisH on 22/02/14.
 *
 * Acts as a bridge between the game package, and internal Engine logic.
 */
public abstract class Screen
{
    protected final EngineInterface engine;

    public Screen(EngineInterface engine) {
        this.engine = engine;
    }
    public abstract void update(float deltaTime);

    public abstract void draw();

    public abstract void pause();

    public abstract void resume();
}
