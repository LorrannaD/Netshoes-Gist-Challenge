package br.com.netshoesgistchallenge.database

import br.com.netshoesgistchallenge.entities.Files
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable


@DatabaseTable(tableName = "file")
class FileRecord {

    @DatabaseField(generatedId = true)
    var id: Int = 0

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "helloworldrb_id")
    var helloworldrb: HelloWorldRbRecord? = null

    constructor()

    constructor(helloworldrb: HelloWorldRbRecord?) {
        this.helloworldrb = helloworldrb
    }

    fun toFiles(): Files {
        var item = Files()
        item.helloWorldRb = helloworldrb?.toHelloWorldRb()
        return item
    }

}
