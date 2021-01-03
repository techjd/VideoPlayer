package com.techjd.videoplayer.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.techjd.videoplayer.R;
import com.techjd.videoplayer.models.Msg;
import com.techjd.videoplayer.utils.CacheDataSourceFactory;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder> {

    private List<Msg> videosList;
    private Context context;


    public MainAdapter(List<Msg> videosList, Context context) {
        this.videosList = videosList;
        this.context = context;

    }

    @NonNull
    @Override
    public MainAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listVideos = layoutInflater.inflate(R.layout.item_videos, parent, false);
        MainAdapterViewHolder mainAdapterViewHolder = new MainAdapterViewHolder(listVideos);
        return mainAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapterViewHolder holder, int position) {
        Msg msg = videosList.get(position);
        Uri uri = Uri.parse(msg.getVideo());

        MediaItem mediaItem = MediaItem.fromUri(uri);
        holder.simpleExoPlayer = new SimpleExoPlayer.Builder(context).build();
        holder.playerView.setPlayer(holder.simpleExoPlayer);
        holder.simpleExoPlayer.setRepeatMode(Player.REPEAT_MODE_ALL);


//        DataSource.Factory dataSourceFactory = new DefaultHttpDataSourceFactory();
//        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
//                .createMediaSource(MediaItem.fromUri(uri));


//        holder.simpleExoPlayer.setPlayWhenReady(true);
//        holder.simpleExoPlayer.setMediaSource(mediaSource);
        holder.simpleExoPlayer.setMediaItem(mediaItem);
        holder.simpleExoPlayer.prepare();


        holder.firstName.setText(msg.getUserInfo().getFirstName());
        holder.lastName.setText(msg.getUserInfo().getLastName());
        holder.userName.setText(msg.getUserInfo().getUsername());
        String verified = msg.getUserInfo().getVerified();
        if (verified.equals("0")) {
            holder.verified.setVisibility(View.INVISIBLE);
        } else {
            holder.verified.setVisibility(View.VISIBLE);
        }
        Glide.with(context).load(msg.getUserInfo().getProfilePic()).into(holder.profilePic);


    }

    @Override
    public int getItemCount() {
        return videosList.size();
    }

    @Override
    public void onViewRecycled(@NonNull MainAdapterViewHolder holder) {
        super.onViewRecycled(holder);
//        holder.simpleExoPlayer.pause();
        holder.pausePlayer();

    }

    @Override
    public void onViewAttachedToWindow(@NonNull MainAdapterViewHolder holder) {
        super.onViewAttachedToWindow(holder);
//        holder.simpleExoPlayer.play();
        holder.startPlayer();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull MainAdapterViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
//        holder.simpleExoPlayer.pause();
        holder.pausePlayer();


    }


    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

    }

    public static class MainAdapterViewHolder extends RecyclerView.ViewHolder {

        PlayerView playerView;
        SimpleExoPlayer simpleExoPlayer;
        TextView firstName, lastName, userName;
        ImageView verified;
        CircleImageView profilePic;

        public MainAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            playerView = itemView.findViewById(R.id.player_view);
            firstName = itemView.findViewById(R.id.firstName);
            lastName = itemView.findViewById(R.id.lastName);
            userName = itemView.findViewById(R.id.username);
            profilePic = itemView.findViewById(R.id.profilePic);
            verified = itemView.findViewById(R.id.verified);
        }

        public void startPlayer() {
            simpleExoPlayer.setPlayWhenReady(true);
            simpleExoPlayer.getPlaybackState();
        }

        public void pausePlayer() {
            simpleExoPlayer.setPlayWhenReady(false);
            simpleExoPlayer.getPlaybackState();
        }

        public void releasePlayer() {
            simpleExoPlayer.setPlayWhenReady(false);
            simpleExoPlayer.release();
            simpleExoPlayer.stop(true);
        }
    }
}
