package com.wow.battlebirds.engine;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.content.res.Configuration;

/**
 * Created by ChrisH on 22/02/14.
 */
public class GameActivity extends Activity implements Game
{
    GameView renderView;
    Input input;
    FileIO fileIO;
    Renderer renderer;
    Audio audio;
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
        renderer = new AndroidRenderer(this, getAssets(), frameBuffer);
        fileIO = new AndroidIO(this);
        renderView = new GameView(this, this, frameBuffer);
        renderView.setOnTouchListener(input);
        setContentView(renderView);
        setScreen(new GameScreen(this));

        Log.d("GameActivity", "View added");
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
    public Input getInput()
    {
        return input;
    }

    @Override
    public FileIO getFileIO()
    {
        return fileIO;
    }

    @Override
    public Renderer getRenderer()
    {
        return renderer;
    }

    @Override
    public AssetFactory getAssetFactory() { return assets; }

    @Override
    public Audio getAudio()
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
