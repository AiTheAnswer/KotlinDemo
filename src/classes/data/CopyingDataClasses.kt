package classes.data

/**
 * 数据类对象的copy
 *
 */

data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {
    val p = Person("sub", 24)
    println(p)
    //copy对象(完全copy，不更改属性)
    val p1 = p.copy()
    println(p1)
    //copy对象，指定改变某个属性
    val p2 = p.copy(name ="那个女孩")
    println(p2)
    //copy对象，不指定改变的属性,从属性列表第一个属性开始改变
    val p3 = p.copy("哪个女孩",25)
    println(p3)
}