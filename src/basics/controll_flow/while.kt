package basics.controll_flow

/**
 * while 循环
 * do..while 循环
 */
fun main(args: Array<String>) {
    val args = listOf("Allen0", "Allen1", "Allen2", "Allen3", "Allen4")
    var i = 0
    while (i < args.size)
        println(args[i++])
    while (i < 11) {
        println(i++)
    }
    do {
        i--
        println(i)
    } while (i > 0)
}