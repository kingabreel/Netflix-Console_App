package org.proway.model.media;

import java.time.LocalDate;
import java.util.ArrayList;

public class Movie extends Media {
    private int durationMinutes;

    public Movie(String name, String synopsis, ArrayList<String> casting, double imdb, String releaseDate, String mediaGenre) {
        super(name, synopsis, casting, mediaGenre, imdb, releaseDate);
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
