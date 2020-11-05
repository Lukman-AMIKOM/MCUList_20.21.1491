package com.pam.mculist_20211491.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pam.mculist_20211491.Movie;
import com.pam.mculist_20211491.R;

import java.util.ArrayList;

public class GridMovieAdapter extends RecyclerView.Adapter<GridMovieAdapter.GridViewHolder> {
    
    public static final String VIEW_TYPE = "RecyclerView Grid";
    
    private ArrayList<Movie> listMovie;
    private OnItemClickCallback onItemClickCallback;
    
    public GridMovieAdapter(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }
    
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    
    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_grid, parent, false);
        return new GridViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listMovie.get(position).getPoster())
                .apply(new RequestOptions().override(255, 360))
                .into(holder.imgPoster);
        
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    onItemClickCallback.onItemClicked(listMovie.get(holder.getAdapterPosition()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    @Override
    public int getItemCount() {
        return listMovie.size();
    }
    
    public class GridViewHolder extends RecyclerView.ViewHolder {
        
        ImageView imgPoster;
        
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_item_poster);
        }
    }
}