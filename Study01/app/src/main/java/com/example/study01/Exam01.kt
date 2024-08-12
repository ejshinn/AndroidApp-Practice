package com.example.study01

import java.text.SimpleDateFormat
import java.util.Date

val data1 = 100 // 자바 final
var data2 = 200
val data3:Int = 300
// var data5:Int // 전역 변수는 반드시 초기화 필요
var data = 10

fun formatDate(date:Date):String { // public String formatDate(Date date)
    // 코틀린 객체 생성 시 new 연산자 없음
    val sdformat = SimpleDateFormat("yyyy-MM-dd")
    // println(sdformat.format(date))
    return sdformat.format(date)
}

class User{
    var name = "hello"
    fun sayHello() {
        println("sayHello")
    }
}

fun main() {
    User()
    val user = User()
    user.sayHello()

    var date1 = formatDate(Date())
    println(date1)

    println("코틀린 실행하기01")

    // data1 = 300 오류 발생 ==> 값 변경 불가
    data2 = 150

    println("data2 : $data2") // 문자열리터럴
    println("data3 : ${data3}")
    // var data4 // 변수 선언 시 타입이 없고 초기값 없음

    var data4:Int
    data4 = 60

    data = 20

}