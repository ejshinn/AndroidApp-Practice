package com.example.study02

// p123
// object : 선언과 동시에 객체를 생성(익명 클래스 생성 목적)
open class Parent {
    open var data = 10
    open fun some() {
        println() {
            println("parent data : ${data}")
        }
    }
}
val obj = object : Parent() {
    override  var data = 10
    override fun some() {
        println("data : $data")
    }
}

//var obj1 = object : 객체 유형 선언 {
//    var data1 = 10
//    fun some1() {
//        println("data1 : $data1")
//    }
//}

class MyClass {
    var d = 10
    companion object { // companion object => 자바의 static
        var d1 = 10
        fun some2() {

        }
    }
}

fun main() {
    // 클래스 이름으로 접근
    // MyClass.d // 오류
    MyClass.d1
    MyClass.some2()

    // obj1.data1 = 20 // 오류
    // obj1.some1() // 오류

    obj.data = 20
    obj.some()
}