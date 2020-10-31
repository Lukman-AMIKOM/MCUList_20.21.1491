package com.pam.mculist_20211491.adapters;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pam.mculist_20211491.Movie;
import com.pam.mculist_20211491.R;

public class MovieDataSetter {
    
    private Movie movie;
    private int index;
    
    private ListViewHolder holder;
    
    private Drawable imgDefault, imgSelected;
    
    public MovieDataSetter(Movie movie, int index, ListViewHolder holder) {
        this.movie = movie;
        this.index = index;
        this.holder = holder;
        imgDefault = holder.itemView.getResources().getDrawable(R.drawable.favorite_default);
        imgSelected = holder.itemView.getResources().getDrawable(R.drawable.favorite_selected);
        
        setData();
        setFav(movie.isFavorite() == 1 ? imgSelected : imgDefault);
        
        holder.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFav(movie.isFavorite() == 0 ? imgSelected : imgDefault, movie.isFavorite() == 0 ? 1 : 0);
            }
        });
    }
    
    private void setData() {
        Glide.with(holder.itemView.getContext())
                .load(movie.getPoster())
                .apply(new RequestOptions().override(101, 150))
                .into(holder.imgPoster);
//        holder.imgPoster.setImageResource(movie.getPoster()); // cara alternatif untuk load image ke layout menggunakan fitur built-in dari Android SDK
        holder.tvTitle.setText(movie.getTitle());
        holder.tvYear.setText(movie.getYear());
        holder.tvDetails.setText(movie.getDetails());
        holder.tvDirector.setText(movie.getDirector());
        holder.tvStars.setText(movie.getStars());
        holder.tvIndex.setText(String.valueOf(index));
    }
    
    private void setFav(Drawable drawable) {
        setFav(drawable, -1);
    }
    
    private void setFav(Drawable drawable, int isFav) {
        holder.imgFavorite.setImageDrawable(drawable);
        if (isFav != -1) {
            movie.setFavorite(isFav);
        }
    }
}
