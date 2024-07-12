package org.proway.view;

import org.proway.controller.Player;
import org.proway.model.midia.Movie;
import org.proway.model.user.User;

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
            System.out.println("""
                    1- Show catalog
                    2- Search movie or serie
                    3- My list
                    4- History
                    0- Logout""");

            choice = scanner.nextInt();

            while (choice < 0 || choice > 4) {
                System.out.println("Invalid choice");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1 -> new CatalogView(scanner).watch(new Movie("Batman", "aa", new ArrayList<>(), "", 2, ""));
                case 2 -> System.out.println();
                case 3 -> System.out.println();
                case 4 -> System.out.println();
                case 0 -> System.out.println();
            }
        }
    }
}
