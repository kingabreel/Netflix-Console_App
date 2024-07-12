package org.proway.model.midia;

import java.util.ArrayList;

public class Movie extends Midia {
    private int durationMinutes;

    public Movie(String name, String synopsis, ArrayList<String> casting, String genre, double imdb, String releaseDate) {
        super(name, synopsis, casting, genre, imdb, releaseDate);
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
