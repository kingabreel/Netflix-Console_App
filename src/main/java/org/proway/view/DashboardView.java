package org.proway.view;

import org.proway.controller.AdminController;
import org.proway.model.user.User;
import org.proway.repository.MongoRepository;
import org.proway.util.Utils;

import java.util.Scanner;

public class DashboardView {
    private final User user;
    private final Scanner scanner;
    private final CatalogView catalogView;

    public DashboardView(Scanner scanner, User user){
        this.scanner = scanner;
        this.user = user;
        this.catalogView = new CatalogView(scanner);
    }

    public void dashboardMenu() {
        int choice = -1;
        while (choice != 0) {
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
        AdminController ac = new AdminController(new MongoRepository(), scanner);

        switch (choice){
            case 1 -> {
                catalogView.showMedia();

                System.out.println("Please choose an movie id to watch, type 0 to get more movies or type -1 to exit");
                int midiaChoice = scanner.nextInt();

                while (midiaChoice != -1) {
                    if (midiaChoice > 0 && midiaChoice < catalogView.getMedia().size())
                        catalogView.watch(catalogView.getMedia().get(midiaChoice - 1));
                    else if (midiaChoice == 0) {
                        catalogView.nextMediaList();
                        midiaChoice = scanner.nextInt();
                    }
                }
            }
            case 2 -> System.out.println();
            case 3 -> {
                System.out.println("Your list: ");
                user.getMyList().forEach(e -> System.out.println(STR."Name: \{e.getName()}\nImdb: \{e.getImdb()}Genre: \{e.getGenre()}"));
            }
            case 4 -> {
                System.out.println("Watched history: ");
                user.getHistory().forEach(e -> System.out.println("Name: \" + e.getName() + \"\\n\" + \"Imdb: \" + e.getImdb() + \"Genre: \" + e.getGenre()"));
            }
            case 5 -> ac.addMedia();
            case 6 -> ac.removeMovie();
            case 7 -> ac.removeSerie();
            case 0 -> System.out.println();
        }

    }

    private void normalUserRedirect(int choice) {
        switch (choice) {
            case 1 -> {
                catalogView.showMedia();

                System.out.println("Please choose an movie id to watch, type 0 to get more movies or type -1 to exit");
                int midiaChoice = scanner.nextInt();

                while (midiaChoice != -1) {
                    if (midiaChoice > 0 && midiaChoice < catalogView.getMedia().size())
                        catalogView.watch(catalogView.getMedia().get(midiaChoice - 1));
                    else if (midiaChoice == 0) {
                        catalogView.nextMediaList();
                        midiaChoice = scanner.nextInt();
                    }
                }
            }
            case 2 -> System.out.println();
            case 3 -> {
                System.out.println("Your list: ");
                user.getMyList().forEach(e -> {
                    System.out.println("Name: " + e.getName() + "\n" + "Imdb: " + e.getImdb() + "Genre: " + e.getGenre());
                });
            }
            case 4 -> {
                System.out.println("Watched history: ");
                user.getHistory().forEach(e -> System.out.println("Name: \" + e.getName() + \"\\n\" + \"Imdb: \" + e.getImdb() + \"Genre: \" + e.getGenre()"));
            }
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
                    6- Remove movie
                    7- Remove series
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
