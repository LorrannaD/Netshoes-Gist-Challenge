package br.com.netshoesgistchallenge.data.network

import br.com.netshoesgistchallenge.entities.HelloWorldRb
import com.google.gson.annotations.SerializedName
import java.io.Serializable


public class HelloWorldRbResponse : Serializable {

    @SerializedName("filename")
    var filename: String? = null

    @SerializedName("type")
    var type: String? = null

    @SerializedName("language")
    var language: String? = null

    @SerializedName("raw_url")
    var rawUrl: String? = null

    @SerializedName("size")
    var size: Int? = null


    fun toHelloWorldRb(): HelloWorldRb {
        return HelloWorldRb(this.filename, this.type, this.language, this.rawUrl, this.size)
    }
}