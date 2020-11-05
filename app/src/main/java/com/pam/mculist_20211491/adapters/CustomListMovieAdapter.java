package com.pam.mculist_20211491.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pam.mculist_20211491.Movie;
import com.pam.mculist_20211491.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomListMovieAdapter extends ArrayAdapter<Movie> {
    
    private final Context mContext;
    int mResource;
    
    public CustomListMovieAdapter(@NonNull Context context, int resource, @NonNull List<Movie> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Movie movie = getItem(position);
        
        String movieTitle = movie.getTitle();
        String movieYear = movie.getYear();
        
        convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        
        CircleImageView imgPoster = convertView.findViewById(R.id.custom_img_poster);
        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        TextView tvYear = convertView.findViewById(R.id.tv_year);
        
        Glide.with(mContext).load(movie.getPoster()).apply(new RequestOptions().override(255, 360)).into(imgPoster);
        tvTitle.setText(movieTitle);
        tvYear.setText(movieYear);
        
        return convertView;
    }
}