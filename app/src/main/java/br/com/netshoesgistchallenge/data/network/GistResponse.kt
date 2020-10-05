package br.com.netshoesgistchallenge.data.network

import br.com.netshoesgistchallenge.entities.Gist
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class GistResponse : Serializable {

    @SerializedName("url")
    val url: String? = null

    @SerializedName("forks_url")
    val forksUrl: String? = null

    @SerializedName("commits_url")
    val commitsUrl: String? = null

    @SerializedName("id")
    val id: String? = null

    @SerializedName("node_id")
    val nodeId: String? = null

    @SerializedName("git_pull_url")
    val gitPullUrl: String? = null

    @SerializedName("git_push_url")
    val gitPushUrl: String? = null

    @SerializedName("html_url")
    var htmlUrl: String? = null

    @SerializedName("files")
    val files: FilesResponse? = null

    @SerializedName("public")
    val _public: Boolean? = null

    @SerializedName("created_at")
    val createdAt: String? = null

    @SerializedName("updated_at")
    val updatedAt: String? = null

    @SerializedName("description")
    val description: String? = null

    @SerializedName("comments")
    val comments: Int? = null

    @SerializedName("user")
    val user: Any? = null

    @SerializedName("comments_url")
    val commentsUrl: String? = null

    @SerializedName("owner")
    val owner: OwnerResponse? = null

    @SerializedName("truncated")
    val truncated: Boolean? = null

    fun toGist(): Gist {
        return Gist(
            this.url,
            this.forksUrl,
            this.commitsUrl,
            this.id,
            this.nodeId,
            this.gitPullUrl,
            this.gitPushUrl,
            this.htmlUrl,
            this.files?.toFiles(),
            this._public,
            this.createdAt,
            this.updatedAt,
            this.description,
            this.comments,
            this.user,
            this.commentsUrl,
            this.owner?.toOwner(),
            this.truncated,
            this.files?.toFiles()!!
        )
    }

}