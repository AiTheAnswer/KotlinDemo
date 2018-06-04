package fop

/**
 * 函数参数
 * 一、定义
 * 使用Pascal表示法定义，即name : type 。参数之间用逗号隔开。每个参数必须显示指定其类型
 */
fun add(x: Int, y: Int): Int {
    return x + y
}

/**
 * 二、默认参数
 * 函数参数可以有默认值，当省略相应的参数时使用默认值。这可以减少重载数量
 */
fun sum(x: Int = 0, y: Int = 0): Int {
    return x + y
}

/**
 * 三、可变数量的参数（Varargs）
 * 函数的参数（通常是最后一个）可以用vararg 修饰标记
 * 和Java一样，可变参数当作数组来处理
 */
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) { //ts is an Array
        result.add(t)
    }
    return result
}

fun main(args: Array<String>) {
    add(1, 2)
    sum()//调用时使用函数的默认值
    sum(x = 1)//调用时指定某个参数的值，未指定的参数使用默认值
    sum(y = 2)
    sum(1, 2)//指定所有参数，不使用默认值
    //允许将可变数量的参数传递给函数
    asList(1,2,3)

}