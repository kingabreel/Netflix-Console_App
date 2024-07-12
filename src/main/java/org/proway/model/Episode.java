package org.proway.model;

public class Episode {
    private String title;
    private int durationMin;
    private int season;
    private int episode;
    private String synopsis;

    public Episode(String title, int durationMin, int season, int episode, String synopsis) {
        this.title = title;
        this.durationMin = durationMin;
        this.season = season;
        this.episode = episode;
        this.synopsis = synopsis;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
