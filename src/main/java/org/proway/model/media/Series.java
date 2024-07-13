package org.proway.model.media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Series extends Media {

    private int totalSeason;
    private int totalEpisodes;
    private int averageDurationEpisode;
    private Map<Integer, List<Episode>> seasons;

    public Series(String name, String synopsis, ArrayList<String> casting, String genre, double imdb, String releaseDate) {
        super(name, synopsis, casting, genre, imdb, releaseDate);

        this.seasons = new HashMap<Integer, List<Episode>>();
        totalSeason = 0;
        totalEpisodes = 0;
        averageDurationEpisode = 0;
    }

    public void addEpisode(Episode episode, Integer season) {
        for (Map.Entry<Integer, List<Episode>> entry : seasons.entrySet()) {
            if (entry.getKey().equals(season)){
                entry.getValue().add(episode);
            }
        }

        totalEpisodes += 1;
        // averageDurationEpisode += episode.getDurationMin() / totalEpisodes;
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

        totalSeason += season.size();
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
