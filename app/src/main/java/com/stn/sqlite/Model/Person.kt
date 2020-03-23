package com.stn.sqlite.Model

import java.util.UUID

class Person {
    var id: String? = null
    var name: String? = null
    var age: Int = 0
    var gender: String? = null
    var memo: String? = null

    constructor(){}

    constructor(name:String, age:Int, gender:String, meme:String){
        this.id = UUID.randomUUID().toString()
        this.name = name
        this.age = age
        this.gender = gender
        this.memo = memo
    }

    constructor(id:String, name:String, age:Int, gender:String, meme:String){
        this.id = id
        this.name = name
        this.age = age
        this.gender = gender
        this.memo = memo
    }
}


