package com.example.study02

// p128

// 일반 함수
fun fun1(num1 : Int, num2 : Int) : Int {
    var result: Int = 0
    result = num1 + num2
    return result
}

// 람다 함수(익명 함수), 변수에 함수를 저장
val result2 = { num1 : Int, num2 : Int ->
    var result : Int = 0
    result = num1 + num2
    result
}

// 변수에 람다 함수 저장
var result22 : (Int, Int) -> Int = { num1 : Int, num2 : Int ->
    var result : Int = 0
    result = num1 + num2
    result
}

// 매개변수가 1개(Int) 가지며 그 값을 *2 해서 리턴
var function2:(Int) -> Int = {n1:Int -> n1 * 2}

// 데이터 유형을 추론할 수 있으면 생략 가능
var function3 = {n1 : Int -> n1 * 2}

// 매개변수가 1개 => it
var function4:(Int) -> Int = {it * 2}

fun main() {
    var result : Int
    // multi_total : 자료 유형 표시하는 람다 함수 정의
    val multi_total:(Int, Int) -> Int = {x:Int, y:Int -> x*y} // 생략 안 한 전체 표현
    val multi_skip = {x:Int, y:Int -> x*y} // 선언 자료형 생략
    val multi_args:(Int, Int) -> Int = {x, y -> x*y} // 람다식 매개변수 자료형 생략
    // var multi = {x,y -> x*y} // 자료형을 모두 생략하면 자료형을 알 수 없어 오류 발생

    result = multi_total(10, 20) // 생략 안 한 전체 표현
    println("multi_total result : ${result}") // 200

    result = multi_skip(10, 20) // 선언 자료형 생략
    println("multi_skip result : ${result}") // 200

    result = multi_args(10, 20) // 람다식 매개변수 자료형 생략
    println("multi_args result : ${result}\n") // 200

    /////

    val multi:(Int,  Int) -> Int = { x:Int, y:Int ->
        print("x*y = ")
        x*y
    }
    println(multi(100, 200)) // x*y = 20000

    val multi2 = { x:Int, y:Int ->
        print("x*y = ")
        x*y
    }
    println(multi2(100, 200)) // x*y = 20000

    val multi3:(Int,  Int) -> Int = { x, y ->
        print("x*y = ")
        x*y
    }
    println(multi3(100, 200)) // x*y = 20000

    // 매개변수, 반환형이 없을 경우
    val greet:() -> Unit = { println("\n매개변수, 반환형 없음") }
    greet()

    // 반환형이 없을 경우 => 생략 가능
    val greet1 = { println("매개변수, 반환형 없음 생략 가능\n") }
    greet1()

    val onep1: (String)->Unit = { s:String -> println("onep1 : $s") }
    onep1("hello world!") // "onep1 : hello world!

    val onep2 = { s:String -> println("onep2 : $s") }
    onep2("hello world!") // "onep2 : hello world!

    val onep3:(String)->Unit = {println("onep3 :  $it")} // it 사용하기
    onep3("hello world!") // "onep3 : hello world!

    val onep4 = {it:String -> println("onep4 : $it")}
    onep4("hello world!") // "onep4 : hello world!
}