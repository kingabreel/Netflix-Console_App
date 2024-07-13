package org.proway.model.search.Series;

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
    private Integer numberOfEpisodesIntervalStart;
    private Integer numberOfEpisodesIntervalEnd;

    private Integer numberOfSeasonIntervalStart;
    private Integer numberOfSeasonIntervalEnd;

    private Integer totalSeasonIntervalStart;
    private Integer totalSeasonIntervalEnd;

    private Integer totalEpisodesIntervalStart;
    private Integer totalEpisodesIntervalEnd;

    private Integer averageDurationEpisodeIntervalStart;
    private Integer averageDurationEpisodeIntervalEnd;

    public FilterSeries(ArrayList<String> midiaNamesToSarch, String synopsisSearchTerm, ArrayList<String> actorsToSearch, ArrayList<String> genreToSearch, double imdbScoreIntervalStart, double imdbScoreIntervalEnd, LocalDate releaseDateIntervalStart, LocalDate releaseDateIntervalEnd, Integer numberOfEpisodesIntervalStart, Integer numberOfEpisodesIntervalEnd, Integer numberOfSeasonIntervalStart, Integer numberOfSeasonIntervalEnd, Integer totalSeasonIntervalStart, Integer totalSeasonIntervalEnd, Integer totalEpisodesIntervalStart, Integer totalEpisodesIntervalEnd, Integer averageDurationEpisodeIntervalStart, Integer averageDurationEpisodeIntervalEnd) {
        super(midiaNamesToSarch, synopsisSearchTerm, actorsToSearch, genreToSearch, imdbScoreIntervalStart, imdbScoreIntervalEnd, releaseDateIntervalStart, releaseDateIntervalEnd);
        this.emptyAllFilters();
        this.numberOfEpisodesIntervalStart = numberOfEpisodesIntervalStart;
        this.numberOfEpisodesIntervalEnd = numberOfEpisodesIntervalEnd;
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
        this.emptyAllFilters();
    }

    public void emptyAllFilters()
    {
        numberOfEpisodesIntervalStart = null;
        numberOfEpisodesIntervalEnd = null;
        numberOfSeasonIntervalStart = null;
        numberOfSeasonIntervalEnd = null;
        totalSeasonIntervalStart = null;
        totalSeasonIntervalEnd = null;
        totalEpisodesIntervalStart = null;
        totalEpisodesIntervalEnd = null;
        averageDurationEpisodeIntervalStart = null;
        averageDurationEpisodeIntervalEnd = null;
    }

    public Integer getNumberOfEpisodesIntervalStart() {
        return numberOfEpisodesIntervalStart;
    }

    public void setNumberOfEpisodesIntervalStart(Integer numberOfEpisodesIntervalStart) {
        this.numberOfEpisodesIntervalStart = numberOfEpisodesIntervalStart;
    }

    public Integer getNumberOfEpisodesIntervalEnd() {
        return numberOfEpisodesIntervalEnd;
    }

    public void setNumberOfEpisodesIntervalEnd(Integer numberOfEpisodesIntervalEnd) {
        this.numberOfEpisodesIntervalEnd = numberOfEpisodesIntervalEnd;
    }

    public Integer getNumberOfSeasonIntervalStart() {
        return numberOfSeasonIntervalStart;
    }

    public void setNumberOfSeasonIntervalStart(Integer numberOfSeasonIntervalStart) {
        this.numberOfSeasonIntervalStart = numberOfSeasonIntervalStart;
    }

    public Integer getNumberOfSeasonIntervalEnd() {
        return numberOfSeasonIntervalEnd;
    }

    public void setNumberOfSeasonIntervalEnd(Integer numberOfSeasonIntervalEnd) {
        this.numberOfSeasonIntervalEnd = numberOfSeasonIntervalEnd;
    }

    public Integer getTotalSeasonIntervalStart() {
        return totalSeasonIntervalStart;
    }

    public void setTotalSeasonIntervalStart(Integer totalSeasonIntervalStart) {
        this.totalSeasonIntervalStart = totalSeasonIntervalStart;
    }

    public Integer getTotalSeasonIntervalEnd() {
        return totalSeasonIntervalEnd;
    }

    public void setTotalSeasonIntervalEnd(Integer totalSeasonIntervalEnd) {
        this.totalSeasonIntervalEnd = totalSeasonIntervalEnd;
    }

    public Integer getTotalEpisodesIntervalStart() {
        return totalEpisodesIntervalStart;
    }

    public void setTotalEpisodesIntervalStart(Integer totalEpisodesIntervalStart) {
        this.totalEpisodesIntervalStart = totalEpisodesIntervalStart;
    }

    public Integer getTotalEpisodesIntervalEnd() {
        return totalEpisodesIntervalEnd;
    }

    public void setTotalEpisodesIntervalEnd(Integer totalEpisodesIntervalEnd) {
        this.totalEpisodesIntervalEnd = totalEpisodesIntervalEnd;
    }

    public Integer getAverageDurationEpisodeIntervalStart() {
        return averageDurationEpisodeIntervalStart;
    }

    public void setAverageDurationEpisodeIntervalStart(Integer averageDurationEpisodeIntervalStart) {
        this.averageDurationEpisodeIntervalStart = averageDurationEpisodeIntervalStart;
    }

    public Integer getAverageDurationEpisodeIntervalEnd() {
        return averageDurationEpisodeIntervalEnd;
    }

    public void setAverageDurationEpisodeIntervalEnd(Integer averageDurationEpisodeIntervalEnd) {
        this.averageDurationEpisodeIntervalEnd = averageDurationEpisodeIntervalEnd;
    }
}
