package org.proway.view;

import org.proway.controller.Player;
import org.proway.model.media.Comment;
import org.proway.model.media.Media;
import org.proway.model.media.Movie;
import org.proway.model.user.User;

import java.time.LocalDateTime;
import java.util.Scanner;

public class CatalogView {
    private final Scanner scanner;
    private final Player player;
    private User currentUser;

    public CatalogView(Scanner scanner, User currentUser) {
        this.scanner = scanner;
        this.player = new Player<>();
        this.currentUser = currentUser;
    }

    public void watch(Media media) {
        System.out.println("Movie configuration: ");
        configureMovie(media);
        this.player.setMidia(media);
        this.player.startPlayer();
    }

    public void configureMovie(Media media) {
        boolean configurating = true;

        while (configurating) {
            System.out.println("""
                    1- Language
                    2- Subtitles
                    3- Video speed
                    4- Video quality
                    5- Watch
                    6- Add to my list
                    """);

            int userChoice = scanner.nextInt();

            while (validateLoop(userChoice, 6)) {
                System.out.println("Invalid option, try again: ");
                userChoice = scanner.nextInt();
            }

            switch (userChoice) {
                case 1 -> player.setLanguage(languageConfig());
                case 2 -> player.setSubtitle(languageConfig());
                case 3 -> {
                    System.out.println("""
                            1- 1x speed (default)
                            2- 1.5x speed
                            3- 2x speed
                            """);

                    int choice = scanner.nextInt();

                    while (validateLoop(choice, 3)) {
                        System.out.println("Invalid choice, try again:");
                        choice = scanner.nextInt();
                    }

                    player.setVideoSpeed(choice);
                }
                case 4 -> {
                    System.out.println("""
                            1- 144p
                            2- 240p
                            3- 360p
                            4- 480p
                            5- 720p
                            6- 1024p
                            7- 2K
                            8- 4K
                            """);

                    int choice = scanner.nextInt();

                    while (validateLoop(choice, 8)) {
                        System.out.println("Invalid choice, try again:");
                        choice = scanner.nextInt();
                    }

                    player.setQuality(choice == 1 ? "144p" : choice == 2 ? "240p" : choice == 3 ? "360p" :
                            choice == 4 ? "480p" : choice == 5 ? "720p" : choice == 6 ? "1024p" :
                                    choice == 7 ? "2K" : "4K");
                }
                case 5 -> {
                    configurating = false;

                    currentUser.addMediaToHistory(media);

                    player.startPlayer();

                    userInfoForMovie(currentUser, media);
                }
                case 6 -> currentUser.addMedia(media);

            }
        }
    }

    public void userInfoForMovie(User user, Media midia) {
        int choice = 0;
        while (validateLoop(choice, 3) && choice != 4) {
            System.out.println("""
                    1- Like
                    2- Unlike
                    3- Comment
                    4- Return
                    """);

            choice = scanner.nextInt();

            if (validateLoop(choice, 4)) {
                System.out.println("Invalid choice, try again");
                continue;
            }

            switch (choice) {
                case 1 -> System.out.println("Liked");
                case 2 -> System.out.println("Unliked");
                case 3 -> {
                    System.out.println("Type your comment:");
                    scanner.nextLine();
                    String commentText = scanner.nextLine();
                    LocalDateTime now = LocalDateTime.now();
                    Comment comment = new Comment(user, commentText, now, midia);
//                    if (user.addCommentToMedia(midia, comment)) {
//                        System.out.println("Comment added successfully.");
//                    } else {
//                        System.out.println("Failed to add comment..");
//                    }
                    user.addCommentToMedia(midia, comment);
                }
                case 4 -> {
                    return;
                }
            }
        }
    }

    private String languageConfig() {
        System.out.println("""
                1- English
                2- Portuguese
                3- German
                """);
        int choice = scanner.nextInt();

        while (validateLoop(choice, 3)) {
            System.out.println("Invalid option");
            choice = scanner.nextInt();
        }

        return choice == 1 ? "English" : choice == 2 ? "Portuguese" : "German";
    }

    private boolean validateLoop(int var, int y) {
        return var < 1 || var > y;
    }

}
