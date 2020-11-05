package com.pam.mculist_20211491;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pam.mculist_20211491.adapters.CustomListMovieAdapter;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {
    
    public static final String EXTRA_MOVIE_LIST = "movie_array_list";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Custom ListView");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.background_actionbar_about));
        }
        
        ArrayList<Movie> list = getIntent().getParcelableArrayListExtra(EXTRA_MOVIE_LIST);
        ListView lvMovie = findViewById(R.id.lv_movie);
        CustomListMovieAdapter customListMovieAdapter = new CustomListMovieAdapter(this, R.layout.custom_listview_row, list);
        lvMovie.setAdapter(customListMovieAdapter);
        
        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent movieDetailsIntent = new Intent(CustomListViewActivity.this, MovieDetailsActivity.class);
                movieDetailsIntent.putExtra(MovieDetailsActivity.EXTRA_MOVIE_OBJECT, list.get(position));
                
                startActivity(movieDetailsIntent);
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