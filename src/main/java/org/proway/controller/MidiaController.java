package org.proway.controller;

import org.proway.model.midia.Midia;

import java.util.ArrayList;

public class MidiaController {
    private ArrayList<Midia> midiaList = new ArrayList<Midia>();

    // addMidia
    public void addMidia(Midia midia) {
        midiaList.add(midia);
    }

    // getMidia
    public Midia getMidia(Integer index){
        return midiaList.get(index);
    }

    // updateMidia
    public void updateMidia(Midia midia, Integer index) {

        midiaList.set(index, midia);
    }

    // removeMidia
    public void removeMidia(Integer index) {

        midiaList.remove(index);
    }


}
