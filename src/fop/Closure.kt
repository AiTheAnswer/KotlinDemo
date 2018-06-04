package fop


/**
 * 闭包（Closure）
 * Lambda表达式或者匿名函数，以及局部函数和对象表达式可以访问其闭包，即在外部作用域中声明的变量。
 * 与Java不同的是可以修改闭包中捕获的变量
 */

fun sumGTZero(c: Iterable<Int>): Int {
    var sum = 0
    c.filter2 { it > 0 }.forEach { sum += it }
    return sum
}

fun closureDemo() {
    var sum = 0
    Thread({
        for (i in 1..10) {
            sum += i
            println("I = $i")
            Thread.sleep(1000)
            println(sum)

        }
    }).start()

    Thread({
        for (j in 10..20) {
            sum += j
            println("J = $j")
            Thread.sleep(1000)
            println(sum)
        }
    }).start()
}

fun main(args: Array<String>) {
    val listOf = listOf(1, 2, 3, 4, 5, 6)
    val sumGTZero = sumGTZero(listOf)
    println(sumGTZero)
    closureDemo()
}