package basics.return_jumps

class Person(val name: String?, val age: Int)


fun main(args: Array<String>) {
    defaultReturn()
    println("------defaultReturn--------")
    returnAtLabels()

}

/**
 * return   返回到标签处
 */
fun returnAtLabels() {
    val list = listOf<Int>(1, 2, 3, 4, 5)

    list.forEach lit@{
        if (it == 3) {
            return@lit
        }
        println(it)
    }
    print(" done with nested loop")
}

/**
 * return   默认从最近的闭合函数或匿名函数返回
 *
 * ?:相当于Java的三目运算符  为null的时候执行 ?: 后面的值
 */
fun defaultReturn() {
    val person = Person(null, 25)
    val s: String = person.name ?: return
    println(s)
}
