package org.proway.controller;

import java.util.ArrayList;

public class NetflixSystem {
    private ArrayList<String> catalog;

    public NetflixSystem() {
        catalog = new ArrayList<>();
    }

    public ArrayList<String> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<String> catalog) {
        this.catalog = catalog;
    }
}
