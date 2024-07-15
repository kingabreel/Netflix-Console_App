package org.proway.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.proway.config.database.MongoDbConnection;
import org.proway.model.media.Media;
import org.proway.model.media.Movie;
import org.proway.model.media.Series;

import java.util.ArrayList;
import java.util.List;

public class MongoRepository {
    private MongoDatabase database;

    public MongoRepository(){
        database = MongoDbConnection.getInstance().getDatabase();
    }

    public void addMovie(Movie movie) {
        Document q = new Document("name", movie.getName());

        if (!database.getCollection("Movies").find(q).iterator().hasNext()){
            Document doc = new Document("name", movie.getName())
                    .append("synopsis", movie.getSynopsis())
                    .append("casting", movie.getCasting())
                    .append("genre", movie.getGenre())
                    .append("imdb", movie.getImdb())
                    .append("release", movie.getReleaseDate())
                    .append("duration", movie.getDurationMinutes());

            database.getCollection("Movies").insertOne(doc);
        }
    }

    public void addSerie(Series serie) {
        Document q = new Document("name", serie.getName());

        if (!database.getCollection("Movies").find(q).iterator().hasNext()){
            Document doc = new Document("name", serie.getName())
                    .append("synopsis", serie.getSynopsis())
                    .append("casting", serie.getCasting())
                    .append("genre", serie.getGenre())
                    .append("imdb", serie.getImdb())
                    .append("release", serie.getReleaseDate())
                    .append("duration", serie.getAverageDurationEpisode());

            database.getCollection("Series").insertOne(doc);
        }
    }

    public List<Movie> getMovie(){
        List<Movie> movies = new ArrayList<>();
        MongoCollection<Document> collection = database.getCollection("Movies");
        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            ArrayList<String> casting = new ArrayList<>(doc.getList("casting", String.class));

            Movie movie = new Movie(doc.getString("name"), doc.getString("sinopsys"), casting, doc.getString("genre"), doc.getDouble("imdb"), doc.getString("releaseDate"));
            movie.setDurationMinutes(doc.getInteger("duration"));

            movies.add(movie);
        }

        return movies;
    }

    public List<Series> getSeries(){
        List<Series> series = new ArrayList<>();
        MongoCollection<Document> collection = database.getCollection("Series");
        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            ArrayList<String> casting = new ArrayList<>(doc.getList("casting", String.class));

            Series serie = new Series(doc.getString("name"), doc.getString("synopsis"), casting, doc.getString("genre"), doc.getDouble("imdb"), doc.getString("releaseDate"));
            serie.setAverageDurationEpisode(doc.getInteger("duration"));
            series.add(serie);
        }

        return series;
    }

    public List<Media> getAllMedia(){
        List<Media> media = new ArrayList<>();

        media.addAll(getMovie());
        media.addAll(getSeries());

        return media;
    }

    public void removeSerie(String serie){
        Document q = new Document("name", serie);

        if (database.getCollection("Series").find(q).iterator().hasNext()) {
            database.getCollection("Series").deleteOne(q);
            System.out.println("Deleted");
        } else {
            System.out.println("Not found");
        }
    }

    public void removeMovie(String movie){
        Document q = new Document("name", movie);

        if (database.getCollection("Series").find(q).iterator().hasNext()) {
            database.getCollection("Series").deleteOne(q);
            System.out.println("Deleted");
        } else {
            System.out.println("Not found");
        }
    }
}
