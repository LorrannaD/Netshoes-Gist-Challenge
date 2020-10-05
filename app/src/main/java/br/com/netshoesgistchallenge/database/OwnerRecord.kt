package br.com.netshoesgistchallenge.database

import br.com.netshoesgistchallenge.entities.Owner
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable


@DatabaseTable(tableName = "owner")
class OwnerRecord {

    @DatabaseField(generatedId = true)
    var id: Int = 0

    @DatabaseField
    var login: String? = null

    @DatabaseField
    var  idOwner: Int? = null

    @DatabaseField
    var avatarUrl: String? = null

    @DatabaseField
    var htmlUrl : String? = null

    constructor()

    constructor(
        login: String?,
        idOwner: Int?,
        avatarUrl: String?,
        htmlUrl: String?
    ) {
        this.login = login
        this.idOwner = idOwner
        this.avatarUrl = avatarUrl
        this.htmlUrl =  htmlUrl
    }

    fun toOwner(): Owner {
        var item = Owner()
        item.login = login
        item.id = idOwner
        item.avatarUrl = avatarUrl
        item.htmlUrl = htmlUrl

        return item
    }
}