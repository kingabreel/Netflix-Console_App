package org.proway;

import org.proway.config.CreateMoviesAndSeries;
import org.proway.controller.MediaSearchController;
import org.proway.controller.NetflixSystem;
import org.proway.model.media.Episode;
import org.proway.model.media.Genre;
import org.proway.model.media.Movie;
import org.proway.model.media.Series;
import org.proway.model.search.FilterMedia;
import org.proway.model.search.FilterMovie;
import org.proway.model.search.Series.FilterSeries;
import org.proway.model.search.Series.FilterSeriesEpisode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CreateMoviesAndSeries createMoviesAndSeries = new CreateMoviesAndSeries(new NetflixSystem());

        MediaSearchController myMediaSearchController = new MediaSearchController(createMoviesAndSeries.getNetflixSystem());

        // Filter Movie
        // Spider-Man
        FilterMovie myFilterMovieSpiderMan = new FilterMovie();
        // Filter Media
        myFilterMovieSpiderMan.setMediaNamesToSearch(new ArrayList<String>(Arrays.asList("Spider-Man")));
        myFilterMovieSpiderMan.setReleaseDateInterval("2001-07-20", "2019-07-30");
        myFilterMovieSpiderMan.setSynopsisSearchTerm("Spider-Man centers on student Peter Parker (Tobey Maguire) who, after being bitten by a genetically-altered spider, gains superhuman strength and the spider-like ability to cling to any surface. He vows to use his abilities to fight crime, coming to understand the words of his beloved Uncle Ben: With great power comes great responsibility.");
        myFilterMovieSpiderMan.setActorsToSearch(new ArrayList<String>(Arrays.asList("Tobey Maguire")));
        myFilterMovieSpiderMan.setGenresToSearch(new ArrayList<Genre>(Arrays.asList(Genre.ACTION)));
        myFilterMovieSpiderMan.setImdbScoreInterval(0.0, 7.5);
        // Filter Movie
        myFilterMovieSpiderMan.setDurationMinutesInterval(0, 121);

        System.out.println("\nMOVIE FILTER\n");
        for (Movie mv : myMediaSearchController.searchForMovie(myFilterMovieSpiderMan)) {
            System.out.println(mv.getName());
        }

        // Filter Series
        // The Boys
        FilterSeries myFilterSeriesTheBoys = new FilterSeries();
        // Filter Media
        myFilterSeriesTheBoys.setMediaNamesToSearch(new ArrayList<String>(Arrays.asList("The Boys")));
        myFilterSeriesTheBoys.setReleaseDateInterval("2019-07-20", "2019-07-30");
        myFilterSeriesTheBoys.setSynopsisSearchTerm("Superheroes are often as popular as celebrities, as influential as politicians, and sometimes even as revered as gods. But that's when they're using their powers for good. What happens when the heroes go rogue and start abusing their powers? When it's the powerless against the super powerful, the Boys head out on a heroic quest to expose the truth about the Seven and Vought, the multibillion-dollar conglomerate that manages the superheroes and covers up their dirty secrets. Based on the comic book series of the same name.");
        myFilterSeriesTheBoys.setActorsToSearch(new ArrayList<String>(Arrays.asList("Philip Sgriccia")));
        myFilterSeriesTheBoys.setGenresToSearch(new ArrayList<Genre>(Arrays.asList(Genre.COMEDY)));
        myFilterSeriesTheBoys.setImdbScoreInterval(0.0, 8.7);
        // Series Filter
        myFilterSeriesTheBoys.setNumberOfEpisodesInterval(1, 2);
        myFilterSeriesTheBoys.setNumberOfSeasonInterval(0, 3);
        myFilterSeriesTheBoys.setAverageDurationEpisodeInterval(30, 60);

        System.out.println("\nSERIES FILTER\n");
        for (Series sr : myMediaSearchController.searchForMediaSeries(myFilterSeriesTheBoys)) {
            System.out.println(sr.getName());
        }

        // Filter Seasons
        System.out.println("\nSEASON FILTER\n");
        System.out.println("Seasons indexes corresponding to total number of episodes:");
        for (Series sr : myMediaSearchController.searchForMediaSeries(myFilterSeriesTheBoys)) {
            System.out.println(sr.getName());
            System.out.println(myMediaSearchController.searchForMediaSeriesSeason(sr, 0, 100));
        }

        // Filter episodes
        FilterSeriesEpisode myFilterSeriesEpisode = new FilterSeriesEpisode();
        myFilterSeriesEpisode.setTitleSearchTerm("The Name of the Game");
        myFilterSeriesEpisode.setDurationMinSearchTerm(50);
        myFilterSeriesEpisode.setDurationMaxSearchTerm(100);
        myFilterSeriesEpisode.setSeasonSearchTerm(1);
        myFilterSeriesEpisode.setSynopsisSearchTerm("Hughie Campbell suffers mental trauma after his girlfriend Robin is killed in a high-velocity impact with celebrity superhero A-Train. Lawyers from Vought International offer a $45,000 settlement, which Hughie hesitates to accept. Aspiring superhero Annie January auditions as \"Starlight\" and is accepted to join the Seven, following the retirement of the Lamplighter. Arriving at Seven headquarters, she is greeted by the Deep, who blackmails her into giving him oral sex.[6] Billy Butcher offers Hughie a chance to expose superhero corruption. Butcher takes Hughie to a secret \"Supes club\", and shows him security footage of A-Train laughing about Robin's death. Butcher asks Hughie to take the settlement money and to plant a bug at Seven Tower, but Hughie refuses. In Central Park, Annie meets Hughie. They motivate each other to stand up for themselves, and face their challenges. Hughie plants the bug. Translucent discovers the bug and confronts Hughie alone at work. Butcher arrives and together they incapacitate Translucent. Elsewhere, Homelander shoots down the Mayor of Baltimore's plane, owing to his attempts to blackmail Vought.");
        System.out.println("\nEPISODE FILTER\n");
        for (Episode ep : myMediaSearchController.searchForMediaSeriesEpisode(myMediaSearchController.searchForMediaSeries(myFilterSeriesTheBoys).getFirst(), 1, myFilterSeriesEpisode)) {
            System.out.println(ep.getTitle());
        }
    }
}