package org.proway.controller;

import org.proway.model.media.Media;
import org.proway.model.media.Movie;
import org.proway.model.media.Series;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NetflixSystem {
    private ArrayList<Media> catalog;

    public NetflixSystem() {
        catalog = new ArrayList<Media>();
    }

    public ArrayList<Media> getCatalog() {
        return catalog;
    }

    public ArrayList<Movie> getMovieCatalog() {
        ArrayList<Movie> moviesList = new ArrayList<>();
        for (Media media : catalog) {
            if (media instanceof Movie) {
                moviesList.add((Movie) media);
            }
        }

        return moviesList;
    }

    public ArrayList<Series> getSeriesCatalog() {
        ArrayList<Series> seriesList = new ArrayList<>();
        for (Media media : catalog) {
            if (media instanceof Series) {
                seriesList.add((Series) media);
            }
        }

        return seriesList;
    }

    public void setCatalog(ArrayList<Media> catalog) {
        this.catalog = catalog;
    }
}
