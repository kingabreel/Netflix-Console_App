package org.proway.view;

import org.proway.model.media.Media;
import org.proway.model.user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPageView {
    private Scanner scanner;
    private final String logo;

    public MainPageView(){
        this.scanner = new Scanner(System.in);
        this.logo = "\uD83C\uDDF3\u200C\uD83C\uDDEA\u200C\uD83C\uDDF9\u200C\uD83C\uDDEB\u200C\uD83C\uDDF1\u200C\uD83C\uDDEE\u200C\uD83C\uDDFD\u200C";

        startAccount();
    }

    private void startAccount(){
        System.out.println("""
                \t  Bem vindo \t
                \t %s \t
               
                \t1- Login \t
                \t2- Sign in\t
                \t0- Exit\t
                """.formatted(logo));

        int userChoice = scanner.nextInt();

        while(userChoice != 1 && userChoice != 2){
            userChoice = scanner.nextInt();
        }
        scanner.nextLine();
        if (userChoice == 1) {
            login();
        } else {
            createAccount();
        }
    }

    private void login(){
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.println();
        // chama funcao para fazer login

        ArrayList<Media> emptyMyList = new ArrayList<>();
        ArrayList<Media> historyList = new ArrayList<>();

        new DashboardView(scanner, new User("username", "password", "email", "comum", true, emptyMyList, historyList, false)).dashboardMenu();

    }

    private void createAccount(){
        System.out.print("Username: ");
        String username = scanner.nextLine();

      /*  while (!validadeUserName(username)) {
            System.out.println("Invalid user name.");
            System.out.print("Username: ");
            username = scanner.nextLine();
        }

        System.out.print("Email: ");
        String email = scanner.nextLine();

        while (!validadeEmail(email)){
            System.out.println("Invalid email");
            email = scanner.nextLine();
        }
        System.out.print("Password: ");
        String password = scanner.nextLine();

        while (!validadePassword(password)){
            System.out.println("Invalid password");
            password = scanner.nextLine();
        }

        User user = new User(username, password, email, "comum", true, false);
        db.addUser(user);
        */
        login();
    }

}
