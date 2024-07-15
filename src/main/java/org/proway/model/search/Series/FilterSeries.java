package org.proway.model.search.Series;

import org.proway.model.media.Genre;
import org.proway.model.search.FilterMedia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class FilterSeries extends FilterMedia {
    /*
    private int totalSeason;
    private int totalEpisodes;
    private int averageDurationEpisode;
    private Map<Integer, List<Episode>> seasons;
    */

    private Integer numberOfSeasonIntervalStart;
    private Integer numberOfSeasonIntervalEnd;

    private Integer totalSeasonIntervalStart;
    private Integer totalSeasonIntervalEnd;

    private Integer totalEpisodesIntervalStart;
    private Integer totalEpisodesIntervalEnd;

    private Integer averageDurationEpisodeIntervalStart;
    private Integer averageDurationEpisodeIntervalEnd;

    public FilterSeries(ArrayList<String> midiaNamesToSarch, String synopsisSearchTerm, ArrayList<String> actorsToSearch, ArrayList<Genre> genreToSearch, double imdbScoreIntervalStart, double imdbScoreIntervalEnd, LocalDate releaseDateIntervalStart, LocalDate releaseDateIntervalEnd, Integer numberOfEpisodesIntervalStart, Integer numberOfEpisodesIntervalEnd, Integer numberOfSeasonIntervalStart, Integer numberOfSeasonIntervalEnd, Integer totalSeasonIntervalStart, Integer totalSeasonIntervalEnd, Integer totalEpisodesIntervalStart, Integer totalEpisodesIntervalEnd, Integer averageDurationEpisodeIntervalStart, Integer averageDurationEpisodeIntervalEnd) {
        super(midiaNamesToSarch, synopsisSearchTerm, actorsToSearch, genreToSearch, imdbScoreIntervalStart, imdbScoreIntervalEnd, releaseDateIntervalStart, releaseDateIntervalEnd);
        this.emptyAllFiltersSeries();
        this.numberOfSeasonIntervalStart = numberOfSeasonIntervalStart;
        this.numberOfSeasonIntervalEnd = numberOfSeasonIntervalEnd;
        this.totalSeasonIntervalStart = totalSeasonIntervalStart;
        this.totalSeasonIntervalEnd = totalSeasonIntervalEnd;
        this.totalEpisodesIntervalStart = totalEpisodesIntervalStart;
        this.totalEpisodesIntervalEnd = totalEpisodesIntervalEnd;
        this.averageDurationEpisodeIntervalStart = averageDurationEpisodeIntervalStart;
        this.averageDurationEpisodeIntervalEnd = averageDurationEpisodeIntervalEnd;
    }

    public FilterSeries() {
        this.emptyAllFiltersSeries();
    }

    public void emptyAllFiltersSeries()
    {
        numberOfSeasonIntervalStart = null;
        numberOfSeasonIntervalEnd = null;
        totalSeasonIntervalStart = null;
        totalSeasonIntervalEnd = null;
        totalEpisodesIntervalStart = null;
        totalEpisodesIntervalEnd = null;
        averageDurationEpisodeIntervalStart = null;
        averageDurationEpisodeIntervalEnd = null;
    }

    public void setNumberOfEpisodesInterval(Integer totalEpisodesIntervalStart, Integer totalEpisodesIntervalEnd) {
        this.totalEpisodesIntervalStart = totalEpisodesIntervalStart;
        this.totalEpisodesIntervalEnd = totalEpisodesIntervalEnd;
    }
    public void setNumberOfEpisodesInterval(Integer totalEpisodesIntervalEnd) {
        this.totalEpisodesIntervalEnd = totalEpisodesIntervalEnd;
    }

    public void setNumberOfSeasonInterval(Integer totalSeasonIntervalStart, Integer totalSeasonIntervalEnd) {
        this.totalSeasonIntervalStart = totalSeasonIntervalStart;
        this.totalSeasonIntervalEnd = totalSeasonIntervalEnd;
    }
    public void setNumberOfSeasonInterval(Integer totalSeasonIntervalEnd) {
        this.totalSeasonIntervalEnd = totalSeasonIntervalEnd;
    }

    public void setAverageDurationEpisodeInterval(Integer averageDurationEpisodeIntervalStart, Integer averageDurationEpisodeIntervalEnd) {
        this.averageDurationEpisodeIntervalStart = averageDurationEpisodeIntervalStart;
        this.averageDurationEpisodeIntervalEnd = averageDurationEpisodeIntervalEnd;
    }
    public void setAverageDurationEpisodeInterval(Integer averageDurationEpisodeIntervalEnd) {
        this.averageDurationEpisodeIntervalEnd = averageDurationEpisodeIntervalEnd;
    }

    public Integer getNumberOfSeasonIntervalStart() {
        return numberOfSeasonIntervalStart;
    }

    public Integer getNumberOfSeasonIntervalEnd() {
        return numberOfSeasonIntervalEnd;
    }

    public Integer getTotalSeasonIntervalStart() {
        return totalSeasonIntervalStart;
    }

    public Integer getTotalSeasonIntervalEnd() {
        return totalSeasonIntervalEnd;
    }

    public Integer getTotalEpisodesIntervalStart() {
        return totalEpisodesIntervalStart;
    }

    public Integer getTotalEpisodesIntervalEnd() {
        return totalEpisodesIntervalEnd;
    }

    public Integer getAverageDurationEpisodeIntervalStart() {
        return averageDurationEpisodeIntervalStart;
    }

    public Integer getAverageDurationEpisodeIntervalEnd() {
        return averageDurationEpisodeIntervalEnd;
    }
}
