package com.wow.battlebirds.engine;

import android.graphics.Point;

import com.wow.battlebirds.engine.entity.Entity;
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
        boolean isCollision = false;

        try {
            EngineLock.lock();

            // We break when an object is touched, so the event doesn't propagate to every single
            // object in the touched area, resulting in every object under the cursor being selected.
            // We only want the topmost object to actually be touched.
            for(Entity a : EntityManager.retrieveEntities())
            {
                if(a.onTouched(event))
                {
                    isCollision = true;
                    break;
                }
            }

            // If not a single object was collided with, then we create a new block in the empty space.
            if( !isCollision && event.getMotionType() == TouchEvent.TOUCH_DOWN )
            {
                Block b = new Block(new Point((int)event.getX(), (int)event.getY()));
                b.asset = getAssetFactory().getAsset("Box2.png");

                EntityManager.addEntity(b);
            }

        } finally {
            EngineLock.unlock();
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
