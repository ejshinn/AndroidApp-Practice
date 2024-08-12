package com.example.study01

fun main() {
    function1() // 매개변수 없는 함수
    function2(10,20) // num1 : 10, num2 : 20, 합계 : 30

    var hap = function3(50, 70)
    println("리턴된 hap : $hap\n")

    add(10, 20) // 결과 : 30

    var subValue = sub() // 결과 10
    println("sub 결과 : ${subValue}")

    var mulValue = multiply(10, 20) // 결과 200
    println("multiply 결과 : ${mulValue}")

    divide() // 결과 : 2
}

fun function1() {
    println("매개변수 없는 함수\n")
}

fun function2(num1: Int, num2: Int) {
    val sum = num1 + num2
    println("num1: $num1, num2: $num2")
    println("합계 : $sum\n")
}

fun function3(num1: Int, num2: Int):Int {
    return num1 + num2
}

fun add(num1: Int, num2: Int) {
    return println("add 결과 : ${num1 + num2}")
}

fun sub():Int {
    return 40 - 30
}

fun multiply(num1: Int, num2: Int):Int {
    return num1 * num2
}

fun divide() {
    println("divide 결과 : ${20/10}")
}