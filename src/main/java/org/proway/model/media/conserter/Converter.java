package org.proway.model.media.conserter;

import org.bson.Document;
import org.proway.model.media.Media;
import org.proway.model.media.Movie;
import org.proway.model.media.Series;

import java.util.ArrayList;

public class Converter {
    public static Document mediaToDoc(Media media) {
        Document doc = new Document("name", media.getName())
                .append("synopsis", media.getSynopsis())
                .append("casting", media.getCasting())
                .append("genre", media.getGenre())
                .append("imdb", media.getImdb());

        try {
            doc.append("releaseDate", media.getReleaseDate().toString());
        } catch (NullPointerException e){}
        finally {
            doc.append("releaseDate", "2000-01-01");
        }
        if (media instanceof Movie) {
            doc.append("durationMinutes", ((Movie) media).getDurationMinutes());
        } else if (media instanceof Series) {
            doc.append("totalSeason", ((Series) media).getTotalSeason())
                    .append("totalEpisode", ((Series) media).getTotalEpisode())
                    .append("averageDurationEpisode", ((Series) media).getAverageDurationEpisode());
        }

        return doc;
    }

    public static Media docToMedia(Document doc) {
        String name = doc.getString("name");
        String synopsis = doc.getString("synopsis");
        ArrayList<String> casting = (ArrayList<String>) doc.get("casting");
        String genre = doc.getString("genre");
        double imdb = doc.getDouble("imdb");
        String releaseDate = doc.getString("releaseDate");

        if (doc.containsKey("durationMinutes")) {
            int durationMinutes = doc.getInteger("durationMinutes");
            Movie movie = new Movie(name, synopsis, casting, imdb, releaseDate, genre);
            movie.setDurationMinutes(durationMinutes);
            return movie;
        } else {
            int totalSeason = doc.getInteger("totalSeason");
            int totalEpisode = doc.getInteger("totalEpisode");
            int averageDurationEpisode = doc.getInteger("averageDurationEpisode");
            Series series = new Series(name, synopsis, casting, genre, imdb, releaseDate);
            series.setTotalSeason(totalSeason);
            series.setTotalEpisode(totalEpisode);
            series.setAverageDurationEpisode(averageDurationEpisode);
            return new Series(name, synopsis, casting, genre, imdb, releaseDate);
        }
    }

}
