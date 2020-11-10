package com.pam.mculist_20211491;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
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
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pam.mculist_20211491.adapters.MovieAdapter;
import com.pam.mculist_20211491.adapters.MyComparator;
import com.pam.mculist_20211491.adapters.OnItemClickCallback;

import java.util.ArrayList;
import java.util.List;

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
    private static final String STATE_SEARCH_QUERY = "state_search";
    
    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();
    
    private TextView tvViewType;
    private Spinner spinnerSort;
    private final String[] sorter = {SORT_BY_DATE, SORT_BY_TITLE, SORT_BY_CHRONOLOGICAL};
    
    private boolean isListInitialized = false;
    private int selectedMode;
    private MovieAdapter cardMovieAdapter, listMovieAdapter, gridMovieAdapter;
    
    private SearchView searchView;
    private List<Movie> filteredMovieList;
    private String searchQuery;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.background_actionbar_main));
        }
        
        BottomNavigationView navigationView = findViewById(R.id.nav_bottom_main);
        navigationView.setSelectedItemId(R.id.nav_cardview);
        navigationView.setOnNavigationItemSelectedListener(this);
        
        rvMovies = findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);
        
        tvViewType = findViewById(R.id.tv_view_type);
        
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_sorter, sorter);
        spinnerSort = findViewById(R.id.spinner_sort);
        spinnerSort.setAdapter(arrayAdapter);
        spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sortBy(selectedMode, spinnerSort.getSelectedItem().toString());
            }
            
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        
        if (savedInstanceState != null) {
            isListInitialized = savedInstanceState.getBoolean(LIST_INITIALIZATION_STATUS);
            selectedMode = savedInstanceState.getInt(STATE_SELECTED_VIEW);
            list = savedInstanceState.getParcelableArrayList(STATE_LIST);
            searchQuery = savedInstanceState.getString(STATE_SEARCH_QUERY);
        }
        
        if (!isListInitialized) {
            list.addAll(MoviesData.getListData(this, R.raw.movies));
            selectedMode = RECYCLERVIEW_CARDVIEW_MODE;
            isListInitialized = true;
        }
    }
    
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(LIST_INITIALIZATION_STATUS, isListInitialized);
        outState.putInt(STATE_SELECTED_VIEW, selectedMode);
        outState.putParcelableArrayList(STATE_LIST, list);
        
        if (!TextUtils.isEmpty(searchQuery)) {
            outState.putString(STATE_SEARCH_QUERY, searchQuery);
        }
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
        
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint(getString(R.string.search));
        searchView.setOnQueryTextListener(this);
        searchView.setMaxWidth(Integer.MAX_VALUE);
        TextView tvSearch = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        tvSearch.setTextSize(12);
        
        if (!TextUtils.isEmpty(searchQuery)) {
            searchView.setQuery(searchQuery, true);
            searchView.setIconified(false);
            searchView.clearFocus();
        }
        return true;
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
    
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    
    @Override
    public boolean onQueryTextChange(String query) {
        filteredMovieList = filter(list, query);
        searchQuery = query;
    
        switch (selectedMode) {
            case RECYCLERVIEW_CARDVIEW_MODE:
                cardMovieAdapter.replaceAll(filteredMovieList);
                break;
            case RECYCLERVIEW_GRID_MODE:
                gridMovieAdapter.replaceAll(filteredMovieList);
                break;
            case RECYCLERVIEW_LIST_MODE:
                listMovieAdapter.replaceAll(filteredMovieList);
                break;
        }
    
        rvMovies.scrollToPosition(0);
        return true;
    }
    
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_listview:
                showListView();
                break;
            case R.id.action_custom_listview:
                showCustomListView();
                break;
            case R.id.nav_cardview:
                this.selectedMode = RECYCLERVIEW_CARDVIEW_MODE;
                showRecyclerView(MovieAdapter.TYPE_CARD, new LinearLayoutManager(this),
                        cardMovieAdapter = new MovieAdapter(MovieAdapter.TYPE_CARD, getComparator(spinnerSort.getSelectedItem().toString())));
                break;
            case R.id.nav_grid:
                this.selectedMode = RECYCLERVIEW_GRID_MODE;
                showRecyclerView(MovieAdapter.TYPE_GRID, new GridLayoutManager(this, 4),
                        gridMovieAdapter = new MovieAdapter(MovieAdapter.TYPE_GRID, getComparator(spinnerSort.getSelectedItem().toString())));
                break;
            case R.id.nav_list:
                this.selectedMode = RECYCLERVIEW_LIST_MODE;
                showRecyclerView(MovieAdapter.TYPE_LIST, new LinearLayoutManager(this),
                        listMovieAdapter = new MovieAdapter(MovieAdapter.TYPE_LIST, getComparator(spinnerSort.getSelectedItem().toString())));
                break;
            case R.id.action_about:
                showAboutActivity();
                break;
        }
    }
    
    private void showRecyclerView(String type, RecyclerView.LayoutManager layoutManager, MovieAdapter movieAdapter) {
        tvViewType.setText(type);
        
        rvMovies.setLayoutManager(layoutManager);
        rvMovies.setAdapter(movieAdapter);
        setList(movieAdapter);
        
        movieAdapter.setOnItemClickCallback(new OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie data) {
                showMovieDetailsActivity(data);
            }
        });
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
    
    private void setList(MovieAdapter movieAdapter) {
        if (searchView != null) {
            if (TextUtils.isEmpty(searchView.getQuery().toString())) {
                movieAdapter.add(list);
            } else {
                movieAdapter.replaceAll(filteredMovieList);
            }
        } else {
            movieAdapter.add(list);
        }
    }
    
    private void showMovieDetailsActivity(Movie movie) {
        Intent movieDetailsIntent = new Intent(MainActivity.this, MovieDetailsActivity.class);
        movieDetailsIntent.putExtra(MovieDetailsActivity.EXTRA_MOVIE_OBJECT, movie);
        
        startActivity(movieDetailsIntent);
    }
    
    private void showAboutActivity() {
        Intent aboutActivityIntent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(aboutActivityIntent);
    }
    
    private void sortBy(int selectedMode, String sorter) {
        switch (selectedMode) {
            case RECYCLERVIEW_CARDVIEW_MODE:
                showRecyclerView(MovieAdapter.TYPE_CARD, new LinearLayoutManager(this),
                        cardMovieAdapter = new MovieAdapter(MovieAdapter.TYPE_CARD, getComparator(sorter)));
                break;
            case RECYCLERVIEW_GRID_MODE:
                showRecyclerView(MovieAdapter.TYPE_GRID, new GridLayoutManager(this, 4),
                        gridMovieAdapter = new MovieAdapter(MovieAdapter.TYPE_GRID, getComparator(sorter)));
                break;
            case RECYCLERVIEW_LIST_MODE:
                showRecyclerView(MovieAdapter.TYPE_LIST, new LinearLayoutManager(this),
                        listMovieAdapter = new MovieAdapter(MovieAdapter.TYPE_LIST, getComparator(sorter)));
                break;
        }
    }
    
    private MyComparator getComparator(String sorter) {
        switch (sorter) {
            case SORT_BY_DATE:
                return new MyComparator(MyComparator.TYPE_RELEASE_DATE);
            case SORT_BY_TITLE:
                return new MyComparator(MyComparator.TYPE_TITLE);
            case SORT_BY_CHRONOLOGICAL:
                return new MyComparator(MyComparator.TYPE_CHRONOLOGICAL);
        }
        return null;
    }
    
    private static List<Movie> filter(List<Movie> movies, String query) {
        final String lowerCaseQuery = query.toLowerCase();
        final List<Movie> filteredMovieList = new ArrayList<>();
    
        for (Movie movie : movies) {
            final String title = movie.getTitle().toLowerCase();
            final String year = String.valueOf(movie.getYear());
            final String releaseDate = movie.getReleaseDate().toLowerCase();
            final String director = movie.getDirector().toLowerCase();
            final String stars = movie.getStars().toLowerCase();
            
            if (title.contains(lowerCaseQuery) || year.contains(lowerCaseQuery) ||
                    releaseDate.contains(lowerCaseQuery) || director.contains(lowerCaseQuery) ||
                    stars.contains(lowerCaseQuery)) {
                filteredMovieList.add(movie);
            }
        }
        return filteredMovieList;
    }
}