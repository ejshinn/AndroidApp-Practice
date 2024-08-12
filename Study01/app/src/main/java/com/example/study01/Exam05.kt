package com.example.study01

// p94 컬렉션 타입 => Array, List, Set, Map
fun main() {
    val data1:Array<Int> = Array(3, {0})

    println(data1)
    println(data1[0])

    data1[1] = 100 // 배열 접근[index] 사용
    data1[2] = 200
    for(i in data1) {
        print("$i ")
    }
    println("\n")
    println(data1.get(1)) // set(), get()
    data1.set(1,1000)
    println("data1[1] : ${data1.get(1)}")
    println("data1 배열 크기 : ${data1.size}\n")

    // 코틀린은 기본타입 배열 클래스를 사용하여 배열 생성 =>
    // ByteArray, ShortArray, IntArray, LongArray,
    // FloatArray, DoubleArray, BooleanArray, CharArray 클래스 제공
    val arrInt = IntArray(3, {0})
    val arrBool = BooleanArray(5, {false})

    // 배열 선언과 동시에 초기값 설정
    // arrayOf()
    // 기본타입 사용하여 배열 생성
    // byteArrayOf()
    val arrdata1 = intArrayOf(10, 20, 30)
    val arrdata2 = booleanArrayOf(true, false, true)
    println(arrdata2[0])

    // List
    // 리스트(불변 클래스)
    var list1:List<Int> = List(3, {0})
    // 생성, 초기화 동시에
    var list2 = listOf<Int>(10, 20, 30)
    println("list2 크기 : ${list2.size}")
    println("list2 값 : ${list2[0]}, ${list2.get(1)}, ${list2.get(2)}")
    // 오류 발생 => 리스트는 불변이므로 값을 수정할 수 없음
    // list2[0] = 100
    // list2[1] = 2500
    // list2.set(2, 200)

    // 가변 클래스로 리스트 생성
    var list3:MutableList<Int> = MutableList(3, {0})
    // 생성, 초기화 동시에 => mutableListOf
    var list4 = mutableListOf<Int>(10, 20, 30)
    println("\nmutable list4 크기 : ${list4.size}")
    println("mutable list4 값 : ${list4[0]}, ${list4.get(1)}, ${list4.get(2)}}")

    list4[0] = 100
    list4[1] = 200
    list4.set(2,300)
    println("\nmutable list4 값 : ${list4[0]}, ${list4.get(1)}, ${list4.get(2)}}\n")

    list4.add(3, 40)

    for(i in list4) {
        print("$i ")
    }
    println("\n")

    list4.set(3, 400)
    for(i in list4) {
        print("$i ")
    }
    println("\n")

    // Map => mapOf 불변
    var map1 = mapOf<String, String>(Pair("one", "hello"), "two" to "world")
    println("""
        mapsize : ${map1.size}
        mapdata : ${map1.get("one")}, ${map1.get("two")}
    """.trimIndent())
    println()

    // map1.set("two", "worldworld") // 불변이므로 수정 불가

    var map2 = mutableMapOf<String, String>(Pair("oneone", "hello"), "twotwo" to "world")
    println("""
        mutable mapsize : ${map2.size}
        mutable mapdata : ${map2.get("oneone")}, ${map2.get("twotwo")}
    """.trimIndent())
    println()

    map2.set("twotwo", "worldworld") // 수정 가능
    println("""${map2.get("twotwo")}""")
    println()

    println(map2.keys) // keys => 맵의 키값만
    println(map2.values) // values => 맵의 values값만
    println()

    println("map2.count : ${map2.count()}") // count => map의 크기(현재 2개)
    println("map2 : ${map2}\n") // map2 : {oneone=hello, twotwo=worldworld}

    map2.set("oneone", "hello 대신 들어가는 값")
    // map은 키가 중복되지 않기 때문에 oneone이 추가되지 않고 내용이 바뀜
    println("map2.count : ${map2.count()}") // map2.count : 2
    println("map2 : ${map2}\n") // map2 : {oneone=hello 대신 들어가는 값, twotwo=worldworld}

    map2.remove("oneone")
    println("map2 : ${map2}") // map2 : {twotwo=worldworld}
    println(map2.containsKey("oneone")) // oneone 키가 없으므로 false
    println(map2.containsValue("worldworld")) // worldworld의 value가 있으므로 true
    println()

    // Set
    val set1 = mutableSetOf("one", "two", "three", "four", "five")
    for(i in set1) {
        print("$i ")
    }

    println("\n")
    println("set1 : ${set1}") // set1 : [one, two, three, four, five]
    println("set1 count : ${set1.count()}\n") // 5

    set1.add("test")
    println("set1 : ${set1}") // set1 : [one, two, three, four, five, test]
    println("set1 count : ${set1.count()}\n") // 6

    set1.remove("test")
    println("set1 : ${set1}") // set1 : [one, two, three, four, five]
    println("set1 count : ${set1.count()}\n") // 5

    set1.add("one") // 이미 one이 있으므로 추가 안됨, set은 중복 허용 안됨
    println("set1 : ${set1}") // set1 : [one, two, three, four, five]
    println("set1 count : ${set1.count()}\n") // 5

    println(set1.contains("three")) // three라는 값이 있으므로 true
}