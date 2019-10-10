package com.example.testnewdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.util.Constants;
import com.example.util.Utils;

public class splashScreen extends AppCompatActivity {
    public static final String TAG = "SplashActivity";

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            launchHome();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        Utils.changeStatusBarColor(getWindow());
        setContentView(R.layout.activity_splash_screen);
        skip();
    }

    @Override
    public void onStart() {
        if (Utils.isGooglePlayServicesAvailable(this)) {
        } else {
            skip();
        }
        super.onStart();
        Log.d(TAG, "onStart");
    }
    public void skip() {

        handler.postDelayed(runnable, Constants.SPLASH_DELAY_MS);

    }

    private void launchHome() {
        Intent intent = new Intent(splashScreen.this, WelcomeActivity.class);
        splashScreen.this.startActivity(intent);
        splashScreen.this.finish();
        overridePendingTransition(0, 0);
    }


}
