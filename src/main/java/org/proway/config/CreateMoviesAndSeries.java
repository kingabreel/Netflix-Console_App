package org.proway.config;

import org.json.JSONArray;
import org.json.JSONObject;
import org.proway.model.media.Movie;
import org.proway.model.media.Series;
import org.proway.repository.MongoRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CreateMoviesAndSeries {
    private static MongoRepository mongoRepository;
    private static final String MOVIE_API_URL = "https://yts.mx/api/v2/list_movies.json?limit=50";
    private static final String SERIE_API_URL = "https://api.tvmaze.com/shows";

    public static void fillDb(){
        mongoRepository = new MongoRepository();

        ArrayList<Movie> movies = fetchMovies();
        ArrayList<Series> series = fetchSeries();

        for (Movie m : movies) {
            mongoRepository.addMovie(m);
        }

        for (Series s : series) {
            mongoRepository.addSerie(s);
        }
    }

    private static ArrayList<Movie> fetchMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            StringBuilder content = getAllMidia(MOVIE_API_URL);

            JSONObject json = new JSONObject(content.toString());
            JSONArray moviesArray = json.getJSONObject("data").getJSONArray("movies");

            for (int i = 0; i < moviesArray.length(); i++) {
                JSONObject movieJson = moviesArray.getJSONObject(i);
                String name = movieJson.getString("title");
                String synopsis = movieJson.getString("synopsis");
                ArrayList<String> casting = new ArrayList<>();
                String genre = movieJson.getJSONArray("genres").getString(0);
                double imdb = movieJson.getDouble("rating");

                Movie movie = new Movie(name, synopsis, casting, imdb, "01-01-2000", genre);
                movie.setDurationMinutes(movieJson.getInt("runtime"));
                movies.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    private static ArrayList<Series> fetchSeries() {
        ArrayList<Series> seriesList = new ArrayList<>();
        try {
            StringBuilder content = getAllMidia(SERIE_API_URL);

            JSONArray seriesArray = new JSONArray(content.toString());

            for (int i = 0; i < seriesArray.length(); i++) {
                JSONObject seriesJson = seriesArray.getJSONObject(i);
                String name = seriesJson.getString("name");
                String synopsis = seriesJson.getString("summary");
                ArrayList<String> casting = new ArrayList<>();

                JSONArray genreArray = seriesJson.getJSONArray("genres");
                String genre = "";
                if (!genreArray.isEmpty()) genre = genreArray.getString(0);

                JSONObject imdbJson = seriesJson.getJSONObject("rating");
                double imdb = 0;
                if (imdbJson.has("average") && !imdbJson.isNull("average")) {
                    imdb = imdbJson.getDouble("average");
                }

                String releaseDate = seriesJson.getString("premiered");

                Series series = new Series(name, synopsis, casting, genre, imdb, releaseDate);
                series.setAverageDurationEpisode((int) seriesJson.getDouble("averageRuntime"));
                seriesList.add(series);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seriesList;
    }

    private static StringBuilder getAllMidia(String apiURL) throws IOException {
        URL url = new URL(apiURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        conn.disconnect();

        return content;
    }
}
