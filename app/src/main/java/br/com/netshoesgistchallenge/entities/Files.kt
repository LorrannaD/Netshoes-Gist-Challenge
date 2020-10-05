package br.com.netshoesgistchallenge.entities

import java.io.Serializable

class Files : Serializable {

    var helloWorldRb: HelloWorldRb? = null

    constructor()

    constructor(
        helloWorldRb: HelloWorldRb?) {
        this.helloWorldRb = helloWorldRb


    }




}