package com.example.study02

// 확장 함수

data class Person(var name:String, var age:Int)

fun main() {
    val person = Person("", 0)
    person.name = "ann"
    person.age = 10
    println("$person\n")

    // 1. let => not-null 체크 때 유용
    val nameStr = person?.let { it.name } ?: "Noname"
    println("nameStr : $nameStr\n")

    val person2: Person? = null
    val nameStr2 = person2?.let { it.name } ?: "Noname"
    println("nameStr2 : $nameStr2\n")

    // 2. with
    with(person) {
        println(name) // ann
        println(age) // 10
    }

    // 3. apply => 자기 자신을 반환
    val result = person.apply {
        name = "Android"
        age = 30
    }
    println("apply person ${person}")
    println("apply person result ${result}")
    
    println(isEven.fmethod(30)) // true
    println(isEven2.fmethod(25)) // false
}

//////
// interface 안에 구현해야 할 함수가 하나일 떄
fun interface InterTest {
    fun fmethod(i:Int) : Boolean
}

val isEven = object : InterTest {
    override fun fmethod(i: Int): Boolean {
        return i%2 == 0
    }
}

// SAM(Single Abstract Method)
val isEven2 = InterTest {i-> i%2 ==0}