package fop

/**
 *  通过扩展声明完成一个类的新功能扩展，而需继承该类或使用设计模式（例如：装饰设计者模式）
 */
/**
 * 扩展字符串类的新功能，根据角标交换对应角标的位置字符
 */
fun String.swap(index1: Int, index2: Int): String {
    return if (this.length <= index1 || this.length <= index2) {
        this
    } else {
        val charArray = this.toCharArray()
        val tmp = charArray[index1]
        charArray[index1] = charArray[index2]
        charArray[index2] = tmp
        charArrayToString(charArray)
    }
}

fun charArrayToString(charArray: CharArray): String {
    var result = ""
    charArray.forEach {
        result += it
    }
    return result
}

fun main(args: Array<String>) {
   val str = "abc"
    val swap = str.swap(0, 3)
    println(swap)
}