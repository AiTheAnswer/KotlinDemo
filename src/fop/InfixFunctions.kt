package fop

/**
 * 以下场景中，函数还可以用中缀表示法调用：
 *  成员函数或扩展函数
 *  只有一个参数
 *  用infix 关键字标注
 */
infix fun Int.shl(x: Int): Int {
    return this + x
}

fun main(args: Array<String>) {
    val i = 1 shl 2//等同于1.shl(2)
}