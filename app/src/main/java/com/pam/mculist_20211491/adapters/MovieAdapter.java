package com.pam.mculist_20211491.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pam.mculist_20211491.Movie;
import com.pam.mculist_20211491.R;

import java.util.Comparator;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    
    public static final String TYPE_CARD = "RecyclerView CardView";
    public static final String TYPE_LIST = "RecyclerView List";
    public static final String TYPE_GRID = "RecyclerView Grid";
    
    private final String type;
    private final Comparator<Movie> movieComparator;
    
    private OnItemClickCallback onItemClickCallback;
    
    public MovieAdapter(String type, Comparator<Movie> movieComparator) {
        this.type = type;
        this.movieComparator = movieComparator;
    }
    
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutResId = 0;
        
        switch (type) {
            case TYPE_CARD:
                layoutResId = R.layout.recyclerview_cardview;
                break;
            case TYPE_LIST:
                layoutResId = R.layout.recyclerview_list;
                break;
            case TYPE_GRID:
                layoutResId = R.layout.recyclerview_grid;
                break;
        }
        
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        return new MovieViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieSortedList.get(position);
        
        if (type.equals(TYPE_CARD) || type.equals(TYPE_LIST)) {
            new MovieDataSetter(movie, position + 1, holder);
        } else {
            Glide.with(holder.itemView.getContext())
                    .load(movieSortedList.get(position).getPoster())
                    .apply(new RequestOptions().override(255, 360))
                    .into(holder.imgPoster);
        }
        
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(movieSortedList.get(holder.getAdapterPosition()));
            }
        });
    }
    
    @Override
    public int getItemCount() {
        return movieSortedList.size();
    }
    
    private final SortedList<Movie> movieSortedList = new SortedList<>(Movie.class, new SortedList.Callback<Movie>() {
        @Override
        public int compare(Movie movie1, Movie movie2) {
            return movieComparator.compare(movie1, movie2);
        }
    
        @Override
        public void onChanged(int position, int count) {
            notifyItemRangeChanged(position, count);
        }
    
        @Override
        public boolean areContentsTheSame(Movie oldItem, Movie newItem) {
            return oldItem.equals(newItem);
        }
    
        @Override
        public boolean areItemsTheSame(Movie item1, Movie item2) {
            return item1.hashCode() == item2.hashCode();
        }
    
        @Override
        public void onInserted(int position, int count) {
            notifyItemRangeInserted(position, count);
        }
    
        @Override
        public void onRemoved(int position, int count) {
            notifyItemRangeRemoved(position, count);
        }
    
        @Override
        public void onMoved(int fromPosition, int toPosition) {
            notifyItemMoved(fromPosition, toPosition);
        }
    });
    
    public void add(Movie movie) {
        movieSortedList.add(movie);
    }
    
    public void remove(Movie movie) {
        movieSortedList.remove(movie);
    }
    
    public void add(List<Movie> movies) {
        movieSortedList.addAll(movies);
    }
    
    public void remove(List<Movie> movies) {
        movieSortedList.beginBatchedUpdates();
        for (Movie movie : movies) {
            movieSortedList.remove(movie);
        }
        movieSortedList.endBatchedUpdates();
    }
    
    public void replaceAll(List<Movie> movies) {
        movieSortedList.beginBatchedUpdates();
        movieSortedList.clear();
        for (int i = movieSortedList.size() - 1 ; i >= 0; i--) {
            final Movie movie = movieSortedList.get(i);
            if (!movies.contains(movie)) {
                movieSortedList.remove(movie);
            }
        }
        movieSortedList.addAll(movies);
        movieSortedList.endBatchedUpdates();
    }
}