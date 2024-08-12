package com.example.study01

// p115 상속
// 코틀린 클래스는 기본적으로 상속 불가능
// 부모 클래스 open 키워드 추가
// 코틀린에서는 : 사용하여 상속 받음(자바에서는 extends)
// 코틀린 상속관계에서도 자식 클래스는 부모 클래스의 생성자를 반드시 호출
open class Super{ }
class Sub : Super() { }

open class Super1(name:String) { }
class Sub1(name: String) : Super1(name) { }

open class Super2(name: String) {}
class Sub2 : Super2{
    constructor(name: String): super(name)
}

open class Super3 {
    var superData = 10
    fun superFun() {
        println("나는 Super3 superData : $superData")
    }
}

class Sub3 : Super3()

open class Super117 {
    open var someData = 10
    open fun superFun() {
        println("나는 Super117 someData : $someData")
    }
}

class Sub117: Super117() {
    // 오버라이딩
    override var someData = 200
    override fun superFun() {
        println("나는 Super117 someData : $someData\n")
    }
}

fun main() {
    val obj = Sub3()
    obj.superData = 20
    obj.superFun()

    val obj117 = Sub117()
    obj117.superFun()

    val pa = Parent("Parent") // someData = 1, name = Parent
    pa.someFun()

    val ch1 = Child("Child")
    ch1.someFun() // someData = 10, name = Child

    println()
    ch1.parentFun()
    ch1.childFun()
    
    // pa.childFun() // 오류 발생, pa는 Parent형
    
    val pa1:Parent = Child("자식")
    pa1.someFun() // 오버라이딩된 메서드 실행(Child의 somFun 실행)
    pa1.parentFun()
    // pa1.childFun() // 오류 발생, pa1은 Parent형이므로 오버라이딩되지 않은 자식의 메서드 사용불가
    // 자바코드
    // List list = new ArrayList<String>()
}

open class Parent(val name:String) {
    open val someData = 1
    open fun someFun() {
        println("someData = $someData, name = ${name}") // someData = 1, name = Parent
    }
    fun parentFun() {
        println("parentFun")
    }
}

class Child(val value:String): Parent(value) {
    override val someData = 10
    override fun someFun() {
        println("someData = $someData, name = ${value}") // someData = 10, value = Child
        println("11someData = $someData, name = ${value}, name = ${name}") // someData = 10, value = Child
    }
    fun childFun() {
        println("childFun")
    }
}

// p118
// public(모두) protected(상속관계) internal(같은 모듈 => 자바 : defalut) private(자신만)
// 코틀린의 기본 접근제한자는 public, 생략하면 public

// p120 데이터 클래스
class NonDataClass(val name:String, val email:String, val age:Int) {}
data class DataClass(val name:String, val email:String, val age:Int) {}