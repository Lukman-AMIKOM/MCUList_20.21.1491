package com.pam.mculist_20211491;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MovieDetailsActivity extends AppCompatActivity {
    
    public static final String EXTRA_MOVIE_OBJECT = "extra_movie_object";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        
        Intent intent = getIntent();
        Movie movie = (Movie) intent.getParcelableExtra(EXTRA_MOVIE_OBJECT);
        
        int color = R.color.design_default_color_primary;
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(movie.getTitle() + " (" + movie.getYear() + ")");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            
            switch (movie.getPhase()) {
                case MoviesData.PHASE_ONE:
                    color = R.color.phase_one;
                    break;
                case MoviesData.PHASE_TWO:
                    color = R.color.phase_two;
                    break;
                case MoviesData.PHASE_THREE:
                    color = R.color.phase_three;
                    break;
                case MoviesData.PHASE_FOUR:
                    color = R.color.phase_four;
                    break;
            }
            
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(color)));
        }
        
        ImageView imgPoster = findViewById(R.id.img_item_poster);
        TextView tvTitle = findViewById(R.id.tv_movie_title);
        TextView tvYear = findViewById(R.id.tv_movie_year);
        TextView tvDetails = findViewById(R.id.tv_movie_details);
        TextView tvDirector = findViewById(R.id.tv_movie_director);
        TextView tvStars = findViewById(R.id.tv_movie_stars);
        TextView tvSynopsis = findViewById(R.id.tv_movie_synopsis);
        TextView tvChronologicalIndex = findViewById(R.id.tv_chronological_index);
        TextView tvPhase = findViewById(R.id.tv_phase);
        
        Glide.with(this)
                .load(movie.getPoster())
                .apply(new RequestOptions().override(101, 150))
                .into(imgPoster);
        tvTitle.setText(movie.getTitle());
        tvYear.setText(movie.getYear());
        tvDetails.setText(movie.getDetails());
        tvDirector.setText(movie.getDirector());
        tvStars.setText(movie.getStars());
        tvSynopsis.setText(movie.getSynopsis());
        tvChronologicalIndex.setText(getString(R.string.chronological_index, String.valueOf(movie.getChronologicalIndex())));
        tvPhase.setText(getString(R.string.phase, movie.getPhase()));
        tvPhase.setTextColor(getResources().getColor(color));
    }
    
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}