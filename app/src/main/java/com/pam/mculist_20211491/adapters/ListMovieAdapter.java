package com.pam.mculist_20211491.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import com.pam.mculist_20211491.Movie;
import com.pam.mculist_20211491.R;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListViewHolder> {
    
    public static final String VIEW_TYPE = "RecyclerView List";
    
    private ArrayList<Movie> listMovie;
    private OnItemClickCallback onItemClickCallback;
    
    public ListMovieAdapter(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }
    
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list, parent, false);
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
    
    private final SortedList.Callback<Movie> movieCallback = new SortedList.Callback<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return 0;
        }
        
        @Override
        public void onChanged(int position, int count) {
            
        }
        
        @Override
        public boolean areContentsTheSame(Movie oldItem, Movie newItem) {
            return false;
        }
        
        @Override
        public boolean areItemsTheSame(Movie item1, Movie item2) {
            return false;
        }
        
        @Override
        public void onInserted(int position, int count) {
            
        }
        
        @Override
        public void onRemoved(int position, int count) {
            
        }
        
        @Override
        public void onMoved(int fromPosition, int toPosition) {
            
        }
    };
}
