package basics


/**
 *   ？. 指的是安全调用
 *   ！！. 指的是非空断言调用
 */

fun main(args: Array<String>) {
    var str: String? = null
    //安全调用，发生错误返回null
    val length = str?.length
    println(length)
    //非空断言调用，不为null的时候调用，为空的时候报错
    val length1 = str!!.length
    println(length1)
}