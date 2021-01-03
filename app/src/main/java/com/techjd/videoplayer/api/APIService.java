package com.techjd.videoplayer.api;

import com.techjd.videoplayer.models.BodyCredentials;
import com.techjd.videoplayer.models.Videos;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    @POST("index.php")
    Call<Videos> getAllVideos(
            @Body BodyCredentials bodyCredentials,
            @Query("p") String query
    );
}
