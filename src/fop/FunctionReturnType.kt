package fop

/**
 * 函数的返回类型
 * 函数返回类型需要显示声明
 * 具体代码块体的函数必须始终显示指定返回类型，除非他们旨在返回Unit
 * Kotlin不推断具有块代码体的函数的返回类型，因为这样的函数在代码体中可能有复杂的控制流，并且返回类型对于读者也不是很明显
 */
/**
 * 返回Unit的函数
 * 如果一个函数不返回任何有用的值，它的返回类型是Unit。Unit是一种只有一个Unit值的类型。这个值不需要显示返回：
 */
fun printHello(name: String?): Unit {//Unit类型的返回也可以不显示声明
    if (!name.isNullOrBlank()) {
        println("Hello$name")
    } else {
        println("Hello")
    }
    // return Unit  或者return 是可选的
}

/**
 * 函数表达式
 * 当函数返回单个表达式时，可以省略花括号并且在 = 符号之后指定代码体即可
 */
fun double(x: Int): Int = x * 2

fun double2(x: Int) = x * 2

fun double3(x: Int): Int {
    return x * 2
}


fun main(args: Array<String>) {

}