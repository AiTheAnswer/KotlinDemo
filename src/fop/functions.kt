package fop

fun isOdd(x: Int) = x % 2 != 0

fun length(s: String) = s.length

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x ->
        f(g(x))
    }
}

fun main(args: Array<String>) {
    //可以将一个函数赋值给变量
    val print = fun(x: Any) {
        println(x)
    }
    val list = listOf(1, 2, 3, 4)
    //将一个函数变量作为某个方法的参数
    list.forEach(print)
    println("-------------------------------------")
    list.forEach { print(it) }
    val compose = compose(::isOdd, ::length)
    val listOf = listOf("a", "ab", "abc")
    println(listOf.filter(compose))
}