package com.wow.battlebirds.engine;

import android.graphics.Point;

import com.wow.battlebirds.engine.entity.EntityManager;
import com.wow.battlebirds.engine.entity.asset.AssetFactory;
import com.wow.battlebirds.engine.input.BaseTouchInput;
import com.wow.battlebirds.engine.input.ITouchEventCallback;
import com.wow.battlebirds.engine.input.MultiTouchInput;
import com.wow.battlebirds.engine.input.TouchEvent;
import com.wow.battlebirds.engine.io.AndroidIO;
import com.wow.battlebirds.engine.io.IFileIO;
import com.wow.battlebirds.engine.renderer.IRenderer;
import com.wow.battlebirds.engine.renderer.Renderer;
import com.wow.battlebirds.engine.renderer.RenderView;
import com.wow.battlebirds.engine.sound.IAudio;
import com.wow.battlebirds.game.Block;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ChrisH on 27/02/14.
 *
 * The main Engine class which holds accessors to all of the core functionality.
 */
public class Engine implements EngineInterface, ITouchEventCallback
{
    BaseTouchInput input;
    IFileIO fileIO;
    IRenderer renderer;
    IAudio audio;
    Screen screen;
    AssetFactory assets;
    RenderView view;

    private ReentrantLock EngineLock = new ReentrantLock();

    public Engine(RenderView view)
    {
        this.view = view;

        float scaleX = (float) view.getFramebuffer().getWidth()
                / view.deviceWidth;
        float scaleY = (float)  view.getFramebuffer().getHeight()
                / view.deviceHeight;

        input = new MultiTouchInput(scaleX, scaleY);
        input.setTouchEventCallback(this);

        renderer = new Renderer(view);
        assets = new AssetFactory(this.renderer);
        fileIO = new AndroidIO();
    }

    public void onTouch(TouchEvent event)
    {
        if(event.getMotionType() == TouchEvent.TOUCH_DOWN)
        {
            try {
                EngineLock.lock();

                Block b = new Block(new Point((int)(event.getX() * input.scaleX), (int)(event.getY() * input.scaleY)));
                b.asset = getAssetFactory().getAsset("Box2.png");

                EntityManager.addEntity(b);
            } finally {
                EngineLock.unlock();
            }
        }
    }

    public ReentrantLock getEngineLock()
    {
        return EngineLock;
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
    public BaseTouchInput getInput()
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
