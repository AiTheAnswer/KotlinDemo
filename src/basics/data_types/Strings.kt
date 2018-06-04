package basics.data_types


fun stringsExample() {
    //构造方法： 可以直接赋值一个字符串
    val s = "Some String"
    println(s)

    //使用迭代器取出字符串中的每一个字符
    //Iterate:
    val iterator = s.iterator()
    while (iterator.hasNext()) {
        println("Character: ${iterator.next()}")
    }
    println("--------------")

    //或者使用for循环取出每一个字符
    for (c in s) {
        println("Character $c")
    }
}

fun stringsExample2() {
    //直接指定字符串
    val s1 = "Some String"
    //串中可以包含制表符合换行符
    val s2 = "Some\tstring\n"
    //字符串可以多行  用 """  """ 包含
    val s3 = """
   Raw string example...
        We have multiline here!
        """
    println("$s1\n$s2$s3")
}

fun stringsExample3() {
    //字符串的拼接(像java中可以直接进行拼接)
    val s = "abc" + 1
    println(s + "def")
    //去掉某个标识符之前的空格（默认的标识符是'|'）
    val s1 = """ABC
        |123
        |456
        #456
        |DEF
        """.trimMargin()

    println(s1)

    //如果使用$符号不支持使用反斜杠，使用一下语法
    val s2 = "${'$'} 9.99"
    println(s2)
    val s3 = String()
    println("sss $s3 --")
}

fun main(args: Array<String>) {
    stringsExample()
    stringsExample2()
    stringsExample3()

}
