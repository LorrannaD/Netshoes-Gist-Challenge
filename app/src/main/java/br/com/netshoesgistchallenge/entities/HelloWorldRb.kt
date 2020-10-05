package br.com.netshoesgistchallenge.entities

import java.io.Serializable

class HelloWorldRb: Serializable {

    var filename: String? = null
    var type: String? = null
    var language: String? = null
    var rawUrl: String? = null
    var size: Int? = null

    constructor()

    constructor(
        filename: String?,
        type: String?,
        language: String?,
        rawUrl: String?,
        size: Int?,

    ) {
        this.filename = filename
        this.type = type
        this.language = language
        this.rawUrl = rawUrl
        this.size = size

    }


}