package br.com.netshoesgistchallenge.data.network

import br.com.netshoesgistchallenge.entities.Files
import com.google.gson.annotations.SerializedName
import java.io.Serializable



class FilesResponse : Serializable {

        @SerializedName("hello_world.rb")
        var helloWorldRb: HelloWorldRbResponse? = null


        fun toFiles(): Files {
                return Files(this.helloWorldRb?.toHelloWorldRb())
        }

}