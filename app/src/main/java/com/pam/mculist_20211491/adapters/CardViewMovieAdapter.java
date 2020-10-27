package com.pam.mculist_20211491.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pam.mculist_20211491.Movie;
import com.pam.mculist_20211491.R;

import java.util.ArrayList;

public class CardViewMovieAdapter extends RecyclerView.Adapter<ListViewHolder> {
    
    public static final String VIEW_TYPE = "RecyclerView CardView";
    
    private ArrayList<Movie> listMovie;
    private OnItemClickCallback onItemClickCallback;
    
    public CardViewMovieAdapter(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }
    
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_cardview, parent, false);
        return new ListViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Movie movie = listMovie.get(position);
        
        new MovieDataSetter(movie, position + 1, holder);
        
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listMovie.get(holder.getAdapterPosition()));
            }
        });
    }
    
    @Override
    public int getItemCount() {
        return listMovie.size();
    }
}