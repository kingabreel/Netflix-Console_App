package org.proway.model.media;

import java.time.LocalDate;
import java.util.ArrayList;

public class Movie extends Media {
    private int durationMinutes;

    public Movie(String name, String synopsis, ArrayList<String> casting, double imdb, String releaseDate, Genre mediaGenre, int durationMinutes) {
        super(name, synopsis, casting, imdb, releaseDate, mediaGenre);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
