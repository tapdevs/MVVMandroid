package com.tapdevs.myapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerInfo {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("balance")
    @Expose
    private Integer balance;

    @SerializedName("avatarLink")
    @Expose
    private String avatarLink;

    @SerializedName("lastLogindate")
    @Expose
    private String lastLogindate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    public String getLastLogindate() {
        return lastLogindate;
    }

    public void setLastLogindate(String lastLogindate) {
        this.lastLogindate = lastLogindate;
    }

}

