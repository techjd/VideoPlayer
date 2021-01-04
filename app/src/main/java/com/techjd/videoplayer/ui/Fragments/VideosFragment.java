package com.techjd.videoplayer.ui.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.techjd.videoplayer.R;
import com.techjd.videoplayer.adapters.MainAdapter;
import com.techjd.videoplayer.api.APIService;
import com.techjd.videoplayer.api.RetrofitInstance;
import com.techjd.videoplayer.models.BodyCredentials;
import com.techjd.videoplayer.models.Videos;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VideosFragment extends Fragment{
    private ViewPager2 videos;
    private APIService apiService;
    private MainAdapter mainAdapter;
    private MainAdapter.MainAdapterViewHolder mainAdapterViewHolder;
    private SimpleExoPlayer simpleExoPlayer;
    private int mPlayerCurrentPosition;

    public VideosFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_videos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        videos = view.findViewById(R.id.videoPager);

        simpleExoPlayer = new SimpleExoPlayer.Builder(getContext()).build();

        BodyCredentials bodyCredentials = new BodyCredentials(
                "0",
                "eynBsaVYwIE:APA91bEmLkA0mold83uPz1N570IZjPGwAUE_o93EkDCPjSZ5-sQRxKRRwAEsSpiGvEOFMq06XQxrCx0k1Kbh8GVjYr3OmDjSGikCiJCReVGsM4-hHvPWgYMOaFrP-9HaO1JfWDg7PgZV",
                "related",
                "1",
                "af37ba10f52bca24");

        APIService apiService = RetrofitInstance.getService();
        Call<Videos> getAllVideos = apiService.getAllVideos(bodyCredentials, "showAllVideos");
        getAllVideos.enqueue(new Callback<Videos>() {
            @Override
            public void onResponse(Call<Videos> call, Response<Videos> response) {
                if (response.isSuccessful()) {

                    videos.setAdapter(new MainAdapter(response.body().getMsg(), getContext(), simpleExoPlayer));
                }
            }

            @Override
            public void onFailure(Call<Videos> call, Throwable t) {
                Log.d("ERROR", t.getLocalizedMessage());
            }
        });


        videos.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                Toast.makeText(getContext(), "Page Scrolled", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Toast.makeText(getContext(), position + "Page Selected", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                Toast.makeText(getContext(), "State Of Page Selected", Toast.LENGTH_SHORT).show();
//                simpleExoPlayer.setPlayWhenReady(false);
//                simpleExoPlayer.getPlaybackState();
            }
        });

    }



    @Override
    public void onPause() {
        super.onPause();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}