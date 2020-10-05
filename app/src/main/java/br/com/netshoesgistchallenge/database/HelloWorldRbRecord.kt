package br.com.netshoesgistchallenge.database

import br.com.netshoesgistchallenge.entities.HelloWorldRb
import com.google.gson.annotations.SerializedName
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

@DatabaseTable(tableName = "helloworldrb")
class HelloWorldRbRecord {

    @DatabaseField(generatedId = true)
    var id: Int = 0

    @DatabaseField
    var filename: String? = null

    @DatabaseField
    var type: String? = null

    @DatabaseField
    var language: String? = null

    @DatabaseField
    var rawUrl: String? = null

    @DatabaseField
    var size: Int? = null

    constructor()

    constructor(
        filename: String?,
        type: String?,
        language: String?,
        rawUrl: String?,
        size: Int?

    ) {
        this.filename = filename
        this.type = type
        this.language = language
        this.rawUrl = rawUrl
        this.size = size
    }

    fun toHelloWorldRb(): HelloWorldRb {
        var item = HelloWorldRb()
        item.filename = filename
        item.type = type
        item.language = language
        item.rawUrl = rawUrl
        item.size = size

        return item
    }


}