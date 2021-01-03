package com.techjd.videoplayer.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.techjd.videoplayer.R;
import com.techjd.videoplayer.ui.Fragments.VideosFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new VideosFragment()).commit();
        }



    }


}