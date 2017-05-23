package com.tapdevs.myapp.models

import android.databinding.BaseObservable
import android.os.Parcel
import android.os.Parcelable

import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

import android.R.attr.id
import android.R.attr.type

/**
 * Created by  Jan Shair on 08/02/2017.
 */

open class User : RealmObject, Parcelable {

    var login: String? = null
    var avatar_url: String? = null
    var gravatar_id: String? = null
    var url: String? = null
    var html_url: String? = null
    var followers_url: String? = null
    var following_url: String? = null
    var gists_url: String? = null
    var starred_url: String? = null
    var subscriptions_url: String? = null
    var organizations_url: String? = null
    var repos_url: String? = null
    var events_url: String? = null
    var received_events_url: String? = null
    var type: String? = null
    var site_admin: String? = null

    @PrimaryKey var id: String? = null

    constructor() {

    }

    protected constructor(`in`: Parcel) {
        login = `in`.readString()
        id = `in`.readString()
        avatar_url = `in`.readString()
        gravatar_id = `in`.readString()
        url = `in`.readString()
        html_url = `in`.readString()
        followers_url = `in`.readString()
        following_url = `in`.readString()
        gists_url = `in`.readString()
        starred_url = `in`.readString()
        subscriptions_url = `in`.readString()
        organizations_url = `in`.readString()
        repos_url = `in`.readString()
        events_url = `in`.readString()
        received_events_url = `in`.readString()
        type = `in`.readString()
        site_admin = `in`.readString()
    }


    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is User) return false

        val user = o

        if (if (login != null) login != user.login else user.login != null)
            return false
        if (if (id != null) id != user.id else user.id != null) return false
        if (if (avatar_url != null) avatar_url != user.avatar_url else user.avatar_url != null)
            return false
        if (if (gravatar_id != null) gravatar_id != user.gravatar_id else user.gravatar_id != null)
            return false
        if (if (url != null) url != user.url else user.url != null)
            return false
        if (if (html_url != null) html_url != user.html_url else user.html_url != null)
            return false
        if (if (followers_url != null) followers_url != user.followers_url else user.followers_url != null)
            return false
        if (if (following_url != null) following_url != user.following_url else user.following_url != null)
            return false
        if (if (gists_url != null) gists_url != user.gists_url else user.gists_url != null)
            return false
        if (if (starred_url != null) starred_url != user.starred_url else user.starred_url != null)
            return false
        if (if (subscriptions_url != null) subscriptions_url != user.subscriptions_url else user.subscriptions_url != null)
            return false
        if (if (organizations_url != null) organizations_url != user.organizations_url else user.organizations_url != null)
            return false
        if (if (repos_url != null) repos_url != user.repos_url else user.repos_url != null)
            return false
        if (if (events_url != null) events_url != user.events_url else user.events_url != null)
            return false
        if (if (received_events_url != null) received_events_url != user.received_events_url else user.received_events_url != null)
            return false
        if (if (type != null) type != user.type else user.type != null)
            return false
        return if (site_admin != null) site_admin == user.site_admin else user.site_admin == null

    }

    override fun hashCode(): Int {
        var result = if (login != null) login!!.hashCode() else 0
        result = 31 * result + if (id != null) id!!.hashCode() else 0
        result = 31 * result + if (avatar_url != null) avatar_url!!.hashCode() else 0
        result = 31 * result + if (gravatar_id != null) gravatar_id!!.hashCode() else 0
        result = 31 * result + if (url != null) url!!.hashCode() else 0
        result = 31 * result + if (html_url != null) html_url!!.hashCode() else 0
        result = 31 * result + if (followers_url != null) followers_url!!.hashCode() else 0
        result = 31 * result + if (following_url != null) following_url!!.hashCode() else 0
        result = 31 * result + if (gists_url != null) gists_url!!.hashCode() else 0
        result = 31 * result + if (starred_url != null) starred_url!!.hashCode() else 0
        result = 31 * result + if (subscriptions_url != null) subscriptions_url!!.hashCode() else 0
        result = 31 * result + if (organizations_url != null) organizations_url!!.hashCode() else 0
        result = 31 * result + if (repos_url != null) repos_url!!.hashCode() else 0
        result = 31 * result + if (events_url != null) events_url!!.hashCode() else 0
        result = 31 * result + if (received_events_url != null) received_events_url!!.hashCode() else 0
        result = 31 * result + if (type != null) type!!.hashCode() else 0
        result = 31 * result + if (site_admin != null) site_admin!!.hashCode() else 0
        return result
    }


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(login)
        parcel.writeString(id)
        parcel.writeString(avatar_url)
        parcel.writeString(gravatar_id)
        parcel.writeString(url)
        parcel.writeString(html_url)
        parcel.writeString(followers_url)
        parcel.writeString(following_url)
        parcel.writeString(gists_url)
        parcel.writeString(starred_url)
        parcel.writeString(subscriptions_url)
        parcel.writeString(organizations_url)
        parcel.writeString(repos_url)
        parcel.writeString(events_url)
        parcel.writeString(received_events_url)
        parcel.writeString(type)
        parcel.writeString(site_admin)
    }


}
