package com.pam.mculist_20211491;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FullscreenPosterActivity extends AppCompatActivity {
    
    public static final String EXTRA_POSTER_ID = "extra_poster_id";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_poster);
    
        ImageView imgPoster = findViewById(R.id.img_poster);
        int posterId = getIntent().getIntExtra(EXTRA_POSTER_ID, 0);
    
        Glide.with(this)
                .load(posterId)
                .into(imgPoster);
    }
}