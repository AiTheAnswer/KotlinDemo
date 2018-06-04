package basics.data_types

/**
 * 基本数据类型
 * 看文档doc
 */
fun main(args: Array<String>) {
    val a: Int = 1
    var b: Long? = null
    b = a.toLong()
    println("a = $a")
    println("b = $b")
    println(a.equals(b))

}