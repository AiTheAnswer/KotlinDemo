package basics.controll_flow

fun main(args: Array<String>) {
    cases("Hello")
    cases(1)
    cases(0)
    cases(0L)
    cases("hello")
    cases(MyClass())
}

/**
 *  when 相当于Java的switch语句
 *  但并不需要写case 和break
 *  而且条件更广，
 *  可以判断是否是某个具体的值
 *  多个具体值之间用逗号隔开
 *  多个连续的整数可以用in 1...10
 *  使用is 判断是否是某类型
 *  else相当于switch的default
 */
fun cases(obj: Any) {
    when (obj) {
        1 -> println("One")
        0, 3, 2 -> println("0 or 2 or 3")
        in 10..20 -> println("10到20之间")
    // !in 20..30 -> println("不在20到30之间")
        "Hello" -> println("String")
        is Long -> println("Long")
        !is String -> println("Not a String")
        else -> println("Unknown")
    }
}

class MyClass() {}
