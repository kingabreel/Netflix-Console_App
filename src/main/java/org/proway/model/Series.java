package org.proway.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Series extends Midia{
    private String episodeTitle;
    private int totalSeason;
    private int totalEpisode;
    private int averageDurationEpisode;
    private ArrayList<Episode> episodes;
    private Map<int, List<Episode>> seasons;

    public Series(String name, String synopsis, ArrayList<String> casting, String genre, double imdb, String releaseDate) {
        super(name, synopsis, casting, genre, imdb, releaseDate);
    }

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public void setEpisodeTitle(String episodeTitle) {
        this.episodeTitle = episodeTitle;
    }

    public int getTotalSeason() {
        return totalSeason;
    }

    public void setTotalSeason(int totalSeason) {
        this.totalSeason = totalSeason;
    }

    public int getTotalEpisode() {
        return totalEpisode;
    }

    public void setTotalEpisode(int totalEpisode) {
        this.totalEpisode = totalEpisode;
    }

    public int getAverageDurationEpisode() {
        return averageDurationEpisode;
    }

    public void setAverageDurationEpisode(int averageDurationEpisode) {
        this.averageDurationEpisode = averageDurationEpisode;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }

    public Map<int, List<Episode>> getSeasons() {
        return seasons;
    }

    public void setSeasons(Map<int, List<Episode>> seasons) {
        this.seasons = seasons;
    }
}
