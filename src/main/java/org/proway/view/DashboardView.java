package org.proway.view;

import org.proway.controller.AdminController;
import org.proway.model.media.Movie;
import org.proway.model.user.User;
import org.proway.util.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class DashboardView {
    private final User user;
    private final Scanner scanner;

    public DashboardView(Scanner scanner, User user){
        this.scanner = scanner;
        this.user = user;
    }

    public void dashboardMenu() {
        int choice = -1;
        while (choice < 0 || choice > 4) {
            printMenu();
            choice = scanner.nextInt();

            while (user.isAdm() ? Utils.validateLoop(choice, 0, 4) : Utils.validateLoop(choice, 0, 7)) {
                System.out.println("Invalid choice");
                choice = scanner.nextInt();
            }

            if (user.isAdm()) adminRedirect(choice);
            else normalUserRedirect(choice);
        }
    }

    private void adminRedirect(int choice) {
        AdminController ac = new AdminController();
        switch (choice){
            case 1 -> new CatalogView(scanner).watch(new Movie("Batman", "aa", new ArrayList<>(), "", 2, ""));
            case 2 -> System.out.println();
            case 3 -> System.out.println();
            case 4 -> System.out.println();
            case 5 -> ac.addMedia(new Movie("","", new ArrayList<>(), "", 2, ""));
            case 6 -> ac.removeMedia(new Movie("","", new ArrayList<>(), "", 2, ""));
            case 7 -> ac.removeMedia(new Movie("","", new ArrayList<>(), "", 2, ""));
            case 0 -> System.out.println();
        }

    }

    private void normalUserRedirect(int choice) {
        switch (choice) {
            case 1 -> new CatalogView(scanner).watch(new Movie("Batman", "aa", new ArrayList<>(), "", 2, ""));
            case 2 -> System.out.println();
            case 3 -> System.out.println();
            case 4 -> System.out.println();
            case 0 -> System.out.println();
        }
    }

    private void printMenu(){
        if (user.isAdm()){
            System.out.println("""
                    1- Show catalog
                    2- Search movie or serie
                    3- My list
                    4- History
                    ==== Admin Options ======
                    5- Insert movie/series to the catalog
                    6- Update movie/series
                    7- Remove movie/series
                    0- Logout
                    """);
        } else {
            System.out.println("""
                    1- Show catalog
                    2- Search movie or serie
                    3- My list
                    4- History
                    0- Logout
                    """);
        }
    }
}
