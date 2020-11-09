package com.pam.mculist_20211491;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Movie implements Parcelable {
    
    private int poster;
    private String title;
    private int year;
    private String details;
    private String releaseDate;
    private String director;
    private String stars;
    private String synopsis;
    private int chronologicalIndex;
    private String phase;
    private int isFavorite;
    
    public Movie(int poster, String title, int year, String details, String releaseDate,
                 String director, String stars, String synopsis, int chronologicalIndex,
                 String phase) {
        this.poster = poster;
        this.title = title;
        this.year = year;
        this.details = details;
        this.releaseDate = releaseDate;
        this.director = director;
        this.stars = stars;
        this.synopsis = synopsis;
        this.chronologicalIndex = chronologicalIndex;
        this.phase = phase;
        this.isFavorite = 0;
    }
    
    protected Movie(Parcel in) {
        poster = in.readInt();
        title = in.readString();
        year = in.readInt();
        details = in.readString();
        releaseDate = in.readString();
        director = in.readString();
        stars = in.readString();
        synopsis = in.readString();
        chronologicalIndex = in.readInt();
        phase = in.readString();
        isFavorite = in.readInt();
    }
    
    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }
        
        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(poster);
        dest.writeString(title);
        dest.writeInt(year);
        dest.writeString(details);
        dest.writeString(releaseDate);
        dest.writeString(director);
        dest.writeString(stars);
        dest.writeString(synopsis);
        dest.writeInt(chronologicalIndex);
        dest.writeString(phase);
        dest.writeInt(isFavorite);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return title.equals(movie.title);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
    
    // Getter and Setter
    
    public int getPoster() {
        return poster;
    }
    
    public void setPoster(int poster) {
        this.poster = poster;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getDetails() {
        return details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
    
    public String getReleaseDate() {
        return releaseDate;
    }
    
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public String getDirector() {
        return director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }
    
    public String getStars() {
        return stars;
    }
    
    public void setStars(String stars) {
        this.stars = stars;
    }
    
    public String getSynopsis() {
        return synopsis;
    }
    
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    
    public static Creator<Movie> getCREATOR() {
        return CREATOR;
    }
    
    public int getChronologicalIndex() {
        return chronologicalIndex;
    }
    
    public void setChronologicalIndex(int chronologicalIndex) {
        this.chronologicalIndex = chronologicalIndex;
    }
    
    public String getPhase() {
        return phase;
    }
    
    public void setPhase(String phase) {
        this.phase = phase;
    }
    
    public int isFavorite() {
        return isFavorite;
    }
    
    public void setFavorite(int favorite) {
        isFavorite = favorite;
    }
}
