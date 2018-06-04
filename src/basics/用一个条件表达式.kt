package basics

/**
 * 我们在Kotlin中，可以直接使用 = 符号来直接返回一个函数的值。
 */
fun main(args: Array<String>) {
    println("5和9的较大值是：" + max(5, 9))
    println("5 + 9 = " + sum(5, 9))
    println(second(3, 2))
}

/**
 * 函数的返回值可以是一个表达式
 */
fun max(a: Int, b: Int) = if (a > b) a else b

/**
 * 函数可以直接指定返回值
 */
fun sum(a: Int, b: Int) = a + b

/**
 * when 条件语句(很像switch 语句)
 */
fun second(a: Int, b: Int) = when (a) {
    1 -> a
    2 -> b
    else -> 0
}
