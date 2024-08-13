package com.example.study02

// p123 데이터클래스
class NonDataClass(val name: String, val email: String, val age: Int)

data class DataClass(val name: String, val email: String, val age: Int) {
    lateinit var address: String // 초기화 해야 함, lateinit => 값 할당을 나중에
    constructor(name: String, email: String, age: Int, address: String)
            :this(name, email, age) {
                this.address = address
    }
}

fun main() {
    val non1 = NonDataClass("name", "a@a.com", 10)
    val non2 = NonDataClass("name", "a@a.com", 10)
    println("non1 : ${non1.name}, ${non1.email}, ${non1.age}")
    println("non2 : ${non2.name}, ${non2.email}, ${non2.age}")

    // 일반 클래스로 생성 시 동일한 데이터가 있어도 메모리상의 생성 위치가 다르므로 false
    println("non1 equals non2 : ${non1.equals(non2)}") // false
    println("non1 == non2 : ${non1==non2}\n") // false

    val data1 = DataClass("name", "a@a.com", 10, "seoul")
    val data2 = DataClass("name", "a@a.com", 10, "busan")
    println("data1 : ${data1.name}, ${data1.email}, ${data1.age}, ${data1.address}")
    println("data2 : ${data2.name}, ${data2.email}, ${data2.age}, ${data2.address}")
    
    // 데이터클래스, 데이터가 같으므로 true
    println("date1 equals data2 : ${data1.equals(data2)}") // true
    println("date1 == data2 : ${data1==data2}\n") // true

    // toString()
    println("non1 toString: ${non1.toString()}") // 객체 주소값 출력
    println("data1 toString: ${data1.toString()}") // DataClass(name=name, email=a@a.com, age=10)
    println("data2 toString: ${data2.toString()}") // DataClass(name=name, email=a@a.com, age=10)
}