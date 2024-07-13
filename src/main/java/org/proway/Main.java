package org.proway;

import org.proway.config.CreateMoviesAndSeries;
import org.proway.controller.MediaSearchController;
import org.proway.controller.NetflixSystem;
import org.proway.model.search.FilterMovie;

public class Main {
    public static void main(String[] args) {
        CreateMoviesAndSeries createMoviesAndSeries = new CreateMoviesAndSeries(new NetflixSystem());
        MediaSearchController myMediaSearchController = new MediaSearchController(createMoviesAndSeries.getNetflixSystem());
        FilterMovie myFilterMovie = new FilterMovie();
        myMediaSearchController.searchForMovie(myFilterMovie);


    }
}