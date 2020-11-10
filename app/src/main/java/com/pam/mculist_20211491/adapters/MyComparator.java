package com.pam.mculist_20211491.adapters;

import com.pam.mculist_20211491.Movie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class MyComparator implements Comparator<Movie> {
    
    public static final String TYPE_RELEASE_DATE = "release_date";
    public static final String TYPE_TITLE = "title";
    public static final String TYPE_CHRONOLOGICAL = "chronological";
    
    private final String type;
    
    public MyComparator(String type) {
        this.type = type;
    }
    
    @Override
    public int compare(Movie movie1, Movie movie2) {
        if (movie1.hashCode() == movie2.hashCode()) {
            return 0;
        } else {
            switch (type) {
                case TYPE_RELEASE_DATE:
                    String strDate1 = movie1.getReleaseDate();
                    String strDate2 = movie2.getReleaseDate();
            
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM yyyy", Locale.ENGLISH);
                    try {
                        Date releaseDate1 = sdf.parse(strDate1);
                        Date releaseDate2 = sdf.parse(strDate2);
                
                        if (Objects.requireNonNull(releaseDate1).before(releaseDate2)) {
                            return -1;
                        } else {
                            return 1;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 0;
                case TYPE_TITLE:
                    String title1 = movie1.getTitle();
                    String title2 = movie2.getTitle();
            
                    if (title1.compareToIgnoreCase(title2) < 0) {
                        return -1;
                    } else {
                        return 1;
                    }
                case TYPE_CHRONOLOGICAL:
                    int chronologicalIndex1 = movie1.getChronologicalIndex();
                    int chronologicalIndex2 = movie2.getChronologicalIndex();
            
                    if (chronologicalIndex1 < chronologicalIndex2) {
                        return -1;
                    } else {
                        return 1;
                    }
            }
        }
        
        return 0;
    }
}
