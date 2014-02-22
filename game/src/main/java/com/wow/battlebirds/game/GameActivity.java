package com.wow.battlebirds.game;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        renderView = new GameView(this);
        setContentView(renderView);

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
    public Audio getAudio()
    {
        return audio;
    }
}
