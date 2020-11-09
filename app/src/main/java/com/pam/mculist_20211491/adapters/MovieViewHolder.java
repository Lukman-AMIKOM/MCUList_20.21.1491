package com.pam.mculist_20211491.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pam.mculist_20211491.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    
    ImageView imgPoster;
    TextView tvTitle, tvYear, tvDetails, tvDirector, tvStars, tvIndex;
    CircleImageView imgFavorite;
    
    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        imgPoster = itemView.findViewById(R.id.img_item_poster);
        tvTitle = itemView.findViewById(R.id.tv_movie_title);
        tvYear = itemView.findViewById(R.id.tv_movie_year);
        tvDetails = itemView.findViewById(R.id.tv_movie_details);
        tvDirector = itemView.findViewById(R.id.tv_movie_director);
        tvStars = itemView.findViewById(R.id.tv_movie_stars);
        tvIndex = itemView.findViewById(R.id.tv_movie_index);
        imgFavorite = itemView.findViewById(R.id.img_favorite);
    }
}