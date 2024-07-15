package org.proway.controller;

import org.proway.model.media.Media;

import java.util.ArrayList;

public class MediaController {
    private ArrayList<Media> mediaList = new ArrayList<Media>();

    // addMedia
    public void addMedia(Media media) {
        mediaList.add(media);
    }

    // getMedia
    public Media getMedia(Integer index){
        return mediaList.get(index);
    }

    // updateMedia
    public void updateMedia(Media media, Integer index) {

        mediaList.set(index, media);
    }

    // removeMedia
    public void removeMedia(Integer index) {

        mediaList.remove(index);
    }


}
