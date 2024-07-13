package org.proway.model.user;

import org.proway.model.media.Media;

import java.util.ArrayList;

public class User {
    private String nome;
    private String password;
    private String email;
    // plan payment
    private String plan;
    private boolean active;
    private ArrayList<Media> minhaLista;
    private ArrayList<Media> history;
    private boolean adm;

    public User(String nome, String password, String email, String plan, boolean active, ArrayList<Media> minhaLista, ArrayList<Media> history, boolean adm) {
        this.nome = nome;
        this.password = password;
        this.email = email;
        this.plan = plan;
        this.active = active;
        this.minhaLista = minhaLista;
        this.history = history;
        this.adm = adm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public ArrayList<Media> getMinhaLista() {
        return minhaLista;
    }

    public void setMinhaLista(ArrayList<Media> minhaLista) {
        this.minhaLista = minhaLista;
    }

    public ArrayList<Media> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Media> history) {
        this.history = history;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }
}
