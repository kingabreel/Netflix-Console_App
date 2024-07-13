package org.proway.model.media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public abstract class Media {
    private String name;
    private String synopsis;
    private ArrayList<String> casting;
    private String genre;
    private double imdb;
    private LocalDate releaseDate;

    public Media(String name, String synopsis, ArrayList<String> casting, String genre, double imdb, String releaseDate) {
        this.name = name;
        this.synopsis = synopsis;
        this.casting = casting;
        this.genre = genre;
        this.imdb = imdb;
        this.releaseDate = LocalDate.parse(releaseDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public ArrayList<String> getCasting() {
        return casting;
    }

    public void setCasting(ArrayList<String> casting) {
        this.casting = casting;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
