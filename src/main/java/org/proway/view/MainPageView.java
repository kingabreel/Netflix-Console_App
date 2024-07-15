package org.proway.view;

import org.proway.model.media.Media;
import org.proway.model.user.User;
import org.proway.repository.MongoRepository;

import java.util.ArrayList;
import java.util.Scanner;

import static org.proway.util.Utils.validateLoop;

public class MainPageView {
    private Scanner scanner;
    private final String logo;
    private MongoRepository mongoRepository;

    public MainPageView(){
        this.scanner = new Scanner(System.in);
        this.logo = "\uD83C\uDDF3\u200C\uD83C\uDDEA\u200C\uD83C\uDDF9\u200C\uD83C\uDDEB\u200C\uD83C\uDDF1\u200C\uD83C\uDDEE\u200C\uD83C\uDDFD\u200C";
        mongoRepository = new MongoRepository();
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

        while(validateLoop(userChoice, 0, 2)){
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
        System.out.println("====Login====");
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.println();
        User user = mongoRepository.login(email, password);
        if (user != null) {
            DashboardView dv = new DashboardView(scanner, user);
            dv.dashboardMenu();
        }
        else System.out.println("Invalid user");
    }

    private void createAccount(){
        System.out.println("====New account====");
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = new User(username, password, email, "comum", true, false);
        mongoRepository.addUser(user);

        login();
    }

}
