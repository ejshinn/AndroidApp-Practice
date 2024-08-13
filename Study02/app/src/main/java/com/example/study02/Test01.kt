package com.example.study02

open class PTest() { //
    open var pvalue01 = 10
    var pval = 1
    open fun fun1() {
        println("PTest fun1\n")
    }
}

class CTest(val name:String) : PTest() {
    override var pvalue01 = 100
    override fun fun1() {
        println("override fun1\n")
    }
}

fun main() {
    val p1:PTest = PTest() // val var
    val c1:PTest = CTest("홍길동") // 상속 관계일 때 이런 표현 가능
    val c2:CTest = CTest("강감찬")
    
    p1.fun1() // PTest fun1
    c1.fun1() // c1은 PTest형 => override fun1
    c2.fun1() // c2는 CTest형이므로 override fun1 출력

    println("pvalue01 : ${c1.pvalue01}") // pvalue01: 100
    println("pval : ${p1.pval}") // pval: 1
}