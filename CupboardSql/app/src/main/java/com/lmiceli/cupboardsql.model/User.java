package com.lmiceli.cupboardsql.model;

import nl.qbusict.cupboard.annotation.Column;
import nl.qbusict.cupboard.annotation.Ignore;

/**
 * Created by lmiceli on 20/04/2016.
 */
public class User extends Entity{

    private String userName;
    @Column("pic") // I want to set specific column name
    private String profilePictureUrl;
    @Ignore // this value is not persistent (like transient bu avoids conflicts with other serializations)
    private Boolean modified;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}
