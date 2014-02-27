package com.wow.battlebirds.engine;

import com.wow.battlebirds.engine.entity.asset.AssetFactory;
import com.wow.battlebirds.engine.input.ITouchInput;
import com.wow.battlebirds.engine.input.touchScreen;
import com.wow.battlebirds.engine.io.AndroidIO;
import com.wow.battlebirds.engine.io.IFileIO;
import com.wow.battlebirds.engine.renderer.IRenderer;
import com.wow.battlebirds.engine.renderer.Renderer;
import com.wow.battlebirds.engine.renderer.RenderView;
import com.wow.battlebirds.engine.sound.IAudio;

/**
 * Created by ChrisH on 27/02/14.
 */
public class Engine implements EngineInterface
{
    ITouchInput input;
    IFileIO fileIO;
    IRenderer renderer;
    IAudio audio;
    Screen screen;
    AssetFactory assets;
    RenderView view;

    public Engine(RenderView view)
    {
        this.view = view;

        float scaleX = (float) view.getFramebuffer().getWidth()
                / view.deviceWidth;
        float scaleY = (float)  view.getFramebuffer().getHeight()
                / view.deviceHeight;

        input = new touchScreen(scaleX, scaleY);
        assets = new AssetFactory();
        renderer = new Renderer(view);
        fileIO = new AndroidIO();
    }

    @Override
    public IAudio getAudio()
    {
        return audio;
    }

    @Override
    public IFileIO getFileIO()
    {
        return fileIO;
    }

    @Override
    public ITouchInput getInput()
    {
        return input;
    }

    @Override
    public IRenderer getRenderer()
    {
        return renderer;
    }

    @Override
    public AssetFactory getAssetFactory()
    {
        return assets;
    }

    @Override
    public void setScreen(Screen screen)
    {
        this.screen = screen;
    }

    @Override
    public Screen getCurrentScreen()
    {
        return screen;
    }
}
