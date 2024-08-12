package com.example.study01

// p89 데이터 타입
// 정수형 기본 타입은 Int
val a1:Byte = 0b00001011
val a2:Int = 123
val a3:Int = 123
val a4:Long = 10L

val a5:Float = 10.0f
val a6:Double = 10.0

val a7:Boolean = true
val a:Char = 'A'
// if(a==1) { // char형은 정수타입으로 호환 안됨(자바의 char형은 정수타입으로 변환 가능)
// }

fun main() {
    val str1 = "Hello \n World"
    val str2 = """
        Hello
        World
    """
    println("str1 : $str1")
    println("str2 : $str2")

    //////
    fun sum(no:Int):Int {
        var sum = 0
        for(i in 1 .. no) {
            sum += i
        }
        return sum
    }

    val name:String = "kang"
    println("name:$name, sum:${sum(10)}")

    //////
    // Any 코틀린 최상위 객체, 모든 데이터 타입을 저장할 수 있음
    val da1:Any = 10 // 정수형
    val da2:Any = "hello" // 문자열 데이터 저장
    class User
    val data3:Any = User() // 클래스 객체 저장
    class Exam
    val data4:Any = Exam() // 클래스 객체 저장

    //////
    // Unit : 코틀린에서 해당 함수의 반환(리턴)값이 없음(자바의 void) => Unit 생략 가능하고 생략하면 자동으로 Unit 적용
    val data1:Unit = Unit
    some() // Unit 사용
    some1() // Unit 생략

    // Nothing : null만 저장 가능, 함수의 리턴 타입은 null과 예외만 반환
    var data5:Nothing? = null
    // data5 = 500 // null만 저장 가능한데 숫자 지정했기 때문에 오류 발생
}

fun some():Unit{
    println(10*20)
}

fun some1():Unit{
    println("some1 ${10*20}")
}