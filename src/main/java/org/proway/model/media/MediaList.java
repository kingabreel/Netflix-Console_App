package org.proway.model.media;

import java.util.ArrayList;

public interface MediaList {
    boolean addMedia(Media media);
    boolean removeMedia(Media media);
    ArrayList<Media> listMedia();
}