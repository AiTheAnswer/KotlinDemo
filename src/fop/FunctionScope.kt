package fop

/**
 * 函数作用域
 * 在kotlin 中函数可以在文件顶层声明，这意味着你不需要像一些语言如Java、C#那样创建一个类来保存一个函数。
 * 此外除了顶层函数，在Kotlin中函数也可以声明在局部作用域、作为成员函数以及扩展函数
 */
/**
 * 一、局部函数（嵌套函数）
 * Kotlin支持局部函数，即一个函数在另一个函数内部
 * 局部函数可以访问外部函数（即闭包）中的局部变量delta
 */
fun sum(x: Int, y: Int, z: Int): Int {
    val delta = 0
    fun add(a: Int, b: Int): Int {
        return a + b + delta
    }
    return add(x, add(y, z))
}

/**
 * 二、成员函数
 * 成员函数是在类或对象内部定义的函数
 * 成员函数以点表示法调用
 */

class Sample() {
    fun foo() {
        println("Foo")
    }
}

/**
 * 三、泛型函数
 * 函数可以有泛型参数，通过在函数名前使用尖括号指定
 */
fun <T> add(a: T, b: T): List<T> {
    return asList(a, b)
}

/**
 * 四、 高阶函数
 * 高阶函数是将函数用作参数或返回值的函数。例如，Iterable的filter函数：
 * 它的输入参数predicate: (T) -> Boolean就是一个函数。其中，函数类型声明的语法是： （X）-> Y
 * 表示这个函数是从类型X到类型Y的映射。即这个函数输入X类型,输出Y类型。
 */
fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
    return filterTo(ArrayList(), predicate)
}

fun <T, C : MutableCollection<in T>> Iterable<T>.filterTo(destination: C, predicate: (T) -> Boolean): C {
    for (element in this) {
        if (predicate(element)) {
            destination.add(element)
        }
    }
    return destination
}

fun isOdds(x: Int): Boolean {
    return x % 2 == 1
}

/**
 * 五、匿名函数
 * 我们也可以使用匿名函数来实现这个predicate函数
 */

/**
 * 六、Lambda 表达式
 *  我们也可以直接使用跟简单的Lambda表达式来实现一个predicate函数：
 *  1、lambda表达式总是被大括号{}括着
 *  2、其参数（如果有）
 */

fun main(args: Array<String>) {
    val sum = sum(1, 2, 3)
    println(sum)
    val listOf = listOf(1, 2, 3, 4, 5, 6)
    // :: 用来引用一个函数
    listOf.filter(::isOdds)
    //匿名函数
    listOf.filter((fun(x: Int): Boolean {
        return x % 2 == 1
    }))
    //lambda表达式
    listOf.filter { it % 2 == 1 }

}