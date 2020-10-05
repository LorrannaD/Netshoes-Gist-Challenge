package br.com.netshoesgistchallenge.data.network

import br.com.netshoesgistchallenge.entities.Owner
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class OwnerResponse : Serializable {

    @SerializedName("login")
    val login: String? = null

    @SerializedName("id")
    val id: Int? = null

    @SerializedName("node_id")
    val nodeId: String? = null

    @SerializedName("avatar_url")
    val avatarUrl: String? = null

    @SerializedName("gravatar_id")
    val gravatarId: String? = null

    @SerializedName("url")
    val url: String? = null

    @SerializedName("html_url")
    var htmlUrl: String? = null

    @SerializedName("followers_url")
    val followersUrl: String? = null

    @SerializedName("following_url")
    val followingUrl: String? = null

    @SerializedName("gists_url")
    val gistsUrl: String? = null

    @SerializedName("starred_url")
    val starredUrl: String? = null

    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String? = null

    @SerializedName("organizations_url")
    val organizationsUrl: String? = null

    @SerializedName("repos_url")
    val reposUrl: String? = null

    @SerializedName("events_url")
    val eventsUrl: String? = null

    @SerializedName("received_events_url")
    val receivedEventsUrl: String? = null

    @SerializedName("type")
    val type: String? = null

    @SerializedName("site_admin")
    val siteAdmin: Boolean? = null

    fun toOwner(): Owner {
        return Owner(
            this.login,
            this.id,
            this.nodeId,
            this.avatarUrl,
            this.gravatarId,
            this.avatarUrl,
            this.htmlUrl,
            this.followersUrl,
            this.gistsUrl,
            this.starredUrl,
            this.subscriptionsUrl,
            this.organizationsUrl,
            this.reposUrl,
            this.eventsUrl,
            this.receivedEventsUrl,
            this.type,
            this.siteAdmin
        )
    }

}
