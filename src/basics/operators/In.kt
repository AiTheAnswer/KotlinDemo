package basics

/**
 * 使用 in 操作符判断是否在某个范围内
 */
fun main(args: Array<String>) {
    val y = 10
    val i = 1
    //使用 .. 或者until 表示一个区间
    if (i in 1 until y - 1) {
        println("Ok")
    }
    //创建一个ArrayList
    val array = arrayListOf<String>()
    array.add("aaa")
    array.add("bbb")
    array.add("ccc")
    if (-1 !in 0..-3) {
        println("-1不在0到array集合长度之间")
    }
}