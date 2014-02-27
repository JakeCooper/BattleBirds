package com.wow.battlebirds.engine;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent;


/**
 * Created by kisselev on 22/02/14.
 */
public class MenuActivity extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu);

        Log.d("MenuActivity", "View added");
    }

    /** Called when the user touches the button */
    public void runGame(View view)
    {

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

    }

}