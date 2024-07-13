package org.proway.model.media;

import java.util.ArrayList;

public interface HistoryList {
    boolean addMediaToHistory(Media media);
    boolean removeMediaFromHistory(Media media);
    ArrayList<Media> listHistory();
}
