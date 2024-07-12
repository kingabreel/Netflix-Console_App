package org.proway;

import org.proway.config.CreateMoviesAndSeries;
import org.proway.controller.NetflixSystem;

public class Main {
    public static void main(String[] args) {
        CreateMoviesAndSeries createMoviesAndSeries = new CreateMoviesAndSeries(new NetflixSystem());
    }
}