package com.example.study02

// p135 null 안전성(null safe)
fun main() {
    var data:String? = null

    val length = if(data == null) {
        0
    } else {
        data.length
    }
    println("data length : ${length}\n")


    var data2:String? = null
    println("data2 length ${data2?.length ?: 0}") // ?: 엘비스 표현

    var d:String? = "kang"
    println("d = $d : ${d?.length ?: -1}")
    d = null
    println("d = $d : ${d?.length ?: -1}\n")

    println(some("kang"))
    // println(some(null)) // NullPointerException
}

fun some(data:String?) : Int {
    return data!!.length
}