package classes.companion_object

import java.io.File

/**
 * 伴生对象
 * 在Kotlin 中类没有静态方法。在大多数情况下，它建议简单地使用包级函数
 * 如果你需要写一个可以无需用一个类的实例来调用、但需要访问类内部的 函数（例如，工厂方法），你可以把它写成该类内“对象声明”中的一员。
 * 更具体地讲，如果在你的类内声明了一个“伴生对象”， 你就可以使用像在 Java/C# 中调用静态方法相同的语法来调用其成员，只使用类名 作为限定符。
 *
 */
fun simpleObjectExample() {
    val obj = object {
        var x = 0
        var y = 9
        fun print() {
            println("x = $x , y = $y")
        }
    }
    obj.print()
    obj.x = 10
    obj.y = 11
    obj.print()
}

/**
 *  一、对象表达式
 */
var handler: Handler = object : Handler() {
    override fun handleMessage(msg: Message) {
        when (msg.what) {
            0 -> println("what is 0")
            1 -> println("what is 1")
            else -> println("else")
        }
    }
}


open class Handler {
    open fun handleMessage(msg: Message) {

    }
}

class Message {
    var what = 0
}

/**
 * 二、Object对象的声明
 */
object SingleObject {
    init {
        println("init")
    }

    fun test() {
        println("test")
    }
}

fun main(args: Array<String>) {
    simpleObjectExample()
    SingleObject.test()
    handler.handleMessage(Message())
    val empty = DataProcessor.isEmpty("a")
    println("empty = $empty")

}

/**
 * 伴生对象，用companion object 关键字声明
 *
 * 一个类只能有一个伴生对象
 * 一个类的伴生对象默认引用名是Companion:
 * 伴生对象的初始化是在相对应的类被加载解析时，与Java静态初始化器的语义相匹配
 * 伴生对象还可以实现接口：
 *
 *
 */
class DataProcessor {
    fun process() {
        println("Process Data")
    }

    object FileUtils {
        val userHome = "/Users/Allen/"
        fun getFileContent(file: String): String {
            var content = ""
            var f = File(userHome + file)
            f.forEachLine { content = "$content$it/n" }
            return content
        }
    }


    //StringUtils可以省略
    companion object StringUtils : BeanFactory<String> {
        override fun create(): String {
            return "A"
        }

        fun isEmpty(s: String): Boolean {
            return s.isEmpty()
        }
    }
}

interface BeanFactory<out T> {
    fun create(): T
}
