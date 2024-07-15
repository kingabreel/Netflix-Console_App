package org.proway.model.user;

import org.proway.model.media.Comment;
import org.proway.model.media.HistoryList;
import org.proway.model.media.Media;
import org.proway.model.media.MediaList;
import org.proway.util.annotations.Doc;

import java.util.ArrayList;

public class User implements MediaList, HistoryList {
    private String name;
    private String password;
    private String email;
    // plan payment
    private String plan;
    private boolean active;
    private ArrayList<Media> myList;
    private ArrayList<Media> history;
    private boolean adm;
    private static ArrayList<User> userBasicInfo = new ArrayList<>();

    public User() {}

    public User(String name, String password, String email, String plan, boolean active, boolean adm) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.plan = plan;
        this.active = active;
        this.myList = new ArrayList<>();
        this.history = new ArrayList<>();
        this.adm = adm;
        userBasicInfo.add(this);
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

    public ArrayList<Media> getMyList() {
        return myList;
    }

    public void setMyList(ArrayList<Media> myList) {
        this.myList = myList;
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

    @Override
    public String toString() {
        return "name='" + name + '\'';
    }

    @Doc(author = "Caique Bezerra", date = "12/07/2024", version = "1.0", description = "Add a media to the user list")
    @Override
    public boolean addMedia(Media media) {
        if (!myList.contains(media)) {
            myList.add(media);
            return true;
        }
        return false;
    }

    @Doc(author = "Caique Bezerra", date = "12/07/2024", version = "1.0", description = "Remove a media from the user list")
    @Override
    public boolean removeMedia(Media media) {
        return myList.remove(media);
    }

    @Doc(author = "Caique Bezerra", date = "12/07/2024", version = "1.0", description = "List all media from the user list")
    @Override
    public ArrayList<Media> listMedia() {
        if(myList.isEmpty()){
            System.out.println("Empty list\n");
        } else {
            myList.forEach(System.out::println);
        }

        return myList;
    }

    @Doc(author = "Caique Bezerra", date = "12/07/2024", version = "1.0", description = "Add a comment to a media from the user list")
    public boolean addCommentToMedia(Media media, Comment comment) {
        if (myList.contains(media) || history.contains(media)) {
            return media.addComment(comment);
        }
        return false;
    }

    @Doc(author = "Caique Bezerra", date = "12/07/2024", version = "1.0", description = "List all comments from a media from the user list")
    public ArrayList<Comment> listComments(Media media) {
        if (myList.contains(media) || history.contains(media)) {
            return media.getComments();
        }
        return new ArrayList<>();
    }

    @Doc(author = "Caique Bezerra", date = "13/07/2024", version = "1.0", description = "Add a media to the user history")
    @Override
    public boolean addMediaToHistory(Media media) {
        if (!history.contains(media)) {
            history.add(media);
            return true;
        }
        return false;
    }

    @Doc(author = "Caique Bezerra", date = "13/07/2024", version = "1.0", description = "Remove a media from the user history")
    @Override
    public boolean removeMediaFromHistory(Media media) {
        return history.remove(media);
    }

    @Doc(author = "Caique Bezerra", date = "13/07/2024", version = "1.0", description = "List all media from the user history")
    @Override
    public ArrayList<Media> listHistory() {
        if(history.isEmpty()){
            System.out.println("Empty history\n");
        } else {
            history.forEach(System.out::println);
        }
        return history;

    }
}
