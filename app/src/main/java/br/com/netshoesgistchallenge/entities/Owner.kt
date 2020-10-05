package br.com.netshoesgistchallenge.entities

import java.io.Serializable

class Owner : Serializable{

    var login: String? = null
    var id: Int? = null
    var nodeId: String? = null
    var avatarUrl: String? = null
    var gravatarId: String? = null
    var url: String? = null
    var htmlUrl: String? = null
    var followersUrl: String? = null
    var followingUrl: String? = null
    var gistsUrl: String? = null
    var starredUrl: String? = null
    var subscriptionsUrl: String? = null
    var organizationsUrl: String? = null
    var reposUrl: String? = null
    var eventsUrl: String? = null
    var receivedEventsUrl: String? = null
    var type: String? = null
    var siteAdmin: Boolean? = null


    constructor(
        login: String?,
        id: Int?,
        nodeId: String?,
        avatarUrl: String?,
        gravatarId: String?,
        url: String?,
        htmlUrl: String?,
        followingUrl: String?,
        gistsUrl: String?,
        starredUrl: String?,
        subscriptionsUrl: String?,
        organizationsUrl: String?,
        reposUrl: String?,
        eventsUrl: String?,
        receivedEventsUrl: String?,
        type: String?,
        siteAdmin: Boolean?
    ) {
        this.login = login
        this.id = id
        this.nodeId = nodeId
        this.avatarUrl = avatarUrl
        this.gravatarId = gravatarId
        this.url = url
        this.htmlUrl = htmlUrl
        this.followingUrl = followingUrl
        this.gistsUrl = gistsUrl
        this.starredUrl = starredUrl
        this.subscriptionsUrl = subscriptionsUrl
        this.organizationsUrl = organizationsUrl
        this.reposUrl = reposUrl
        this.eventsUrl = eventsUrl
        this.receivedEventsUrl = receivedEventsUrl
        this.type = type
        this.siteAdmin = siteAdmin
    }

    constructor()
}