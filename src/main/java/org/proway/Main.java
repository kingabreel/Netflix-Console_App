package org.proway;

import org.proway.config.CreateMoviesAndSeries;
import org.proway.controller.NetflixSystem;
import org.proway.view.MainPageView;

public class Main {
    public static void main(String[] args) {
        CreateMoviesAndSeries createMoviesAndSeries = new CreateMoviesAndSeries(new NetflixSystem());
        new MainPageView();
    }
}