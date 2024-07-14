package org.proway;

import org.proway.config.CreateMoviesAndSeries;
import org.proway.controller.MediaSearchController;
import org.proway.controller.NetflixSystem;
import org.proway.model.media.Movie;
import org.proway.model.search.FilterMovie;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CreateMoviesAndSeries createMoviesAndSeries = new CreateMoviesAndSeries(new NetflixSystem());

        MediaSearchController myMediaSearchController = new MediaSearchController(createMoviesAndSeries.getNetflixSystem());

        FilterMovie myFilterMovie = new FilterMovie();
        myFilterMovie.setMediaNamesToSearch(new ArrayList<String>(Arrays.asList("Spider-Man", "")));

        for (Movie mv : myMediaSearchController.searchForMovie(myFilterMovie)) {
            System.out.println(mv.getName());
        }


    }
}