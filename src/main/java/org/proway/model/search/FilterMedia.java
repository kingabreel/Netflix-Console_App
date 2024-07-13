package org.proway.model.search;

import java.util.ArrayList;
import java.time.LocalDate;

public abstract class FilterMedia {
    /*
    private String name;
    private String synopsis;
    private ArrayList<String> casting;
    private String genre;
    private double imdb;
    private String releaseDate;
    */
    // All search parameters are not exact string match, so it can be a slice of the original media
    private ArrayList<String> mediaNamesToSarch;
    private String synopsisSearchTerm;
    private ArrayList<String> actorsToSearch;
    private ArrayList<String> genresToSearch;
    private double imdbScoreIntervalStart;
    private double imdbScoreIntervalEnd;
    private LocalDate releaseDateIntervalStart;
    private LocalDate releaseDateIntervalEnd;

    public FilterMedia(ArrayList<String> mediaNamesToSarch, String synopsisSearchTerm, ArrayList<String> actorsToSearch, ArrayList<String> genresToSearch, double imdbScoreIntervalStart, double imdbScoreIntervalEnd, LocalDate releaseDateIntervalStart, LocalDate releaseDateIntervalEnd) {
        this.emptyAllFilters();
        this.mediaNamesToSarch = mediaNamesToSarch;
        this.synopsisSearchTerm = synopsisSearchTerm;
        this.actorsToSearch = actorsToSearch;
        this.genresToSearch = genresToSearch;
        this.imdbScoreIntervalStart = imdbScoreIntervalStart;
        this.imdbScoreIntervalEnd = imdbScoreIntervalEnd;
        this.releaseDateIntervalStart = releaseDateIntervalStart;
        this.releaseDateIntervalEnd = releaseDateIntervalEnd;
    }

    public FilterMedia() {
        this.emptyAllFilters();
    }

    public void emptyAllFilters()
    {
        mediaNamesToSarch = null;
        synopsisSearchTerm = null;
        actorsToSearch = null;
        genresToSearch = null;
        imdbScoreIntervalStart = -1;
        imdbScoreIntervalEnd = -1;
        releaseDateIntervalStart = null;
        releaseDateIntervalEnd = null;
    }

    public void setMediaNamesToSarch(ArrayList<String> mediaNamesToSarch) {
        this.mediaNamesToSarch = this.mediaNamesToSarch;
    }

    public void setSynopsisSearchTerm(String synopsisSearchTerm) {
        this.synopsisSearchTerm = synopsisSearchTerm;
    }

    public void setActorsToSearch(ArrayList<String> actorsToSearch) {
        this.actorsToSearch = actorsToSearch;
    }

    public void setGenresToSearch(ArrayList<String> genresToSearch) {
        this.genresToSearch = genresToSearch;
    }

    public void setImdbScoreInterval(double imdbScoreIntervalEnd) {
        this.imdbScoreIntervalEnd = imdbScoreIntervalEnd;
    }

    public void setImdbScoreInterval(double imdbScoreIntervalStart, double imdbScoreIntervalEnd) {
        this.imdbScoreIntervalStart = imdbScoreIntervalStart;
        this.imdbScoreIntervalEnd = imdbScoreIntervalEnd;
    }

    public void setReleaseDateInterval(LocalDate releaseDateIntervalEnd) {
        this.releaseDateIntervalEnd = releaseDateIntervalEnd;
    }

    public void setReleaseDateInterval(LocalDate releaseDateIntervalStart ,LocalDate releaseDateIntervalEnd) {
        this.releaseDateIntervalStart = releaseDateIntervalStart;
        this.releaseDateIntervalEnd = releaseDateIntervalEnd;
    }

    public ArrayList<String> getMediaNamesToSarch() {
        return mediaNamesToSarch;
    }

    public String getSynopsisSearchTerm() {
        return synopsisSearchTerm;
    }

    public ArrayList<String> getActorsToSearch() {
        return actorsToSearch;
    }

    public ArrayList<String> getGenresToSearch() {
        return genresToSearch;
    }

    public double getImdbScoreIntervalStart() {
        return imdbScoreIntervalStart;
    }

    public double getImdbScoreIntervalEnd() {
        return imdbScoreIntervalEnd;
    }

    public LocalDate getReleaseDateIntervalStart() {
        return releaseDateIntervalStart;
    }

    public LocalDate getReleaseDateIntervalEnd() {
        return releaseDateIntervalEnd;
    }
}
