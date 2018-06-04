package basics.data_types


fun arraysExample() {
    //创建数组，通过角标来创建数组值
    val a = Array(5, { i -> i + 100 })
    for (x in a) {
        println("A number $x")
    }
    //设置数组中某个位置的数值
    println("------------设置数组中的某个值")
    a[2] = 50 //or a.set(2,50)
    for (x in a) {
        println("A number $x")
    }
    //通过角标获取数组的值
    val y = a.get(2) //or a[2]
    println("Number at 2 position: $y")
    println("--------------------------------")
    //创建数组，通过具体的值（可以有不同的值）
    val b = arrayOf(2, 4, 6, "String", "one String", 8, 10)
    print("数组B的元素有")
    for (x in b) {
        print("$x ,")
    }
    println()

    //创建一个空值的数组
    val c = arrayOfNulls<Int>(5)
    for (x in c) {
        println(x)
    }
    println("---------------------------")
    //可以遍历数组的角标
    for (x in c.indices) {
        c[x] = x + 1000
    }
    for (x in c) {
        println(x)
    }
    println("----------------------------")

    //创建一个数组值为Int类型的数组
    val d = intArrayOf(1,3,5,7,9,11)
    for (x in d) {
        println("D member : $x")
    }
    println("-----------------------------")
    //获取数组的大小
    println("A size ${a.size}")
    println("B size ${b.size}")
    println("C size ${c.size}")
    println("D size ${d.size}")

}

fun main(args: Array<String>) {
    arraysExample()
}