package org.proway.view;

import org.proway.controller.MediaSearchController;
import org.proway.model.search.FilterMovie;
import org.proway.model.search.Series.FilterSeries;
import org.proway.repository.MongoRepository;
import org.proway.util.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SearchView {
    private MediaSearchController mediaSearchController;
    private Scanner scanner;
    public SearchView(Scanner scanner){
        mediaSearchController = new MediaSearchController(new MongoRepository());
        this.scanner = scanner;
        showOptions();

    }
    public void showOptions(){
        System.out.println("""
                1- Search Movie
                2- Search Series
                """);
        int search = scanner.nextInt();

        while (Utils.validateLoop(search, 2)){
            System.out.println("Invalid");
            search = scanner.nextInt();
        }

        if (search == 1) addOptionsToFilter(true);
        else addOptionsToFilter(false);
    }

    public void addOptionsToFilter(boolean movie){
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Synopsis term: ");
        String synopsis = scanner.nextLine();

        System.out.print("Actor: ");
        String actor = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.println("Imdb Interval");
        System.out.print("Imdb start: ");
        double imdbStart = scanner.nextDouble();

        System.out.print("Imdb end: ");
        double imdbEnd = scanner.nextDouble();

        scanner.nextLine();
        System.out.println("Release date interval");
        System.out.print("Release date start: ");
        String dateStart = scanner.nextLine();

        System.out.print("Release date end: ");
        String dateEnd = scanner.nextLine();

        System.out.print("Minimum duration (minutes): ");
        int minDuration = scanner.nextInt();

        System.out.print("Maximum duration (minutes): ");
        int maxDuration = scanner.nextInt();

        if (movie) {

            FilterMovie fm = new FilterMovie();
            if (name.length() > 3) fm.setMediaNamesToSearch(new ArrayList<>(Collections.singletonList(name)));
            if (synopsis.length() > 5) fm.setSynopsisSearchTerm(synopsis);
            if (actor.length() > 3) fm.setActorsToSearch(new ArrayList<>(Collections.singletonList(actor)));
            if (imdbStart > 0 && imdbStart <= 10) {
                if (imdbEnd > 0 && imdbEnd <= 10 && imdbEnd > imdbStart) fm.setImdbScoreInterval(imdbStart, imdbEnd);
            } else if (imdbEnd > 0 && imdbEnd <= 10) fm.setImdbScoreInterval(imdbEnd);

            try {
                fm.setReleaseDateInterval(dateStart, dateEnd);
            } catch (DateTimeParseException e){}
            fm.setDurationMinutesInterval(minDuration, maxDuration);

            fm.setGenreSearchTerm(genre);
            fm.setGenresToSearch(new ArrayList<>(Collections.singletonList(genre)));
            mediaSearchController.searchForMovie(fm).forEach(System.out::println);
        } else {
            FilterSeries fs = new FilterSeries();

            fs.setMediaNamesToSearch(new ArrayList<>(Collections.singletonList(name)));
            fs.setSynopsisSearchTerm(synopsis);
            fs.setActorsToSearch(new ArrayList<>(Collections.singletonList(actor)));
            fs.getGenresToSearch().add(genre);
            fs.setImdbScoreInterval(imdbStart, imdbEnd);
            fs.setAverageDurationEpisodeInterval(minDuration, maxDuration);
            try {
                fs.setAverageDurationEpisodeInterval(minDuration, maxDuration);
            } catch (DateTimeParseException e) {}

            System.out.println("Min episodes: ");
            int minEp = scanner.nextInt();

            System.out.println("Max episodes: ");
            int maxEp = scanner.nextInt();

            fs.setNumberOfEpisodesInterval(maxEp, minEp);

            System.out.println("Min seasons: ");
            int minSeasons = scanner.nextInt();

            System.out.println("Max seasons: ");
            int maxSeasons = scanner.nextInt();

            fs.setNumberOfSeasonInterval(minSeasons, maxSeasons);

            mediaSearchController.searchForMediaSeries(fs).forEach(System.out::println);
        }

    }
}
