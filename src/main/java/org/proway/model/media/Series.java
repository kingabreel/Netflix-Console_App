package org.proway.model.media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Series extends Media {

    private int totalSeason;
    private int totalEpisodes;
    private int totalSeriesDuration;
    private int averageDurationEpisode;
    private Map<Integer, List<Episode>> seasons;

    public Series(String name, String synopsis, ArrayList<String> casting, double imdb, String releaseDate, Genre mediaGenre, Map<Integer, List<Episode>> seasons) {
        super(name, synopsis, casting, imdb, releaseDate, mediaGenre);
        this.totalSeriesDuration = 0;
        this.totalSeason = 0;
        this.totalEpisodes = 0;
        this.averageDurationEpisode = 0;
        this.seasons = new HashMap<>();
        this.addSeason(seasons);
    }

    public Episode getEpisode(Integer index, Integer season) {
        Episode episode = null;

        for (Map.Entry<Integer, List<Episode>> entry : seasons.entrySet()) {
            if (entry.getKey().equals(season)){
                episode = entry.getValue().get(index);
            }
        }

        return episode;
    }

    public void addSeason(Map<Integer, List<Episode>> season){
        this.seasons.putAll(season);

        for (Map.Entry<Integer, List<Episode>> entry : season.entrySet()) {
            this.totalSeason += 1;
            this.totalEpisodes += entry.getValue().size();
            for (Episode episode : entry.getValue()) {
                this.totalSeriesDuration += episode.getDurationMin();
            }
        }

        this.averageDurationEpisode = this.totalSeriesDuration / this.totalEpisodes;
    }

    public void getSeason(Integer index){
        seasons.get(index);
    }

    public int getTotalSeason() {
        return totalSeason;
    }

    public void setTotalSeason(int totalSeason) {
        this.totalSeason = totalSeason;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public int getAverageDurationEpisode() {
        return averageDurationEpisode;
    }

    public void setAverageDurationEpisode(int averageDurationEpisode) {
        this.averageDurationEpisode = averageDurationEpisode;
    }

    public Map<Integer, List<Episode>> getSeasons() {
        return seasons;
    }

    public void setSeasons(Map<Integer, List<Episode>> seasons) {
        this.seasons = seasons;
    }
}
