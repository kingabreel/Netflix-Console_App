package org.proway.controller;

import org.proway.model.media.Episode;
import org.proway.model.media.Movie;
import org.proway.model.media.Series;
import org.proway.repository.MongoRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminController {
    private final Scanner scanner;
    private final MongoRepository mongoRepository;

    public AdminController(MongoRepository mongoRepository, Scanner scanner){
        this.mongoRepository = mongoRepository;
        this.scanner = scanner;
    }
    public void addMedia(){
        System.out.print("Movie or Series? (m or s)");
        scanner.nextLine();
        String choice = scanner.nextLine().toLowerCase();

        while (!choice.startsWith("m") && !choice.startsWith("s")){
            System.out.println("Invalid");
            choice = scanner.nextLine();
        }

        if (choice.startsWith("m")){
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Imdb: ");
            double imdb = scanner.nextDouble();

            scanner.nextLine();

            System.out.print("Synopsis: ");
            String synopsis = scanner.nextLine();

            System.out.print("ReleaseDate: yyyy-MM-dd ");
            String date = scanner.nextLine();

            System.out.print("Duration (min): ");
            int min = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Genre: ");
            String genre = scanner.nextLine();

            ArrayList<String> casting = new ArrayList<>();

            boolean finishedCasting = false;
            System.out.println("Casting");

            while (!finishedCasting){
                System.out.print("Name: ");
                casting.add(scanner.nextLine());

                System.out.println("Add more actors? y or n");
                String continueAdding = scanner.nextLine().toLowerCase();

                if (continueAdding.startsWith("n")) finishedCasting = true;
            }

            Movie movie = new Movie(name, synopsis, casting, imdb, date, genre);
            movie.setDurationMinutes(min);

            System.out.println();
            mongoRepository.addMovie(movie);
        } else {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Imdb: ");
            double imdb = scanner.nextDouble();

            System.out.print("Synopsis: ");
            String synopsis = scanner.nextLine();

            System.out.print("ReleaseDate: dd-mm-yyyy");
            String date = scanner.nextLine();

            System.out.print("Genre: ");
            String genre = scanner.nextLine();

            ArrayList<String> casting = new ArrayList<>();

            boolean finishedCasting = false;
            System.out.println("Casting: ");

            while (!finishedCasting){
                System.out.print("Name: ");
                casting.add(scanner.nextLine());

                System.out.println("Add more actors? y or n");
                String continueAdding = scanner.nextLine().toLowerCase();

                if (continueAdding.startsWith("n")) finishedCasting = true;
            }

            System.out.print("Average duration (min): ");
            int duration = scanner.nextInt();

            System.out.print("Total season: ");
            int seasons = scanner.nextInt();

            System.out.print("Total episodes: ");
            int episodes = scanner.nextInt();


            Series series = new Series(name, synopsis, casting, genre, imdb, date);
            series.setAverageDurationEpisode(duration);
            series.setTotalSeason(seasons);
            series.setTotalEpisode(episodes);

            System.out.println("Add episodes now? y or n");
            String addEpisode = scanner.nextLine().toLowerCase();

            if (addEpisode.startsWith("y")) addEpisode(series);

            mongoRepository.addSerie(series);
        }
    }

    private void addEpisode(Series series) {
        boolean addingEpisode = true;
        while(addingEpisode){
            System.out.print("Episode title: ");
            String title = scanner.nextLine();

            System.out.print("Duration (min): ");
            int duration = scanner.nextInt();

            System.out.print("Season: ");
            int season = scanner.nextInt();

            System.out.print("Episode id: ");
            int episodeId = scanner.nextInt();

            System.out.print("Synopsis: ");
            String synopsis = scanner.nextLine();

            series.getEpisodes().add(new Episode(title, duration, season, episodeId, synopsis));

            System.out.println("Added succesfully!");
            System.out.println("Continue? y or n");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.startsWith("n")) addingEpisode = false;
        }
    }

    public void removeSerie(){
        scanner.nextLine();

        System.out.println("Name: ");
        String name = scanner.nextLine();

        mongoRepository.removeSerie(name);
    }

    public void removeMovie(){
        scanner.nextLine();

        System.out.println("Name: ");
        String name = scanner.nextLine();

        mongoRepository.removeMovie(name);
    }
}
