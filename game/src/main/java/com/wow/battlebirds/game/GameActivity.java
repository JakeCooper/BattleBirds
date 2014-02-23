package com.wow.battlebirds.game;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/**
 * Created by ChrisH on 22/02/14.
 */
public class GameActivity extends Activity implements Game {

    GameView renderView;
    Input input;
    FileIO fileIO;
    Renderer renderer;
    Audio audio;
    Screen screen;
    AssetFactory assets;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bitmap frameBuffer = Bitmap.createBitmap(1280,720, Config.RGB_565);


        assets = new AssetFactory();
        renderer = new AndroidRenderer(this, getAssets(), frameBuffer);
        fileIO = new AndroidIO(this);
        renderView = new GameView(this, this, frameBuffer);
        setContentView(renderView);
        setScreen(new GameScreen(this));

        Log.d("GameActivity", "View added");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    protected void onStop() {
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
