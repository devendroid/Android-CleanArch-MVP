package com.devs.android_cleanarch_mvp.domain.model;

/**
 * Created by Deven on 2019-09-07.
 */

/**
 * Class that represents a User in the domain layer.
 */
public class User {
    private final int userId;

    public User(int userId) {
        this.userId = userId;
    }

    private String userName;
    private String password;
    private String coverUrl;
    private String fullName;
    private String email;
    private String description;
    private int followers;

    public int getUserId() {
        return userId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
