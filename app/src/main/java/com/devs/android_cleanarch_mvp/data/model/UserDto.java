package com.devs.android_cleanarch_mvp.data.model;

/**
 * Created by Deven on 2019-09-07.
 */

import com.google.gson.annotations.SerializedName;

/**
 * User Entity used in the data layer.
 */
public class UserDto {
    @SerializedName("id")
    private int userId;

    @SerializedName("profile_pic")
    private String coverUrl;

    @SerializedName("full_name")
    private String fullname;

    @SerializedName("description")
    private String description;

    @SerializedName("followers")
    private int followers;

    @SerializedName("email")
    private String email;

    @SerializedName("user_name")
    private String userName;

    @SerializedName("password")
    private String password;

    public UserDto() {
        //empty
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDescription() {
        return description;
    }

    public int getFollowers() {
        return followers;
    }

    public String getEmail() {
        return email;
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
