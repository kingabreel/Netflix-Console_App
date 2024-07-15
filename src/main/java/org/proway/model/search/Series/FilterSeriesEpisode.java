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
    private Integer episodeSearchTerm;
    private String synopsisSearchTerm;

    public FilterSeriesEpisode(String titleSearchTerm, Integer durationMinSearchTerm, Integer durationMaxSearchTerm, Integer seasonSearchTerm, Integer episodeSearchTerm, String synopsisSearchTerm) {
        emptyAllFilters();
        this.titleSearchTerm = titleSearchTerm;
        this.durationMinSearchTerm = durationMinSearchTerm;
        this.durationMaxSearchTerm = durationMaxSearchTerm;
        this.seasonSearchTerm = seasonSearchTerm;
        this.episodeSearchTerm = episodeSearchTerm;
        this.synopsisSearchTerm = synopsisSearchTerm;
    }

    public FilterSeriesEpisode()
    {
        emptyAllFilters();
    }

    public void emptyAllFilters()
    {
        titleSearchTerm = null;
        durationMinSearchTerm = null;
        durationMaxSearchTerm = null;
        seasonSearchTerm = null;
        episodeSearchTerm = null;
        synopsisSearchTerm = null;
    }

    public String getTitleSearchTerm() {
        return titleSearchTerm;
    }

    public void setTitleSearchTerm(String titleSearchTerm) {
        this.titleSearchTerm = titleSearchTerm;
    }

    public Integer getDurationMinSearchTerm() {
        return durationMinSearchTerm;
    }

    public void setDurationMinSearchTerm(Integer durationMinSearchTerm) {
        this.durationMinSearchTerm = durationMinSearchTerm;
    }

    public Integer getDurationMaxSearchTerm() {
        return durationMaxSearchTerm;
    }

    public void setDurationMaxSearchTerm(Integer durationMaxSearchTerm) {
        this.durationMaxSearchTerm = durationMaxSearchTerm;
    }

    public Integer getSeasonSearchTerm() {
        return seasonSearchTerm;
    }

    public void setSeasonSearchTerm(Integer seasonSearchTerm) {
        this.seasonSearchTerm = seasonSearchTerm;
    }

    public Integer getEpisodeSearchTerm() {
        return episodeSearchTerm;
    }

    public void setEpisodeSearchTerm(Integer episodeSearchTerm) {
        this.episodeSearchTerm = episodeSearchTerm;
    }

    public String getSynopsisSearchTerm() {
        return synopsisSearchTerm;
    }

    public void setSynopsisSearchTerm(String synopsisSearchTerm) {
        this.synopsisSearchTerm = synopsisSearchTerm;
    }
}
