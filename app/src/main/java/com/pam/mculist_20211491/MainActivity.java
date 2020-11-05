package com.pam.mculist_20211491;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pam.mculist_20211491.adapters.CardViewMovieAdapter;
import com.pam.mculist_20211491.adapters.GridMovieAdapter;
import com.pam.mculist_20211491.adapters.ListMovieAdapter;
import com.pam.mculist_20211491.adapters.OnItemClickCallback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, BottomNavigationView.OnNavigationItemSelectedListener {
    
    private static final String SORT_BY_DATE = "release date";
    private static final String SORT_BY_TITLE = "title";
    private static final String SORT_BY_CHRONOLOGICAL = "chronological";
    
    private static final int RECYCLERVIEW_LIST_MODE = R.id.nav_list;
    private static final int RECYCLERVIEW_GRID_MODE = R.id.nav_grid;
    private static final int RECYCLERVIEW_CARDVIEW_MODE = R.id.nav_cardview;
    
    private static final String LIST_INITIALIZATION_STATUS = "list_initialization_status";
    private static final String STATE_LIST = "list";
    private static final String STATE_SELECTED_VIEW = "selected_view";
    
    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();
    
    private TextView tvViewType;
    private Spinner spinnerSort;
    private final String[] sorter = {SORT_BY_DATE, SORT_BY_TITLE, SORT_BY_CHRONOLOGICAL};
    private ArrayAdapter<String> arrayAdapter;
    
    private BottomNavigationView navigationView;
    
    private boolean isListInitialized = false;
    private int selectedMode;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.background_actionbar_main));
        }
        
        navigationView = findViewById(R.id.nav_bottom_main);
        navigationView.setSelectedItemId(R.id.nav_cardview);
        navigationView.setOnNavigationItemSelectedListener(this);
        
        rvMovies = findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);
        
        tvViewType = findViewById(R.id.tv_view_type);
    
        arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_sorter, sorter);
        spinnerSort = findViewById(R.id.spinner_sort);
        spinnerSort.setAdapter(arrayAdapter);
        spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sortBy(spinnerSort.getSelectedItem().toString());
            }
            
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        
        if (savedInstanceState != null) {
            isListInitialized = savedInstanceState.getBoolean(LIST_INITIALIZATION_STATUS);
            selectedMode = savedInstanceState.getInt(STATE_SELECTED_VIEW);
            list = savedInstanceState.getParcelableArrayList(STATE_LIST);
        }
        
        if (!isListInitialized) {
            list.addAll(MoviesData.getListData());
            selectedMode = RECYCLERVIEW_CARDVIEW_MODE;
            isListInitialized = true;
        }
        
        setMode(selectedMode);
    }
    
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(LIST_INITIALIZATION_STATUS, isListInitialized);
        outState.putInt(STATE_SELECTED_VIEW, selectedMode);
        outState.putParcelableArrayList(STATE_LIST, list);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        MenuCompat.setGroupDividerEnabled(menu, true);
        
        menuInflater.inflate(R.menu.menu_main, menu);
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            SpannableString spanString = new SpannableString(menu.getItem(i).getTitle().toString());
            int end = spanString.length();
            spanString.setSpan(new RelativeSizeSpan(0.8f), 0, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            item.setTitle(spanString);
        }
        
        // Search Feature masih dalam pengembangan.
//        final MenuItem searchItem = menu.findItem(R.id.action_search);
//        final SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setOnQueryTextListener(this);
//
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return true;
    }
    
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                
                if (!outRect.contains((int) ev.getRawX(), (int) ev.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }
    
    private void showListView() {
        Intent listViewIntent = new Intent(MainActivity.this, ListViewActivity.class);
        listViewIntent.putExtra(ListViewActivity.EXTRA_MOVIE_LIST, list);
        
        startActivity(listViewIntent);
    }
    
    private void showCustomListView() {
        Intent customListViewIntent = new Intent(MainActivity.this, CustomListViewActivity.class);
        customListViewIntent.putExtra(CustomListViewActivity.EXTRA_MOVIE_LIST, list);
        
        startActivity(customListViewIntent);
    }
    
    
    private void showRecyclerList() {
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(list);
        rvMovies.setAdapter(listMovieAdapter);
        
        tvViewType.setText(ListMovieAdapter.VIEW_TYPE);
        
        listMovieAdapter.setOnItemClickCallback(new OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie data) {
                showMovieDetails(data);
            }
        });
    }
    
    private void showRecyclerGrid() {
        rvMovies.setLayoutManager(new GridLayoutManager(this, 4));
        GridMovieAdapter gridMovieAdapter = new GridMovieAdapter(list);
        rvMovies.setAdapter(gridMovieAdapter);
        
        tvViewType.setText(GridMovieAdapter.VIEW_TYPE);
        
        gridMovieAdapter.setOnItemClickCallback(new OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie data) {
                showMovieDetails(data);
            }
        });
    }
    
    private void showRecyclerCardView() {
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
        CardViewMovieAdapter cardViewMovieAdapter = new CardViewMovieAdapter(list);
        rvMovies.setAdapter(cardViewMovieAdapter);
        
        tvViewType.setText(CardViewMovieAdapter.VIEW_TYPE);
        
        cardViewMovieAdapter.setOnItemClickCallback(new OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie data) {
                showMovieDetails(data);
            }
        });
    }
    
    private void showMovieDetails(Movie movie) {
        Intent movieDetailsIntent = new Intent(MainActivity.this, MovieDetailsActivity.class);
        movieDetailsIntent.putExtra(MovieDetailsActivity.EXTRA_MOVIE_OBJECT, movie);
        
        startActivity(movieDetailsIntent);
    }
    
    private void showAboutActivity() {
        Intent aboutActivityIntent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(aboutActivityIntent);
    }
    
    
    private void sortBy(String sorter) {
        Collections.sort(list, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2) {
                switch (sorter) {
                    case SORT_BY_DATE:
                        String strDate1 = movie1.getReleaseDate();
                        String strDate2 = movie2.getReleaseDate();
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM yyyy");
                        try {
                            Date releaseDate1 = sdf.parse(strDate1);
                            Date releaseDate2 = sdf.parse(strDate2);
                            
                            if (Objects.requireNonNull(releaseDate1).before(releaseDate2)) {
                                return -1;
                            } else {
                                return 1;
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    case SORT_BY_TITLE:
                        String title1 = movie1.getTitle();
                        String title2 = movie2.getTitle();
                        
                        if (title1.compareToIgnoreCase(title2) < 0) {
                            return -1;
                        } else {
                            return 1;
                        }
                    case SORT_BY_CHRONOLOGICAL:
                        int chronologicalIndex1 = movie1.getChronologicalIndex();
                        int chronologicalIndex2 = movie2.getChronologicalIndex();
                        
                        if (chronologicalIndex1 < chronologicalIndex2) {
                            return -1;
                        } else {
                            return 1;
                        }
                }
                return 0;
            }
        });
        Objects.requireNonNull(rvMovies.getAdapter()).notifyDataSetChanged();
    }
    
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_listview:
                showListView();
                break;
            case R.id.action_custom_listview:
                showCustomListView();
                break;
            case R.id.nav_list:
                this.selectedMode = RECYCLERVIEW_LIST_MODE;
                showRecyclerList();
                break;
            case R.id.nav_grid:
                this.selectedMode = RECYCLERVIEW_GRID_MODE;
                showRecyclerGrid();
                break;
            case R.id.nav_cardview:
                this.selectedMode = RECYCLERVIEW_CARDVIEW_MODE;
                showRecyclerCardView();
                break;
            case R.id.action_about:
                showAboutActivity();
                break;
            case R.id.action_search:
                break;
        }
    }
    
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    
    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}