package com.pam.mculist_20211491;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    
    public static final String EXTRA_MOVIE_LIST = "movie_array_list";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ListView");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.background_actionbar_about));
        }
        
        Intent intent = getIntent();
        ArrayList<Movie> list = intent.getParcelableArrayListExtra(EXTRA_MOVIE_LIST);
        ListView lvMovie = findViewById(R.id.lv_movie);
        String[] movie = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            movie[i] = list.get(i).getTitle();
        }
        
        ArrayAdapter<String> movieAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, movie);
        lvMovie.setAdapter(movieAdapter);
        
        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent movieDetailsIntent = new Intent(ListViewActivity.this, MovieDetailsActivity.class);
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