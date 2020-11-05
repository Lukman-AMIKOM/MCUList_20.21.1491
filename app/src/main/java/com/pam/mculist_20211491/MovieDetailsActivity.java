package com.pam.mculist_20211491;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
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
        Movie movie = intent.getParcelableExtra(EXTRA_MOVIE_OBJECT);
        
        int actionbarBackground = R.drawable.background_actionbar_phase_one;
        int phaseColor = R.color.text_color;
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(movie.getTitle() + " (" + movie.getYear() + ")");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            
            switch (movie.getPhase()) {
                case MoviesData.PHASE_ONE:
                    actionbarBackground = R.drawable.background_actionbar_phase_one;
                    phaseColor = R.color.phase_one;
                    break;
                case MoviesData.PHASE_TWO:
                    actionbarBackground = R.drawable.background_actionbar_phase_two;
                    phaseColor = R.color.phase_two;
                    break;
                case MoviesData.PHASE_THREE:
                    actionbarBackground = R.drawable.background_actionbar_phase_three;
                    phaseColor = R.color.phase_three;
                    break;
                case MoviesData.PHASE_FOUR:
                    actionbarBackground = R.color.phase_four;
                    phaseColor = R.color.phase_four;
                    break;
            }
            
            getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, actionbarBackground));
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
                .apply(new RequestOptions().override(255, 360))
                .into(imgPoster);
        tvTitle.setText(movie.getTitle());
        tvYear.setText(movie.getYear());
        tvDetails.setText(movie.getDetails());
        tvDirector.setText(movie.getDirector());
        tvStars.setText(movie.getStars());
        tvSynopsis.setText(movie.getSynopsis());
        tvChronologicalIndex.setText(getString(R.string.chronological_index, String.valueOf(movie.getChronologicalIndex())));
        tvPhase.setText(getString(R.string.phase, movie.getPhase()));
        tvPhase.setTextColor(getResources().getColor(phaseColor));
    
        TypedValue value = new TypedValue();
        getTheme().resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, value, true);
        imgPoster.setBackground(ContextCompat.getDrawable(this, value.resourceId));
        imgPoster.setClickable(true);
        imgPoster.setFocusable(true);
        imgPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fullscreenPosterActivityIntent = new Intent(MovieDetailsActivity.this, FullscreenPosterActivity.class);
                fullscreenPosterActivityIntent.putExtra(FullscreenPosterActivity.EXTRA_POSTER_ID, movie.getPoster());
                startActivity(fullscreenPosterActivityIntent);
            }
        });
    }
    
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }
}