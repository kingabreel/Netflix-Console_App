package org.proway.view;

import org.proway.controller.user.Login;
import org.proway.controller.user.Signing;
import org.proway.model.media.Media;
import org.proway.model.user.User;
import org.proway.repository.MongoRepository;

import java.util.ArrayList;
import java.util.Scanner;

import static org.proway.util.Utils.validateLoop;

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
        System.out.println();
        Login login = new Login();
        User user = login.makeLogin();
        if (user != null) {
            DashboardView dv = new DashboardView(scanner, user);
            dv.dashboardMenu();
        }
        else System.out.println("Invalid user");
    }

    private void createAccount(){
        Signing signing = new Signing();
        signing.createAccount();
        login();
    }

}
