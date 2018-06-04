package fop

fun <T> Iterable<T>.filter2(predicate: (T) -> Boolean): List<T> {
    return filterTo2(ArrayList(), predicate)
}

fun <T, C : MutableCollection<in T>> Iterable<T>.filterTo2(destination: C, predicate: (T) -> Boolean): C {
    for (element in this) {
        if (predicate(element))     {
            destination.add(element)
        }
    }
    return destination
}

/**
 * Lambda 表达式
 *  我们也可以直接使用跟简单的Lambda表达式来实现一个predicate函数：
 *  1、lambda表达式总是被大括号{}括着
 *  2、其参数（如果有的话）在 -> 之前声明（参数类型可以省略）
 *  3、函数体（如果存在的话）在 -> 后面
 */

fun main(args: Array<String>) {
    val listOf = listOf(1, 2, 3, 4, 5)
    //Lambda表达式
    listOf.filter2({
        it % 2 == 1
    })
    //如果Lambda是该调用的唯一参数，则调用中的圆括号可以省略
    listOf.filter2 {
        it % 2 == 1
    }
    //使用Lambda表达式定义一个函数字面值：
    val sum = { x: Int, y: Int -> x + y }
    val sum1 = sum(1, 1)
    println(sum1)
    //使用嵌套的Lambda表达式来定义一个柯里化的sum函数：
    val sum2 = { x: Int -> { y: Int -> x + y } }
    println(sum2)
    val result = sum2(2)(2)
    println(result)
}
/**
 * it: 单个参数的隐式名称
 * Kotlin中另一个有用的约定是，如果函数字面值只有一个参数，那么它的声明可以省略（连同 -> ）,其名称是it
 */