package com.wow.battlebirds.engine;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.wow.battlebirds.engine.entity.asset.AssetFactory;
import com.wow.battlebirds.engine.input.ITouchInput;
import com.wow.battlebirds.engine.io.IFileIO;
import com.wow.battlebirds.engine.renderer.RenderThread;
import com.wow.battlebirds.engine.renderer.RenderView;
import com.wow.battlebirds.engine.renderer.IRenderer;
import com.wow.battlebirds.engine.sound.IAudio;
import com.wow.battlebirds.game.GameScreen;

/**
 * Created by ChrisH on 22/02/14.
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

        this.renderView = new RenderView(this, getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight());
        this.engine = new Engine(this.renderView);
        this.renderThread = new RenderThread(this.renderView.getHolder(), this.engine);

        this.renderView.setThread(this.renderThread);
        this.renderView.setOnTouchListener(this.engine.getInput());

        setContentView(this.renderView);

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
    public ITouchInput getInput()
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
