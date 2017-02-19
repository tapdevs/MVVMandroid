package com.tapdevs.myapp.models;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

import static android.R.attr.id;
import static android.R.attr.type;

/**
 * Created by  Jan Shair on 08/02/2017.
 */

public class User extends RealmObject implements Parcelable {

    private String login,avatar_url,gravatar_id,url,html_url,followers_url,following_url,gists_url,
            starred_url,subscriptions_url,organizations_url,repos_url,events_url,received_events_url,type,
            site_admin;

    @PrimaryKey String id;

    public User() {

    }

    protected User(Parcel in) {
        login = in.readString();
        id = in.readString();
        avatar_url = in.readString();
        gravatar_id = in.readString();
        url = in.readString();
        html_url = in.readString();
        followers_url = in.readString();
        following_url = in.readString();
        gists_url = in.readString();
        starred_url = in.readString();
        subscriptions_url = in.readString();
        organizations_url = in.readString();
        repos_url = in.readString();
        events_url = in.readString();
        received_events_url = in.readString();
        type = in.readString();
        site_admin = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSite_admin() {
        return site_admin;
    }

    public void setSite_admin(String site_admin) {
        this.site_admin = site_admin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getLogin() != null ? !getLogin().equals(user.getLogin()) : user.getLogin() != null)
            return false;
        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
        if (getAvatar_url() != null ? !getAvatar_url().equals(user.getAvatar_url()) : user.getAvatar_url() != null)
            return false;
        if (getGravatar_id() != null ? !getGravatar_id().equals(user.getGravatar_id()) : user.getGravatar_id() != null)
            return false;
        if (getUrl() != null ? !getUrl().equals(user.getUrl()) : user.getUrl() != null)
            return false;
        if (getHtml_url() != null ? !getHtml_url().equals(user.getHtml_url()) : user.getHtml_url() != null)
            return false;
        if (getFollowers_url() != null ? !getFollowers_url().equals(user.getFollowers_url()) : user.getFollowers_url() != null)
            return false;
        if (getFollowing_url() != null ? !getFollowing_url().equals(user.getFollowing_url()) : user.getFollowing_url() != null)
            return false;
        if (getGists_url() != null ? !getGists_url().equals(user.getGists_url()) : user.getGists_url() != null)
            return false;
        if (getStarred_url() != null ? !getStarred_url().equals(user.getStarred_url()) : user.getStarred_url() != null)
            return false;
        if (getSubscriptions_url() != null ? !getSubscriptions_url().equals(user.getSubscriptions_url()) : user.getSubscriptions_url() != null)
            return false;
        if (getOrganizations_url() != null ? !getOrganizations_url().equals(user.getOrganizations_url()) : user.getOrganizations_url() != null)
            return false;
        if (getRepos_url() != null ? !getRepos_url().equals(user.getRepos_url()) : user.getRepos_url() != null)
            return false;
        if (getEvents_url() != null ? !getEvents_url().equals(user.getEvents_url()) : user.getEvents_url() != null)
            return false;
        if (getReceived_events_url() != null ? !getReceived_events_url().equals(user.getReceived_events_url()) : user.getReceived_events_url() != null)
            return false;
        if (getType() != null ? !getType().equals(user.getType()) : user.getType() != null)
            return false;
        return getSite_admin() != null ? getSite_admin().equals(user.getSite_admin()) : user.getSite_admin() == null;

    }

    @Override
    public int hashCode() {
        int result = getLogin() != null ? getLogin().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getAvatar_url() != null ? getAvatar_url().hashCode() : 0);
        result = 31 * result + (getGravatar_id() != null ? getGravatar_id().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        result = 31 * result + (getHtml_url() != null ? getHtml_url().hashCode() : 0);
        result = 31 * result + (getFollowers_url() != null ? getFollowers_url().hashCode() : 0);
        result = 31 * result + (getFollowing_url() != null ? getFollowing_url().hashCode() : 0);
        result = 31 * result + (getGists_url() != null ? getGists_url().hashCode() : 0);
        result = 31 * result + (getStarred_url() != null ? getStarred_url().hashCode() : 0);
        result = 31 * result + (getSubscriptions_url() != null ? getSubscriptions_url().hashCode() : 0);
        result = 31 * result + (getOrganizations_url() != null ? getOrganizations_url().hashCode() : 0);
        result = 31 * result + (getRepos_url() != null ? getRepos_url().hashCode() : 0);
        result = 31 * result + (getEvents_url() != null ? getEvents_url().hashCode() : 0);
        result = 31 * result + (getReceived_events_url() != null ? getReceived_events_url().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getSite_admin() != null ? getSite_admin().hashCode() : 0);
        return result;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(login);
        parcel.writeString(id);
        parcel.writeString(avatar_url);
        parcel.writeString(gravatar_id);
        parcel.writeString(url);
        parcel.writeString(html_url);
        parcel.writeString(followers_url);
        parcel.writeString(following_url);
        parcel.writeString(gists_url);
        parcel.writeString(starred_url);
        parcel.writeString(subscriptions_url);
        parcel.writeString(organizations_url);
        parcel.writeString(repos_url);
        parcel.writeString(events_url);
        parcel.writeString(received_events_url);
        parcel.writeString(type);
        parcel.writeString(site_admin);
    }
}
