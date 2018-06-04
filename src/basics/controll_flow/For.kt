package basics.controll_flow

/**
 * 使用for .. 循环
 */
fun main(args: Array<String>) {
    val args = intArrayOf(1, 9, 45)
    // for循环遍历取出所有的值
    for (arg in args) {
        println(arg)
    }
    println()
    //for循环遍历数据的角标
    for (i in args.indices) {
        println(args[i])
    }
    //使用 1..9 循环从 1-9
    println("for 循环使用 n....N")
    for (i in -6..10) {
        println(i)
    }
    //循环从6 减少到0 每次减小2
    for (i in 6 downTo 0 step 2) {
        println(i)
    }
    //使用withIndex
    for ((index, value) in args.withIndex()) {
        println("index =  $index    value = $value")
    }
}