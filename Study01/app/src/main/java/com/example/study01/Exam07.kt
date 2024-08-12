package com.example.study01

// p107 클래스와 생성자

// 클래스 선언
class User01{}

// 빈 클래스의 경우 {} 생략
class User02

class User107 {
    var name = "kang"

    constructor(name:String) {
        this.name = name
    }

    fun someFun() {
        println("name : $name\n")
    }

    class someClass(){}
}

fun main() {
    val user107 = User107("kim")
    user107.someFun() // name : kim

    val user108 = User108("kang108", 10)
    user108.someFun()

    val user109 = User109("kim109", 100)
    user109.someFun()

    User112("user112") // 생성자 name 하나 호출
    User112("user112", 112) // 생성자 name, count 두 개 호출

    User113("user113", 113) // 1번, 2번 순으로 실행
    println()
    User113("user113", 113, "email113") // 1번, 2번, 3번 순으로 실행
}

// 주생성자 사용
class User03 constructor() {}

class User108(name: String, count: Int) { // 주생성자의 contructor 생략
    var name = "kang"
    var count = 0

    init {
        this.name = name
        this.count = count
        println("User108 주생성자 호출") // init이 실행되어 "주생성자 호출" 출력됨
    }

    fun someFun() {
        println("name : $name, count : $count\n")
    }
}

// var, val 키워드로 매개변수 선언 시 클래스 멤버 변수(클래스 변수)처럼 사용
class User109(val name: String, var count: Int) {
    init{
        println("User109 주생성자 호출")
    }
    fun someFun() {
        println("User109 name : $name, User109 count : $count\n") // User109 name : kim109, User109 count : 100
    }
}

// p112 보조생성자 => 클래스 본문에 constructor 키워드로 선언한 함수
class User112 {
    constructor(name: String) {
        // 보조생성자를 생성자 오버로딩에 의해 여러 생성자 사용
        println("생성자 name 하나 호출")
    }
    constructor(name: String, count: Int) {
        println("생성자 name, count 두 개 호출\n")
    }
}

// 주생성자 + 보조생성자 => 보조생성자는 주생성자를 반드시 호출해야 함
class User113(name: String) { // User113(name:String) 주생성자
    init {
        println("User113 name 하나 있는 주생성자") // 1번 실행(주생성자 먼저 실행)
    }
    // 보조생성자
    constructor(name: String, count: Int) : this(name){
        println("매개변수가 2개인 보조 생성자") // 2번 실행(보조생성자 실행)
    }
    // 보조 생성자
    constructor(name: String, count: Int, email: String) : this(name, count) {
        println("매개변수가 2개인 보조 생성자") // 2번 실행(보조생성자 실행)
    }
}