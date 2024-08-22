package com.example.study06

data class Person3(var id:Int, var name:String, var phone:String) {
    constructor(name: String, phone: String): this(0, name, phone)
}