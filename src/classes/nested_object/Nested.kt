package classes.nested_object

import java.io.File

/**
 * 嵌套（Nested） object对象
 * 这个object 对象还可以放到一个类里面
 */
class DataProcessor {
    fun process() {
        println("Process Data")
    }

    object FileUtils {
        const val userHome = "/Users/Allen"
        fun getFileContent(file: String): String {
            var content = ""
            val f = File(file)
            f.forEachLine { content = content + it + "\n" }
            return content

        }
    }
}

fun main(args: Array<String>) {
    DataProcessor.FileUtils.userHome
    DataProcessor.FileUtils.getFileContent("f")

}