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
    // Search for any Media
    public <M extends Media> ArrayList<M> searchForMedia(M md, FilterMedia mediaFilter) {
        ArrayList<M> filteredMediaList = new ArrayList<>();

        // MediaNamesToSearch
        if (mediaFilter.getMediaNamesToSearch() != null) {
            for (String nameToSearch : mediaFilter.getMediaNamesToSearch()){
                if (md.getName().toLowerCase().contains(nameToSearch.toLowerCase())) {
                    if (!filteredMediaList.contains(md)) {
                        filteredMediaList.add(md);
                    }
                }
            }
        }

        // synopsisSearchTerm
        if (mediaFilter.getSynopsisSearchTerm() != null) {
            try {
                if (md.getSynopsis().toLowerCase().contains(mediaFilter.getSynopsisSearchTerm().toLowerCase())){
                    if (!filteredMediaList.contains(md)) {
                        filteredMediaList.add(md);
                    }

                }
            } catch (NullPointerException e) {}
        }

        // actorsToSearch
        if (mediaFilter.getActorsToSearch() != null) {
            System.out.println(mediaFilter.getActorsToSearch());
            for (String actor : mediaFilter.getActorsToSearch()){
                for (String castMember : md.getCasting()){
                    if (castMember.toLowerCase().contains(actor))
                        if (!filteredMediaList.contains(md)) {
                            filteredMediaList.add(md);
                        break;}
                }
            }
        }

        // genresToSearch
        if (mediaFilter.getGenresToSearch() != null & !mediaFilter.getGenresToSearch().isEmpty()) {
            String filterGenre = mediaFilter.getGenresToSearch().stream().findFirst().orElse(null);
            if (filterGenre != null && md.getGenre().equals(filterGenre)) {
                if (!filteredMediaList.contains(md)) {
                    filteredMediaList.add(md);
                }
            }
        }

        // imdbScoreIntervalStartEnd (Interval between two scores)
        if (mediaFilter.getImdbScoreIntervalStart() != -1 && mediaFilter.getImdbScoreIntervalEnd() != -1) {
            if (md.getImdb() >= mediaFilter.getImdbScoreIntervalStart() && md.getImdb() <= mediaFilter.getImdbScoreIntervalEnd()){
                if (!filteredMediaList.contains(md)) {filteredMediaList.add(md);}
            }
        }

        // imdbScoreIntervalEnd (Filters all media up to a certain score)
        if (mediaFilter.getImdbScoreIntervalStart() == -1 && mediaFilter.getImdbScoreIntervalEnd() != -1) {
            if (md.getImdb() <= mediaFilter.getImdbScoreIntervalEnd()){
                if (!filteredMediaList.contains(md)) {filteredMediaList.add(md);}
            }
        }

        // releaseDateIntervalStartEnd (Interval between two LocalDate values)
        if (mediaFilter.getReleaseDateIntervalStart() != null && mediaFilter.getReleaseDateIntervalEnd() != null) {
            if (md.getReleaseDate().isAfter(mediaFilter.getReleaseDateIntervalStart()) &&
                md.getReleaseDate().isBefore(mediaFilter.getReleaseDateIntervalEnd())) {
                if (!filteredMediaList.contains(md)) {filteredMediaList.add(md);}
            }
        }

        // releaseDateIntervalEnd (Filters all media released until a certain LocalDate)
        if (mediaFilter.getReleaseDateIntervalStart() == null && mediaFilter.getReleaseDateIntervalEnd() != null) {
            if (md.getReleaseDate().isBefore(mediaFilter.getReleaseDateIntervalEnd())) {
                if (!filteredMediaList.contains(md)) {filteredMediaList.add(md);}
            }
        }

        return filteredMediaList;
    }

    /*** SERIES SEARCH ***/
    // Search Series
    public ArrayList<Series> searchForMediaSeries(FilterSeries seriesFilter) {
        ArrayList<Series> filteredSeriesList = new ArrayList<>();

        for (Series sr :  mongoRepository.getSeries().stream().toList())
        {
            /* Filter Media */
            filteredSeriesList.addAll(this.searchForMedia(sr, seriesFilter));

            /* Filter Series */
            // numberOfEpisodesIntervalStartEnd (Number of episodes in a range)
            if (seriesFilter.getNumberOfEpisodesIntervalStart() != null && seriesFilter.getNumberOfEpisodesIntervalEnd() != null) {
                if (sr.getTotalEpisode() >= seriesFilter.getNumberOfEpisodesIntervalStart() && sr.getTotalEpisode() <= seriesFilter.getNumberOfEpisodesIntervalEnd()){
                    if (!filteredSeriesList.contains(sr)) {filteredSeriesList.add(sr);}
                }
            }

            // numberOfEpisodesIntervalEnd (Number of episodes up to a total inclusive)
            if (seriesFilter.getNumberOfEpisodesIntervalStart() == null && seriesFilter.getNumberOfEpisodesIntervalEnd() != null) {
                if (sr.getTotalEpisode() <= seriesFilter.getNumberOfEpisodesIntervalEnd()){
                    if (!filteredSeriesList.contains(sr)) {filteredSeriesList.add(sr);}
                }
            }
        }

        return filteredSeriesList;
    }

    // Search for Season
    public List<Episode> searchForMediaSeriesSeason(Series series, Integer SeasonNumber) {
        List<Episode> filteredSeriesSeasonsList = new ArrayList<>();

        for (Series sr :  mongoRepository.getSeries().stream().toList())
        {
            /* Filter Season */
            for (Map.Entry<Integer, List<Episode>> SeEntry : sr.getSeasons().entrySet()) {
                if (SeEntry.getKey().equals(SeasonNumber)) {
                    filteredSeriesSeasonsList.addAll(SeEntry.getValue());
                }
            }
        }

        return filteredSeriesSeasonsList;
    }

    // Search for Episode
    public List<Episode> searchForMediaSeriesEpisode(Series series, Integer SeasonNumber, FilterSeriesEpisode episodeFilter) {
        // Input a null into SeasonNumber if you don't want to filter by episodes by season
        List<Episode> filteredSeriesEpisodeList = new ArrayList<>();
        boolean dontFilterEpisodesBySeason = (SeasonNumber == null);

        for (Series sr : mongoRepository.getSeries().stream().toList())
        {
            // Filter Season
            for (Map.Entry<Integer, List<Episode>> SeEntry : sr.getSeasons().entrySet()) {
                if (SeEntry.getKey().equals(SeasonNumber) || dontFilterEpisodesBySeason) {
                    filteredSeriesEpisodeList.addAll(SeEntry.getValue());
                    // Filter Episode
                    for (Episode ep : SeEntry.getValue()) {
                        // Filter by titleSearchTerm
                        if (ep.getTitle().toLowerCase().contains(episodeFilter.getTitleSearchTerm())) {
                            if (!filteredSeriesEpisodeList.contains(ep)) {filteredSeriesEpisodeList.add(ep);}
                        }

                        // Filter by durationMinSearchTerm
                        if (ep.getDurationMin() <= episodeFilter.getDurationMinSearchTerm()) {
                            if (!filteredSeriesEpisodeList.contains(ep)) {filteredSeriesEpisodeList.add(ep);}
                        }

                        // Filter by durationMaxSearchTerm
                        if (ep.getDurationMin() >= episodeFilter.getDurationMaxSearchTerm()) {
                            if (!filteredSeriesEpisodeList.contains(ep)) {filteredSeriesEpisodeList.add(ep);}
                        }

                        // Filter by seasonSearchTerm
                        if (SeEntry.getKey().equals(episodeFilter.getSeasonSearchTerm())) {
                            if (!filteredSeriesEpisodeList.contains(ep)) {filteredSeriesEpisodeList.add(ep);}
                        }

                        // Filter by episodeSearchTerm
                        if (ep.getTitle().toLowerCase().contains(episodeFilter.getTitleSearchTerm().toLowerCase())) {
                            if (!filteredSeriesEpisodeList.contains(ep)) {filteredSeriesEpisodeList.add(ep);}
                        }

                        // Filter by synopsisSearchTerm
                        if (ep.getSynopsis().toLowerCase().contains(episodeFilter.getSynopsisSearchTerm().toLowerCase())) {
                            if (!filteredSeriesEpisodeList.contains(ep)) {filteredSeriesEpisodeList.add(ep);}
                        }
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

        for (Movie mv : mongoRepository.getMovie().stream().toList())
        {
            /* Filter Media */
            filteredMovieList.addAll(this.searchForMedia(mv, movieFilter));

            /* Filter Movie */
            // DurationMinutesIntervalStartEnd
            if (movieFilter.getDurationMinutesIntervalStart() != null && movieFilter.getDurationMinutesIntervalEnd() != null) {
                if (mv.getDurationMinutes() >= movieFilter.getDurationMinutesIntervalStart() &&
                        mv.getDurationMinutes() <= movieFilter.getDurationMinutesIntervalEnd()) {
                    filteredMovieList.add(mv);
                }
            }

            // DurationMinutesIntervalEnd
            if (movieFilter.getDurationMinutesIntervalStart() == null && movieFilter.getDurationMinutesIntervalEnd() != null) {
                if (mv.getDurationMinutes() <= movieFilter.getDurationMinutesIntervalEnd()) {
                    filteredMovieList.add(mv);
                }
            }
        }

        return filteredMovieList;
    }

}
