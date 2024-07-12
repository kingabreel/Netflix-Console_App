package org.proway.controller;

import org.proway.model.midia.Movie;

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
        this.min = 94;

        midia = (T) new Movie("Batman", "A man with fear", new ArrayList<>(Arrays.asList("Bruce", "Megan")), "Fiction", 6.3, "30-10-2005");
    }

    public void startPlayer() {
        if (midia != null){
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