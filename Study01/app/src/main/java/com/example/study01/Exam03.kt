package com.example.study01

// p88

// lateinit : 변수의 초기값을 나중에 지정할 수 있음
// var에만 사용 val 오류 발생
// 코틀린의 기본 타입인 Byte, Int, Long, Float, Double, Boolean에는 사용할 수 없음

// lateinit var data11:Int // 기본 타입 Int 사용으로 오류 발생
// lateinit val data22:String // val 사용으로 오류 발생
lateinit var data33:String

// by lazy {} : 변수의 초기값을 나중에 지정할 수 있음
// var, val 사용 가능
// 모든 타입에 사용 가능
// by lazy {}의 코드 블록 안에 간단한 연산 가능
// by lazy {} 코드 블록의 마지막은 해당 변수의 초기값

val data44: Int by lazy {
    println("in lazy")
    10
}

// p89
fun someFun() {
    var d1: Int = 10
    var d2: Int? = null // null 대입 가능 ==> 안전한 코드

    d1 = d1 + 10
    // d1 = d1.plus(10)
    println("d1 : $d1")
}

var d2:Int = 100 // 초기값 선언해야 함

fun main() {
    println("in main")
    println(data44 + 10) // in lazy 20
    println(data44 + 10) // 20 초기화가 되었기 때문에 {}은 실행되지 않고 기존 저장된 값 사용
    var d3:Int // 함수 내부 변수만 초기값 없이 선언 가능
    someFun()
}