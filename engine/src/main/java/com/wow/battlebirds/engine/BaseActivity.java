package com.wow.battlebirds.engine;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.content.res.Configuration;

import com.wow.battlebirds.engine.entity.asset.AssetFactory;
import com.wow.battlebirds.engine.input.ITouchInput;
import com.wow.battlebirds.engine.input.touchScreen;
import com.wow.battlebirds.engine.io.AndroidIO;
import com.wow.battlebirds.engine.io.IFileIO;
import com.wow.battlebirds.engine.renderer.RenderView;
import com.wow.battlebirds.engine.renderer.Renderer;
import com.wow.battlebirds.engine.renderer.IRenderer;
import com.wow.battlebirds.engine.sound.IAudio;
import com.wow.battlebirds.game.GameScreen;

/**
 * Created by ChrisH on 22/02/14.
 */
public class BaseActivity extends Activity implements EngineInterface
{
    RenderView renderView;
    ITouchInput input;
    IFileIO fileIO;
    IRenderer renderer;
    IAudio audio;
    Screen screen;
    AssetFactory assets;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Boolean isPortrait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;

        int frameBufferWidth = isPortrait ? 720: 1280;
        int frameBufferHeight = isPortrait ? 1280: 720;

        float scaleX = (float) frameBufferWidth
                / getWindowManager().getDefaultDisplay().getWidth();
        float scaleY = (float) frameBufferHeight
                / getWindowManager().getDefaultDisplay().getHeight();

        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth,frameBufferHeight, Config.ARGB_8888);

        input = new touchScreen(scaleX, scaleY);
        assets = new AssetFactory();
        renderer = new Renderer(this, getAssets(), frameBuffer);
        fileIO = new AndroidIO(this);
        renderView = new RenderView(this, this, frameBuffer);
        renderView.setOnTouchListener(input);
        setContentView(renderView);
        setScreen(new GameScreen(this));
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
        return input;
    }

    @Override
    public IFileIO getFileIO()
    {
        return fileIO;
    }

    @Override
    public IRenderer getRenderer()
    {
        return renderer;
    }

    @Override
    public AssetFactory getAssetFactory() { return assets; }

    @Override
    public IAudio getAudio()
    {
        return audio;
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
