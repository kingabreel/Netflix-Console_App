package org.proway.controller.user;

import org.proway.model.user.User;
import org.proway.repository.MongoRepository;

import java.util.Objects;
import java.util.Scanner;

public class Login {
    private String name;
    private String email;
    private String password;
    private boolean isAdm;
    private MongoRepository mongoRepository;

    Scanner scanner = new Scanner(System.in);

    public Login(){
        mongoRepository = new MongoRepository();
    }

    public Login(User user) {
        mongoRepository = new MongoRepository();
    }

    public Login(String name, String email, String password, boolean isAdm) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdm = isAdm;
        mongoRepository = new MongoRepository();
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

    public User makeLogin() {
        try {
            System.out.println("========================================");
            System.out.println("Login");
            System.out.println("========================================");
            System.out.println("Enter your email:");
            String email = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            User user = mongoRepository.login(email, password);
            if (user == null) throw new Error();
            makeSets(user);
            return user;
        } catch (Error e) {
            System.out.println("Invalid email or password");
            makeLogin();
        }
        return null;
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
