package com.techjd.videoplayer.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.techjd.videoplayer.R;
import com.techjd.videoplayer.utils.Constants;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent openMain = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(openMain);
                finish();
            }
        }, Constants.SPLASH_TIME_OUT);
    }
}