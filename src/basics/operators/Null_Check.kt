package basics

/**
 *  ？ 表示值可以为空
 *   使用可以为NUll的变量时，必须进行Null判断
 */
fun parseInt(str: String): Int? {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        println("One of the arguments is not Int")
    }
    return null

}

fun main(args: Array<String>) {
    val x = parseInt("7")
    val y = parseInt("9")
    //使用可以为Null的变量前必须进行Null检测
    if (x == null || y == null) {
        println("One of the arguments is null")
    } else {
        println("x * y = ${x * y}")
    }
}