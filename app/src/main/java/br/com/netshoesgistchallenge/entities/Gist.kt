package br.com.netshoesgistchallenge.entities

import java.io.Serializable

class Gist : Serializable{

    var url: String? = null
    var forksUrl: String? = null
    var commitsUrl: String? = null
    var id: String? = null
    var nodeId: String? = null
    var gitPullUrl: String? = null
    var gitPushUrl: String? = null
    var htmlUrl: String? = null
    var files: Files? = null
    var _public: Boolean? = null
    var createdAt: String? = null
    var updatedAt: String? = null
    var description: String? = null
    var comments: Int? = null
    var user: Any? = null
    var commentsUrl: String? = null
    var owner: Owner? = null
    var truncated: Boolean? = null

    var isFavorites: Boolean? = null
    var file: Files? = null

    constructor()

    constructor(
        url: String?,
        forksUrl: String?,
        commitsUrl: String?,
        id: String?,
        nodeId: String?,
        gitPullUrl: String?,
        gitPushUrl: String?,
        htmlUrl: String?,
        files: Files?,
        _public: Boolean?,
        createdAt: String?,
        updatedAt: String?,
        description: String?,
        comments: Int?,
        user: Any?,
        commentsUrl: String?,
        owner: Owner?,
        truncated: Boolean?,
        file: Files
    ) {
        this.url = url
        this.forksUrl = forksUrl
        this.commitsUrl = commitsUrl
        this.id = id
        this.nodeId = nodeId
        this.gitPullUrl = gitPullUrl
        this.gitPushUrl = gitPushUrl
        this.htmlUrl = htmlUrl
        this.files = files
        this._public = _public
        this.createdAt = createdAt
        this.updatedAt = updatedAt
        this.description = description
        this.comments = comments
        this.user = user
        this.commentsUrl = commentsUrl
        this.owner = owner
        this.truncated = truncated
        this.file = file
    }
}