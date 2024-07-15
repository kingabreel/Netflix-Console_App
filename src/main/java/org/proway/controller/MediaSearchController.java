package org.proway.controller;

import org.proway.model.media.*;
import org.proway.model.search.FilterMedia;
import org.proway.model.search.FilterMovie;
import org.proway.model.search.Series.FilterSeries;
import org.proway.model.search.Series.FilterSeriesEpisode;
import org.proway.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * SEARCHES FOR EVERY MEDIA, SERIES, SEASON OR EPISODE, INSIDE OF NETFLIX'S CATALOG
 */
public class MediaSearchController {
    private MongoRepository mongoRepository;

    public MediaSearchController(MongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    /*** MEDIA SEARCH ***/
    // Gets if a Media matches a media filter
    public <M extends Media> M filterMatchMedia(M md, FilterMedia mediaFilter) {
        boolean itMatchesSomething;

        /**
         * If a filter exists, it is supposed to match with media's data,
         * if it doesn't, it should return empty. This for every filter.
         */

        // MediaNamesToSearch
        if (mediaFilter.getMediaNamesToSearch() != null) {
            itMatchesSomething = false;
            for (String nameToSearch : mediaFilter.getMediaNamesToSearch()){
                if (md.getName().toLowerCase().contains(nameToSearch.toLowerCase())) {
                    itMatchesSomething = true;
                }
            }
            if (!itMatchesSomething) {
                return null;
            }
        }

        // synopsisSearchTerm
        if (mediaFilter.getSynopsisSearchTerm() != null) {
            itMatchesSomething = false;
            if (md.getSynopsis().toLowerCase().contains(mediaFilter.getSynopsisSearchTerm().toLowerCase())){
                itMatchesSomething = true;
            }
            if (!itMatchesSomething) {
                return null;
            }
        }

        // actorsToSearch
        if (mediaFilter.getActorsToSearch() != null) {
            itMatchesSomething = false;
            for (String actor : mediaFilter.getActorsToSearch()){
                for (String castMember : md.getCasting()){
                    if (castMember.equalsIgnoreCase(actor))
                        itMatchesSomething = true;
                }
            }
            if (!itMatchesSomething) {
                return null;
            }
        }

        // genresToSearch
        if (mediaFilter.getGenresToSearch() != null) {
            itMatchesSomething = false;
            if (mediaFilter.getGenresToSearch().contains(md.getMediaGenre()))
                itMatchesSomething = true;
            if (!itMatchesSomething) {
                return null;
            }
        }

        // imdbScoreIntervalStartEnd (Interval between two scores)
        if (mediaFilter.getImdbScoreIntervalStart() != -1.0 && mediaFilter.getImdbScoreIntervalEnd() != -1.0) {
            itMatchesSomething = false;
            if (md.getImdb() >= mediaFilter.getImdbScoreIntervalStart() && md.getImdb() <= mediaFilter.getImdbScoreIntervalEnd()){
                itMatchesSomething = true;
            }
            if (!itMatchesSomething) {
                return null;
            }
        }

        // imdbScoreIntervalEnd (Filters all media up to a certain score)
        if (mediaFilter.getImdbScoreIntervalStart() == -1.0 && mediaFilter.getImdbScoreIntervalEnd() != -1.0) {
            itMatchesSomething = false;
            if (md.getImdb() <= mediaFilter.getImdbScoreIntervalEnd()){
                itMatchesSomething = true;
            }
            if (!itMatchesSomething) {
                return null;
            }
        }

        // releaseDateIntervalStartEnd (Interval between two LocalDate values)
        if (mediaFilter.getReleaseDateIntervalStart() != null && mediaFilter.getReleaseDateIntervalEnd() != null) {
            itMatchesSomething = false;
            if (md.getReleaseDate().isAfter(mediaFilter.getReleaseDateIntervalStart()) &&
                md.getReleaseDate().isBefore(mediaFilter.getReleaseDateIntervalEnd())) {
                itMatchesSomething = true;
            }
            if (!itMatchesSomething) {
                return null;
            }
        }

        // releaseDateIntervalEnd (Filters all media released until a certain LocalDate)
        if (mediaFilter.getReleaseDateIntervalStart() == null && mediaFilter.getReleaseDateIntervalEnd() != null) {
            itMatchesSomething = false;
            if (md.getReleaseDate().isBefore(mediaFilter.getReleaseDateIntervalEnd())) {
                itMatchesSomething = true;
            }
            if (!itMatchesSomething) {
                return null;
            }
        }

        return md;
    }

    /*** SERIES SEARCH ***/
    // Search Series
    public ArrayList<Series> searchForMediaSeries(FilterSeries seriesFilter) {
        ArrayList<Series> filteredSeriesList = new ArrayList<>();
        boolean itMatchesSomething;

        for (Series sr :  mongoRepository.getSeries().stream().toList())
        {
            /* Filter Medias */
            if (sr.equals(this.filterMatchMedia(sr, seriesFilter)))
            {
                /* Filter Series */
                // TotalEpisodesIntervalStartEnd (Number of episodes in a range)
                if (seriesFilter.getTotalEpisodesIntervalStart() != null && seriesFilter.getTotalEpisodesIntervalEnd() != null) {
                    itMatchesSomething = false;
                    if (sr.getTotalEpisode() >= seriesFilter.getTotalEpisodesIntervalStart() && sr.getTotalEpisodes() <= seriesFilter.getTotalEpisodesIntervalEnd()){
                        itMatchesSomething = true;
                    }
                    if (!itMatchesSomething) {
                        continue;
                    }
                }
                // TotalEpisodesIntervalEnd (Number of episodes up to a total inclusive)
                if (seriesFilter.getTotalEpisodesIntervalStart() == null && seriesFilter.getTotalEpisodesIntervalEnd() != null) {
                    itMatchesSomething = false;
                    if (sr.getTotalEpisode() <= seriesFilter.getTotalEpisodesIntervalEnd()){
                        itMatchesSomething = true;
                    }
                    if (!itMatchesSomething) {
                        continue;
                    }
                }

                // NumberOfSeasonIntervalStartEnd (Number of seasons in a range)
                if (seriesFilter.getTotalSeasonIntervalStart() != null && seriesFilter.getTotalSeasonIntervalEnd() != null) {
                    itMatchesSomething = false;
                    if (sr.getTotalSeason() >= seriesFilter.getTotalSeasonIntervalStart() && sr.getTotalSeason() <= seriesFilter.getTotalSeasonIntervalEnd()){
                        itMatchesSomething = true;
                    }
                    if (!itMatchesSomething) {
                        continue;
                    }
                }
                // NumberOfSeasonIntervalEnd (Number of seasons up to a total inclusive)
                if (seriesFilter.getTotalSeasonIntervalStart() == null && seriesFilter.getTotalSeasonIntervalEnd() != null) {
                    itMatchesSomething = false;
                    if (sr.getTotalSeason() <= seriesFilter.getTotalSeasonIntervalEnd()){
                        itMatchesSomething = true;
                    }
                    if (!itMatchesSomething) {
                        continue;
                    }
                }

                // AverageDurationEpisodeIntervalStartEnd (Series AverageDurationOfEpisodes in a range)
                if (seriesFilter.getAverageDurationEpisodeIntervalStart() != null && seriesFilter.getAverageDurationEpisodeIntervalEnd() != null) {
                    itMatchesSomething = false;
                    if (sr.getAverageDurationEpisode() >= seriesFilter.getAverageDurationEpisodeIntervalStart() && sr.getAverageDurationEpisode() <= seriesFilter.getAverageDurationEpisodeIntervalEnd()){
                        itMatchesSomething = true;
                    }
                    if (!itMatchesSomething) {
                        continue;
                    }
                }
                // AverageDurationEpisodeIntervalEnd (Series AverageDurationOfEpisodes up to a total inclusive)
                if (seriesFilter.getAverageDurationEpisodeIntervalStart() == null && seriesFilter.getAverageDurationEpisodeIntervalEnd() != null) {
                    itMatchesSomething = false;
                    if (sr.getAverageDurationEpisode() <= seriesFilter.getAverageDurationEpisodeIntervalEnd()){
                        itMatchesSomething = true;
                    }
                    if (!itMatchesSomething) {
                        continue;
                    }
                }

                if (!filteredSeriesList.contains(sr)) {filteredSeriesList.add(sr);}
            }
        }

        return filteredSeriesList;
    }

    // Search for Seasons
    public ArrayList<Integer> searchForMediaSeriesSeason(Series series, Integer SeasonNumberNumberOfEpisodesStart, Integer SeasonNumberNumberOfEpisodesEnd) {
        ArrayList<Integer> filteredSeriesSeasonsIndexList = new ArrayList<>();

        for (Series sr :  mongoRepository.getSeries().stream().toList())
        {
            /* Filter Seasons */
            for (Map.Entry<Integer, List<Episode>> SeEntry : sr.getSeasons().entrySet()) {
                if (SeEntry.getValue().size() >= SeasonNumberNumberOfEpisodesStart && SeEntry.getValue().size() <= SeasonNumberNumberOfEpisodesEnd) {}
                filteredSeriesSeasonsIndexList.add(SeEntry.getKey());
            }
        }

        return filteredSeriesSeasonsIndexList;
    }

    // Search for Episode
    public List<Episode> searchForMediaSeriesEpisode(Series series, Integer SeasonNumber, FilterSeriesEpisode episodeFilter) {
        // Input a null into SeasonNumber if you don't want to filter by episodes by season
        List<Episode> filteredSeriesEpisodeList = new ArrayList<>();
        boolean dontFilterEpisodesBySeason = (SeasonNumber == null);
        boolean itMatchesSomething;

        for (Series sr : mongoRepository.getSeries().stream().toList())
        {
            /* Filter Seasons */
            for (Map.Entry<Integer, List<Episode>> SeEntry : sr.getSeasons().entrySet()) {
                if (SeEntry.getKey().equals(SeasonNumber) || dontFilterEpisodesBySeason) {
                    //filteredSeriesEpisodeList.addAll(SeEntry.getValue());
                    /* Filter Episodes */
                    for (Episode ep : SeEntry.getValue()) {
                        // Filter by titleSearchTerm
                        if (episodeFilter.getTitleSearchTerm() != null)
                        {
                            itMatchesSomething = false;
                            if (ep.getTitle().toLowerCase().contains(episodeFilter.getTitleSearchTerm().toLowerCase())) {
                                itMatchesSomething = true;
                            }
                            if (!itMatchesSomething) {
                                continue;
                            }
                        }

                        // Filter by durationMinSearchTerm
                        if (episodeFilter.getDurationMinSearchTerm() != null)
                        {
                            itMatchesSomething = false;
                            if (ep.getDurationMin() >= episodeFilter.getDurationMinSearchTerm()) {
                                itMatchesSomething = true;
                            }
                            if (!itMatchesSomething) {
                                continue;
                            }
                        }

                        // Filter by durationMaxSearchTerm
                        if (episodeFilter.getDurationMaxSearchTerm() != null)
                        {
                            itMatchesSomething = false;
                            if (ep.getDurationMin() <= episodeFilter.getDurationMaxSearchTerm()) {
                                itMatchesSomething = true;
                            }
                            if (!itMatchesSomething) {
                                continue;
                            }
                        }

                        // Filter by seasonSearchTerm
                        if (episodeFilter.getSeasonSearchTerm() != null)
                        {
                            itMatchesSomething = false;
                            if (SeEntry.getKey().equals(episodeFilter.getSeasonSearchTerm())) {
                                itMatchesSomething = true;
                            }
                            if (!itMatchesSomething) {
                                continue;
                            }
                        }

                        // Filter by synopsisSearchTerm
                        if (episodeFilter.getSynopsisSearchTerm() != null)
                        {
                            itMatchesSomething = false;
                            if (ep.getSynopsis().toLowerCase().contains(episodeFilter.getSynopsisSearchTerm().toLowerCase())) {
                                itMatchesSomething = true;
                            }
                            if (!itMatchesSomething) {
                                continue;
                            }
                        }

                        filteredSeriesEpisodeList.add(ep);
                    }
                }
            }
        }

        return filteredSeriesEpisodeList;
    }

    /*** MOVIE SEARCH ***/
    // Search Movie
    public ArrayList<Movie> searchForMovie(FilterMovie movieFilter) {
        ArrayList<Movie> filteredMovieList = new ArrayList<>();
        boolean itMatchesSomething;

        for (Movie mv : mongoRepository.getMovie().stream().toList())
        {
            /* Filter Media */
            if (mv.equals(this.filterMatchMedia(mv, movieFilter))) {
                /* Filter Movie */
                // DurationMinutesIntervalStartEnd
                if (movieFilter.getDurationMinutesIntervalStart() != null && movieFilter.getDurationMinutesIntervalEnd() != null) {
                    itMatchesSomething = false;
                    if (mv.getDurationMinutes() >= movieFilter.getDurationMinutesIntervalStart() &&
                        mv.getDurationMinutes() <= movieFilter.getDurationMinutesIntervalEnd()) {
                        itMatchesSomething = true;
                    }
                    if (!itMatchesSomething) {
                        continue;
                    }
                }

                // DurationMinutesIntervalEnd
                if (movieFilter.getDurationMinutesIntervalStart() == null && movieFilter.getDurationMinutesIntervalEnd() != null) {
                    itMatchesSomething = false;
                    if (mv.getDurationMinutes() <= movieFilter.getDurationMinutesIntervalEnd()) {
                        itMatchesSomething = true;
                    }
                    if (!itMatchesSomething) {
                        continue;
                    }
                }

                filteredMovieList.add(mv);
            }
        }

        return filteredMovieList;
    }
}
