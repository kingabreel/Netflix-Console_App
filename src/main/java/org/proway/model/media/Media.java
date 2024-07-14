package org.proway.model.media;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public abstract class Media {
    protected String name;
    protected String synopsis;
    protected ArrayList<String> casting;
    protected double imdb;
    protected LocalDate releaseDate;
    protected Genre mediaGenre;

    public Media(String name, String synopsis, ArrayList<String> casting, double imdb, String releaseDate, Genre mediaGenre) {
        this.name = name;
        this.synopsis = synopsis;
        this.casting = casting;
        this.imdb = imdb;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.releaseDate = LocalDate.parse(releaseDate, formatter);
        this.mediaGenre = mediaGenre;
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

    public Genre getMediaGenre() {
        return mediaGenre;
    }

    public void setMediaGenre(Genre mediaGenre) {
        this.mediaGenre = mediaGenre;
    }
}
