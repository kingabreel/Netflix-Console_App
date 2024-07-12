package org.proway.model.media;

import org.proway.model.user.User;

import java.time.LocalDateTime;

public class Comment {
    private User user;
    private String content;
    private LocalDateTime date;
    private Media media;

    public Comment(User user, String content, LocalDateTime date, Media media) {
        this.user = user;
        this.content = content;
        this.date = date;
        this.media = media;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}