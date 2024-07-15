package org.proway.model.search.Series;

public class FilterSeriesEpisode {
    /*
    private String title;
    private int durationMin;
    private int season;
    private int episode;
    private String synopsis;
     */

    private String titleSearchTerm;
    private Integer durationMinSearchTerm;
    private Integer durationMaxSearchTerm;
    private Integer seasonSearchTerm;
    private String synopsisSearchTerm;

    public FilterSeriesEpisode(String titleSearchTerm, Integer durationMinSearchTerm, Integer durationMaxSearchTerm, Integer seasonSearchTerm, Integer episodeSearchTerm, String synopsisSearchTerm) {
        emptyAllFiltersSeriesEpisode();
        this.titleSearchTerm = titleSearchTerm;
        this.durationMinSearchTerm = durationMinSearchTerm;
        this.durationMaxSearchTerm = durationMaxSearchTerm;
        this.seasonSearchTerm = seasonSearchTerm;
        this.synopsisSearchTerm = synopsisSearchTerm;
    }

    public FilterSeriesEpisode()
    {
        emptyAllFiltersSeriesEpisode();
    }

    public void emptyAllFiltersSeriesEpisode()
    {
        titleSearchTerm = null;
        durationMinSearchTerm = null;
        durationMaxSearchTerm = null;
        seasonSearchTerm = null;
        synopsisSearchTerm = null;
    }

    public void setTitleSearchTerm(String titleSearchTerm) {
        this.titleSearchTerm = titleSearchTerm;
    }

    public void setDurationMinSearchTerm(Integer durationMinSearchTerm) {
        this.durationMinSearchTerm = durationMinSearchTerm;
    }

    public void setDurationMaxSearchTerm(Integer durationMaxSearchTerm) {
        this.durationMaxSearchTerm = durationMaxSearchTerm;
    }

    public void setSeasonSearchTerm(Integer seasonSearchTerm) {
        this.seasonSearchTerm = seasonSearchTerm;
    }

    public void setSynopsisSearchTerm(String synopsisSearchTerm) {
        this.synopsisSearchTerm = synopsisSearchTerm;
    }

    public String getTitleSearchTerm() {
        return titleSearchTerm;
    }

    public Integer getDurationMinSearchTerm() {
        return durationMinSearchTerm;
    }

    public Integer getDurationMaxSearchTerm() {
        return durationMaxSearchTerm;
    }

    public Integer getSeasonSearchTerm() {
        return seasonSearchTerm;
    }

    public String getSynopsisSearchTerm() {
        return synopsisSearchTerm;
    }
}
