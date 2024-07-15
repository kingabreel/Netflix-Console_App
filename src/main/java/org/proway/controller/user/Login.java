package org.proway.controller.user;

import org.proway.model.user.User;

import java.util.Objects;
import java.util.Scanner;

public class Login {
    private String name;
    private String email;
    private String password;
    private boolean isAdm;

    Scanner scanner = new Scanner(System.in);

    public Login(){
        makeLogin();
    }

    public Login(User user) {

    }

    public Login(String name, String email, String password, boolean isAdm) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdm = isAdm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdm() {
        return isAdm;
    }

    private void setAdm() {
        isAdm = true;
    }

    public void makeLogin() {
        try {
            System.out.println("========================================");
            System.out.println("Login");
            System.out.println("========================================");
            System.out.println("Enter your email:");
            String email = scanner.nextLine();
            User user = getUser(email);
            System.out.println("Enter your password:");
            String password = scanner.nextLine();
            if (user == null || !Objects.equals(password, user.getPassword())) throw new Error();
            makeSets(user);
        } catch (Error e) {
            System.out.println("Invalid email or password");
            makeLogin();
        }
    }

    private void makeSets(User user) {
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        if (checkIfIsAdm(user.getEmail())) setAdm();
    }

    private User getUser(String email) {
        return User.getUserByEmail(email);
    }

    private boolean checkIfIsAdm(String email) {
        String domain = email.split("[@.]")[1];
        return domain.equals("adm");
    }
}
