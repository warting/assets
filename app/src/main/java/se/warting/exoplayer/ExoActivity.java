package se.warting.exoplayer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.android.exoplayer2.upstream.DataSource;

public class ExoActivity extends AppCompatActivity {

    private SimpleExoPlayer player;

    public static void show(Context context) {
        Intent intent = new Intent(context, ExoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo);
        final PlayerView videoPlayer = findViewById(R.id.video_view);


        AdaptiveTrackSelection.Factory factory = new AdaptiveTrackSelection.Factory(null);
        DefaultTrackSelector trackSelector = new DefaultTrackSelector(factory);

        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector);

        videoPlayer.requestFocus();
        videoPlayer.setUseController(false);
        videoPlayer.setPlayer(player);

        DataSource.Factory dataSourceFactory = new DataSource.Factory() {
            @Override
            public DataSource createDataSource() {
                return new AssetDataSource(ExoActivity.this);
            }
        };
        ExtractorMediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse("assets:///video_04.mp4"));

        player.prepare(mediaSource);
        player.setPlayWhenReady(true);
    }

    @Override
    public void onBackPressed() {
        player.seekTo(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }
}
