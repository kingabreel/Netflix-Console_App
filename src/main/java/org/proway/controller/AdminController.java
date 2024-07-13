package org.proway.controller;

import org.proway.model.media.Media;

public class AdminController {
    NetflixSystem ns = new NetflixSystem();

    public void addMedia(Media media){
        ns.getCatalog().add(media.getName());
    }

    public void removeMedia(Media media){
        ns.getCatalog().remove(media.getName());
    }

    public void updateMedia(Media media){
        ns.getCatalog().stream()
                .filter(m -> m.equals(media.getName()));
    }
}
