package org.proway.controller.user;

import org.proway.model.user.User;

import java.util.Scanner;

public class Signing {
    private String name;
    private String email;
    private String password;
    private boolean isAdm;

    Scanner scanner = new Scanner(System.in);

    public Signing(){
        createAccount();
    }

    public Signing(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        createAccount();
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

    private boolean getAdm() {
        return this.isAdm;
    }

    private void setAdm() {
        this.isAdm = true;
    }

    public void createAccount() {
        try{
            System.out.println("========================================");
            System.out.println("Signing");
            System.out.println("========================================");
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            System.out.println("Enter your email:");
            String email = scanner.nextLine();
            if(checkEmail(email)) throw new Error();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();
            setName(name);
            setEmail(email);
            setPassword(password);
            if (checkIfIsAdm(email)) setAdm();
            new User(getName(), getPassword(), getEmail(), getAdm());
            new Login();
        } catch (Error e) {
            System.out.println("Email already exists");
        }
    }
    private boolean checkEmail(String email) {
        User u = User.getUserByEmail(email);
        return u != null;
    }

    private boolean checkIfIsAdm(String email) {
        String domain = email.split("[@.]")[1];
        return domain.equals("adm");
    }
}
