package com.pam.mculist_20211491;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MoviesData {
    
    private static final String poster = "poster";
    private static final String title = "title";
    private static final String year = "year";
    private static final String date = "date";
    private static final String details = "details";
    private static final String director = "director";
    private static final String stars = "stars";
    private static final String synopsis = "synopsis";
    private static final String chronologicalIndex = "chronologicalIndex";
    private static final String phase = "phase";
    
    public static final String PHASE_ONE = "One";
    public static final String PHASE_TWO = "Two";
    public static final String PHASE_THREE = "Three";
    public static final String PHASE_FOUR = "Four";
    
    static ArrayList<Movie> getListData(Context context, int resource) {
        InputStream inputStream = context.getResources().openRawResource(resource);
        String moviesJsonString = new Scanner(inputStream).useDelimiter("\\A").next();
        
        ArrayList<Movie> movieList = new ArrayList<>();
    
        try {
            JSONArray movieJsonArray = new JSONArray(moviesJsonString);
    
            int resId;
            
            for (int i = 0; i < movieJsonArray.length(); i++) {
                JSONObject obj = movieJsonArray.getJSONObject(i);
    
                resId = context.getResources().getIdentifier(obj.getString(poster), "drawable", context.getPackageName());
                
                Movie movie = new Movie(
                        resId,
                        obj.getString(title),
                        obj.getString(year),
                        obj.getString(details) + obj.getString(date),
                        obj.getString(date),
                        obj.getString(director),
                        obj.getString(stars),
                        obj.getString(synopsis),
                        obj.getInt(chronologicalIndex),
                        obj.getString(phase)
                );
    
                movieList.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        return movieList;
    }
}
