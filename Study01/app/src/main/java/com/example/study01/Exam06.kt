package com.example.study01

// p99 조건문 반복문
fun main() {
    var data = 10 // 자료형 생략 했음, 변수 선언과 동시에 초기화 했음
    if(data > 0) {
        println("data > 0\n")
    }
    else {
        println("data <= 0\n")
    }

    if(data > 10) {
        println("data > 10\n")
    } else if(data > 0 && data <= 10) {
        println("data > 0 && data <= 10\n")
    }else {
        println("data <= 10\n")
    }

    var result = if(data > 0) {
        println("data > 10")
        true
    }
    else {
        println("data <= 10")
        false
    }
    println("result : ${result}\n")

    when(data) {
        10 -> println("data=10\n")
        20 -> println("data=20\n")
        else -> println("data\n")
    }

    var str = "hello"
    when(str) {
        "hello" -> println("data is hello\n")
        "world" -> println("data is world\n")
        else -> {
            println("data\n")
        }
    }

    var data102:Any = 10
    when(data102) {
        is String        -> println("data102 is String\n")
        20, 30           -> println("data is 20 or 30\n")
        in 1 .. 10 -> println("data is 1..10\n")
        else             -> println("data\n")
    }

    var data103 = 10
    val result103 = when{
        data103 <= 0 -> "data is <= 0"
        data103 > 100 -> "data is >= 100"
        else -> "data"
    }
    println("result103 : ${result103}\n")

    // 반복문
    var sum1:Int = 0
    for(i in 1 .. 10) {
        sum1 += i
        println("i : $i, sum1 : $sum1")
    }
    println()

    // until : 1씩 증가, 마지막 10은 포함하지 않음
    for(i in 1 until 10) {
        println("i : $i")
    }

    println("\n=== step ===")
    for(i in 1 .. 10 step 2) { // step 2는 2씩 증가
        println("i : $i")
    }

    println("\n=== downTo ===")
    for(i in 10 downTo  2) { // 1씩 감소
        println("i : $i")
    }

    println("\n=== downTo step 2 ===")
    for(i in 10 downTo  2 step 2) { // 2씩 감소
        println("i : $i")
    }
    println()

    // p104
    var data104 = arrayOf<Int>(10, 20, 30)
    for(i in data104.indices) {
        print("$i ")
    }

    println("\n\n=== indices ===") // indices 배열과 같은 컬렉션이 가지는 위치값(index)
    for(i in data104.indices) {
        // println(i) // 0, 1, 2 위치값(index)
        print(data104[i]) // 10, 20, 30
        if(i != data104.size-1) print(", ") // data104.size = 3
    }

    println("\n\n=== withIndex ===")
    var arr = arrayOf<Int>(10, 20, 30, 40, 50)
    for((index, value) in arr.withIndex()) { // 값(value)과 위치값(index)
        println("value : ${value}, index : ${index}")
    }

    // while
    print("\n=== while ===\n")
    var x = 1
    sum1 = 0
    while(x < 11) {
        sum1 += x
        println("x : $x, sum1 : $sum1")
        x++
    }
}