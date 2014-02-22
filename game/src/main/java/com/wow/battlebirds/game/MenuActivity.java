package com.wow.battlebirds.game;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


/**
 * Created by kisselev on 22/02/14.
 */
public class MenuActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu);

        Log.d("GameActivity", "View added");
    }

    /** Called when the user touches the button */
    public void runGame(View view) {
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText("Welcome to android");
    }

}