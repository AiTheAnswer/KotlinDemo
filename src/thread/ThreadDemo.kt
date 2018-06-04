package thread

import java.io.File
import java.nio.charset.Charset
import kotlin.concurrent.thread

/**
 * Kotlin中的多线程
 * Kotlin中没有synchronized关键字。Kotlin中没有volatile关键字。Kotlin中Any类似于Java中的Object,
 *    但是没有wait(),notify()和notifyAll()方法
 */

/**
 * 一、创建线程
 * 1.1使用对象表达式创建
 */
fun createThread1() {
    object : Thread() {
        override fun run() {
            Thread.sleep(3000)
            println("A 使用 Thread 对象表达式： ${Thread.currentThread()}")
        }
    }.start()
}

/**
 * 1.2 使用Lambda表达式
 */
fun createThread2() {
    Thread({
        Thread.sleep(3000)
        println("B 使用 Lambda 表达式： ${Thread.currentThread()}")
    }).start()
}

/**
 * 1.3 使用Kotlin封装的thread函数
 * kotlin把一些操作封装简化了
 */
fun createThread3() {
    val thread = thread(start = false, isDaemon = false, name = "DThread", priority = 3) {
        Thread.sleep(1000)
        println("D 使用Kotlin封装的函数thread（）：${Thread.currentThread()}")
    }
    thread.start()
}

/**
 * 二、同步方法和块
 *  synchronized不是Kotlin中的关键字，它替换为@synchronized注解。
 *  2.1 同步方法
 *  @Synchronized注解与Java中的synchronized具有相同的效果
 */
@Synchronized
fun appendFile(text: String, destFile: String) {
    val file = File(destFile)
    if (!file.exists()) {
        file.createNewFile()
    }
    file.appendText(text, Charset.defaultCharset())
}

class SynAndVolatile() {
    /**
     * 2.2 同步代码块
     *  使用 synchronized()函数，它使用锁作为参数
     */
    fun appendFileSync(text: String, destFile: String) {
        val file = File(destFile)
        if (!file.exists()) {
            file.createNewFile()
        }
        synchronized(this) {
            file.appendText(text, Charset.defaultCharset())
        }
    }

    /**
     *  三、可变字段
     *  Kotlin中没有volatile 关键字，但是有@Volatile注解
     */
    @Volatile
    private var running = false

    fun start() {
        running = true
        thread(start = true) {
            while (running) {
                println("Still running: ${Thread.currentThread()}")
            }
        }
    }

    fun stop() {
        running = false
        println("Stopped : ${Thread.currentThread()}")
    }

}


fun main(args: Array<String>) {
    createThread1()
    createThread2()
    createThread3()
}