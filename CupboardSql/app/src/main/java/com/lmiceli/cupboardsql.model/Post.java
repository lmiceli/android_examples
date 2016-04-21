package com.lmiceli.cupboardsql.model;

/**
 * Created by lmiceli on 20/04/2016.
 */
public class Post extends Entity{
    private User user;
    private String text;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
