package org.proway;

import org.proway.config.CreateMoviesAndSeries;
import org.proway.controller.NetflixSystem;
import org.proway.controller.Player;

public class Main {
    public static void main(String[] args) {
        CreateMoviesAndSeries createMoviesAndSeries = new CreateMoviesAndSeries(new NetflixSystem());
        Player p = new Player();
        p.startPlayer();
    }
}