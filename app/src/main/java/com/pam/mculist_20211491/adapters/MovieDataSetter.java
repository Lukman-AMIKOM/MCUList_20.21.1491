package com.pam.mculist_20211491.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import androidx.core.content.res.ResourcesCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pam.mculist_20211491.Movie;
import com.pam.mculist_20211491.R;

public class MovieDataSetter {
    
    private final Movie movie;
    private final int index;
    
    private final MovieViewHolder holder;
    
    private final Drawable imgDefault;
    private final Drawable imgSelected;
    
    public MovieDataSetter(Movie movie, int index, MovieViewHolder holder) {
        this.movie = movie;
        this.index = index;
        this.holder = holder;
        Context context = holder.itemView.getContext();
        imgDefault = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_favorite_default, null);
        imgSelected = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_favorite_selected, null);
        
        setData();
        setFav(movie.isFavorite() == 1 ? imgSelected : imgDefault);
        
        holder.imgFavorite.setOnClickListener(v -> setFav(movie.isFavorite() == 0 ? imgSelected : imgDefault, movie.isFavorite() == 0 ? 1 : 0));
    }
    
    private void setData() {
        Glide.with(holder.itemView.getContext())
                .load(movie.getPoster())
                .apply(new RequestOptions().override(255, 360))
                .into(holder.imgPoster);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvYear.setText(String.valueOf(movie.getYear()));
        holder.tvDetails.setText(movie.getDetails());
        holder.tvDirector.setText(movie.getDirector());
        holder.tvStars.setText(movie.getStars());
        holder.tvStars.setMaxLines(3);
        holder.tvStars.setEllipsize(TextUtils.TruncateAt.END);
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
