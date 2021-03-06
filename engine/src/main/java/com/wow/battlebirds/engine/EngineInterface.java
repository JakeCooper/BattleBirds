package com.wow.battlebirds.engine;

import com.wow.battlebirds.engine.entity.asset.AssetFactory;
import com.wow.battlebirds.engine.input.BaseTouchInput;
import com.wow.battlebirds.engine.io.IFileIO;
import com.wow.battlebirds.engine.renderer.IRenderer;
import com.wow.battlebirds.engine.sound.IAudio;

/**
 * Created by ChrisH on 22/02/14.
 *
 * A logical interface for all the core accessors.
 */
public interface EngineInterface
{
    public IAudio getAudio();

    public IFileIO getFileIO();

    public BaseTouchInput getInput();

    public IRenderer getRenderer();

    public AssetFactory getAssetFactory();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();
}
