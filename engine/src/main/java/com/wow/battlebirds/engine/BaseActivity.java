package com.wow.battlebirds.engine;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.wow.battlebirds.engine.entity.asset.AssetFactory;
import com.wow.battlebirds.engine.input.BaseTouchInput;
import com.wow.battlebirds.engine.io.IFileIO;
import com.wow.battlebirds.engine.renderer.RenderThread;
import com.wow.battlebirds.engine.renderer.RenderView;
import com.wow.battlebirds.engine.renderer.IRenderer;
import com.wow.battlebirds.engine.sound.IAudio;
import com.wow.battlebirds.game.GameScreen;

/**
 * Created by ChrisH on 22/02/14.
 *
 * Base activity for the Engine, which also implements the Engine interface to allow
 * for accessing the Engine through the activity.
 *
 * The actual game can extend this class, and access the Engine if necessary.
 */
public class BaseActivity extends Activity implements EngineInterface
{
    RenderThread renderThread;
    RenderView renderView;
    Engine engine;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Create the render view which will hold the bitmap we draw to and then blit to the screen
        this.renderView = new RenderView(this, getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight());

        // Create the actual Engine object
        this.engine = new Engine(this.renderView);

        // Create the thread which will handle game logic and rendering
        this.renderThread = new RenderThread(this.renderView.getHolder(), this.engine);

        this.renderView.setThread(this.renderThread);

        // Set where touch events will go
        this.renderView.setOnTouchListener(this.engine.getInput());

        setContentView(this.renderView);

        // Initialize the actual game screen. This is the interface binding the game logic to the engine.
        // Eventually this will have to be reworked and separated, so the game package initializes this rather
        // than the engine package initializing the game package.
        this.engine.setScreen(new GameScreen(this));
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }

    @Override
    public BaseTouchInput getInput()
    {
        return engine.input;
    }

    @Override
    public IFileIO getFileIO()
    {
        return engine.fileIO;
    }

    @Override
    public IRenderer getRenderer()
    {
        return engine.renderer;
    }

    @Override
    public AssetFactory getAssetFactory()
    {
        return engine.assets;
    }

    @Override
    public IAudio getAudio()
    {
        return engine.audio;
    }

    @Override
    public void setScreen(Screen screen)
    {
        this.engine.screen = screen;
    }

    @Override
    public Screen getCurrentScreen()
    {
        return engine.screen;
    }
}
