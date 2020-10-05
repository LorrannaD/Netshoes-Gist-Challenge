package br.com.netshoesgistchallenge.database

import br.com.netshoesgistchallenge.entities.Gist
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable


@DatabaseTable(tableName = "gist")
class GistRecord {

    @DatabaseField(generatedId = true)
    var id: Int = 0

    @DatabaseField
    var idGist: String? = null

    @DatabaseField
    var isFavorites: Boolean? = null

    @DatabaseField
    var htmlUrl: String? = null

    @DatabaseField
    var description: String? = null

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "owner_id")
    var owner: OwnerRecord? = null

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "file_id")
    var files: FileRecord? = null

    constructor(
        id: String?,
        isFavorites: Boolean?,
        htmlUrl: String?,
        description: String?,
        owner: OwnerRecord?,
        files: FileRecord?
    ) {
        this.idGist = id
        this.isFavorites = isFavorites
        this.htmlUrl = htmlUrl
        this.description = description
        this.owner = owner
        this.files = files
    }

    constructor()

    fun toGist(): Gist {
        var item = Gist()
        item.id = idGist
        item.isFavorites = isFavorites
        item.htmlUrl = htmlUrl
        item.description = description
        item.owner = owner?.toOwner()
        item.files = files?.toFiles()

        return item
    }
}