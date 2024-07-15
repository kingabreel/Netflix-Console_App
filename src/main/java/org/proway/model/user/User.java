package org.proway.model.user;

import org.proway.model.midia.Midia;

import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private String email;
    // plan payment
    private String plan;
    private boolean active;
    private ArrayList<Midia> myList;
    private ArrayList<Midia> history;
    private boolean adm;
    private static ArrayList<User> userBasicInfo = new ArrayList<>();

    public User() {}

    public User(String name, String password, String email, boolean adm) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.adm = adm;
        userBasicInfo.add(this);
    }

    public User(String name, String password, String email, String plan, boolean active, ArrayList<Midia> myList, ArrayList<Midia> history, boolean adm) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.plan = plan;
        this.active = active;
        this.myList = myList;
        this.history = history;
        this.adm = adm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<Midia> getMinhaLista() {
        return myList;
    }

    public void setMinhaLista(ArrayList<Midia> myList) {
        this.myList = myList;
    }

    public ArrayList<Midia> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Midia> history) {
        this.history = history;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    public ArrayList<User> getUserBasicInfo() {
        return userBasicInfo;
    }

    public void setUserBasicInfo(ArrayList<User> userBasicInfo) {
        this.userBasicInfo = userBasicInfo;
    }

    public static User getUserByEmail(String email) {
        User user = null;
        for(User u : userBasicInfo) {
            if (u.getEmail().equals(email)) {
                user = u;
            }
        }
        return user;
    }
}
