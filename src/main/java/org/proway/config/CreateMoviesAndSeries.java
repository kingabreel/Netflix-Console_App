package org.proway.config;

import org.proway.controller.NetflixSystem;

public class CreateMoviesAndSeries {
    private NetflixSystem netflixSystem;

    public CreateMoviesAndSeries(NetflixSystem netflixSystem) {
        this.netflixSystem = netflixSystem;
        addMovies();
        addSeries();
    }

    private void addMovies(){
        netflixSystem.getCatalog().add("Batman");
        netflixSystem.getCatalog().add("Batman 2");
        netflixSystem.getCatalog().add("Batman 3");
        netflixSystem.getCatalog().add("Batman 4");
        netflixSystem.getCatalog().add("Batman 5");
    }

    private void addSeries(){
        netflixSystem.getCatalog().add("Robin");
        netflixSystem.getCatalog().add("Robin 2");
        netflixSystem.getCatalog().add("Robin 3");
        netflixSystem.getCatalog().add("Robin 4");
        netflixSystem.getCatalog().add("Robin 5");
    }
}
