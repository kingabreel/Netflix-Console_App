package org.proway.controller;

import org.proway.model.media.Media;

import java.util.ArrayList;

public class MediaController {
    private ArrayList<Media> mediaList = new ArrayList<Media>();

    // addMidia
    public void addMidia(Media media) {
        mediaList.add(media);
    }

    // getMidia
    public Media getMidia(Integer index){
        return mediaList.get(index);
    }

    // updateMidia
    public void updateMidia(Media media, Integer index) {

        mediaList.set(index, media);
    }

    // removeMidia
    public void removeMidia(Integer index) {

        mediaList.remove(index);
    }


}
