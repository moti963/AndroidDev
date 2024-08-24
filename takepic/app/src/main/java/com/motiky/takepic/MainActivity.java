package com.motiky.takepic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageView image_view;
    private final int CAMERA_REQ_CODE = 100;
    private final int IMG_REQ_CODE = 101;
    BottomNavigationView bottom_nav;
    LinearLayout btn_cont;
    Button btn_play, btn_pause, btn_stop;
    VideoView video_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        image_view = findViewById(R.id.image_view);
        bottom_nav = findViewById(R.id.bottom_nav);
        btn_cont = findViewById(R.id.btn_cont);
        btn_play = findViewById(R.id.btn_play);
        btn_pause = findViewById(R.id.btn_pause);
        btn_stop = findViewById(R.id.btn_stop);
        video_view = findViewById(R.id.video_view);

        MediaPlayer mediaPlayer = new MediaPlayer();

        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_camera) {
                    btn_cont.setVisibility(View.GONE);
                    video_view.setVisibility(View.GONE);
                    Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(iCamera, CAMERA_REQ_CODE);
                } else if (id == R.id.nav_img) {
                    btn_cont.setVisibility(View.GONE);
                    video_view.setVisibility(View.GONE);
                    Intent iImg = new Intent(Intent.ACTION_PICK);
                    iImg.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(iImg, IMG_REQ_CODE);
                } else if (id == R.id.nav_music) {
                    image_view.setVisibility(View.GONE);
                    video_view.setVisibility(View.GONE);
                    btn_cont.setVisibility(View.VISIBLE);

                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    String m1_path = "android.resource://" + getPackageName() + "/raw/music1";
                    String m2_path = "android.resource://" + getPackageName() + "/raw/music2";

                    Uri m1_uri = Uri.parse(m1_path);
                    Uri m2_uri = Uri.parse(m2_path);

                    try {
                        mediaPlayer.setDataSource(MainActivity.this, m1_uri);
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        Log.e("AUDIO", e.getMessage());
                    }
                } else if (id == R.id.nav_video) {
                    image_view.setVisibility(View.GONE);
                    btn_cont.setVisibility(View.GONE);
                    video_view.setVisibility(View.VISIBLE);
                    String v1_path = "android.resource://" + getPackageName() + "/raw/video1";
                    String v2_path = "android.resource://" + getPackageName() + "/raw/video2";
                    String vid_clg_path = "android.resource://" + getPackageName() + "/raw/video_clg";

                    Uri v1_uri = Uri.parse(v1_path);
                    Uri v2_uri = Uri.parse(v2_path);
                    Uri vid_clg_uri = Uri.parse(vid_clg_path);

                    video_view.setVideoURI(v2_uri);
                    video_view.start();

                    MediaController mediaController = new MediaController(MainActivity.this);
                    video_view.setMediaController(mediaController);
                    mediaController.setAnchorView(video_view);

                } else {
                    btn_cont.setVisibility(View.GONE);
                    video_view.setVisibility(View.GONE);
                    image_view.setVisibility(View.GONE);
                }
                return true;
            }
        });
//        bottom_nav.setSelectedItemId(R.id.nav_home);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQ_CODE) {
                Bitmap img = (Bitmap) data.getExtras().get("data");
                image_view.setImageBitmap(img);
            } else if (requestCode == IMG_REQ_CODE) {
                image_view.setImageURI(data.getData());
            }
        }
    }
}