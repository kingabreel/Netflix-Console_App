package org.proway;

import org.proway.config.CreateMoviesAndSeries;
import org.proway.view.MainPageView;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        System.out.println("\t Starting application...");

        // Remove the comment to fill the local database
        // CreateMoviesAndSeries.fillDb();
        try {
            new MainPageView();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}