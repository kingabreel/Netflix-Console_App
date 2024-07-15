package org.proway.controller;

import org.proway.model.media.Episode;
import org.proway.model.media.Media;
import org.proway.model.media.Movie;
import org.proway.model.media.Series;
import java.util.ArrayList;
import java.util.Arrays;

public class Player<T> {
    private String quality;
    private double videoSpeed;
    private boolean paused;
    private String language;
    private String subtitle;
    private T midia;
    private final String notFilledBar;
    private final String filledBar;
    private final String play;
    private final String pause;
    private int min;

    public Player() {
        this.quality = "4k";
        this.videoSpeed = 1;
        this.paused = false;
        this.language = "English";
        this.subtitle = "English";
        this.notFilledBar = "░";
        this.filledBar = "▓";
        this.play = "▶";
        this.pause = "⏸";

    }

    public void startPlayer() {
        if (midia != null && min > 10){
            int count = 0;
            while (count <= this.min){
                try {
                    System.out.println(this.pause + "  " + "↻   ⟳ " + (filledBar.repeat(count)) + (notFilledBar.repeat(this.min - count)) + "  " +
                            (count < 60 ? "00:" + (count < 10 ? "0" + count : count) + ":00" : count < 120 ? "01:" + (count - 60 < 10 ? "0" + (count - 60) : (count - 60)) + ":00" : "02:" + (count - 120 < 10 ? "0" + (count - 120) : count - 120) + ":00")
                            + "   " + this.videoSpeed + "x");
                    Thread.sleep(500);
                    System.out.println("\n".repeat(25));
                } catch (InterruptedException e) {}
                count++;
            }
        }
    }

    public T getMidia() {
        return midia;
    }

    public void setMidia(T midia) {
        if (midia instanceof Movie) this.min = ((Movie) midia).getDurationMinutes();
        else if (midia instanceof Episode) this.min = ((Episode) midia).getDurationMin();

        this.midia = midia;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public double getVideoSpeed() {
        return videoSpeed;
    }

    public void setVideoSpeed(double videoSpeed) {
        this.videoSpeed = videoSpeed;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}