package classes.anonymous_inner_class

/**
 * 匿名内部类（Anonymous Inner Class）
 * 就是没有名字的内部类。既然是内部类，那么自然也可以访问外部类的变量
 */
class NestedClassDemo {
    class AnonymousInnerClassDemo {
        var isRunning = false
        fun doRun() {
            //使用对象表达式创建一个匿名内部类实例
            Thread(object : Runnable {
                override fun run() {
                    isRunning = true
                    println("doRun: I am running, isRunning = $isRunning ")
                }
            }).start()
        }

        fun doStop() {
            //使用Lambda表达式创建
            Thread {
                isRunning = false
                println("doStop: I am not running,isRunning = $isRunning")
            }.start()
        }

        fun doWait() {
            val wait = Runnable {
                isRunning = false
                println("doWait: I am waiting, isRunning = $isRunning")
            }
            Thread(wait).start()
        }

        fun doNotify(){
            val wait ={
                isRunning = true
                println("doNotify: i am notify ,is Running = $isRunning")
            }
            Thread(wait).start()
        }
    }
}

fun main(args: Array<String>) {
    val innerClassDemo = NestedClassDemo.AnonymousInnerClassDemo()
    innerClassDemo.doRun()
    innerClassDemo.doStop()
    innerClassDemo.doWait()
    innerClassDemo.doNotify()
}